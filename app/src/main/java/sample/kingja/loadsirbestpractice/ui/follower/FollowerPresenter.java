package sample.kingja.loadsirbestpractice.ui.follower;

import android.os.SystemClock;
import android.support.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import sample.kingja.loadsirbestpractice.model.Api;
import sample.kingja.loadsirbestpractice.model.ResultObserver;
import sample.kingja.loadsirbestpractice.model.entiy.Follower;

/**
 * Description：TODO
 * Create Time：2017/3/21 11:17
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class FollowerPresenter implements FollowerContract.Presenter {
    private Api api;
    private FollowerContract.View view;

    @Inject
    public FollowerPresenter(Api api) {
        this.api = api;
    }

    @Override
    public void getFollowers(String user) {
        view.showLoading();
        api.getFollower(user)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ResultObserver<List<Follower>>(view) {
            @Override
            protected void onSuccess(List<Follower> followers) {
                view.showFollowers(followers);
            }
        });
    }

    @Override
    public void attachView(@NonNull FollowerContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {

    }
}
