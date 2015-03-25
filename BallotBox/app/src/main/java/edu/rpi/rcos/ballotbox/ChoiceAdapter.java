package edu.rpi.rcos.ballotbox;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.gulena.ballotbox.R;

import java.util.List;

public class ChoiceAdapter extends ArrayAdapter<Choice> {
    public ChoiceAdapter(Context c, List<Choice> choices) {
        super(c,0,choices);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Choice choice = getItem(position);
        if(convertView == null) {

        }

        TextView choiceName = (TextView) convertView.findViewById(R.id.choiceName);
        choiceName.setText(choice.getText());
        CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.choiceCheckBox);
        checkBox.setChecked(choice.isVoted());
        return convertView;
    }
}
