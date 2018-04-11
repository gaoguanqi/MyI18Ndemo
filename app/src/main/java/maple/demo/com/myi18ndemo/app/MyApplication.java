package maple.demo.com.myi18ndemo.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import maple.demo.com.myi18ndemo.utils.I18NUtils;

/**
 * Created by Gaoguanqi on 2018/4/11.
 */

public class MyApplication extends Application {
    private static MyApplication app;
    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    //  设置本地化语言
        I18NUtils.setLocale(this);
    }

    public static Context getAppContext() {
        return app;
    }
}
