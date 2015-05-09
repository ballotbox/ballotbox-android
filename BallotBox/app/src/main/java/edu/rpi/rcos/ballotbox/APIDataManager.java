package edu.rpi.rcos.ballotbox;

import android.os.Parcel;

import java.util.ArrayList;
import java.util.List;

import retrofit.RestAdapter;

public class APIDataManager implements DataManager {

    String authKey;
    RestAdapter restAdapter;
    VotesAPI votesAPI;
    public APIDataManager() {
        restAdapter = new RestAdapter.Builder()
                .setEndpoint("https://ballot-box.herokuapp.com/api/")
                .build();
        votesAPI = restAdapter.create(VotesAPI.class);
    }

    //GET /elections/{id}

    @Override
    public Election getElectionWithID(String private_id) {
        Election e = votesAPI.getElection(private_id);
        Choice currentChoice = getVoteOnElection(e);
        if(currentChoice != null) {
            for(Choice c : e.getChoices()) {
                if(c.equals(currentChoice)) {
                    c.setVoted(true);
                } else {
                    c.setVoted(false);
                }
            }
        }
        return e;
    }

    //GET /elections

    @Override
    public List<Election> getPublicElections() {
        List<Election> elections = votesAPI.getPublicElections();
        return elections;
    }

    //GET /elections/{id}/vote

    @Override
    public Choice getVoteOnElection(Election e) {
        Choice c = votesAPI.getVotesOnElection(e.getRandomAccessId());
        return c;
    }

    //POST /elections

    @Override
    public Election createNewElection(Election e) {
        Election election = votesAPI.createNewElection(e);
        return election;
    }

    //PUT /elections/{id}

    @Override
    public Election editElection(Election e) {
        Election election = votesAPI.editElection(e);
        return election;
    }

    //DELETE /elections/{id}

    @Override
    public boolean deleteElection(Election e) {

        return votesAPI.deleteElection(e.getRandomAccessId());
    }

    //POST /elections/{id}/choices/{id}/vote

    @Override
    public boolean voteOnElection(Election e, Choice c) {
        return votesAPI.voteOnElection(e.getRandomAccessId(),c.getId());
    }

    private boolean getCreds(String username, String password) {

        return false;
    }

    @Override
    public boolean login(String username, String password) {
        return false;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }

    public boolean isLoggedIn() {
        return authKey != null;
    }
}
