package edu.rpi.rcos.ballotbox;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.gulena.ballotbox.R;

import java.util.List;

public class PollAdapter extends ArrayAdapter<Poll> {

    public PollAdapter(Context context, List<Poll> polls) {
        super(context, 0, polls);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_poll, parent, false);
        }
        TextView pollQuestion = (TextView) convertView.findViewById(R.id.poll_question_text);
        Poll poll = getItem(position);
        pollQuestion.setText(poll.getQuestion());
        return convertView;
    }
}
