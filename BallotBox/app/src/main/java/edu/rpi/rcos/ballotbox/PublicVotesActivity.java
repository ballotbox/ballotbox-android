package edu.rpi.rcos.ballotbox;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.gulena.ballotbox.R;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class PublicVotesActivity extends ListActivity {


    public String ENDPOINT = "http://ballot-box.herokuapp.com/";
    protected List<Poll> polls;
    ArrayAdapter<Poll> array;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.public_votes);
        array = new PublicVotesAdapter(this,R.layout.public_votes,polls);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Poll p = polls.get(position);
        VoteActivity.openVoteView(p.getRandom_access_id(),this);
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
                Toast.makeText(PublicVotesActivity.this, "Could not get data", Toast.LENGTH_LONG);
            }
        });
    }
}

