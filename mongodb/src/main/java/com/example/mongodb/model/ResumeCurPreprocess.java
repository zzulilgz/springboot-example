package com.example.mongodb.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Set;

@Document("resume_cur_process")

public class ResumeCurPreprocess {
    @Id
    private Long id;
    @Field("resume_id")
    private String resumeId;
    @Field("abstract")
    private String resumeAbstract;
    private Set<ObjectId> labels;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResumeId() {
        return resumeId;
    }

    public void setResumeId(String resumeId) {
        this.resumeId = resumeId;
    }

    public String getResumeAbstract() {
        return resumeAbstract;
    }

    public void setResumeAbstract(String resumeAbstract) {
        this.resumeAbstract = resumeAbstract;
    }

    public Set<ObjectId> getLabels() {
        return labels;
    }

    public void setLabels(Set<ObjectId> labels) {
        this.labels = labels;
    }
}
