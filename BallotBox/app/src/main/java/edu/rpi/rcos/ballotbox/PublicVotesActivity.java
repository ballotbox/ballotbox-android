package edu.rpi.rcos.ballotbox;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.gulena.ballotbox.R;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class PublicVotesActivity extends ListActivity {


    public String ENDPOINT = "http://ballot-box.herokuapp.com/";
    protected List<Poll> polls;
    PollAdapter array;
    DataManager dataManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataManager = getIntent().getParcelableExtra("data_manager");
        if(dataManager == null) {
            assert false;
        }
        getData();
        array = new PollAdapter(this,polls);
        setContentView(R.layout.public_votes);
        setListAdapter(array);
        findViewById(R.id.fab_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNewPoll();
            }
        });
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Poll p = polls.get(position);
        Intent intent = new Intent(this,VoteActivity.class);
        intent.putExtra("random_id",p.getRandom_access_id());
        intent.putExtra("data_manager",dataManager);
        Log.i("PublicVotesActivity","Transitioning to poll with id " + p.getRandom_access_id());
        startActivity(intent);
    }

    public void getData() {
        polls = dataManager.getPublicPolls();
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

    public void addNewPoll() {
        Intent intent = new Intent(this,NewPollActivity.class);
        intent.putExtra("data_manager",dataManager);
        startActivity(intent);
    }
}

