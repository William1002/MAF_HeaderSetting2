package com.maf.header.setting.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.widget.Button;

import com.maf.header.setting.R;
import com.maf.header.setting.adapter.MySpinnerAdapter;
import com.maf.header.setting.bean.SubjectCategory;
import com.maf.header.setting.presenter.SubjectCategoryPresenter;
import com.maf.header.setting.view.ISubjectCategoryView;
import com.nd.android.okhttp.Response;
import com.sina.weibo.sdk.utils.LogUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ISubjectCategoryView {
    SubjectCategoryPresenter subjectCategoryPresenter;
    @BindView(R.id.btn_get_subject_category_data)
    Button btnGetSubjectCategoryData;
    MySpinnerAdapter mSpinnerAdapter;
    @BindView(R.id.spn_subject_category)
    AppCompatSpinner spnSubjectCategory;

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
                subjectCategoryPresenter.getSubjectCategoryListCommand();
            }
        });
        mSpinnerAdapter = new MySpinnerAdapter(new ArrayList<SubjectCategory>(), this);
        spnSubjectCategory.setAdapter(mSpinnerAdapter);
    }

    @Override
    public void refreshList(List<SubjectCategory> subjectCategoryList) {
        LogUtil.e("MainActivity", "subjectCategoryList:" + subjectCategoryList.size());
        mSpinnerAdapter.setDataList(subjectCategoryList);
    }

    @Override
    public void getDataFailed(Response response) {

    }
}
