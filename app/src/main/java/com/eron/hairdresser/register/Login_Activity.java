package com.eron.hairdresser.register;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.eron.hairdresser.R;
import com.lin.framwork.config.ConfigUrl;
import com.eron.hairdresser.TabHost_Activity;
import com.eron.hairdresser.model.LoginResult_Model;
import com.lin.framwork.application.ApplicarionTools;
import com.lin.framwork.utils.IntentUtil;
import com.lin.framwork.utils.SharedPreferencesUtil;
import com.lin.framwork.utils.VolleyUtil;
import com.lin.framwork.views.Toast_Control.Toast_Common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Login_Activity extends AppCompatActivity {
    public static final String Tag = "Login_Activity";

    @Bind(R.id.activity_login_Account)
    EditText activityLoginAccount;
    @Bind(R.id.activity_login_Password)
    EditText activityLoginPassword;
    @Bind(R.id.activity_login_Visible)
    ImageView activityLoginVisible;
    @Bind(R.id.activity_login_Login)
    Button activityLoginLogin;
    @Bind(R.id.activity_login_Remember)
    CheckBox activityLoginRemember;
    @Bind(R.id.activity_login_Forget)
    TextView activityLoginForget;

    private boolean visiblePassword = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        Init();
    }


    private void Init() {
        boolean remember = (boolean) SharedPreferencesUtil.get(this, "rememberPassWord", false);
        if (remember) {
            activityLoginAccount.setText(SharedPreferencesUtil.get(this, "userName", "").toString());
            activityLoginPassword.setText(SharedPreferencesUtil.get(this, "passWord", "").toString());
            activityLoginRemember.setChecked(remember);
            activityLoginVisible.setVisibility(View.INVISIBLE);
        }
    }


    @OnClick({R.id.activity_login_Visible, R.id.activity_login_Login, R.id.activity_login_Forget})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.activity_login_Visible:
                if (visiblePassword) {
                    activityLoginVisible.setSelected(false);
                    activityLoginPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                } else {
                    activityLoginVisible.setSelected(true);
                    activityLoginPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                }
                visiblePassword = !visiblePassword;
                break;
            case R.id.activity_login_Login:
                if (activityLoginAccount.getText().toString().equals("") && activityLoginPassword.getText().toString().equals(""))
                    Toast_Common.DefaultToast(this, "请输入账号或密码！");
                else
//                    LoginIn();
                    IntentUtil.goToContext(Login_Activity.this, TabHost_Activity.class);
                    Login_Activity.this.finish();
                break;
            case R.id.activity_login_Forget:
                Toast_Common.CenterToast(this, "忘记密码");
                break;
        }
    }

    private void LoginIn() {
        String Url = ConfigUrl.Login_Activity;
        VolleyUtil util = new VolleyUtil();
        Map<String, String> map = new HashMap<String, String>();
        map.put("nick", activityLoginAccount.getText().toString());
        map.put("pwd", activityLoginPassword.getText().toString());
        util.post(Url, LoginResult_Model.class, Tag, map, new VolleyUtil.PostCallback() {
            @Override
            public void onSuccess(String result, List list) {
                List<LoginResult_Model> modelList = list;
                if (modelList.get(0).getError().equals("0")) {
                    if (activityLoginRemember.isChecked()) {
                        SharedPreferencesUtil.put(Login_Activity.this, "userName", activityLoginAccount.getText().toString());
                        SharedPreferencesUtil.put(Login_Activity.this, "passWord", activityLoginPassword.getText().toString());
                        SharedPreferencesUtil.put(Login_Activity.this, "rememberPassWord", true);
                    } else {
                        SharedPreferencesUtil.remove(Login_Activity.this, "userName");
                        SharedPreferencesUtil.remove(Login_Activity.this, "passWord");
                        SharedPreferencesUtil.remove(Login_Activity.this, "rememberPassWord");
                    }
                    ApplicarionTools.setUserId(modelList.get(0).getUid());
                    Toast_Common.DefaultToast(Login_Activity.this, "登陆成功！");
                    IntentUtil.goToContext(Login_Activity.this, TabHost_Activity.class);
                    Login_Activity.this.finish();
                } else {
                    Toast_Common.DefaultToast(Login_Activity.this, "用户名或密码输入错误！");
                }
            }

            @Override
            public void onFailure(String error) {
                Log.e(Tag, error);
            }
        });
    }
}