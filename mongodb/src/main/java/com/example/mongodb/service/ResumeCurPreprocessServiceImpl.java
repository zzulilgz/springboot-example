package com.example.mongodb.service;

import com.example.mongodb.model.ResumeCurPreprocess;
import com.example.mongodb.model.ResumeLabel;
import com.example.mongodb.repository.ResumeCurPreprocessRepository;
import com.example.mongodb.utils.JsonUtils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.Fields;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;

/**
 * @Description TODO
 * @Author gaozhi.liu
 * @Date 2019/3/19 10:22
 * @Version 1.0
 **/
@Service
public class ResumeCurPreprocessServiceImpl implements ResumeCurPreprocessService {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    ResumeCurPreprocessRepository resumeCurPreprocessRepository;

    @Override
    public void save(ResumeCurPreprocess resumeCurPreprocess) {
        ResumeCurPreprocess save = mongoTemplate.save(resumeCurPreprocess);
    }

    @Override
    public void insertList(List<ResumeCurPreprocess> resumeCurPreprocesses) {
        mongoTemplate.insertAll(resumeCurPreprocesses);
    }

    @Override
    public void delete(Long id) {
        //全部删除
       mongoTemplate.remove(new Query(),ResumeCurPreprocess.class);
    }

    @Override
    public void update(ResumeCurPreprocess resumeCurPreprocess) {

    }

    @Override
    public Integer count(ObjectId id) {
        MatchOperation match = Aggregation.match(new Criteria().where("labels").is(id));
        Aggregation aggregation = Aggregation.newAggregation(Aggregation.unwind("labels"),
                Aggregation.group("labels").count().as("count"),project( "count")
        );
        AggregationResults<ResumeLabel> resume_cur_process =
                mongoTemplate.aggregate(aggregation, "resume_cur_process", ResumeLabel.class);
        System.out.println(resume_cur_process.getMappedResults().get(0));

        return (int)mongoTemplate.count(new Query(Criteria.where("labels").is(id)), ResumeCurPreprocess.class);
    }

    @Override
    public ResumeCurPreprocess findById(Long id) {
        ResumeCurPreprocess model = mongoTemplate.findById(id, ResumeCurPreprocess.class);
        return model;
    }

    @Override
    public Map<String, Integer> countByGroup(List<ObjectId> labels) {

        Criteria criteria = new Criteria();
        MatchOperation match = Aggregation.match(criteria.where("labels").is(labels.get(0)));
        Aggregation aggregation = Aggregation.newAggregation(match
        );

        AggregationResults<Map> ans
                = mongoTemplate.aggregate(aggregation, "resume_cur_process", Map.class);
        System.out.println(JsonUtils.toJson(ans.getRawResults()));
        return null;
    }

    @Override
    public Map<String, Integer> countByLabel(List<ObjectId> labels) {

        return null;
    }

    @Override
    public List<ResumeCurPreprocess> findLByModel(ResumeCurPreprocess resumeCurPreprocess) {
        return null;
    }
}
