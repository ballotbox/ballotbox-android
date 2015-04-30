package edu.rpi.rcos.ballotbox;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

public interface VotesAPI {

    @GET("/api/votes/{id}")
    public void getElection(@Path("id") String randId, retrofit.Callback<Election> response);

    @GET("/api/votes/")
    public void getPublicElections(Callback<List<Election>> response);

    @POST("/oauth/token/")
    public void verifyIdentity(String username, String password);

}
