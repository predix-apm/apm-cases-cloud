package com.ge.apm.cases.apigateway.services.cases;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ge.apm.cases.apigateway.services.catalog.Genre;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApmCase {

    private String title;
    private String mlId;

    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    public String getMlId() {
        return mlId;
    }

    public void setMlId(String mlId) {
        this.mlId = mlId;
    }

}
