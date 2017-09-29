package sample.kingja.loadsirbestpractice.app;

import android.app.Application;
import android.content.SharedPreferences;

import com.kingja.loadsir.core.LoadSir;
import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;
import com.squareup.leakcanary.LeakCanary;

import sample.kingja.loadsirbestpractice.injector.component.AppComponent;
import sample.kingja.loadsirbestpractice.injector.component.DaggerAppComponent;
import sample.kingja.loadsirbestpractice.injector.module.ApiModule;
import sample.kingja.loadsirbestpractice.injector.module.AppModule;
import sample.kingja.loadsirbestpractice.injector.module.SharedPreferencesModule;
import sample.kingja.loadsirbestpractice.loadsir.callback.EmptyCallback;
import sample.kingja.loadsirbestpractice.loadsir.callback.ErrorCallback;
import sample.kingja.loadsirbestpractice.loadsir.callback.LoadingCallback;


/**
 * Description：App
 * Create Time：2016/10/14:04
 * Author:KingJA
 * Email:kingjavip@gmail.com
 * <p>
 * 1.创建全局AppComponent
 * 2.对外提供方法获取AppComponent
 */
public class App extends Application {
    private static App sInstance;
    private AppComponent appComponent;
    private static SharedPreferences mSharedPreferences;
    private AppModule appModule;

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
        sInstance = this;
        setupComponent();
        Logger.init().logLevel(LogLevel.FULL);

        LoadSir.beginBuilder()
                .addCallback(new ErrorCallback())
                .addCallback(new EmptyCallback())
                .addCallback(new LoadingCallback())
                .setDefaultCallback(LoadingCallback.class)
                .commit();
    }

    /**
     * 全局注射器,把全局经常用的实例全引用，然后再给各个Activity或者Fragment引用
     */
    private void setupComponent() {
        appComponent = DaggerAppComponent.builder()
                .apiModule(new ApiModule())
                .appModule(new AppModule(this))
                .sharedPreferencesModule(new SharedPreferencesModule()).build();
        appModule = new AppModule(this);
    }

    public static App getContext() {
        return sInstance;
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public AppModule getAppModule() {
        return appModule;
    }


}
