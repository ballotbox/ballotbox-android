package edu.rpi.rcos.ballotbox;

import java.io.Serializable;
import java.util.List;

public class Election implements Serializable {

    private String question;
    private List<Choice> choices;
    private int id;
    private String randomAccessId;
    private Choice votedChoice;

    public Election(String question, List<Choice> choices, String random_id) {
        this.question = question;
        this.choices = choices;
        this.randomAccessId = random_id;
    }

    public Election() {}

    public String getQuestion() {
        return question;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public int getId() {
        return id;
    }

    public String getRandomAccessId() {
        return randomAccessId;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRandomAccessId(String randomAccessId) {
        this.randomAccessId = randomAccessId;
    }

    public Choice getVotedChoice() {
        return votedChoice;
    }

    public void setVotedChoice(Choice votedChoice) {
        this.votedChoice = votedChoice;
    }
}
