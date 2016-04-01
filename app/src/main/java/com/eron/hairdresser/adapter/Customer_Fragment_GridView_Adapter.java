package com.eron.hairdresser.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.eron.hairdresser.R;
import com.eron.hairdresser.common.ConstantResource;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 林炜智 on 2016/3/10.
 */
public class Customer_Fragment_GridView_Adapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;

    public Customer_Fragment_GridView_Adapter(Context context) {
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return ConstantResource.getCustpmerList() == null ? 0 : ConstantResource.getCustpmerList().size();
    }

    @Override
    public Object getItem(int position) {
        return ConstantResource.getCustpmerList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.adapter_customer_fragment_gridview, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.adapterCustomerFragmentImageView.setImageResource(ConstantResource.getCustpmerList().get(position));
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.adapter_customer_fragment_ImageView)
        ImageView adapterCustomerFragmentImageView;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
