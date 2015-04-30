package edu.rpi.rcos.ballotbox;

import android.os.Parcel;
import android.util.Log;

import java.util.ArrayList;

public class TestDataManager implements DataManager {

    private ArrayList<Election> test_elections;
    private ArrayList<Election> public_elections;

    public TestDataManager() {
        test_elections = new ArrayList<Election>();
        public_elections = new ArrayList<Election>();

        Election p = new Election();

        p.setQuestion("Is this a question?");
        p.setId(1);
        ArrayList<Choice> choices = new ArrayList<Choice>();
        choices.add(new Choice("No."));
        choices.add(new Choice("Maybe"));
        p.setChoices(choices);
        p.setRandomAccessId("Q1");
        test_elections.add(p);

        Election p2 = new Election();
        p2.setQuestion("Is this the next question?");
        p2.setId(2);
        choices = new ArrayList<Choice>();
        choices.add(new Choice("Choice A."));
        choices.add(new Choice("Choice B."));
        p2.setChoices(choices);
        p2.setRandomAccessId("Q2");
        test_elections.add(p2);
        public_elections.add(p2);
    }

    public static final Creator<TestDataManager> CREATOR =
            new Creator<TestDataManager>() {
                @Override
                public TestDataManager createFromParcel(Parcel parcel) {
                    TestDataManager testDataManager = new TestDataManager();
                    return testDataManager;
                }

                @Override
                public TestDataManager[] newArray(int i) {
                    return null;
                }
            };

    @Override
    public Election getElectionWithID(String private_id) {
        for(Election p : test_elections) {
            if(p.getRandomAccessId().equals(private_id)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Election> getPublicElections() {
        return public_elections;
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
        return true;
    }

    @Override
    public boolean isLoggedIn() {
        return true;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}
