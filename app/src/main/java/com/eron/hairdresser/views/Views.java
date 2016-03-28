package com.eron.hairdresser.views;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.eron.hairdresser.R;
import com.eron.hairdresser.model.Customer_Model;
import com.eron.hairdresser.views.dialog.EditDialog;
import com.lin.framwork.utils.SpannableStringUtil;

import java.util.Calendar;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 林炜智 on 2016/3/16.
 * 自定义的View
 */
public class Views {
    /**
     * Don't let anyone instantiate this class.
     */
    private Views() {
        throw new Error("Do not need instantiate!");
    }

    /**
     * 空的View 用于返回
     */
    public static View getDefaultNull(Context context) {
        View views_default_null = View.inflate(context, R.layout.views_default_null, null);
        return views_default_null;
    }

    //详细资料
    public static View getDetailsFirst(Context context, List<Customer_Model> list) {
        if (context == null)
            return null;
        else if (list == null || list.size() == 0)
            return getDefaultNull(context);
        else {
            View view = View.inflate(context, R.layout.views_details_first, null);
            TextView viewsDetailsFirstName = ButterKnife.findById(view, R.id.views_details_first_Name);
            TextView viewsDetailsFirstCardNumber = ButterKnife.findById(view, R.id.views_details_first_CardNumber);
            TextView viewsDetailsFirstCardVariety = ButterKnife.findById(view, R.id.views_details_first_CardVariety);
            TextView viewsDetailsFirstGender = ButterKnife.findById(view, R.id.views_details_first_Gender);
            TextView viewsDetailsFirstBirthday = ButterKnife.findById(view, R.id.views_details_first_Birthday);
            TextView viewsDetailsFirstQuality = ButterKnife.findById(view, R.id.views_details_first_Quality);
            TextView viewsDetailsFirstHairLength = ButterKnife.findById(view, R.id.views_details_first_HairLength);
            TextView viewsDetailsFirstPhone = ButterKnife.findById(view, R.id.views_details_first_Phone);

            String Name = context.getResources().getString(R.string.activity_details_guest) + list.get(0).getName();
            String CardNumber = context.getResources().getString(R.string.activity_details_cardnumber) + list.get(0).getCardNumber();
            String CardVariety = "";
            if (list.get(0).getCardVariety() == 1)
                CardVariety = context.getResources().getString(R.string.activity_details_cardvariety) + "8折";
            else
                CardVariety = context.getResources().getString(R.string.activity_details_cardvariety) + "感恩";
            String Gender = context.getResources().getString(R.string.activity_details_gender) + list.get(0).getGender();
            String Birthday = context.getResources().getString(R.string.activity_details_birthday) + list.get(0).getBirthday();
            String Quality = context.getResources().getString(R.string.activity_details_quality) + list.get(0).getQuality();
            String HairLength = context.getResources().getString(R.string.activity_details_hairlength) + list.get(0).getHairLength();
            String Phone = context.getResources().getString(R.string.activity_details_phone) + list.get(0).getPhone();

            viewsDetailsFirstName.setText(SpannableStringUtil.getForegroundColor(Name, context.getResources().getColor(R.color.text_color1), 4, Name.length()));
            viewsDetailsFirstCardNumber.setText(SpannableStringUtil.getForegroundColor(CardNumber, context.getResources().getColor(R.color.text_color1), 4, CardNumber.length()));
            viewsDetailsFirstCardVariety.setText(SpannableStringUtil.getForegroundColor(CardVariety, context.getResources().getColor(R.color.text_color1), 4, CardVariety.length()));
            viewsDetailsFirstGender.setText(SpannableStringUtil.getForegroundColor(Gender, context.getResources().getColor(R.color.text_color1), 4, Gender.length()));
            viewsDetailsFirstBirthday.setText(SpannableStringUtil.getForegroundColor(Birthday, context.getResources().getColor(R.color.text_color1), 4, Birthday.length()));
            viewsDetailsFirstQuality.setText(SpannableStringUtil.getForegroundColor(Quality, context.getResources().getColor(R.color.text_color1), 4, Quality.length()));
            viewsDetailsFirstHairLength.setText(SpannableStringUtil.getForegroundColor(HairLength, context.getResources().getColor(R.color.text_color1), 4, HairLength.length()));
            viewsDetailsFirstPhone.setText(SpannableStringUtil.getForegroundColor(HairLength, context.getResources().getColor(R.color.text_color1), 4, HairLength.length()));
            return view;
        }
    }

    //输入框Dialog
    public static EditDialog.Builder getEditDialog(Context context, String title, String message) {
        EditDialog.Builder builder = new EditDialog.Builder(context);
        builder.setTitle(title).setMessage(message);
        return builder;
    }

    //日期Dialog
    public static DatePickerDialog getDateDialog(Context context, DatePickerDialog.OnDateSetListener listener) {
        //用来获取日期和时间的
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog dialog = new DatePickerDialog(context, listener,
                calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        return dialog;
    }

    //单选框Dialog
    public static AlertDialog.Builder getSelectDialog(Context context, String[] strings, DialogInterface.OnClickListener listener, DialogInterface.OnClickListener listener2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("提示");
        builder.setItems(strings, listener);
        builder.setPositiveButton("取消", listener2);
        builder.create().show();
        return builder;
    }

    public static View getHairdresserFirst(Context context, String value) {
        if (context == null)
            return null;
        else if (value == null)
            return getDefaultNull(context);
        else {
            View view = View.inflate(context, R.layout.views_hairdresser_first, null);
            ImageView viewsHairdresserFirstIcon = ButterKnife.findById(view, R.id.views_hairdresser_first_Icon);
            ImageView viewsHairdresserFirstSmallicon = ButterKnife.findById(view, R.id.views_hairdresser_first_Smallicon);
            TextView fragmentHairdresserText = ButterKnife.findById(view, R.id.fragment_hairdresser_Text);
            fragmentHairdresserText.setText(value);
            return view;
        }
    }
}
