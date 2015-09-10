package com.example.fryjc.statestest.models;

/**
 * Created by fryjc on 9/9/2015.
 */
public class StatePark {
    private String mStateParkName;
    private String mStateID;
    private String mStateParkImgURL;

    public StatePark(String mStateParkName, String mStateID, String mStateParkImgURL) {
        this.mStateParkName = mStateParkName;
        this.mStateID = mStateID;
        this.mStateParkImgURL = mStateParkImgURL;
    }

    public StatePark() {

    }

    public String getmStateParkName() {
        return mStateParkName;
    }

    public void setmStateParkName(String mStateParkName) {
        this.mStateParkName = mStateParkName;
    }

    public String getmStateID() {
        return mStateID;
    }

    public void setmStateID(String mStateID) {
        this.mStateID = mStateID;
    }

    public String getmStateParkImgURL() {
        return mStateParkImgURL;
    }

    public void setmStateParkImgURL(String mStateParkImgURL) {
        this.mStateParkImgURL = mStateParkImgURL;
    }
}
