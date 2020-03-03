package com.thestarsgroup.test.model.types;

import com.thestarsgroup.test.model.base.BaseType;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "markets")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
public class Market extends BaseType {

    @Id
    protected String marketId;
    private String eventId;

    public Market(BaseType baseType){
        setDisplayed(baseType.getDisplayed());
        setMsgId(baseType.getMsgId());
        setName(baseType.getName());
        setOperation(baseType.getOperation());
        setSuspended(baseType.getSuspended());
        setTimestamp(baseType.getTimestamp());
        setType(baseType.getType());
    }

}
