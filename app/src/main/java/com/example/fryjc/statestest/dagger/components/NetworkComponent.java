package com.example.fryjc.statestest.dagger.components;

import com.example.fryjc.statestest.dagger.modules.NetworkModule;
import com.example.fryjc.statestest.network.StateParkAPI;

import javax.inject.Scope;

import dagger.Component;

/**
 * Created by fryjc on 9/10/2015.
 */
@Component(modules = {NetworkModule.class})
public interface NetworkComponent {

    StateParkAPI getStateParkAPI();

}
