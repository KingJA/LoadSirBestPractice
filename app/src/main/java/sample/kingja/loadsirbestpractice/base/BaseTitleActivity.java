package sample.kingja.loadsirbestpractice.base;

import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.kingja.loadsir.callback.Callback;
import com.kingja.loadsir.core.LoadService;
import com.kingja.loadsir.core.LoadSir;

import butterknife.BindView;
import butterknife.ButterKnife;
import sample.kingja.loadsirbestpractice.R;
import sample.kingja.loadsirbestpractice.injector.component.AppComponent;

import static sample.kingja.loadsirbestpractice.R.id.fl_content;
import static sample.kingja.loadsirbestpractice.R.id.ll_title_back;
import static sample.kingja.loadsirbestpractice.R.id.tv_title_title;

/**
 * Description：TODO
 * Create Time：2017/3/20 14:17
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public abstract class BaseTitleActivity extends BaseActivity implements Callback.OnReloadListener {
    protected LoadService loadService;
    private View rootView;
    private FrameLayout flContent;
    private TextView tvTitleTitle;
    private LinearLayout llTitleBack;

    @Override
    public void initVariable() {

    }

    @Override
    public View getContentId() {
        rootView = View.inflate(this, R.layout.activity_title, null);
        flContent = (FrameLayout) rootView.findViewById(R.id.fl_content);
        tvTitleTitle = (TextView) rootView.findViewById(R.id.tv_title_title);
        llTitleBack = (LinearLayout) rootView.findViewById(R.id.ll_title_back);
        return rootView;
    }

    protected abstract void initComponent(AppComponent appComponent);

    @Override
    protected void initViewAndListener() {
        tvTitleTitle.setText(getContentTitle() == null ? "" : getContentTitle());
        llTitleBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        View content = View.inflate(this, getContentView(), null);
        if (content != null) {
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
                    FrameLayout.LayoutParams.MATCH_PARENT);
            flContent.addView(content, params);
            loadService = LoadSir.getDefault().register(this, this);
        }
//        ButterKnife.bind(rootView);
        initView();
    }

    protected abstract String getContentTitle();

    protected abstract int getContentView();

    protected abstract void initView();


    protected abstract void initNet();

    @Override
    public void onReload(View v) {
        initNet();
    }
}
