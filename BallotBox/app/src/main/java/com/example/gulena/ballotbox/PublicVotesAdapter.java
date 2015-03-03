package com.example.gulena.ballotbox;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

public class PublicVotesAdapter extends ArrayAdapter<Poll> {

    List<Poll> polls;
    public PublicVotesAdapter(Context context, int resource, List<Poll> polls) {
        super(context, resource);
        this.polls = polls;
    }

    public void setPolls(List<Poll> polls) {
        this.polls = polls;
    }
}
