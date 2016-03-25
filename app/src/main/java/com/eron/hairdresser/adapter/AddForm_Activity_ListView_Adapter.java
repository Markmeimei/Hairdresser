package com.eron.hairdresser.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.eron.hairdresser.R;
import com.eron.hairdresser.model.AddForm_Model;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 林炜智 on 2016/3/24.
 */
public class AddForm_Activity_ListView_Adapter extends BaseAdapter {
    private LayoutInflater inflater;
    private Context context;
    private List<AddForm_Model> modelList;

    public AddForm_Activity_ListView_Adapter(Context context, List<AddForm_Model> list) {
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        this.modelList = list;
    }

    @Override
    public int getCount() {
        if (modelList == null)
            return 0;
        return modelList.size();
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
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.adapter_addform_activity_listview, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        ArrayAdapter<String> Project_adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, modelList.get(position).getProject());
        ArrayAdapter<String> Money_adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, modelList.get(position).getMoney());

        holder.adapterAddformActivityListviewProject.setAdapter(Project_adapter);
        holder.adapterAddformActivityListviewMoney.setAdapter(Money_adapter);

        holder.adapterAddformActivityListviewDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modelList.remove(position);
                notifyDataSetChanged();
            }
        });
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.adapter_addform_activity_listview_Project)
        Spinner adapterAddformActivityListviewProject;
        @Bind(R.id.adapter_addform_activity_listview_Money)
        Spinner adapterAddformActivityListviewMoney;
        @Bind(R.id.adapter_addform_activity_listview_Delete)
        ImageView adapterAddformActivityListviewDelete;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
