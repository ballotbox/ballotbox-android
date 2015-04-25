package edu.rpi.rcos.ballotbox;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.gulena.ballotbox.R;

import java.util.List;

public class ElectionAdapter extends ArrayAdapter<Election> {

    public ElectionAdapter(Context context, List<Election> elections) {
        super(context, 0, elections);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_election, parent, false);
        }
        TextView electionQuestion = (TextView) convertView.findViewById(R.id.election_question_text);
        Election election = getItem(position);
        electionQuestion.setText(election.getQuestion());
        return convertView;
    }
}
