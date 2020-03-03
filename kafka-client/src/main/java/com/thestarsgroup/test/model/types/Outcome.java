package com.thestarsgroup.test.model.types;

import com.thestarsgroup.test.model.base.BaseType;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "outcomes")
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = false)
@EqualsAndHashCode(callSuper = false)
public class Outcome extends BaseType {

    @Id
    protected String outcomeId;

    @Indexed
    protected String marketId;

    private String price;

    public Outcome(BaseType baseType){
        setDisplayed(baseType.getDisplayed());
        setMsgId(baseType.getMsgId());
        setName(baseType.getName());
        setOperation(baseType.getOperation());
        setSuspended(baseType.getSuspended());
        setTimestamp(baseType.getTimestamp());
        setType(baseType.getType());
    }

}
