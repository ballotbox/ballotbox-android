package edu.rpi.rcos.ballotbox;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;

public interface VotesAPI {

    @GET("/elections/{id}")
    public Election getElection(@Path("id") String randId);

    @GET("/elections")
    public List<Election> getPublicElections();

    @GET("/elections/{id}/vote")
    public Choice getVotesOnElection(@Path("id") String randId);

    @POST("/elections")
    public Election createNewElection(@Body Election election);

    @PUT("/elections")
    public Election editElection(@Body Election election);

    @DELETE("/elections/{id}")
    public boolean deleteElection(@Path("id") String randId);

    @POST("/elections/{eid}/choices/{cid}/vote")
    public boolean voteOnElection(@Path ("eid") String randId, @Path ("cid") Integer choice_id);

    @POST("/oauth/token/")
    public void verifyIdentity(String username, String password);

}
