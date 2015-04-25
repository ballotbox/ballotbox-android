package edu.rpi.rcos.ballotbox;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.gulena.ballotbox.R;


public class MainMenuActivity extends Activity {
    final String TAG = "MainMenuActivity";

    private DataManager dataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataManager = new TestDataManager();
        setContentView(R.layout.main_menu);

        //set the event listeners for buttons
        View viewPublicButton = findViewById(R.id.ViewPublic);
        viewPublicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPublicElections();
            }
        });

        View button = findViewById(R.id.view_private_menu);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText privateEdit = (EditText) findViewById(R.id.private_election_id_edit);
                viewPrivateElection(privateEdit.getText().toString());
            }
        });

        View addNewElection = findViewById(R.id.new_election_menu_text);
        addNewElection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNewElection();
            }
        });

    }

    /*
    *   Go to Public Polls Activity
     */
    public void viewPublicElections() {
        Intent intent = new Intent(this,PublicVotesActivity.class);
        intent.putExtra("data_manager",dataManager);
        startActivity(intent);
    }

    /*
    *   Go to the Private Poll with the id given in the edit text field if possible
    *       Else, toast failure.
     */

    public void viewPrivateElection(String private_id) {
        if(private_id != null && !private_id.equals("")) {
            Intent intent = new Intent(this,VoteActivity.class);
            intent.putExtra("random_id",private_id);
            intent.putExtra("data_manager",dataManager);
            Log.i(TAG,"Visiting election with id " + private_id + ".");
            startActivity(intent);
        }
    }


    public void createNewElection() {
        Intent intent = new Intent(this,NewElectionActivity.class);
        intent.putExtra("data_manager",dataManager);
        startActivity(intent);
    }
}
