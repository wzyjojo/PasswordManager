package com.wzy.passwordmanager.mvp.ui.view;

/**
 * Created by lmejojo on 2016/5/12 0012.
 */
public interface AddView extends BaseView{
    void init();
    void setToolbarTitle(String title);
    void rdGoForResult(Class<?> clazz,int requestCode);
    void hideKeyBoard();
    String getTitleName();
    String getUserName();
    String getPassWord();
    String getNoteInfo();
    int getIconPosition();

}
