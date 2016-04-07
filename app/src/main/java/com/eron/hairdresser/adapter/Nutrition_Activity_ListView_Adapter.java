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
import com.eron.hairdresser.model.Nutrition_Model;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 林炜智 on 2016/3/12.
 */
public class Nutrition_Activity_ListView_Adapter extends BaseAdapter {
    private LayoutInflater inflater;
    private Context context;
    private List<Nutrition_Model.ObjectBean> modelList;

    public Nutrition_Activity_ListView_Adapter(Context context, List<Nutrition_Model.ObjectBean> list) {
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
            convertView = inflater.inflate(R.layout.adapter_nutrition_activity_listview, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        if (modelList.get(position).getViptype().equals("1")) {
            holder.adapterNutritionActivityListviewLinearLayout.setBackgroundColor(convertView.getResources().getColor(R.color.adapter_nutrition_activity_listview_8zhe));
            holder.adapterNutritionActivityListviewVariety.setText("8折");
        } else {
            holder.adapterNutritionActivityListviewLinearLayout.setBackgroundColor(convertView.getResources().getColor(R.color.adapter_nutrition_activity_listview_ganen));
            holder.adapterNutritionActivityListviewVariety.setText("感恩");
        }
        holder.adapterNutritionActivityListviewName.setText(modelList.get(position).getName());
        holder.adapterNutritionActivityListviewNumber.setText(modelList.get(position).getVipcode());
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.adapter_nutrition_activity_listview_name)
        TextView adapterNutritionActivityListviewName;
        @Bind(R.id.adapter_nutrition_activity_listview_number)
        TextView adapterNutritionActivityListviewNumber;
        @Bind(R.id.adapter_nutrition_activity_listview_variety)
        TextView adapterNutritionActivityListviewVariety;
        @Bind(R.id.adapter_nutrition_activity_listview_LinearLayout)
        LinearLayout adapterNutritionActivityListviewLinearLayout;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
