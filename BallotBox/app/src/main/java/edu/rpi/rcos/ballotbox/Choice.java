package edu.rpi.rcos.ballotbox;


import java.io.Serializable;

public class Choice implements Serializable {
    private String text;
    private int id;
    private boolean voted;
    private int voteCount;

    public Choice() {}

    public Choice(String text) {
        this.text = text;
    }

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

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public boolean isVoted() {
        return voted;
    }

    public void setVoted(boolean voted) {
        this.voted = voted;
    }

    @Override
    public boolean equals(Object c2) {
        if(c2 == null || !(c2 instanceof Choice)) {
            return false;
        }
        return ((Choice)c2).getId() == id;
    }
}
