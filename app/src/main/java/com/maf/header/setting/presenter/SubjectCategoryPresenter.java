package com.maf.header.setting.presenter;

import android.content.Context;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maf.header.setting.bean.SubjectCategoryDataSum;
import com.maf.header.setting.remote.command.SubjectCategoryCommand;
import com.maf.header.setting.utils.CommonUtils;
import com.maf.header.setting.utils.http.MAFHttpManager;
import com.maf.header.setting.view.ISubjectCategoryView;
import com.nd.android.okhttp.Callback;
import com.nd.android.okhttp.Request;
import com.nd.android.okhttp.Response;
import com.nd.smartcan.frame.command.CommandCallback;
import com.sina.weibo.sdk.utils.LogUtil;

import java.io.IOException;

/**
 * Created by CLH on 2016/7/12.
 */
public class SubjectCategoryPresenter {
    ISubjectCategoryView subjectCategoryView;
    String subjectCategory_url = "http://esp-lifecycle.pre1.web.nd/v0.6/" +
            "categories/$S/datas?words&limit=(0,1000)";
    Context context;

    public SubjectCategoryPresenter(ISubjectCategoryView subjectCategoryView, Context context) {
        this.subjectCategoryView = subjectCategoryView;
        this.context = context;
    }

    public void getSubjectCategoryList() {
        MAFHttpManager.getSingleton().getSubjectCategoryData(CommonUtils.getSysLanguage(context),
                subjectCategory_url, new Callback() {
                    @Override
                    public void onFailure(Request request, IOException e) {
                        e.printStackTrace();

                    }

                    @Override
                    public void onResponse(Response response) throws IOException {
                        ObjectMapper objectMapper = new ObjectMapper();
                        try {
                            SubjectCategoryDataSum resultData = objectMapper.readValue(response.body().string(), SubjectCategoryDataSum.class);
                            subjectCategoryView.refreshList(resultData.getItems());
                        } catch (JsonParseException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        } catch (JsonMappingException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }

                    }
                });
    }

    public void getSubjectCategoryListCommand() {
        new SubjectCategoryCommand(CommonUtils.getSysLanguage(context)).post(new CommandCallback<SubjectCategoryDataSum>() {
            @Override
            public void onSuccess(SubjectCategoryDataSum result) {
                subjectCategoryView.refreshList(result.getItems());
            }

            @Override
            public void onFail(Exception e) {

            }
        });
    }
}
