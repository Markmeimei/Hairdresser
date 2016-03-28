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
import com.eron.hairdresser.model.SPA_Model;
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
    private List<SPA_Model> modelList;

    public Details_Activity_ListView_Adapter03(Context context, List<SPA_Model> list) {
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
            convertView = inflater.inflate(R.layout.adapter_details_activity_listview03, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        String Date = convertView.getResources().getString(R.string.activity_details_date) + modelList.get(position).getDate();
        String Project = convertView.getResources().getString(R.string.activity_details_project) + modelList.get(position).getProject();
        String Mask = convertView.getResources().getString(R.string.activity_details_mask) + modelList.get(position).getMask();
        String Assistant = convertView.getResources().getString(R.string.activity_details_assistant) + modelList.get(position).getAssistant();
        String AppointmentTime = convertView.getResources().getString(R.string.activity_details_appointmenttime) + modelList.get(position).getAppointmentTime();
        String AppointmentPerson = convertView.getResources().getString(R.string.activity_details_appointmentperson) + modelList.get(position).getAppointmentPerson();

        holder.adapterDetailsActivityListview03Date.setText(SpannableStringUtil.getForegroundColor(Date, convertView.getResources().getColor(R.color.text_color1), 4, Date.length()));
        holder.adapterDetailsActivityListview03Project.setText(SpannableStringUtil.getForegroundColor(Project, convertView.getResources().getColor(R.color.text_color1), 4, Project.length()));
        holder.adapterDetailsActivityListview03Mask.setText(SpannableStringUtil.getForegroundColor(Mask, convertView.getResources().getColor(R.color.text_color1), 5, Mask.length()));
        holder.adapterDetailsActivityListview03Assistant.setText(SpannableStringUtil.getForegroundColor(Assistant, convertView.getResources().getColor(R.color.text_color1), 4, Assistant.length()));
        holder.adapterDetailsActivityListview03AppointmentTime.setText(SpannableStringUtil.getForegroundColor(AppointmentTime, convertView.getResources().getColor(R.color.text_color1), 6, AppointmentTime.length()));
        holder.adapterDetailsActivityListview03AppointmentPerson.setText(SpannableStringUtil.getForegroundColor(AppointmentPerson, convertView.getResources().getColor(R.color.text_color1), 5, AppointmentPerson.length()));
        holder.adapterDetailsActivityListview03Signature.setImageResource(R.mipmap.ic_launcher);
        holder.adapterDetailsActivityListview03LinearLayoutUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (modelList.get(position).getShow() == false) {
                    holder.adapterDetailsActivityListview03LinearLayoutDown.setVisibility(View.VISIBLE);
                    modelList.get(position).setShow(true);
                } else {
                    holder.adapterDetailsActivityListview03LinearLayoutDown.setVisibility(View.GONE);
                    modelList.get(position).setShow(false);
                }
            }
        });

        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.adapter_details_activity_listview03_Date)
        TextView adapterDetailsActivityListview03Date;
        @Bind(R.id.adapter_details_activity_listview03_Project)
        TextView adapterDetailsActivityListview03Project;
        @Bind(R.id.adapter_details_activity_listview03_Img)
        ImageView adapterDetailsActivityListview03Img;
        @Bind(R.id.adapter_details_activity_listview03_LinearLayout_Up)
        LinearLayout adapterDetailsActivityListview03LinearLayoutUp;
        @Bind(R.id.adapter_details_activity_listview03_Mask)
        TextView adapterDetailsActivityListview03Mask;
        @Bind(R.id.adapter_details_activity_listview03_Assistant)
        TextView adapterDetailsActivityListview03Assistant;
        @Bind(R.id.adapter_details_activity_listview03_AppointmentTime)
        TextView adapterDetailsActivityListview03AppointmentTime;
        @Bind(R.id.adapter_details_activity_listview03_AppointmentPerson)
        TextView adapterDetailsActivityListview03AppointmentPerson;
        @Bind(R.id.adapter_details_activity_listview03_Signature)
        ImageView adapterDetailsActivityListview03Signature;
        @Bind(R.id.adapter_details_activity_listview03_LinearLayout_Down)
        LinearLayout adapterDetailsActivityListview03LinearLayoutDown;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
