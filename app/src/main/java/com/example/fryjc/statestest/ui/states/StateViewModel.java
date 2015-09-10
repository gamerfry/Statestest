package com.example.fryjc.statestest.ui.states;

import com.example.fryjc.statestest.base.BaseViewModel;
import com.example.fryjc.statestest.models.State;
import com.example.fryjc.statestest.network.StateParkAPI;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by fryjc on 9/9/2015.
 */
public class StateViewModel extends BaseViewModel {
    private ArrayList<State> mStateList;
    private Listener mListener;
    private Gson gson;
    private StateParkAPI stateParkAPI;

    @Inject
    public StateViewModel(StateParkAPI api){
        stateParkAPI = api;
    }

    public void initialize(File cacheDir) {
        if(gson == null)
            gson = new Gson();
        stateParkAPI.Initialize(cacheDir);
        String states = stateParkAPI.GetStates();
        mStateList = gson.fromJson(states,new TypeToken<ArrayList<State>>(){}.getType());
        stateUpdate();
    }

    public void storeStates(String stateData) {
        if(gson == null)
            gson = new Gson();
        mStateList = gson.fromJson(stateData,new TypeToken<ArrayList<State>>(){}.getType());
        stateUpdate();
    }

    public void setListener(Listener listener){
        mListener = listener;
    }

    public ArrayList<State> getStateList(){
        return mStateList;
    }

    public String getSerializedStateList(){
        if(gson == null)
            gson = new Gson();
        return gson.toJson(mStateList);
    }

    public interface Listener{
        public void onChange();
    }

    public void stateUpdate(){
        if(mListener != null)
            mListener.onChange();
    }

}
