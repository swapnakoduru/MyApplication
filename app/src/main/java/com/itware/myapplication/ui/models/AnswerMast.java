package com.itware.myapplication.ui.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AnswerMast {

    @SerializedName("aSortOrder")
    @Expose
    private String aSortOrder;
    @SerializedName("aid")
    @Expose
    private String aid;
    @SerializedName("answer")
    @Expose
    private String answer;

    public String getASortOrder() {
        return aSortOrder;
    }

    public void setASortOrder(String aSortOrder) {
        this.aSortOrder = aSortOrder;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
