package com.maf.header.setting.view;

import com.maf.header.setting.bean.SubjectCategory;
import com.nd.android.okhttp.Response;

import java.util.List;

/**
 * Created by CLH on 2016/7/12.
 */
public interface ISubjectCategoryView {
    void refreshList(List<SubjectCategory> subjectCategoryList);

    void getDataFailed(Response response);
}
