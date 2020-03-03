package com.thestarsgroup.test.repository;

import com.thestarsgroup.test.model.types.Outcome;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface OutcomeRepository extends MongoRepository<Outcome, Long> {

}
