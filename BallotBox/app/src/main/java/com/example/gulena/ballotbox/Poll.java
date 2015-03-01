package com.example.gulena.ballotbox;

import org.json.JSONObject;

import java.io.Serializable;
import java.util.List;

public class Poll implements Serializable {

    private String question;
    private List<Choice> choices;
    private int question_id;
    private String random_access_id;


    public Poll() {

    }

    public void update_information() {
        try {
            JSONObject jsonObject = APIBrowser.getSinglePoll(this);
        } catch(Exception e) {
            //manage exception here
        }
        //Fill in object information
    }

    public String getQuestion() {
        return question;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public String getRandom_access_id() {
        return random_access_id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public void setRandom_access_id(String random_access_id) {
        this.random_access_id = random_access_id;
    }
}
