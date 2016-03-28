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
import com.eron.hairdresser.model.PermDye_Model;
import com.lin.framwork.utils.SpannableStringUtil;
import com.lin.framwork.views.Toast_Control.Toast_Common;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 林炜智 on 2016/3/15.
 */
public class Details_Activity_ListView_Adapter03 extends BaseAdapter {
    private LayoutInflater inflater;
    private Context context;
    private List<PermDye_Model> modelList;

    public Details_Activity_ListView_Adapter03(Context context, List<PermDye_Model> list) {
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
            convertView = inflater.inflate(R.layout.adapter_details_activity_listview, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        String Date = convertView.getResources().getString(R.string.activity_details_date) + modelList.get(position).getDate();
        String Project = convertView.getResources().getString(R.string.activity_details_project) + modelList.get(position).getProject();
        String HairstylistName = convertView.getResources().getString(R.string.activity_details_hairstylistname) + modelList.get(position).getHairstylistName();
        String Product = convertView.getResources().getString(R.string.activity_details_product) + modelList.get(position).getProduct();
        String Type = convertView.getResources().getString(R.string.activity_details_type) + modelList.get(position).getType();
        String Satisfaction = convertView.getResources().getString(R.string.activity_details_satisfaction) + modelList.get(position).getSatisfaction();
        //第一个显示内容
//        if (position == 0) {
//            holder.adapterDetailsActivityListviewLinearLayoutDown.setVisibility(View.VISIBLE);
//            modelList.get(position).setShow(true);
//        }
        holder.adapterDetailsActivityListviewDate.setText(SpannableStringUtil.getForegroundColor(Date, convertView.getResources().getColor(R.color.text_color1), 4, Date.length()));
        holder.adapterDetailsActivityListviewProject.setText(SpannableStringUtil.getForegroundColor(Project, convertView.getResources().getColor(R.color.text_color1), 4, Project.length()));
        holder.adapterDetailsActivityListviewHairstylistName.setText(SpannableStringUtil.getForegroundColor(HairstylistName, convertView.getResources().getColor(R.color.text_color1), 5, HairstylistName.length()));
        holder.adapterDetailsActivityListviewProduct.setText(SpannableStringUtil.getForegroundColor(Product, convertView.getResources().getColor(R.color.text_color1), 4, Product.length()));
        holder.adapterDetailsActivityListviewType.setText(SpannableStringUtil.getForegroundColor(Type, convertView.getResources().getColor(R.color.text_color1), 4, Type.length()));
        holder.adapterDetailsActivityListviewSatisfaction.setText(SpannableStringUtil.getForegroundColor(Satisfaction, convertView.getResources().getColor(R.color.text_color1), 5, Satisfaction.length()));
        holder.adapterDetailsActivityListviewLinearLayoutUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (modelList.get(position).getShow() == false) {
                    holder.adapterDetailsActivityListviewLinearLayoutDown.setVisibility(View.VISIBLE);
                    modelList.get(position).setShow(true);
                } else {
                    holder.adapterDetailsActivityListviewLinearLayoutDown.setVisibility(View.GONE);
                    modelList.get(position).setShow(false);
                }
            }
        });
        holder.adapterDetailsActivityListviewUseBeforeImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast_Common.DefaultToast(context,"查看图片");
            }
        });
        holder.adapterDetailsActivityListviewAfterUseImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast_Common.DefaultToast(context,"查看图片");
            }
        });

        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.adapter_details_activity_listview_Date)
        TextView adapterDetailsActivityListviewDate;
        @Bind(R.id.adapter_details_activity_listview_Project)
        TextView adapterDetailsActivityListviewProject;
        @Bind(R.id.adapter_details_activity_listview_Img)
        ImageView adapterDetailsActivityListviewImg;
        @Bind(R.id.adapter_details_activity_listview_LinearLayout_Up)
        LinearLayout adapterDetailsActivityListviewLinearLayoutUp;
        @Bind(R.id.adapter_details_activity_listview_HairstylistName)
        TextView adapterDetailsActivityListviewHairstylistName;
        @Bind(R.id.adapter_details_activity_listview_Product)
        TextView adapterDetailsActivityListviewProduct;
        @Bind(R.id.adapter_details_activity_listview_Type)
        TextView adapterDetailsActivityListviewType;
        @Bind(R.id.adapter_details_activity_listview_UseBeforeImg)
        ImageView adapterDetailsActivityListviewUseBeforeImg;
        @Bind(R.id.adapter_details_activity_listview_AfterUseImg)
        ImageView adapterDetailsActivityListviewAfterUseImg;
        @Bind(R.id.adapter_details_activity_listview_Satisfaction)
        TextView adapterDetailsActivityListviewSatisfaction;
        @Bind(R.id.adapter_details_activity_listview_LinearLayout_Down)
        LinearLayout adapterDetailsActivityListviewLinearLayoutDown;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
