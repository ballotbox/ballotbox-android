package edu.rpi.rcos.ballotbox;


import java.io.Serializable;

public class Choice implements Serializable {
    private String text;
    private int id;
    private boolean voted;
    private int voter_count;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVoter_count() {
        return voter_count;
    }

    public void setVoter_count(int voter_count) {
        this.voter_count = voter_count;
    }

    public boolean isVoted() {
        return voted;
    }

    public void setVoted(boolean voted) {
        this.voted = voted;
    }
}
