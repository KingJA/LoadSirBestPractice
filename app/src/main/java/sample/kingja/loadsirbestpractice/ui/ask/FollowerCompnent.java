package sample.kingja.loadsirbestpractice.ui.ask;


import dagger.Component;
import sample.kingja.loadsirbestpractice.injector.annotation.PerActivity;
import sample.kingja.loadsirbestpractice.injector.component.AppComponent;

/**
 * 项目名称：
 * 类描述：TODO
 * 创建人：KingJA
 * 创建时间：2016/6/13 13:01
 * 修改备注：
 */
@PerActivity
@Component(dependencies = AppComponent.class)
public interface FollowerCompnent {
    void inject(FollowerActivity activity);
}
