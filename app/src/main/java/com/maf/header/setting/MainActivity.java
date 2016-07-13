package com.maf.header.setting;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.maf.header.setting.bean.SubjectCategory;
import com.maf.header.setting.presenter.SubjectCategoryPresenter;
import com.maf.header.setting.view.ISubjectCategoryView;
import com.nd.android.okhttp.Response;
import com.sina.weibo.sdk.utils.LogUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ISubjectCategoryView {
    SubjectCategoryPresenter subjectCategoryPresenter;
    @BindView(R.id.btn_get_subject_category_data)
    Button btnGetSubjectCategoryData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        subjectCategoryPresenter = new SubjectCategoryPresenter(this, this);
        initViews();
    }

    void initViews() {
        btnGetSubjectCategoryData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subjectCategoryPresenter.getSubjectCategoryList();
            }
        });
    }

    @Override
    public void refreshList(List<SubjectCategory> subjectCategoryList) {
        LogUtil.e("MainActivity", "subjectCategoryList:" + subjectCategoryList.size());
    }

    @Override
    public void getDataFailed(Response response) {

    }
}
