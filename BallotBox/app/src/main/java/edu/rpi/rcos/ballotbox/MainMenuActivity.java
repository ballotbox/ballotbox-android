package edu.rpi.rcos.ballotbox;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gulena.ballotbox.R;


public class MainMenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

    }

    /*
    *   Go to Public Polls Activity
     */
    public void viewPublicPolls() {
        Intent intent = new Intent(this,PublicVotesActivity.class);
        startActivity(intent);
    }

    /*
    *   Go to the Private Poll with the id given in the edit text field if possible
    *       Else, toast failure.
     */

    public void viewPrivatePoll() {
        EditText editText = (EditText) this.findViewById(R.id.private_poll_id_edit);
        String private_id = editText.getText().toString();
        if(private_id != null && private_id != "") {
            if(!VoteActivity.openVoteView(private_id,this)) {
                Toast.makeText(this,"Could not find ballot with id: " + private_id,
                        Toast.LENGTH_LONG).show();
            }
        }
    }


    public void createNewPoll() {
        //TODO: not yet implemented
    }
}
