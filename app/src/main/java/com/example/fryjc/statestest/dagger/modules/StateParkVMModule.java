package com.example.fryjc.statestest.dagger.modules;

import com.example.fryjc.statestest.network.StateParkAPI;
import com.example.fryjc.statestest.ui.stateparks.StateParksViewModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by fryjc on 9/10/2015.
 */
@Module
public class StateParkVMModule {

    @Provides
    StateParksViewModel providesStateParksViewModel(StateParkAPI api){
        return new StateParksViewModel(api);
    }
}
