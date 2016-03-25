package com.eron.hairdresser.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by 林炜智 on 2016/3/19.
 */
public class NewPerm_Fragment_ViewPager_Adapter extends FragmentPagerAdapter {
    private List<Fragment> viewList;

    public NewPerm_Fragment_ViewPager_Adapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.viewList = list;
    }

    @Override
    public Fragment getItem(int position) {
        return viewList.get(position);
    }

    @Override
    public int getCount() {
        return viewList == null ? 0 : viewList.size();
    }
}
