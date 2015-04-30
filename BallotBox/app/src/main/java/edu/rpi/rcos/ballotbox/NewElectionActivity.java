package edu.rpi.rcos.ballotbox;

import android.app.Activity;
import android.os.Bundle;
import android.provider.ContactsContract;

import com.example.gulena.ballotbox.R;


public class NewElectionActivity extends Activity {

    Election e;
    DataManager dataManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_election);
        Election e = new Election();
    }

    public Election createElection() {
        return dataManager.createNewElection(e);
    }
}
