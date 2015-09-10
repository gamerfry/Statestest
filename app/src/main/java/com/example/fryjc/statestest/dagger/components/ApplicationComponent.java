package com.example.fryjc.statestest.dagger.components;

import android.app.Application;

import com.example.fryjc.statestest.dagger.modules.ApplicationModule;

import dagger.Component;

/**
 * Created by fryjc on 9/10/2015.
 */
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    Application getApplication();
}
