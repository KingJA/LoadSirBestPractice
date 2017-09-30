package sample.kingja.loadsirbestpractice.ui.follower;

import android.support.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import sample.kingja.loadsirbestpractice.model.Api;
import sample.kingja.loadsirbestpractice.model.entiy.Repository;
import sample.kingja.loadsirbestpractice.model.result.SearchResultObserver;

/**
 * Description：TODO
 * Create Time：2017/3/21 11:17
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class RepostoryPresenter implements RepostoryContract.Presenter {
    private Api api;
    private RepostoryContract.View view;

    @Inject
    public RepostoryPresenter(Api api) {
        this.api = api;
    }

    @Override
    public void getFollowers(String user) {
        view.showLoading();
        api.getFollower(user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SearchResultObserver<Repository>(view) {
                    @Override
                    protected void onSuccess(List<Repository> repositories) {
                        view.showRepostories(repositories);
                    }
                });
    }

    @Override
    public void attachView(@NonNull RepostoryContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {

    }
}
