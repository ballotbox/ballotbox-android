package edu.rpi.rcos.ballotbox;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

public class PublicVotesAdapter extends ArrayAdapter<Election> {

    List<Election> elections;
    public PublicVotesAdapter(Context context, int resource, List<Election> elections) {
        super(context, resource);
        this.elections = elections;
    }

    public void setElections(List<Election> elections) {
        this.elections = elections;
    }
}
