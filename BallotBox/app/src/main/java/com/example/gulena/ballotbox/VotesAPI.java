package com.example.gulena.ballotbox;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by chris on 3/1/15.
 */
public interface VotesAPI {

    @GET("/api/votes/{id}")
    public void getPoll(@Path("id") String randId, retrofit.Callback<Poll> response);

    @GET("/api/votes/")
    public void getPublicPolls(Callback<List<Poll>> response);

}
