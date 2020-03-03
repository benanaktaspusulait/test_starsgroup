package com.thestarsgroup.test.model.base;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
public class BaseType {

    protected String name;
    protected Boolean displayed;
    protected Boolean suspended;
    protected String msgId;
    protected String operation;
    protected String type;
    protected Date timestamp;
}
