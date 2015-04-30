package edu.rpi.rcos.ballotbox;

import android.os.Parcelable;

import java.util.List;

public interface DataManager extends Parcelable {  // consider making abstract class

    public boolean login(String username, String password);

    public boolean isLoggedIn();

    //GET METHODS

    /**
     *
     * @param private_id the hidden id of each election needed to access its internals
     * @return the election with the given private_id, or null if no such election exists
     */
    public Election getElectionWithID(String private_id);

    /**
     *
     * @return A list of all of the elections that have been set to public
     */
    public List<Election> getPublicElections();

    public Choice getVoteOnElection(Election p);

    //POST METHODS

    public Election createNewElection(Election p);

    public Election editElection(Election p);

    public boolean deleteElection(Election p);

    public boolean voteOnElection(Election p, Choice c);


}
