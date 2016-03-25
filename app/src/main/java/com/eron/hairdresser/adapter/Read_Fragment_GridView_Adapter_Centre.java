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
public class Read_Fragment_GridView_Adapter_Centre extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;

    public Read_Fragment_GridView_Adapter_Centre(Context context) {
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public int getCount() {
        return ConstantResource.getReadListCentre() == null ? 0 : ConstantResource.getReadListCentre().size();
    }

    @Override
    public Object getItem(int position) {
        return ConstantResource.getReadListCentre().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.adapter_read_fragment_gridview_centre, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.adapterReadFragmentGridviewCentreImageView.setImageResource(ConstantResource.getReadListCentre().get(position));
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.adapter_read_fragment_gridview_centre_ImageView)
        ImageView adapterReadFragmentGridviewCentreImageView;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
