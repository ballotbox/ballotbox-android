package edu.rpi.rcos.ballotbox;

import android.os.Parcel;

import java.util.ArrayList;

public class APIDataManager implements DataManager {

    String authKey;
    public APIDataManager() {}

    //GET /elections/{id}

    @Override
    public Election getElectionWithID(String private_id) {
        Election e = new Election();
        Choice currentChoice = getVoteOnElection(e);
        if(currentChoice != null) {
            for(Choice c : e.getChoices()) {
                if(c.equals(currentChoice)) {
                    c.setVoted(true);
                }
            }
        }
        return e;
    }

    //GET /elections

    @Override
    public ArrayList<Election> getPublicElections() {
        return null;
    }

    //GET /elections/{id}/vote

    @Override
    public Choice getVoteOnElection(Election e) {
        return null;
    }

    //POST /elections

    @Override
    public Election createNewElection(Election e) {
        return null;
    }

    //PUT /elections/{id}

    @Override
    public Election editElection(Election e) {
        return null;
    }

    //DELETE /elections/{id}

    @Override
    public boolean deleteElection(Election e) {
        return false;
    }

    //POST /elections/{id}/choices/{id}/vote

    @Override
    public boolean voteOnElection(Election e, Choice c) {
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
