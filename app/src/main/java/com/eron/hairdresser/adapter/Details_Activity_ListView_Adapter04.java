package com.eron.hairdresser.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.eron.hairdresser.R;
import com.eron.hairdresser.model.PermDye_Model;
import com.lin.framwork.utils.SpannableStringUtil;
import com.lin.framwork.views.Toast_Control.Toast_Common;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 林炜智 on 2016/3/15.
 */
public class Details_Activity_ListView_Adapter04 extends BaseAdapter {
    private LayoutInflater inflater;
    private Context context;
    private List<PermDye_Model> modelList;

    public Details_Activity_ListView_Adapter04(Context context, List<PermDye_Model> list) {
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        this.modelList = list;
    }

    @Override
    public int getCount() {
        return modelList == null ? 0 : modelList.size();
    }

    @Override
    public Object getItem(int position) {
        return modelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.adapter_details_activity_listview04, null);
        } else {
        }
        return convertView;
    }
}
