package com.feizhang.applink.sample;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.feizhang.applink.AppLinkUtils;
import com.feizhang.applink.PushNotificationReceiver;

public class MyApplication extends Application {
    private static final String APP_LINK_PACKAGE = "com.feizhang.applink.sample.applink";
    private static final String SCHEME = "my-scheme";

    /**
     * account id is usually dynamic, it maybe a phone number or a uuid generated by server。
     */
    public static String accountId = "account_123";

    @Override
    public void onCreate() {
        super.onCreate();
        AppLinkUtils.setup(APP_LINK_PACKAGE, SCHEME);
        PushNotificationReceiver.register(this, new PushNotificationReceiver() {

            @Override
            public String getAccount(@NonNull Context context) {
                return accountId;
            }

            @Override
            public int getSmallIcon(@NonNull Context context) {
                return R.drawable.nofication_small_ic;
            }
        });
    }
}
