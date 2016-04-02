package com.eron.hairdresser.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.eron.hairdresser.R;
import com.eron.hairdresser.model.Expire_Model;
import com.lin.framwork.utils.SpannableStringUtil;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 林炜智 on 2016/3/21.
 */
public class AccountBook_Fragment_ListView_Adapter extends BaseAdapter {
    private LayoutInflater inflater;
    private List<Expire_Model> modelList;
    private Context context;

    public AccountBook_Fragment_ListView_Adapter(Context context, List<Expire_Model> list) {
        this.inflater = LayoutInflater.from(context);
        this.modelList = list;
        this.context = context;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.adapter_expire_activity_listview, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        String Type = context.getResources().getString(R.string.type) + modelList.get(0).getObject().get(position).getLength();
        String Name = context.getResources().getString(R.string.name) + modelList.get(0).getObject().get(position).getName();
        String Phone = context.getResources().getString(R.string.phone) + modelList.get(0).getObject().get(position).getPhone();

        holder.adapterExpireActivityListviewRanking.setText((position + 1) + "");
        holder.adapterExpireActivityListviewTime.setText("16/3/30");
        holder.adapterExpireActivityListviewType.setText(SpannableStringUtil.getForegroundColor(Type, context.getResources().getColor(R.color.text_color1), 4, Type.length()));
        holder.adapterExpireActivityListviewName.setText(SpannableStringUtil.getForegroundColor(Name, context.getResources().getColor(R.color.text_color1), 4, Name.length()));
        holder.adapterExpireActivityListviewPhone.setText(SpannableStringUtil.getForegroundColor(Phone, context.getResources().getColor(R.color.text_color1), 4, Phone.length()));
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.adapter_expire_activity_listview_Ranking)
        TextView adapterExpireActivityListviewRanking;
        @Bind(R.id.adapter_expire_activity_listview_Time)
        TextView adapterExpireActivityListviewTime;
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
