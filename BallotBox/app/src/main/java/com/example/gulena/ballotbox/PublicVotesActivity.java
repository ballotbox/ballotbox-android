package com.example.gulena.ballotbox;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.ListActivity;
import android.content.Intent;
import android.os.AsyncTask;
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

import org.json.JSONArray;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class PublicVotesActivity extends ListActivity {


    public String ENDPOINT = "http://ballotbox.io/api";
    protected List<Poll> polls;
    ArrayAdapter<Poll> array;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.public_votes);
        array = new ArrayAdapter<Poll>(this,R.layout.public_votes,polls);
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

    public void requestData(String uri) {
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(ENDPOINT)
                .build();
        VotesAPI api = adapter.create(VotesAPI.class);
        api.getPublicPolls(new Callback<List<Poll>>() {
            @Override
            public void success(List<Poll> polls, Response response) {
                PublicVotesActivity.this.polls = polls;
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(PublicVotesActivity.this,"Could not get data",Toast.LENGTH_LONG);
            }
        });
    }
}

