package com.eron.hairdresser.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.eron.hairdresser.R;
import com.eron.hairdresser.model.Expire_Model;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 林炜智 on 2016/3/21.
 */
public class Expire_Activity_ListView_Adapter extends BaseAdapter {
    private LayoutInflater inflater;
    private List<Expire_Model> modelList;

    public Expire_Activity_ListView_Adapter(Context context, List<Expire_Model> list) {
        this.inflater = LayoutInflater.from(context);
        this.modelList = list;
    }

    @Override
    public int getCount() {
        if (modelList == null)
            return 0;
        return modelList.size();
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
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.adapter_expire_activity_listview, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.adapterExpireActivityListviewRanking.setText((position + 1) + "");
        holder.adapterExpireActivityListviewCardNumber.setText("VIP卡号：" + modelList.get(position).getCardNumber());
        holder.adapterExpireActivityListviewType.setText("预约服务：" + modelList.get(position).getType());
        holder.adapterExpireActivityListviewName.setText("姓名：" + modelList.get(position).getName());
        holder.adapterExpireActivityListviewPhone.setText("电话" + modelList.get(position).getPhone());
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.adapter_expire_activity_listview_Ranking)
        TextView adapterExpireActivityListviewRanking;
        @Bind(R.id.adapter_expire_activity_listview_CardNumber)
        TextView adapterExpireActivityListviewCardNumber;
        @Bind(R.id.adapter_expire_activity_listview_Type)
        TextView adapterExpireActivityListviewType;
        @Bind(R.id.adapter_expire_activity_listview_Name)
        TextView adapterExpireActivityListviewName;
        @Bind(R.id.adapter_expire_activity_listview_Phone)
        TextView adapterExpireActivityListviewPhone;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
