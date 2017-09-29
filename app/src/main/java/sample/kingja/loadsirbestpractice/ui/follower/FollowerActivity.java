package sample.kingja.loadsirbestpractice.ui.follower;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import sample.kingja.loadsirbestpractice.R;
import sample.kingja.loadsirbestpractice.base.BaseTitleActivity;
import sample.kingja.loadsirbestpractice.injector.component.AppComponent;
import sample.kingja.loadsirbestpractice.loadsir.callback.ErrorCallback;
import sample.kingja.loadsirbestpractice.loadsir.callback.LoadingCallback;
import sample.kingja.loadsirbestpractice.model.entiy.Follower;
import sample.kingja.loadsirbestpractice.util.SharedPreferencesManager;

/**
 * Description：TODO
 * Create Time：2017/3/21 10:46
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class FollowerActivity extends BaseTitleActivity implements FollowerContract.View, SwipeRefreshLayout
        .OnRefreshListener {
    @Inject
    FollowerPresenter mFollowerPresenter;
    @Inject
    SharedPreferencesManager mSpManager;
    @BindView(R.id.rv)
    RecyclerView recyclerView;

    private List<Follower> followers = new ArrayList<>();
    private FollowerAdapter mAnswerAdapter;

    @Override
    protected void initComponent(AppComponent appComponent) {
        DaggerFollowerCompnent.builder()
                .appComponent(appComponent)
                .build()
                .inject(this);
    }

    @Override
    protected String getContentTitle() {
        return "我的提问";
    }

    @Override
    protected int getContentView() {
        return R.layout.single_rv;
    }

    @Override
    protected void initView() {
//        ButterKnife.bind(this);
        mFollowerPresenter.attachView(this);
//        loadService.showSuccess();
        mAnswerAdapter = new FollowerAdapter(this, followers);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setAdapter(mAnswerAdapter);
    }

    @Override
    protected void initNet() {
        mFollowerPresenter.getFollowers("KingJA");
    }

    @Override
    public void showFollowers(List<Follower> followers) {
        mAnswerAdapter.setData(followers);
    }


    @Override
    public void showLoading() {
        loadService.showCallback(LoadingCallback.class);
    }

    @Override
    public void hideLoading() {
        loadService.showSuccess();
    }

    @Override
    public void showError() {
        loadService.showCallback(ErrorCallback.class);
    }


    @Override
    public void onRefresh() {
        initNet();
    }

}
