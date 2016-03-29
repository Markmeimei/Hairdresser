package com.eron.hairdresser.hairdresser.setting;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.eron.hairdresser.R;

/**
 * Author：Mark
 * Date：2016/2/19 0019
 * Tell：15006330640
 *
 *  修改密码
 */
public class ModifyPWDActivity extends Activity implements View.OnClickListener {
    private EditText old_pwd,new_pwd,affirm_pwd;
    private Button modify_complete;
    //
    private Context context = ModifyPWDActivity.this;
    private SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.setting_modify_pwd);
        findView();
        initView();
    }

    private void findView() {
        // 密码
        this.old_pwd = (EditText) super.findViewById(R.id.old_pwd);
        this.new_pwd = (EditText) super.findViewById(R.id.new_pwd);
        this.affirm_pwd = (EditText) super.findViewById(R.id.affirm_pwd);
        //
        this.modify_complete = (Button) super.findViewById(R.id.modify_complete);
    }

    private void initView() {
        this.modify_complete.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.modify_complete:
                if(checkInput()){
//                    modify();
                }
                break;
        }
    }
    // 修改密码
//    private void modify() {
//        HttpUtils httpUtils = new HttpUtils();
//        RequestParams requestParams = new RequestParams();
//        requestParams.addQueryStringParameter(ConstantString.UID, preferences.getString(ConstantString.UID,null));
//        requestParams.addQueryStringParameter(ConstantString.TOKEN, preferences.getString(ConstantString.TOKEN,null));
//        requestParams.addQueryStringParameter(ConstantString.OLD_PED,old_pwd.getText().toString());
//        requestParams.addQueryStringParameter(ConstantString.NEW_PWD,new_pwd.getText().toString());
//        httpUtils.send(HttpRequest.HttpMethod.POST, ConstantsUrl.MODIFY_PWD_URL,requestParams,new RequestCallBack<String>() {
//            @Override
//            public void onSuccess(ResponseInfo<String> objectResponseInfo) {
//                try{
//                    Gson gson = new Gson();
//                    PublicObject publicObject = gson.fromJson(objectResponseInfo.result,PublicObject.class);
//                    if(publicObject.getCode() != null){
//                        if(publicObject.getCode().equals("1")){
//                            Toast.makeText(context, publicObject.getMessage(), Toast.LENGTH_SHORT).show();
//                            SharedPreferences sharedPreferences = getSharedPreferences(ConstantString.USER, Activity.MODE_PRIVATE);
//                            SharedPreferences.Editor editor = sharedPreferences.edit();
//                            editor.clear();
//                            editor.commit();
//                            SDKCoreHelper.logout();
//                            startActivity(new Intent(context, LoginActivity.class));
//                        }else {
//                            Toast.makeText(context, publicObject.getMessage(), Toast.LENGTH_SHORT).show();
//                        }
//                    }else {
//                        Toast.makeText(context, getString(R.string.server_off), Toast.LENGTH_SHORT).show();
//                    }
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(HttpException e, String s) {
//                Toast.makeText(context, getString(R.string.home_error_text), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }

    // 检测输入
    private boolean checkInput() {
        if(old_pwd.getText().toString().equals("") || old_pwd.getText().toString() == null){
            Toast.makeText(context, "原密码不能为空！", Toast.LENGTH_SHORT).show();
            return false;
        }else if(new_pwd.getText().toString().equals("") || new_pwd.getText().toString() == null){
            Toast.makeText(context, "新密码不能为空！", Toast.LENGTH_SHORT).show();
            return false;
        }else if(affirm_pwd.getText().toString().equals("") || affirm_pwd.getText().toString() == null){
            Toast.makeText(context, "请输入确认密码！", Toast.LENGTH_SHORT).show();
            return false;
        }else if(!new_pwd.getText().toString().equals(affirm_pwd.getText().toString())){
            Toast.makeText(context, "两次密码不一致！", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
