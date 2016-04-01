package com.eron.hairdresser.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.eron.hairdresser.R;
import com.eron.hairdresser.model.Product_Model;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 林炜智 on 2016/3/28.
 */
public class Product_Activity_ListView_Adapter extends BaseAdapter {
    private LayoutInflater inflater;
    private Context context;
    private List<Product_Model> modelList;

    public Product_Activity_ListView_Adapter(Context context, List<Product_Model> list) {
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
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.adapter_product_activity_listview, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.adapterProductActivityListviewName.setText(modelList.get(position).getName());
        holder.adapterProductActivityListviewType.setText("类型    " + modelList.get(position).getType());
        holder.adapterProductActivityListviewPrice.setText("价格    " + modelList.get(position).getPrice());
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.adapter_product_activity_listview_ImgaeView)
        ImageView adapterProductActivityListviewImgaeView;
        @Bind(R.id.adapter_product_activity_listview_Name)
        TextView adapterProductActivityListviewName;
        @Bind(R.id.adapter_product_activity_listview_Type)
        TextView adapterProductActivityListviewType;
        @Bind(R.id.adapter_product_activity_listview_Price)
        TextView adapterProductActivityListviewPrice;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
