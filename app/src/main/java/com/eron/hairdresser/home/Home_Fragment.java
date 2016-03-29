package com.eron.hairdresser.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.format.Time;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.eron.hairdresser.R;
import com.eron.hairdresser.adapter.Home_Fragment_ListView_Adapter;
import com.eron.hairdresser.home.birthday.Birthday_Activity;
import com.eron.hairdresser.home.expire.Expire_Activity;
import com.eron.hairdresser.model.HomeHint_Model;
import com.eron.hairdresser.views.headTitle.HeadTitle;
import com.lin.framwork.application.ApplicationTools;
import com.lin.framwork.config.ConfigUrl;
import com.lin.framwork.utils.ASimpleCache;
import com.lin.framwork.utils.DateUtils;
import com.lin.framwork.utils.IntentUtil;
import com.lin.framwork.utils.VolleyUtil;
import com.lin.framwork.views.PopupWindow_Control.PopupWindowListView;
import com.lin.framwork.views.Toast_Control.Toast_Common;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

/**
 * 首页界面
 */
public class Home_Fragment extends Fragment {
    public final static String Tag = "Home_Fragment";

    @Bind(R.id.fragment_home_HeadTitle)
    HeadTitle fragmentHomeHeadTitle;
    @Bind(R.id.fragment_home_Date)
    TextView fragmentHomeDate;
    @Bind(R.id.fragment_home_ListView)
    ListView fragmentHomeListView;

    private View view;
    private Home_Fragment_ListView_Adapter listView_adapter;
    private List<HomeHint_Model> modelList;
    private List<String> stringList;

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_home, container, false);
            ButterKnife.bind(this, view);
            Init();
        }
        ViewGroup parent = (ViewGroup) view.getParent();
        if (parent != null) {
            parent.removeView(view);
        }
        return view;
    }

    private void Init() {
        getData();
        stringList = new ArrayList<>();
        stringList.add("预约顾客" + 0 + "位");
        stringList.add("到期顾客" + 0 + "位");
        stringList.add("今日" + 0 + "位顾客生日");
        listView_adapter = new Home_Fragment_ListView_Adapter(getActivity(), stringList);
        Content();
    }

    private void Content() {
        fragmentHomeDate.setText("日期:" + DateUtils.formatDate(new Date(), DateUtils.yyyyMMDD));
        fragmentHomeListView.setAdapter(listView_adapter);

        ASimpleCache.get(getActivity()).put("birthdayTemplateA", "今天是你的生日，我求上帝赐给你世界上最宝贵的礼物，上帝说就赐给你一生平安！一世健康！这两样礼物你满意吗？祝生日快乐！");
        ASimpleCache.get(getActivity()).put("birthdayTemplateB", "今天你快乐吗？我知道你肯定说不快乐，因为我的祝福还没有到啊，送你一份生日礼物。希望你年年有今日，岁岁有今朝。");
        ASimpleCache.get(getActivity()).put("birthdayTemplateC", "长长的距离，长长的线，长长的思念永不断；长长的时间，长长的挂念，长长的友谊永不变，祝你金钱不缺，微笑不断，笑容洒遍每一天。生日快乐！");
    }

    private void getData() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("uid", ApplicationTools.getUser().getObject().getId());
        new VolleyUtil<>().post(ConfigUrl.Home_FragmentUrl, HomeHint_Model.class, Tag, map, new VolleyUtil.PostCallback() {
            @Override
            public void onSuccess(String result, List list) {
                modelList = list;
                stringList.clear();
                stringList.add("预约顾客" + modelList.get(0).getObject().getAppointment() + "位");
                stringList.add("到期顾客" + modelList.get(0).getObject().getOutdate() + "位");
                stringList.add("今日" + modelList.get(0).getObject().getBirth() + "位顾客生日");
                fragmentHomeDate.setText("日期:    " + modelList.get(0).getObject().getDatetime());
                listView_adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(VolleyError error) {
                Toast_Common.DefaultToast(getActivity(), "网络请求失败，请检查网络");
                Log.e(Tag,error.toString());
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnItemClick(R.id.fragment_home_ListView)
    public void onItemClick(int position) {
        if (position == 1)
            IntentUtil.goToContext(getActivity(), Expire_Activity.class);
        else if (position == 2) {
            IntentUtil.goToContext(getActivity(), Birthday_Activity.class);
        } else {

        }
    }
}
