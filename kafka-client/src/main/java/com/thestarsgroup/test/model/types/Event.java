package com.thestarsgroup.test.model.types;

import com.thestarsgroup.test.model.base.BaseType;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "events")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
public class Event extends BaseType {

    @Id
    private String eventId;
    protected String marketId;
    private String category;
    private String subCategory;
    private Integer startTime;

    public Event(BaseType baseType){
        setDisplayed(baseType.getDisplayed());
        setMsgId(baseType.getMsgId());
        setName(baseType.getName());
        setOperation(baseType.getOperation());
        setSuspended(baseType.getSuspended());
        setTimestamp(baseType.getTimestamp());
        setType(baseType.getType());
    }
}
