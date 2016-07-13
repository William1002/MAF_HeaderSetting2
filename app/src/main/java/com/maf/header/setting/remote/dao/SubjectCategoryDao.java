package com.maf.header.setting.remote.dao;

import com.maf.header.setting.bean.SubjectCategory;
import com.maf.header.setting.bean.SubjectCategoryDataSum;
import com.nd.smartcan.core.restful.ClientResource;
import com.nd.smartcan.core.restful.ResourceException;
import com.nd.smartcan.frame.dao.RestDao;
import com.nd.smartcan.frame.exception.DaoException;

import java.util.Map;

/**
 * Created by CLH on 2016/7/12.
 */
public class SubjectCategoryDao extends RestDao<SubjectCategoryDataSum> {
    String languageName;

    public SubjectCategoryDao(String languageName) {
        this.languageName = languageName;
    }

    @Override
    protected String getResourceUri() {
        return "http://esp-lifecycle.pre1.web.nd/v0.6/categories/$S/datas?words&limit=(0,1000)";
    }

    @Override
    protected <R> R get(String uri, Map<String, Object> param, Class<R> returnClass) throws DaoException {
        ClientResource cr = new ClientResource(uri);
        cr.addHeader("Accept-Language", languageName);
        cr.bindArgument(param);
        try {
            return cr.get(returnClass);
        } catch (ResourceException e) {
            throw new DaoException(e);
        }
    }
}
