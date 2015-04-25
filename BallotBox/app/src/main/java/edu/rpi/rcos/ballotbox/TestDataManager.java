package edu.rpi.rcos.ballotbox;

import android.os.Parcel;
import android.os.Parcelable;
import android.provider.ContactsContract;

import java.util.ArrayList;

public class TestDataManager implements DataManager {

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
    public Poll getPollWithID(String private_id) {
        if(private_id.equals("FAKE")) {
            return null;
        }
        ArrayList<Choice> choices = new ArrayList<Choice>();
        choices.add(new Choice("Nothing"));
        choices.add(new Choice("Everything"));
        return new Poll("What is this?",choices,private_id);
    }

    @Override
    public ArrayList<Poll> getPublicPolls() {
        ArrayList<Poll> polls = new ArrayList<Poll>();
        Poll p = new Poll();
        p.setQuestion("Is this a question?");
        p.setQuestion_id(1);
        ArrayList<Choice> choices = new ArrayList<Choice>();
        choices.add(new Choice("No."));
        choices.add(new Choice("Maybe"));
        p.setChoices(choices);
        p.setRandom_access_id("ABLAK");
        polls.add(p);
        return polls;
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
