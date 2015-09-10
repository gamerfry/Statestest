package com.example.fryjc.statestest.ui.stateparks;

import com.example.fryjc.statestest.base.BaseViewModel;
import com.example.fryjc.statestest.models.State;
import com.example.fryjc.statestest.models.StatePark;
import com.example.fryjc.statestest.network.StateParkAPI;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by fryjc on 9/9/2015.
 */
public class StateParksViewModel extends BaseViewModel {
    private ArrayList<StatePark> mStateParkList;
    private Listener mListener;
    private Gson gson;
    private StateParkAPI stateParkAPI;

    @Inject
    public StateParksViewModel(StateParkAPI api){
        stateParkAPI = api;
    }

    public void initialize(File cache, String id) {
        stateParkAPI.Initialize(cache);
        String stateParkData = stateParkAPI.GetStateParksByID(id);
        if(gson == null)
            gson = new Gson();
        mStateParkList = gson.fromJson(stateParkData,new TypeToken<ArrayList<StatePark>>(){}.getType());
        stateParkUpdate();
    }

    public void setListener(Listener listener){
        mListener = listener;
    }

    public ArrayList<StatePark> getStateParkList(){
        return mStateParkList;
    }


    public interface Listener{
        public void onChange();
    }

    public void stateParkUpdate(){
        if(mListener != null)
            mListener.onChange();
    }

}
