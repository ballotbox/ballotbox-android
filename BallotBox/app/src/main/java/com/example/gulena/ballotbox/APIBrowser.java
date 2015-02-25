package com.example.gulena.ballotbox;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class APIBrowser {
    public static final String BASE_URL = "http://ballotbox.com/api";

    public static JSONObject request(String urlString) throws Exception {
        BufferedReader bufferedReader;
        URL apiURL = new URL(urlString);
        bufferedReader = new BufferedReader(new InputStreamReader(apiURL.openStream()));
        String s = "";
        String line;
        while((line = bufferedReader.readLine()) != null) {
            s += line + "\n";
        }
        bufferedReader.close();
        return new JSONObject(s);
    }

    public static JSONObject getSinglePoll(Poll p) throws Exception {
        return request(BASE_URL + "/" + p.getRandom_access_id());
    }
}
