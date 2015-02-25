package com.example.gulena.ballotbox;


import java.io.Serializable;

public class Choice implements Serializable {
    protected String text;
    protected int id;
    protected int voter_count;
}
