package com.maf.header.setting.utils.http;

import android.content.Context;
import android.text.TextUtils;

import com.maf.header.setting.bean.SubjectCategoryDataSum;
import com.maf.header.setting.utils.CommonUtils;
import com.nd.android.okhttp.Call;
import com.nd.android.okhttp.Callback;
import com.nd.android.okhttp.OkHttpClient;
import com.nd.android.okhttp.Request;
import com.nd.smartcan.frame.command.RequestCommand;

/**
 * Created by CLH on 2016/7/12.
 */
public class MAFHttpManager {
    private volatile static MAFHttpManager singleton;
    private OkHttpClient mOkHttpClient;

    private MAFHttpManager() {
        mOkHttpClient = new OkHttpClient();
    }

    public static MAFHttpManager getSingleton() {
        if (singleton == null) {
            synchronized (MAFHttpManager.class) {
                if (singleton == null) {
                    singleton = new MAFHttpManager();
                }
            }
        }
        return singleton;
    }

    public void getSubjectCategoryData(String url, Callback callback) {
        getSubjectCategoryData(null, url, callback);
    }

    public void getSubjectCategoryData(String sysLanguage, String url, Callback callback) {
        Request.Builder builder = new Request.Builder();
        if (!TextUtils.isEmpty(sysLanguage)) {
            builder.addHeader("Accept-Language", sysLanguage);
        }
        builder.url(url);
        final Request request = builder.build();
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(callback);
    }

    public void ge(){
        RequestCommand<SubjectCategoryDataSum> requestCommand=new RequestCommand<SubjectCategoryDataSum>() {
            @Override
            public SubjectCategoryDataSum execute() throws Exception {
                return null;
            }
        };

    }
}