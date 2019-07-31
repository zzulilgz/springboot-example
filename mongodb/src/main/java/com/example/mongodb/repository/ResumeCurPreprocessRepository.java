package com.example.mongodb.repository;

import com.example.mongodb.model.ResumeCurPreprocess;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumeCurPreprocessRepository extends MongoRepository<ResumeCurPreprocess,String> {


    Integer countByLabels(ObjectId id);
}
