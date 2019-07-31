package com.example.mongodb.repository;

import com.example.mongodb.model.ResumeLabel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description TODO
 * @Author gaozhi.liu
 * @Date 2019/3/19 14:46
 * @Version 1.0
 **/
@Repository
public interface ResumeLabelRepository extends MongoRepository<ResumeLabel,String> {

}
