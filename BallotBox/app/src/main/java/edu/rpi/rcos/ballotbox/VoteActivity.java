package edu.rpi.rcos.ballotbox;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import com.example.gulena.ballotbox.R;

public class VoteActivity extends Activity {

    protected Election p;
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
        ArrayAdapter<Choice> choiceArrayAdapter = new ChoiceAdapter(this, p.getChoices());
        ListView listView = (ListView) findViewById(R.id.choiceList);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
                //TODO: make post request
            }
        });
    }
}
