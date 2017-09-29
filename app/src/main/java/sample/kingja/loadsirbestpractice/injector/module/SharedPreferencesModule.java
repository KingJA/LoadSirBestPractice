package sample.kingja.loadsirbestpractice.injector.module;

import android.app.Application;


import dagger.Module;
import dagger.Provides;
import sample.kingja.loadsirbestpractice.util.SharedPreferencesIO;
import sample.kingja.loadsirbestpractice.util.SharedPreferencesManager;

/**
 * 项目名称：
 * 类描述：TODO
 * 创建人：KingJA
 * 创建时间：2016/6/13 9:48
 * 修改备注：
 */
@Module
public class SharedPreferencesModule {
    public SharedPreferencesModule() {
    }

    @Provides
    public SharedPreferencesIO provideSharedPreferencesIO(Application application) {
        return new SharedPreferencesIO(application);
    }

    @Provides
    public SharedPreferencesManager provideSharedPreferencesManager(SharedPreferencesIO sharedPreferencesIO) {
        return new SharedPreferencesManager(sharedPreferencesIO);
    }

}
