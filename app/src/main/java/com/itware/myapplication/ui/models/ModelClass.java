package com.itware.myapplication.ui.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ModelClass {

    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("surveyData")
    @Expose
    private List<SurverDataModel> surveyData = null;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<SurverDataModel> getSurveyData() {
        return surveyData;
    }

    public void setSurveyData(List<SurverDataModel> surveyData) {
        this.surveyData = surveyData;
    }

}
