package com.eron.hairdresser.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.eron.hairdresser.R;
import com.eron.hairdresser.model.Nutrition_Model;
import com.eron.hairdresser.model.PermDye_Model;
import com.lin.framwork.utils.SpannableStringUtil;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 林炜智 on 2016/3/15.
 */
public class Details_Activity_ListView_Adapter02 extends BaseAdapter {
    private LayoutInflater inflater;
    private Context context;
    private List<Nutrition_Model> modelList;

    public Details_Activity_ListView_Adapter02(Context context, List<Nutrition_Model> list) {
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.adapter_details_activity_listview02, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        String Date = convertView.getResources().getString(R.string.activity_details_date) + modelList.get(position).getDate();
        String Project = convertView.getResources().getString(R.string.activity_details_project) + modelList.get(position).getProject();
        String Product = convertView.getResources().getString(R.string.activity_details_project) + modelList.get(position).getProduct();
        String Diagnosis = convertView.getResources().getString(R.string.activity_details_diagnosis) + modelList.get(position).getDiagnosis();
        String Product2 = convertView.getResources().getString(R.string.activity_details_product2) + modelList.get(position).getProduct2();
        String StoresUse = convertView.getResources().getString(R.string.activity_details_storesuse) + modelList.get(position).getStoresUse();
        String Furnishing = convertView.getResources().getString(R.string.activity_details_furnishing) + modelList.get(position).getFurnishing();

        holder.adapterDetailsActivityListview02Date.setText(SpannableStringUtil.getForegroundColor(Date, convertView.getResources().getColor(R.color.text_color1), 4, Date.length()));
        holder.adapterDetailsActivityListview02Project.setText(SpannableStringUtil.getForegroundColor(Project, convertView.getResources().getColor(R.color.text_color1), 4, Project.length()));
        holder.adapterDetailsActivityListview02Product.setText(SpannableStringUtil.getForegroundColor(Product, convertView.getResources().getColor(R.color.text_color1), 4, Product.length()));
        holder.adapterDetailsActivityListview02Diagnosis.setText(SpannableStringUtil.getForegroundColor(Diagnosis, convertView.getResources().getColor(R.color.text_color1), 4, Diagnosis.length()));
        holder.adapterDetailsActivityListview02Product02.setText(SpannableStringUtil.getForegroundColor(Product2, convertView.getResources().getColor(R.color.text_color1), 4, Product2.length()));
        holder.adapterDetailsActivityListview02StoresUse.setText(SpannableStringUtil.getForegroundColor(StoresUse, convertView.getResources().getColor(R.color.text_color1), 4, StoresUse.length()));
        holder.adapterDetailsActivityListview02Furnishing.setText(SpannableStringUtil.getForegroundColor(Furnishing, convertView.getResources().getColor(R.color.text_color1), 4, Furnishing.length()));

        holder.adapterDetailsActivityListview02LinearLayoutUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (modelList.get(position).getShow() == false) {
                    holder.adapterDetailsActivityListview02LinearLayoutDown.setVisibility(View.VISIBLE);
                    modelList.get(position).setShow(true);
                } else {
                    holder.adapterDetailsActivityListview02LinearLayoutDown.setVisibility(View.GONE);
                    modelList.get(position).setShow(false);
                }
            }
        });

        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.adapter_details_activity_listview02_Date)
        TextView adapterDetailsActivityListview02Date;
        @Bind(R.id.adapter_details_activity_listview02_Project)
        TextView adapterDetailsActivityListview02Project;
        @Bind(R.id.adapter_details_activity_listview02_Img)
        ImageView adapterDetailsActivityListview02Img;
        @Bind(R.id.adapter_details_activity_listview02_LinearLayout_Up)
        LinearLayout adapterDetailsActivityListview02LinearLayoutUp;
        @Bind(R.id.adapter_details_activity_listview02_Product)
        TextView adapterDetailsActivityListview02Product;
        @Bind(R.id.adapter_details_activity_listview02_Diagnosis)
        TextView adapterDetailsActivityListview02Diagnosis;
        @Bind(R.id.adapter_details_activity_listview02_Product02)
        TextView adapterDetailsActivityListview02Product02;
        @Bind(R.id.adapter_details_activity_listview02_StoresUse)
        TextView adapterDetailsActivityListview02StoresUse;
        @Bind(R.id.adapter_details_activity_listview02_Furnishing)
        TextView adapterDetailsActivityListview02Furnishing;
        @Bind(R.id.adapter_details_activity_listview02_LinearLayout_Down)
        LinearLayout adapterDetailsActivityListview02LinearLayoutDown;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
