package edu.rpi.rcos.ballotbox;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
    protected List<Election> elections;
    ElectionAdapter array;
    DataManager dataManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataManager = getIntent().getParcelableExtra("data_manager");
        if(dataManager == null) {
            assert false;
        }
        getData();
        array = new ElectionAdapter(this, elections);
        setContentView(R.layout.public_votes);
        setListAdapter(array);
        findViewById(R.id.fab_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNewElection();
            }
        });
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Election p = elections.get(position);
        Intent intent = new Intent(this,VoteActivity.class);
        intent.putExtra("random_id",p.getRandomAccessId());
        intent.putExtra("data_manager",dataManager);
        Log.i("PublicVotesActivity","Transitioning to election with id " + p.getRandomAccessId());
        startActivity(intent);
    }

    public void getData() {
        elections = dataManager.getPublicElections();
    }

    public void requestData(String uri) {
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(ENDPOINT)
                .build();
        VotesAPI api = adapter.create(VotesAPI.class);
        api.getPublicElections(new Callback<List<Election>>() {
            @Override
            public void success(List<Election> elections, Response response) {
                PublicVotesActivity.this.elections = elections;
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(PublicVotesActivity.this, "Could not get data", Toast.LENGTH_LONG);
            }
        });
    }

    public void addNewElection() {
        Intent intent = new Intent(this,NewElectionActivity.class);
        intent.putExtra("data_manager",dataManager);
        startActivity(intent);
    }
}

