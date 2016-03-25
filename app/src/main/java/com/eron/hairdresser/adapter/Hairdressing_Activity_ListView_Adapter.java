package com.eron.hairdresser.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.eron.hairdresser.R;
import com.eron.hairdresser.model.Customer_Model;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 林炜智 on 2016/3/12.
 */
public class Hairdressing_Activity_ListView_Adapter extends BaseAdapter {
    private LayoutInflater inflater;
    private Context context;
    private List<Customer_Model> modelList;

    public Hairdressing_Activity_ListView_Adapter(Context context, List<Customer_Model> list) {
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        this.modelList = list;
    }

    @Override
    public int getCount() {
        return modelList == null?0:modelList.size();
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
            convertView = inflater.inflate(R.layout.adapter_hairdressing_activity_listview, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        if (modelList.get(position).getCardVariety() == 1) {
            holder.adapterHairdressingActivityListviewLinearLayout.setBackgroundColor(convertView.getResources().getColor(R.color.adapter_hairdressing_activity_listview_8zhe));
            holder.adapterHairdressingActivityListviewVariety.setText("8折");
        } else {
            holder.adapterHairdressingActivityListviewLinearLayout.setBackgroundColor(convertView.getResources().getColor(R.color.adapter_hairdressing_activity_listview_ganen));
            holder.adapterHairdressingActivityListviewVariety.setText("感恩");
        }
        holder.adapterHairdressingActivityListviewName.setText(modelList.get(position).getName());
        holder.adapterHairdressingActivityListviewNumber.setText(modelList.get(position).getCardNumber());
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.adapter_hairdressing_activity_listview_name)
        TextView adapterHairdressingActivityListviewName;
        @Bind(R.id.adapter_hairdressing_activity_listview_number)
        TextView adapterHairdressingActivityListviewNumber;
        @Bind(R.id.adapter_hairdressing_activity_listview_variety)
        TextView adapterHairdressingActivityListviewVariety;
        @Bind(R.id.adapter_hairdressing_activity_listview_LinearLayout)
        LinearLayout adapterHairdressingActivityListviewLinearLayout;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
