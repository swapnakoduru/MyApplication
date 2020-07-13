package com.itware.myapplication.ui.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SurverDataModel {

    @SerializedName("answerMast")
    @Expose
    private List<AnswerMast> answerMast = null;
    @SerializedName("controlType")
    @Expose
    private String controlType;
    @SerializedName("keyboardType")
    @Expose
    private String keyboardType;
    @SerializedName("qSortOrder")
    @Expose
    private String qSortOrder;
    @SerializedName("qid")
    @Expose
    private String qid;
    @SerializedName("question")
    @Expose
    private String question;
    @SerializedName("regularExpression")
    @Expose
    private String regularExpression;
    @SerializedName("requiredValidator")
    @Expose
    private String requiredValidator;
    @SerializedName("requiredValidatorMessage")
    @Expose
    private String requiredValidatorMessage;

    public List<AnswerMast> getAnswerMast() {
        return answerMast;
    }

    public void setAnswerMast(List<AnswerMast> answerMast) {
        this.answerMast = answerMast;
    }

    public String getControlType() {
        return controlType;
    }

    public void setControlType(String controlType) {
        this.controlType = controlType;
    }

    public String getKeyboardType() {
        return keyboardType;
    }

    public void setKeyboardType(String keyboardType) {
        this.keyboardType = keyboardType;
    }

    public String getQSortOrder() {
        return qSortOrder;
    }

    public void setQSortOrder(String qSortOrder) {
        this.qSortOrder = qSortOrder;
    }

    public String getQid() {
        return qid;
    }

    public void setQid(String qid) {
        this.qid = qid;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getRegularExpression() {
        return regularExpression;
    }

    public void setRegularExpression(String regularExpression) {
        this.regularExpression = regularExpression;
    }

    public String getRequiredValidator() {
        return requiredValidator;
    }

    public void setRequiredValidator(String requiredValidator) {
        this.requiredValidator = requiredValidator;
    }

    public String getRequiredValidatorMessage() {
        return requiredValidatorMessage;
    }

    public void setRequiredValidatorMessage(String requiredValidatorMessage) {
        this.requiredValidatorMessage = requiredValidatorMessage;
    }
}
