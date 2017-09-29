package sample.kingja.loadsirbestpractice.model;


import com.orhanobut.logger.Logger;

import io.reactivex.observers.DefaultObserver;
import sample.kingja.loadsirbestpractice.base.BaseView;
import sample.kingja.loadsirbestpractice.model.entiy.HttpResult;
import sample.kingja.loadsirbestpractice.util.ToastUtil;

/**
 * Description：TODO
 * Create Time：2016/10/12 15:56
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public abstract class ResultObserver<T> extends DefaultObserver<HttpResult<T>> {
    private BaseView baseView;

    public ResultObserver(BaseView baseView) {
        this.baseView = baseView;
    }

    @Override
    protected void onStart() {
        super.onStart();
        baseView.showLoading();
    }

    @Override
    public void onNext(HttpResult<T> httpResult) {
        baseView.hideLoading();
        if (httpResult.getResultCode() == 0) {
            onSuccess(httpResult.getResultData());
        } else {
            ToastUtil.showText(httpResult.getResultText());
        }
    }

    protected abstract void onSuccess(T t);

    @Override
    public void onError(Throwable e) {
        //记录错误
        Logger.e(e.toString());
        baseView.hideLoading();
    }

    @Override
    public void onComplete() {
    }


}
