package com.eron.hairdresser.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.eron.hairdresser.R;
import com.eron.hairdresser.model.HairStyleImg_Model;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 林炜智 on 2016/3/16.
 */
public class HairStyleImg_Activity_RecyclerView_Adapter extends RecyclerView.Adapter<HairStyleImg_Activity_RecyclerView_Adapter.ViewHolder> {
    private List<HairStyleImg_Model> modelList;
    private LayoutInflater inflater;
    private Context context;

    public HairStyleImg_Activity_RecyclerView_Adapter(Context context, List<HairStyleImg_Model> list) {
        this.context = context;
        this.modelList = list;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.adapter_hairstyleimg_activity_recyclerview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.adapterHairstyleimgActivityRecyclerviewImageView.setImageResource(modelList.get(position).getImg());
        holder.adapterHairstyleimgActivityRecyclerviewTextView.setText(modelList.get(position).getTitle());
        if (itemClickLitener != null) {
            holder.adapterHairstyleimgActivityRecyclerviewRelativeLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    itemClickLitener.onItemClick(holder.itemView, pos);
                }
            });
            holder.adapterHairstyleimgActivityRecyclerviewRelativeLayout.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int pos = holder.getLayoutPosition();
                    itemClickLitener.onItemLongClick(holder.itemView, pos);
                    return false;
                }
            });
        }
    }


    @Override
    public int getItemCount() {
        return modelList == null ? 0 : modelList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.adapter_hairstyleimg_activity_recyclerview_RelativeLayout)
        RelativeLayout adapterHairstyleimgActivityRecyclerviewRelativeLayout;
        @Bind(R.id.adapter_hairstyleimg_activity_recyclerview_ImageView)
        ImageView adapterHairstyleimgActivityRecyclerviewImageView;
        @Bind(R.id.adapter_hairstyleimg_activity_recyclerview_TextView)
        TextView adapterHairstyleimgActivityRecyclerviewTextView;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    private OnItemClickLitener itemClickLitener;

    public interface OnItemClickLitener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }

    public void setOnItemClickLitener(OnItemClickLitener itemClickLitener) {
        this.itemClickLitener = itemClickLitener;
    }
}
