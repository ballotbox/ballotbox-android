package com.example.gulena.ballotbox;

import android.os.Parcelable;

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
}
