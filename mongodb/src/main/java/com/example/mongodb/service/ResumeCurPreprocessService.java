package com.example.mongodb.service;

import com.example.mongodb.model.ResumeCurPreprocess;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author gaozhi.liu
 * @Date 2019/3/19 10:04
 * @Version 1.0
 **/

public interface ResumeCurPreprocessService {

   void save(ResumeCurPreprocess resumeCurPreprocess);

   void insertList(List<ResumeCurPreprocess> resumeCurPreprocesses);

   void delete(Long id);
   
   void update(ResumeCurPreprocess resumeCurPreprocess);

   Integer count(ObjectId id);

   ResumeCurPreprocess findById(Long id);

   List<ResumeCurPreprocess> findLByModel(ResumeCurPreprocess resumeCurPreprocess);


   Map<String,Integer> countByGroup(List<ObjectId> labels);

   Map<String,Integer> countByLabel(List<ObjectId> labels);
}
