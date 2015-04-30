package edu.rpi.rcos.ballotbox;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gulena.ballotbox.R;

public class VoteActivity extends ListActivity {

    protected Election p;
    ChoiceAdapter array;
    DataManager dataManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String private_id = getIntent().getStringExtra("random_id");
        dataManager = (getIntent().getParcelableExtra("data_manager"));
        p = dataManager.getElectionWithID(private_id);
        if(p == null) {
            Toast.makeText(this, "Could not find ballot with id: " + private_id,
                    Toast.LENGTH_LONG).show();
            finish();
            return;
        }
        setContentView(R.layout.single_election);
        array = new ChoiceAdapter(this, p.getChoices());
        TextView title = (TextView) findViewById(R.id.election_title);
        title.setText(p.getQuestion());
        setListAdapter(array);
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                CheckBox checkbox = (CheckBox) view.findViewById(R.id.choiceCheckBox);
                checkbox.toggle();
            }
        });
        Button submitButton = (Button) findViewById(R.id.submit_vote_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Choice c = new Choice(); //TODO get choice
                dataManager.voteOnElection(p,c);
            }
        });
    }
}
