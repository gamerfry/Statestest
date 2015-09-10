package com.example.fryjc.statestest.network;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.RequestFuture;
import com.example.fryjc.statestest.R;
import com.google.gson.JsonArray;

import org.json.JSONArray;

import java.io.File;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by fryjc on 9/9/2015.
 */
public class StateParkAPI implements StateParkNetBase {
    private String finalStateResponse;
    private RequestQueue mRequestQueue;
    private String finalStateParkResponse;


    public StateParkAPI() {
    }

    public void Initialize(File cacheDir){
        if(mRequestQueue == null) {
            Cache cache = new DiskBasedCache(cacheDir,1024*1024);
            Network network = new BasicNetwork(new HurlStack());
            mRequestQueue = new RequestQueue(cache,network);
            mRequestQueue.start();
        }
    }
    @Override
    public String GetStates() {
        RequestFuture<JSONArray> future = RequestFuture.newFuture();
        JsonArrayRequest arrayRequest = new JsonArrayRequest(
              "http://glaring-heat-6164.firebaseio.com/States.json",future,future);
        try {
            return future.get(30, TimeUnit.SECONDS).toString();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String GetStateParksByID(String id) {
        JsonArrayRequest arrayRequest = new JsonArrayRequest(
                "https://glaring-heat-6164.firebaseio.com/States/" + id, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                finalStateParkResponse = response.toString();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });
        return finalStateParkResponse;
    }
}
