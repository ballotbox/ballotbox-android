package com.example.gulena.ballotbox;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class PublicVotesActivity extends ListActivity {

    protected List<Poll> polls;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.public_votes);
        ArrayAdapter<Poll> array = new ArrayAdapter<Poll>(this,R.layout.public_votes,polls);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Poll p = polls.get(position);
        p.update_information(); // send HTTP request data
        Intent intent = new Intent(this,VotingActivity.class);
        //Add context
        intent.putExtra("Poll",p);
        startActivity(intent);
        //get Poll information
        //send to
    }
}

