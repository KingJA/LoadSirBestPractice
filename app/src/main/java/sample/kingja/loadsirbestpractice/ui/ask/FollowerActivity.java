package sample.kingja.loadsirbestpractice.ui.ask;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import sample.kingja.loadsirbestpractice.R;
import sample.kingja.loadsirbestpractice.base.BaseTitleActivity;
import sample.kingja.loadsirbestpractice.injector.component.AppComponent;
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
//    @BindView(R.id.srl)
//    SwipeRefreshLayout swipeRefreshLayout;
//    @BindView(R.id.rv)
//    RecyclerView recyclerView;

    private List<Follower> questions = new ArrayList<>();
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
        mFollowerPresenter.attachView(this);
//        swipeRefreshLayout.setOnRefreshListener(this);
//        mAnswerAdapter = new FollowerAdapter(this, questions);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setAdapter(mAnswerAdapter);
    }

    @Override
    protected void initNet() {
//        mFollowerPresenter.getFollowers("KingJA");
    }

    @Override
    public void showFollowers(List<Follower> followers) {
//        mAnswerAdapter.setData(questions);
    }


    @Override
    public void showLoading() {
//        swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void hideLoading() {
//        swipeRefreshLayout.setRefreshing(false);
    }


    @Override
    public void onRefresh() {
        initNet();
    }

}
