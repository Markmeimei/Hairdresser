package com.eron.hairdresser.customer.newUser;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.eron.hairdresser.R;
import com.eron.hairdresser.views.Views;
import com.lin.framwork.views.Toast_Control.Toast_Common;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NewUser_Fragment extends Fragment {
    @Bind(R.id.fragment_new_user_User)
    TextView fragmentNewUserUser;
    @Bind(R.id.fragment_new_user_VIPNumber)
    EditText fragmentNewUserVIPNumber;
    @Bind(R.id.fragment_new_user_Name)
    EditText fragmentNewUserName;
    @Bind(R.id.fragment_new_user_Coding)
    EditText fragmentNewUserCoding;
    @Bind(R.id.fragment_new_user_PhoneNumber)
    EditText fragmentNewUserPhoneNumber;
    @Bind(R.id.fragment_new_user_Gender)
    TextView fragmentNewUserGender;
    @Bind(R.id.fragment_new_user_Birthday)
    TextView fragmentNewUserBirthday;
    @Bind(R.id.fragment_new_user_Quality)
    TextView fragmentNewUserQuality;
    @Bind(R.id.fragment_new_user_Length)
    TextView fragmentNewUserLength;
    @Bind(R.id.fragment_new_user_AddTime)
    TextView fragmentNewUserAddTime;

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_new_user, container, false);
            ButterKnife.bind(this, view);
            Init();
        }
        ViewGroup parent = (ViewGroup) view.getParent();
        if (parent != null) {
            parent.removeView(view);
        }
        ButterKnife.bind(this, view);
        return view;
    }

    private void Init() {
        Content();
    }

    private void Content() {
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.fragment_new_user_User, R.id.fragment_new_user_Gender, R.id.fragment_new_user_Birthday, R.id.fragment_new_user_Quality, R.id.fragment_new_user_Length, R.id.fragment_new_user_AddTime})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fragment_new_user_User:
                break;
            case R.id.fragment_new_user_Gender:
                final String items[] = {"男", "女"};
                AlertDialog.Builder dialog = Views.getSelectDialog(getActivity(), items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        fragmentNewUserGender.setText(items[which]);
                        dialog.dismiss();
                    }
                }, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                break;
            case R.id.fragment_new_user_Birthday:
                Views.getDateDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        fragmentNewUserBirthday.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                    }
                }).show();
                break;
            case R.id.fragment_new_user_Quality:
                break;
            case R.id.fragment_new_user_Length:
                break;
            case R.id.fragment_new_user_AddTime:
                Views.getDateDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        fragmentNewUserAddTime.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                    }
                }).show();
                break;
        }
    }
}
