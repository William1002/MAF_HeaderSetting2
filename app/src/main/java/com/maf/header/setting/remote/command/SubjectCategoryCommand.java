package com.maf.header.setting.remote.command;

import com.maf.header.setting.bean.SubjectCategoryDataSum;
import com.maf.header.setting.remote.dao.SubjectCategoryDao;
import com.nd.smartcan.frame.command.RequestCommand;

/**
 * Created by CLH on 2016/7/12.
 */
public class SubjectCategoryCommand extends RequestCommand<SubjectCategoryDataSum> {
    String languageName;

    public SubjectCategoryCommand(String languageName) {
        this.languageName = languageName;
    }

    @Override
    public SubjectCategoryDataSum execute() throws Exception {

        return new SubjectCategoryDao(languageName).get(null);
    }
}
