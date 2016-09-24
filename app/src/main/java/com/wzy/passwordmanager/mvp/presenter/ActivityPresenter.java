package com.wzy.passwordmanager.mvp.presenter;

import android.content.Intent;
import android.os.Bundle;


public interface ActivityPresenter {

    void onCreate(Bundle savedInstanceState);

    void getIntent(Intent intent);


}
