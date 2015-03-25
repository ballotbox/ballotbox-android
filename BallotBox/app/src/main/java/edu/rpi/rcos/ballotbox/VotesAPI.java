package edu.rpi.rcos.ballotbox;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

public interface VotesAPI {

    @GET("/api/votes/{id}")
    public void getPoll(@Path("id") String randId, retrofit.Callback<Poll> response);

    @GET("/api/votes/")
    public void getPublicPolls(Callback<List<Poll>> response);

}