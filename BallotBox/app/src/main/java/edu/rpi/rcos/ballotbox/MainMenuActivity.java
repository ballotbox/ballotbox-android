package edu.rpi.rcos.ballotbox;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
                viewPublicPolls();
            }
        });

        View button = findViewById(R.id.view_private_menu);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText privateEdit = (EditText) findViewById(R.id.private_poll_id_edit);
                viewPrivatePoll(privateEdit.getText().toString());
            }
        });

        View addNewPoll = findViewById(R.id.new_poll_menu_text);
        addNewPoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNewPoll();
            }
        });

    }

    /*
    *   Go to Public Polls Activity
     */
    public void viewPublicPolls() {
        Intent intent = new Intent(this,PublicVotesActivity.class);
        intent.putExtra("data_manager",dataManager);
        startActivity(intent);
    }

    /*
    *   Go to the Private Poll with the id given in the edit text field if possible
    *       Else, toast failure.
     */

    public void viewPrivatePoll(String private_id) {
        if(private_id != null && !private_id.equals("")) {
            Intent intent = new Intent(this,VoteActivity.class);
            intent.putExtra("random_id",private_id);
            intent.putExtra("data_manager",dataManager);
            Log.i(TAG,"Visiting poll with id " + private_id + ".");
            startActivity(intent);
        }
    }


    public void createNewPoll() {
        Intent intent = new Intent(this,NewPollActivity.class);
        intent.putExtra("data_manager",dataManager);
        startActivity(intent);
    }
}
