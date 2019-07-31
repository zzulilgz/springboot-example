package com.example.mongodb.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

/**
 * @Description 简历标签
 * @Author gaozhi.liu
 * @Date 2019/3/19 13:52
 * @Version 1.0
 **/
@Data
@Document(collection = "resume_label")
public class ResumeLabel {

    private String id;
    private String createBy;
    private String name;
    private Instant createTime;
    private String updateBy;
    private Instant updateTime;

    private Integer count;




}
