package com.eron.hairdresser.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.eron.hairdresser.R;
import com.eron.hairdresser.common.ConstantResource;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 林炜智 on 2016/3/11.
 */
public class Setting_Activity_ListView_Adapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private List<String> textList;

    public Setting_Activity_ListView_Adapter(Context context, List<String> list) {
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        this.textList = list;
    }

    @Override
    public int getCount() {
        return textList == null ? 0 : textList.size();
    }

    @Override
    public Object getItem(int position) {
        return textList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.adapter_setting_activity_listview, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.adapterSettingActivityListviewTextView.setText(textList.get(position));
        holder.adapterSettingActivityListviewImageView.setImageResource(ConstantResource.getImgAdvance());
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.adapter_setting_activity_listview_TextView)
        TextView adapterSettingActivityListviewTextView;
        @Bind(R.id.adapter_setting_activity_listview_ImageView)
        ImageView adapterSettingActivityListviewImageView;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
