package sample.kingja.loadsirbestpractice.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import sample.kingja.loadsirbestpractice.app.App;
import sample.kingja.loadsirbestpractice.injector.component.AppComponent;
import sample.kingja.loadsirbestpractice.injector.module.ActivityModule;
import sample.kingja.loadsirbestpractice.injector.module.AppModule;
import sample.kingja.loadsirbestpractice.util.AppManager;

/**
 * Description：BaseActivity
 * Create Time：2016/10/14:45
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public abstract class BaseActivity extends AppCompatActivity {
    protected String TAG = getClass().getSimpleName();
    private ProgressDialog mDialogProgress;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initCommon();
        initVariable();
        setContentView(getContentId());
        initComponent(App.getContext().getAppComponent());
        initViewAndListener();
        initNet();
        AppManager.getAppManager().addActivity(this);

    }


    /*初始化公共组件*/
    private void initCommon() {
        mDialogProgress = new ProgressDialog(this);
    }

    /*设置圆形进度条*/
    protected void setProgressShow(boolean ifShow) {
        if (ifShow) {
            mDialogProgress.show();
        } else {
            mDialogProgress.dismiss();
        }
    }

    protected boolean getProgressShow() {
       return (mDialogProgress!=null&&mDialogProgress.isShowing());
    }

    /*获取初始化数据*/
    public abstract void initVariable();

    /*获取界面Id*/
    public abstract View getContentId();

    /*依赖注入*/
    protected abstract void initComponent(AppComponent appComponent);

    /*初始化界面和事件*/
    protected abstract void initViewAndListener();
   /*初始化网络数据*/
    protected abstract void initNet();


    /*提供全局AppComponent*/
    protected AppComponent getAppComponent() {
        return App.getContext().getAppComponent();
    }
   /*提供全局AppModule*/
    protected AppModule getAppModule() {
        return App.getContext().getAppModule();
    }

    /*提供当前ActivityModule*/
    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    /*清理事件队列*/
    /*销毁对话框*/
    /*销毁Activity*/
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mDialogProgress.isShowing()) {
            mDialogProgress.dismiss();
            mDialogProgress = null;
        }
        AppManager.getAppManager().finishActivity(this);
    }
}
