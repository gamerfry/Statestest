package com.example.fryjc.statestest.dagger.modules;

import android.app.Application;

import dagger.Module;
import dagger.Provides;

/**
 * Created by fryjc on 9/10/2015.
 */
@Module
public class ApplicationModule {

    private Application mApplication;

    public ApplicationModule(Application application){
        mApplication = application;
    }

    @Provides
    Application providesApplication(){
        return mApplication;
    }

}
