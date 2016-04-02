package com.lin.framwork.config;

/**
 * Created by 林炜智 on 2016/3/23.
 */
public class ConfigUrl {
    public final static String Login_ActivityUrl = Config.getUrlPath() + "login";      //登录接口  Post
    public final static String Home_FragmentUrl = Config.getUrlPath() + "remind";      //首页提示接口  Post
    public final static String Birthday_ActivityUrl = Config.getUrlPath() + "birth_remind";      //首页顾客生日提示  Post
    public final static String Expire_FragmentUrl = Config.getUrlPath() + "outdate_remind";      //首页到期顾客  Post
    public final static String CompanyProfile_ActivityUrl = Config.getUrlPath() + "art_cat_info";      //公司简介、升迁制度、规章制度  Post
    public final static String Product_ActivityUrl = Config.getUrlPath() + "product_list";      //产品列表  Post
    public final static String HairStyleImg_ActivityUrl = Config.getUrlPath() + "article_list"; //发型图片  Post
}
