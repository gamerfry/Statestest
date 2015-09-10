package com.example.fryjc.statestest.dagger.modules;

import android.content.Context;

import com.example.fryjc.statestest.network.StateParkAPI;

import dagger.Module;
import dagger.Provides;

/**
 * Created by fryjc on 9/9/2015.
 */
@Module
public class NetworkModule {

    @Provides
    protected StateParkAPI providesStateParkAPI(){
        return new StateParkAPI();
    }
}
