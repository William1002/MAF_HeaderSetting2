package com.maf.header.setting.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.support.annotation.Nullable;
import android.support.v7.widget.ThemedSpinnerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.maf.header.setting.R;
import com.maf.header.setting.bean.SubjectCategory;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by CLH on 2016/7/12.
 */
public class MySpinnerAdapter extends BaseAdapter {
    List<SubjectCategory> subjectCategoryList;
    Context context;
    LayoutInflater inflater;

    public MySpinnerAdapter(List<SubjectCategory> subjectCategoryList, Context context) {
        this.subjectCategoryList = subjectCategoryList;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return subjectCategoryList.size();
    }

    @Override
    public Object getItem(int position) {
        return subjectCategoryList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        SubjectCategory data = subjectCategoryList.get(position);
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.subject_category_list_item, null);
            viewHolder.tvName = (TextView) convertView.findViewById(R.id.tv_subject_category_item_name);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tvName.setText(data.getTitle() + " " + "-" + " " + data.getShortName());
        return convertView;
    }

    public void refresh() {
        notifyDataSetChanged();
    }

    public void setDataList(List<SubjectCategory> subjectCategoryList) {
        this.subjectCategoryList.clear();
        this.subjectCategoryList.addAll(subjectCategoryList);
        refresh();
    }

    class ViewHolder {
        TextView tvName;
    }
}
