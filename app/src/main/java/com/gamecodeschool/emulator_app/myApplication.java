package com.gamecodeschool.emulator_app;

import android.app.Application;

import com.facebook.stetho.Stetho;

public class myApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
