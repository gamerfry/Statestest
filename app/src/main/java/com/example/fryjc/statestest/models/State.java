package com.example.fryjc.statestest.models;

import java.util.ArrayList;

/**
 * Created by fryjc on 9/9/2015.
 */
public class State {
    private String mFact1;
    private String mFact2;
    private String mFact3;
    private String mFact4;
    private String mStateName;
    private String mStateID;

    public State(String mFact1,String mFact2,String mFact3,String mFact4, String mStateName, String mStateID) {
        this.mFact1=mFact1;
        this.mFact2=mFact2;
        this.mFact3=mFact3;
        this.mFact4=mFact4;
        this.mStateName = mStateName;
        this.mStateID = mStateID;
    }

    public String getmFact1() {
        return mFact1;
    }

    public void setmFact1(String mFact1) {
        this.mFact1 = mFact1;
    }

    public String getmFact2() {
        return mFact2;
    }

    public void setmFact2(String mFact2) {
        this.mFact2 = mFact2;
    }

    public String getmFact3() {
        return mFact3;
    }

    public void setmFact3(String mFact3) {
        this.mFact3 = mFact3;
    }

    public String getmFact4() {
        return mFact4;
    }

    public void setmFact4(String mFact4) {
        this.mFact4 = mFact4;
    }

    public State() {
    }


    public String getmStateName() {
        return mStateName;
    }

    public void setmStateName(String mStateName) {
        this.mStateName = mStateName;
    }

    public String getmStateID() {
        return mStateID;
    }

    public void setmStateID(String mStateID) {
        this.mStateID = mStateID;
    }
}
