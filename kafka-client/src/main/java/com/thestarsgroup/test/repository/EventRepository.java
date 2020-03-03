package com.thestarsgroup.test.repository;

import com.thestarsgroup.test.model.types.Event;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface EventRepository extends MongoRepository<Event, Long> {

}
