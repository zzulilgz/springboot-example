package com.example.mongodb.service;

import com.example.mongodb.model.ResumeLabel;

import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author gaozhi.liu
 * @Date 2019/3/19 14:42
 * @Version 1.0
 **/
public interface ResumeLabelService {

    Map<String,Integer> countByGroup(List<ResumeLabel> list);

    Map<String,Integer> countByLabels(List<ResumeLabel> list);

}
