package com.wzy.passwordmanager.utils;

import android.text.TextUtils;

import com.wzy.lmeframe.utils.ChineseSpelling;
import com.wzy.pdmanager.AccountInfo;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 拼音搜索工具类
 * Created by lmejojo on 2016/5/4 0004.
 */
public class SearchUtils {
    /**
     * 按拼音搜索账户信息
     *
     * @param str
     */
    public static ArrayList<AccountInfo> search(String str,
                                                ArrayList<AccountInfo> allAccounts, ArrayList<AccountInfo> searchList) {
        searchList.clear();

        ChineseSpelling finder = ChineseSpelling.getInstance();

        String result = "";
        for (AccountInfo account : allAccounts) {
            // 先将输入的字符串转换为拼音
            finder.setResource(str);
            result = finder.getSpelling();
            if (contains(account, result)) {
                searchList.add(account);
            }
        }
        return searchList;
    }

    /**
     * 根据拼音搜索
     * @return
     */
    public static boolean contains(AccountInfo account, String search) {
        if (TextUtils.isEmpty(account.getTitle())) {
            return false;
        }

        boolean flag = false;

        // 简拼匹配,如果输入在字符串长度大于6就不按首字母匹配了
        if (search.length() < 6) {
            String firstLetters = FirstLetterUtil.getFirstLetter(account
                    .getTitle());
            // 不区分大小写
            Pattern firstLetterMatcher = Pattern.compile(search,
                    Pattern.CASE_INSENSITIVE);
            flag = firstLetterMatcher.matcher(firstLetters).find();
        }

        if (!flag) { // 如果简拼已经找到了，就不使用全拼了
            // 全拼匹配
            ChineseSpelling finder = ChineseSpelling.getInstance();
            finder.setResource(account.getTitle());
            // 不区分大小写
            Pattern pattern2 = Pattern
                    .compile(search, Pattern.CASE_INSENSITIVE);
            Matcher matcher2 = pattern2.matcher(finder.getSpelling());
            flag = matcher2.find();
        }

        return flag;
    }
}
