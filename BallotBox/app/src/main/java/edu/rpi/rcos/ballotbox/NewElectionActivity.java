package edu.rpi.rcos.ballotbox;

import android.app.Activity;
import android.os.Bundle;

import com.example.gulena.ballotbox.R;


public class NewElectionActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_election);
    }
}
