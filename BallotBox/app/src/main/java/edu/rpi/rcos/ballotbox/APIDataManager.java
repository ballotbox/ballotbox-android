package edu.rpi.rcos.ballotbox;

import android.os.Parcel;

import java.util.ArrayList;

/**
 * Created by chris on 4/16/15.
 */
public class APIDataManager implements DataManager {

    String authKey;
    public APIDataManager() {}
    @Override
    public Election getElectionWithID(String private_id) {
        return null;
    }

    @Override
    public ArrayList<Election> getPublicElections() {
        return null;
    }

    @Override
    public Choice getVoteOnElection(Election p) {
        return null;
    }

    @Override
    public Election createNewElection(Election p) {
        return null;
    }

    @Override
    public Election editElection(Election p) {
        return null;
    }

    @Override
    public boolean deleteElection(Election p) {
        return false;
    }

    @Override
    public boolean voteOnElection(Election p, Choice c) {
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
