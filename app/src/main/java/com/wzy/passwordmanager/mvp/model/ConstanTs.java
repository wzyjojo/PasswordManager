package com.wzy.passwordmanager.mvp.model;

import com.wzy.passwordmanager.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yezhidong on 2016/1/26.
 */
public class ConstanTs {

    public static int REALM_VERSION = 1;

    public static int VIEW_MODE = 0;
    public static int CREATE_MODE = 1;

    public static int CREATE_GESTURE = 1;
    public static int UPDATE_GESTURE = 2;

    public static final int ICON_ROUND = 1;
    public static final int ICON_RECT = 2;
    public static final int ICON_ROUNDCORNER = 3;

    public final static class EVEN_BUS {
        public static int CHANGE_THEME = 2;
        public static int CHANGE_PASS_WORD_SHOW = 3;
    }

    public final static class SETTING {
        public static String OPEN_GESTURE = "OPEN_GESTURE";
        public static String OPEN_PASS_WORD_SHOW = "OPEN_PASS_WORD_SHOW";
    }

    public static int[] icons = {R.drawable.icon_acfun,R.drawable.icon_alipay,R.drawable.icon_android,
            R.drawable.icon_apple,R.drawable.icon_baidu,R.drawable.icon_bilibili,R.drawable.icon_coolapk,
            R.drawable.icon_csdn,R.drawable.icon_douban,R.drawable.icon_evernote,R.drawable.icon_facebook,
            R.drawable.icon_github,R.drawable.icon_instagram,R.drawable.icon_jianshu,R.drawable.icon_line,
            R.drawable.icon_linkedin,R.drawable.icon_mail,R.drawable.icon_momo,R.drawable.icon_mop,
            R.drawable.icon_pinterest,R.drawable.icon_renren,R.drawable.icon_skype,R.drawable.icon_steam,
            R.drawable.icon_taobao,R.drawable.icon_tencent,R.drawable.icon_twitter,R.drawable.icon_uber,
            R.drawable.icon_wandoujia,R.drawable.icon_wechat,R.drawable.icon_weibo,R.drawable.icon_windows,
            R.drawable.icon_wps,R.drawable.icon_xiami,R.drawable.icon_xiaomi,R.drawable.icon_xunlei,
            R.drawable.icon_youku,R.drawable.icon_zaker,R.drawable.icon_zhihu
    };

    public static List getTypes(){
        ArrayList typeList = new ArrayList();
        typeList.add("其他");
        typeList.add("购物");
        typeList.add("社交");
        typeList.add("论坛");
        typeList.add("生活");
        typeList.add("游戏");
        return typeList;
    }

}
