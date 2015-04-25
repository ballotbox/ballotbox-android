package edu.rpi.rcos.ballotbox;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class APIBrowser {
    public static final String BASE_URL = "http://ballot-box.herokuapp.com";
    public static final String PUBLIC_VOTES_URL = "";

    public static JSONObject request(String urlString) throws Exception {
        BufferedReader bufferedReader;
        URL apiURL = new URL(urlString);
        HttpURLConnection httpURLConnection = (HttpURLConnection)apiURL.openConnection();
        bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line;
        while((line = bufferedReader.readLine()) != null) {
            sb.append(line + "\n");
        }
        bufferedReader.close();
        return new JSONObject(sb.toString());
    }

    public static JSONObject getSingleElection(Election e) throws Exception {
        return request(BASE_URL + "/" + e.getRandom_access_id());
    }

    public static JSONArray getPublicElections() throws Exception {

        JSONObject returned_object = request(BASE_URL + PUBLIC_VOTES_URL);
        return returned_object.getJSONArray("Public_Votes");
    }
}
