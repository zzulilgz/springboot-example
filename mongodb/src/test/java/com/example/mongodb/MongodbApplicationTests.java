package com.example.mongodb;

import com.example.mongodb.model.ResumeCurPreprocess;
import com.example.mongodb.model.ResumeLabel;
import com.example.mongodb.service.ResumeCurPreprocessService;
import com.example.mongodb.utils.JsonUtils;
import com.fasterxml.jackson.databind.JsonNode;
import org.apache.commons.logging.LogFactory;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.logging.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongodbApplicationTests {
    private static final String COLLECTION_NAME = "resume_cur_process";

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    ResumeCurPreprocessService resumeCurPreprocessService;

    @Test
    public void contextLoads() {


    }

    @Test
    public void delete(){
        resumeCurPreprocessService.delete(1L);
    }
    @Test
    public void batchInsert(){

        List<ResumeCurPreprocess> list = new ArrayList<>();
        for (int i=1;i<=2000;i++){
            ResumeCurPreprocess resumeCurPreprocess = new ResumeCurPreprocess();
            resumeCurPreprocess.setId(RandomNums()*1L);
            ResumeCurPreprocess id = resumeCurPreprocessService.findById(resumeCurPreprocess.getId());
            if(id!=null){
                continue;
            }
            resumeCurPreprocess.setResumeAbstract("java开发工程师");
            resumeCurPreprocess.setResumeId("lagou");
            Set<ObjectId> labels = new HashSet<>();
            labels.add(new ObjectId("111111111111111111111111"));
            labels.add(new ObjectId("cccccccccccccccccccccccc"));
            for (int j=1;j<=10;j++){
                labels.add(new ObjectId("3333333333333333"+RandomNums()));
            }

            resumeCurPreprocess.setLabels(labels);

            list.add(resumeCurPreprocess);
        }
        long pre = new Date().getTime();
        resumeCurPreprocessService.insertList(list);
        System.out.println("保存"+list.size()+"记录,耗时："+(new Date().getTime()-pre)+"ms");

    }
    @Test
    public void findById(){
        ResumeCurPreprocess model = resumeCurPreprocessService.findById(1L);
        System.out.println(JsonUtils.toJson(model));
    }
    @Test
    public void countLabels(){

        Integer count = resumeCurPreprocessService.count(new ObjectId("333333333333333396004918"));
        System.out.println(count);
    }
    @Test
    public void countByGroup(){
        List<ObjectId> labels = new ArrayList<>();
        labels.add(new ObjectId("111111111111111111111111"));
        labels.add(new ObjectId("cccccccccccccccccccccccc"));
        resumeCurPreprocessService.countByGroup(labels);
    }
    @Test
    public void createData(){
        for (int i=1;i<=10000;i++){
            ResumeCurPreprocess resumeCurPreprocess = new ResumeCurPreprocess();
            resumeCurPreprocess.setId(RandomNums()*1L);
            resumeCurPreprocess.setResumeAbstract("java开发工程师");
            resumeCurPreprocess.setResumeId("lagou");
            Set<ObjectId>  labels = new HashSet<>();
            labels.add(new ObjectId("111111111111111111111111"));
            labels.add(new ObjectId("cccccccccccccccccccccccc"));
            for (int j=1;j<=10;j++){
                labels.add(new ObjectId("3333333333333333"+RandomNums()));
            }

            resumeCurPreprocess.setLabels(labels);

            resumeCurPreprocessService.save(resumeCurPreprocess);
        }
    }
    /**
     * 随机生成n位数字
     * @return
     */
    private int RandomNums(){
        return (int)((Math.random()*9+1)*10000000);
    }

}
