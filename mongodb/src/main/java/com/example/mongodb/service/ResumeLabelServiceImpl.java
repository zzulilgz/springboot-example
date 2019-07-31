package com.example.mongodb.service;

import com.example.mongodb.model.ResumeLabel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author gaozhi.liu
 * @Date 2019/3/19 14:45
 * @Version 1.0
 **/
@Service
public class ResumeLabelServiceImpl implements ResumeLabelService {

    @Override
    public Map<String, Integer> countByGroup(List<ResumeLabel> list) {
        return null;
    }

    @Override
    public Map<String, Integer> countByLabels(List<ResumeLabel> list) {
        return null;
    }
}
