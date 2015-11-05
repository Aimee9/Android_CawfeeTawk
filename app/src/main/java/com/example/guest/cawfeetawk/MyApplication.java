package com.example.guest.cawfeetawk;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by Guest on 11/5/15.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.enableLocalDatastore(this);

        Parse.initialize(this, "xSh23vOeeJ2rhYHqDiw3tp9JTCW0y7AuM2hy9U6A", "MEwhKycqLE6mQkFpP63dY5PS5sHbE5UlwrxOQEQo");


    }
}