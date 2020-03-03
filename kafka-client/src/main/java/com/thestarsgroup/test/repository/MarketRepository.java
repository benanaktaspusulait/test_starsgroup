package com.thestarsgroup.test.repository;

import com.thestarsgroup.test.model.types.Market;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface MarketRepository extends MongoRepository<Market, Long> {

}
