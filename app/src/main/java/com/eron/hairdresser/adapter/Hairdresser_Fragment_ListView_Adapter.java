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
import com.lin.framwork.utils.SpannableStringUtil;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 林炜智 on 2016/3/9.
 * 首页的ListView 适配器
 */
public class Hairdresser_Fragment_ListView_Adapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private List<String> textList;

    public Hairdresser_Fragment_ListView_Adapter(Context context, List<String> list) {
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        this.textList = list;
    }

    @Override
    public int getCount() {
        if (textList == null)
            return 0;
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
            convertView = inflater.inflate(R.layout.adapter_hairdresser_fragment_listview, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.adapterHairdresserFragmentListviewIcon.setImageResource(ConstantResource.getHairdresserList().get(position));
        holder.adapterHairdresserFragmentListviewText.setText(textList.get(position));
        holder.adapterHairdresserFragmentListviewSmallicon.setImageResource(ConstantResource.getImgAdvance());
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.adapter_hairdresser_fragment_listview_Icon)
        ImageView adapterHairdresserFragmentListviewIcon;
        @Bind(R.id.adapter_hairdresser_fragment_listview_Smallicon)
        ImageView adapterHairdresserFragmentListviewSmallicon;
        @Bind(R.id.adapter_hairdresser_fragment_listview_Text)
        TextView adapterHairdresserFragmentListviewText;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
