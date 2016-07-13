package com.maf.header.setting;

import android.app.Application;

import com.nd.smartcan.frame.AppDelegate;

/**
 * Created by Administrator on 2014/12/3.
 */
public class AppTemplateApplication extends  Application {

    protected AppDelegate mAppDelegate ;

    @Override
    public void onCreate() {
        super.onCreate();
        //不能删除new AppDelegate(this);
        mAppDelegate = new AppDelegate(this);
    }

    @Override
    public void onTerminate() {
        mAppDelegate.release();
        super.onTerminate();
    }

    @Override
    public void onLowMemory() {
        mAppDelegate.release();
        super.onLowMemory();
    }

}
