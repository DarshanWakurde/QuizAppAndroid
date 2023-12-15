package com.example.quizappdemo;

public class DataModel {

    String question;
    String optiona;
    String optionb;
    int id;
    String optionc;
    String optiond;
    String answer;

    public DataModel() {
    }

    public DataModel(String question, String optiona, String optionb, int id, String optionc, String optiond, String answer) {
        this.question = question;
        this.optiona = optiona;
        this.optionb = optionb;
        this.id = id;
        this.optionc = optionc;
        this.optiond = optiond;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOptiona() {
        return optiona;
    }

    public void setOptiona(String optiona) {
        this.optiona = optiona;
    }

    public String getOptionb() {
        return optionb;
    }

    public void setOptionb(String optionb) {
        this.optionb = optionb;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOptionc() {
        return optionc;
    }

    public void setOptionc(String optionc) {
        this.optionc = optionc;
    }

    public String getOptiond() {
        return optiond;
    }

    public void setOptiond(String optiond) {
        this.optiond = optiond;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
