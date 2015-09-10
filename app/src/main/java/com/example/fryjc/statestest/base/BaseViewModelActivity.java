package com.example.fryjc.statestest.base;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by fryjc on 9/10/2015.
 */
public abstract class BaseViewModelActivity<T extends BaseViewModel>  extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getViewModel();
    }

    @Override
    protected void onResume(){
        super.onResume();
        getViewModel().onAttach();
    }

    @Override
    protected void onPause() {
        super.onPause();
        getViewModel().onDetach();
    }

    protected abstract T getViewModel();
}
