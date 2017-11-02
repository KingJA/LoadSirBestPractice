package sample.kingja.loadsirbestpractice.ui.follower;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.kingja.loadsir.callback.Callback;
import com.kingja.loadsir.core.LoadService;
import com.kingja.loadsir.core.LoadSir;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import sample.kingja.loadsirbestpractice.R;
import sample.kingja.loadsirbestpractice.base.BaseTitleActivity;
import sample.kingja.loadsirbestpractice.injector.component.AppComponent;
import sample.kingja.loadsirbestpractice.loadsir.callback.EmptyCallback;
import sample.kingja.loadsirbestpractice.loadsir.callback.ErrorCallback;
import sample.kingja.loadsirbestpractice.loadsir.callback.LoadingCallback;
import sample.kingja.loadsirbestpractice.model.entiy.Repository;
import sample.kingja.loadsirbestpractice.util.SharedPreferencesManager;

import static sample.kingja.loadsirbestpractice.R.id.rv;

/**
 * Description：TODO
 * Create Time：2017/3/21 10:46
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class RepostoryActivity extends BaseTitleActivity implements RepostoryContract.View, Callback.OnReloadListener {
    @Inject
    RepostoryPresenter mRepostoryPresenter;
    @Inject
    SharedPreferencesManager mSpManager;
    @BindView(R.id.rv)
    RecyclerView recyclerView;
    @BindView(R.id.srl)
    SwipeRefreshLayout swipeRefreshLayout;

    @BindView(R.id.et_keyword)
    EditText mEtKeyword;
    @BindView(R.id.iv_search)
    ImageView mIvSearch;
    protected LoadService loadService;

    private List<Repository> repositories = new ArrayList<>();
    private RepostoryAdapter mRepostoryAdapter;

    @Override
    protected void initComponent(AppComponent appComponent) {
        DaggerRepostoryCompnent.builder()
                .appComponent(appComponent)
                .build()
                .inject(this);
    }

    @Override
    protected String getContentTitle() {
        return "Github Repostory Search";
    }

    @Override
    protected int getContentView() {
        return R.layout.single_rv;
    }

    @Override
    protected void initView() {
        loadService = LoadSir.getDefault().register(recyclerView, this);
        mRepostoryPresenter.attachView(this);
        mRepostoryAdapter = new RepostoryAdapter(this, repositories);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(mRepostoryAdapter);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(false);
            }
        });
        mIvSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doSearch();
            }
        });
    }

    private void doSearch() {
        String keyword = mEtKeyword.getText().toString().trim();
        if (!TextUtils.isEmpty(keyword)) {
            mRepostoryPresenter.getFollowers(keyword);
        }
    }

    @Override
    protected void initNet() {

    }

    @Override
    public void showRepostories(List<Repository> repositories) {
        loadService.showSuccess();
        mRepostoryAdapter.setData(repositories);
    }


    @Override
    public void showLoading() {
        loadService.showCallback(LoadingCallback.class);
    }


    @Override
    public void showError() {
        loadService.showCallback(ErrorCallback.class);
    }

    @Override
    public void showEmpty() {
        loadService.showCallback(EmptyCallback.class);
    }

    @Override
    public void onReload(View v) {
        doSearch();
    }
}
