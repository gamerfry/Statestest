package com.example.fryjc.statestest.network;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.example.fryjc.statestest.models.State;
import com.example.fryjc.statestest.models.StatePark;

import java.util.ArrayList;

/**
 * Created by fryjc on 9/9/2015.
 */
public interface StateParkNetBase {

    public String GetStates();
    public String GetStateParksByID(String id);

}
