package sample.kingja.loadsirbestpractice.injector.component;


import android.app.Application;


import javax.inject.Singleton;

import dagger.Component;
import sample.kingja.loadsirbestpractice.imgaeloader.IImageLoader;
import sample.kingja.loadsirbestpractice.injector.module.ApiModule;
import sample.kingja.loadsirbestpractice.injector.module.AppModule;
import sample.kingja.loadsirbestpractice.injector.module.ImageLoaderModule;
import sample.kingja.loadsirbestpractice.injector.module.SharedPreferencesModule;
import sample.kingja.loadsirbestpractice.model.Api;
import sample.kingja.loadsirbestpractice.util.SharedPreferencesManager;

/**
 * 项目名称：
 * 类描述：TODO
 * 创建人：KingJA
 * 创建时间：2016/6/13 9:42
 * 修改备注：
 */
@Singleton
@Component(modules = {ApiModule.class, AppModule.class, SharedPreferencesModule.class,ImageLoaderModule.class})
public interface AppComponent {
    Api getApi();
    SharedPreferencesManager getSharedPreferencesManager();
    Application getApplication();
    IImageLoader getImageLoader();
}
