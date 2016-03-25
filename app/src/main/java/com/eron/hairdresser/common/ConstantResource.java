package com.eron.hairdresser.common;

import com.eron.hairdresser.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 林炜智 on 2016/3/9.
 * 固定不变的常量
 */
public final class ConstantResource {
    public final static List<Integer> getHomeList() {
        List<Integer> list = new ArrayList<>();
        list.add(R.mipmap.img_adapter_home_fragment_listview01);
        list.add(R.mipmap.img_adapter_home_fragment_listview02);
        list.add(R.mipmap.img_adapter_home_fragment_listview03);
        return list;
    }

    public final static List<Integer> getHairdresserList() {
        List<Integer> list = new ArrayList<>();
        list.add(R.mipmap.img_adapter_hairdresser_fragment_listview01);
        list.add(R.mipmap.img_adapter_hairdresser_fragment_listview02);
        list.add(R.mipmap.img_adapter_hairdresser_fragment_listview03);
        return list;
    }

    public final static Integer getImgAdvance() {
        return R.mipmap.head_title_advance;
    }

    public final static Integer getImgReturn() {
        return R.mipmap.head_title_return;
    }

    public final static List<Integer> getCustpmerList() {
        List<Integer> list = new ArrayList<>();
        list.add(R.mipmap.img_adapter_customer_fragment_girdview01);
        list.add(R.mipmap.img_adapter_customer_fragment_girdview02);
        list.add(R.mipmap.img_adapter_customer_fragment_girdview03);
        list.add(R.mipmap.img_adapter_customer_fragment_girdview04);
        return list;
    }

    public final static List<Integer> getReadListUp() {
        List<Integer> list = new ArrayList<>();
        list.add(R.mipmap.img_adapter_read_fragment_girdview_up01);
        list.add(R.mipmap.img_adapter_read_fragment_girdview_up02);
        list.add(R.mipmap.img_adapter_read_fragment_girdview_up03);
        return list;
    }

    public final static List<Integer> getReadListCentre() {
        List<Integer> list = new ArrayList<>();
        list.add(R.mipmap.img_adapter_read_fragment_girdview_centre01);
        list.add(R.mipmap.img_adapter_read_fragment_girdview_centre02);
        list.add(R.mipmap.img_adapter_read_fragment_girdview_centre03);
        return list;
    }

    public final static List<Integer> getReadListDown() {
        List<Integer> list = new ArrayList<>();
        list.add(R.mipmap.img_adapter_read_fragment_girdview_down01);
        list.add(R.mipmap.img_adapter_read_fragment_girdview_down02);
        list.add(R.mipmap.img_adapter_read_fragment_girdview_down03);
        return list;
    }
}
