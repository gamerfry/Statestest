package com.example.fryjc.statestest.base;

import android.app.Application;


import com.example.fryjc.statestest.dagger.components.ApplicationComponent;
import com.example.fryjc.statestest.dagger.components.DaggerNetworkComponent;
import com.example.fryjc.statestest.dagger.components.NetworkComponent;
import com.example.fryjc.statestest.dagger.modules.ApplicationModule;

/**
 * Created by fryjc on 9/10/2015.
 */
public class BaseApplication extends Application {

    private static NetworkComponent sNetworkComponent;

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
