package com.thestarsgroup.test.repository;

import com.thestarsgroup.test.model.base.BaseType;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BaseClassRepository extends MongoRepository<BaseType, Long> {

}
