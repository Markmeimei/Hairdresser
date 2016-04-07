package com.lin.framwork.views.PopupWindow_Control;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.bumptech.glide.Glide;
import com.lin.framwork.R;

import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by 林炜智 on 2016/3/25.
 */
public class PopupWindowImageView extends PopupWindow {
    private View view;

    public PopupWindowImageView(Activity context, String imgUrl, int img01, int img02) {
        view = LayoutInflater.from(context).inflate(R.layout.views_popupwindow_imageview, null);

        ImageView imageView = ButterKnife.findById(view, R.id.views_popupwindow_imageview_ImageView);

        Glide.with(context).load(imgUrl).placeholder(img01).error(img02).crossFade().into(imageView);

        int h = context.getWindowManager().getDefaultDisplay().getHeight();
        int w = context.getWindowManager().getDefaultDisplay().getWidth();
        // 设置SelectPicPopupWindow的View
        this.setContentView(view);
        // 设置SelectPicPopupWindow弹出窗体的宽
        this.setWidth(w);
        // 设置SelectPicPopupWindow弹出窗体的高
        this.setHeight(LayoutParams.MATCH_PARENT);
        // 设置SelectPicPopupWindow弹出窗体可点击
        this.setFocusable(true);
        this.setOutsideTouchable(true);
        // 刷新状态
        this.update();
        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0x90000000);
        // 点back键和其他地方使其消失,设置了这个才能触发OnDismisslistener ，设置其他控件变化等操作
        this.setBackgroundDrawable(dw);
        // mPopupWindow.setAnimationStyle(android.R.style.Animation_Dialog);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupWindowImageView.this.dismiss();
            }
        });
    }

    public void showPopupWindow(View parent) {
        if (!this.isShowing()) {
            this.showAsDropDown(parent, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        } else {
            this.dismiss();
        }
    }
}
