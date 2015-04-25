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
    public Poll getPollWithID(String private_id) {
        return null;
    }

    @Override
    public ArrayList<Poll> getPublicPolls() {
        return null;
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
