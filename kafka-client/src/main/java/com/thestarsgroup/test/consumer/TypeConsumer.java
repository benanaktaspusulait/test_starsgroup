package com.thestarsgroup.test.consumer;

import com.thestarsgroup.test.Constants;
import com.thestarsgroup.test.model.types.*;
import com.thestarsgroup.test.model.base.BaseType;
import com.thestarsgroup.test.repository.EventRepository;
import com.thestarsgroup.test.repository.MarketRepository;
import com.thestarsgroup.test.repository.OutcomeRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.sql.Date;

@Slf4j
@Service
public class TypeConsumer {

    @Autowired
    MarketRepository marketRepository;

    @Autowired
    OutcomeRepository outcomeRepository;

    @Autowired
    EventRepository eventRepository;

    @KafkaListener(topics = Constants.TYPE_TOPIC, groupId = "1")
    public void saveType(String message) throws IOException {

        Reader in = new StringReader(message);
        CSVParser csvParser = new CSVParser(in, CSVFormat.DEFAULT.withDelimiter('|').
                withIgnoreHeaderCase().withTrim().withEscape('\\')); // TODO escape character kontrolu


        for (CSVRecord csvRecord : csvParser) {

            BaseType baseType = new BaseType();

            baseType.setMsgId(csvRecord.get(1));
            baseType.setOperation(csvRecord.get(2));
            baseType.setType(csvRecord.get(3));
            baseType.setTimestamp(new Date(Long.valueOf(csvRecord.get(4))));

            String type = baseType.getType();

            if (type.equals("outcome")) {

                Outcome outcome = new Outcome(baseType);
                outcome.setDisplayed(Boolean.valueOf(csvRecord.get(9)));
                outcome.setName(csvRecord.get(7).replace("|", ""));
                outcome.setSuspended(Boolean.valueOf(csvRecord.get(10)));
                outcome.setMarketId(csvRecord.get(5));
                outcome.setOutcomeId(csvRecord.get(6));
                outcome.setPrice(csvRecord.get(8));
                outcomeRepository.save(outcome);
            } else if (type.equals("market")) {

                Market market = new Market(baseType);
                market.setDisplayed(Boolean.valueOf(csvRecord.get(8)));
                market.setName(csvRecord.get(7).replace("|", ""));
                market.setSuspended(Boolean.valueOf(csvRecord.get(9)));
                market.setEventId(csvRecord.get(5));
                market.setMarketId(csvRecord.get(6));
                marketRepository.save(market);
            } else if (type.equals("event")) {

                Event event = new Event(baseType);
                event.setDisplayed(Boolean.valueOf(csvRecord.get(10)));
                event.setName(csvRecord.get(8).replace("|", ""));
                event.setSuspended(Boolean.valueOf(csvRecord.get(11)));
                event.setEventId(csvRecord.get(5));
                event.setCategory(csvRecord.get(6));
                event.setSubCategory(csvRecord.get(7));
                eventRepository.save(event);
            }
        }
    }
}
