package com.lin.framwork.views.PopupWindow_Control;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.ViewGroup.LayoutParams;
import android.widget.PopupWindow;

import com.lin.framwork.R;

import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by 林炜智 on 2016/3/25.
 */
public class PopupWindowListView extends PopupWindow {
    private View view;

    public PopupWindowListView(Activity context, List<String> list01, List<String> list02, List<String> list03) {
        view = LayoutInflater.from(context).inflate(R.layout.views_popupwindow_listview, null);

        ListView listView01 = ButterKnife.findById(view, R.id.views_popupwindow_listview_ListView01);
        final ListView listView02 = ButterKnife.findById(view, R.id.views_popupwindow_listview_ListView02);
        final ListView listView03 = ButterKnife.findById(view, R.id.views_popupwindow_listview_ListView03);

        Adapter_PopupWindowListView listView01_adapter = new Adapter_PopupWindowListView(context, list01);
        final Adapter_PopupWindowListView listView02_adapter = new Adapter_PopupWindowListView(context, list02);
        final Adapter_PopupWindowListView listView03_adapter = new Adapter_PopupWindowListView(context, list03);

        listView01.setAdapter(listView01_adapter);
        listView01.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listView02.setAdapter(listView02_adapter);
                listView03.setAdapter(listView03_adapter);
            }
        });

        int h = context.getWindowManager().getDefaultDisplay().getHeight();
        int w = context.getWindowManager().getDefaultDisplay().getWidth();
        // 设置SelectPicPopupWindow的View
        this.setContentView(view);
        // 设置SelectPicPopupWindow弹出窗体的宽
        this.setWidth(w);
        // 设置SelectPicPopupWindow弹出窗体的高
        this.setHeight(LayoutParams.WRAP_CONTENT);
        // 设置SelectPicPopupWindow弹出窗体可点击
        this.setFocusable(true);
        this.setOutsideTouchable(true);
        // 刷新状态
        this.update();
        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0000000000);
        // 点back键和其他地方使其消失,设置了这个才能触发OnDismisslistener ，设置其他控件变化等操作
        this.setBackgroundDrawable(dw);
        // mPopupWindow.setAnimationStyle(android.R.style.Animation_Dialog);
        // 设置SelectPicPopupWindow弹出窗体动画效果
        this.setAnimationStyle(R.style.AnimationPreview);
    }

    public void showPopupWindow(View parent) {
        if (!this.isShowing()) {
            this.showAsDropDown(parent, parent.getLayoutParams().width / 2, 18);
        } else {
            this.dismiss();
        }
    }
}
