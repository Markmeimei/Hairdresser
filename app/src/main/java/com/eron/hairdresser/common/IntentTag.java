package com.eron.hairdresser.common;

/**
 * Created by 林炜智 on 2016/3/22.
 */
public final class IntentTag {
    public final static String newRecordTag = "newRecord";
    private static String PermDye = "PermDye";
    private static String Nutrition = "Nutrition";
    private static String SPA = "SPA";
    private static String Hairdressing = "Hairdressing";

    public final static String getNewRecordBase(int position) {
        if (position == 1)
            return PermDye;
        else if (position == 2)
            return Nutrition;
        else if (position == 3)
            return SPA;
        else if (position == 4)
            return Hairdressing;
        else
            return "";
    }
}
