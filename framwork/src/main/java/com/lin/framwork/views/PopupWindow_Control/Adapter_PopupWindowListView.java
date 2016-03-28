package com.lin.framwork.views.PopupWindow_Control;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lin.framwork.R;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 林炜智 on 2016/3/25.
 */
public class Adapter_PopupWindowListView extends BaseAdapter {
    private LayoutInflater inflater;
    private Context context;
    private List<String> stringList;

    public Adapter_PopupWindowListView(Context context, List<String> list) {
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        this.stringList = list;
    }

    @Override
    public int getCount() {
        if (stringList == null)
            return 0;
        return stringList.size();
    }

    @Override
    public Object getItem(int position) {
        return stringList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.adapter_popupwindow_listview, null);
            holder = new ViewHolder();
            holder.adapterPopupwindowListviewTextView = ButterKnife.findById(convertView, R.id.adapter_popupwindow_listview_TextView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.adapterPopupwindowListviewTextView.setText(stringList.get(position));
        holder.adapterPopupwindowListviewTextView.setSelected(true);
        return convertView;
    }

    static class ViewHolder {
        TextView adapterPopupwindowListviewTextView;
    }
}
