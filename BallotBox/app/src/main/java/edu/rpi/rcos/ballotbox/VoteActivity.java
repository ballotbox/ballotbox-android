package edu.rpi.rcos.ballotbox;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;

import com.example.gulena.ballotbox.R;

public class VoteActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_poll);
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



    protected Poll p;

    public static void openVoteView(String vote_id, Context c) {
        Intent intent = new Intent(c,VoteActivity.class);  //caching?
    }
}
