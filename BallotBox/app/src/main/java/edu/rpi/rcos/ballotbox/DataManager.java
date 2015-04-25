package edu.rpi.rcos.ballotbox;

import android.os.Parcelable;

import java.util.List;

public interface DataManager extends Parcelable {
    /**
     *
     * @param private_id the hidden id of each poll needed to access its internals
     * @return the poll with the given private_id, or null if no such poll exists
     */
    public Poll getPollWithID(String private_id);

    /**
     *
     * @return A list of all of the polls that have been set to public
     */
    public List<Poll> getPublicPolls();

    public boolean login(String username, String password);

    public boolean isLoggedIn();
}
