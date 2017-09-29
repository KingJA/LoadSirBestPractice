package sample.kingja.loadsirbestpractice.base;

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

/**
 * Description：TODO
 * Create Time：2017/3/20 14:17
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public abstract class BaseTitleActivity extends BaseActivity implements Callback.OnReloadListener {
//    @BindView(R.id.ll_title_back)
//    LinearLayout llTitleBack;
//    @BindView(R.id.tv_title_title)
//    TextView tvTitleTitle;
//    @BindView(R.id.fl_content)
//    FrameLayout flContent;
    protected LoadService loadService;
    private FrameLayout fl_content;
    private TextView tv_title_title;
    private LinearLayout ll_title_back;

    @Override
    public void initVariable() {

    }

    @Override
    public int getContentId() {
        View rootView = View.inflate(this, R.layout.activity_title, null);
        fl_content = (FrameLayout) rootView.findViewById(R.id.fl_content);
        tv_title_title = (TextView) rootView.findViewById(R.id.tv_title_title);
        ll_title_back = (LinearLayout) rootView.findViewById(R.id.ll_title_back);
        tv_title_title.setText(getContentTitle() == null ? "" : getContentTitle());
        ll_title_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        return R.layout.activity_title;
    }

    protected abstract void initComponent(AppComponent appComponent);

    @Override
    protected void initViewAndListener() {
        View content = View.inflate(this, getContentView(), null);
        if (content != null) {
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
                    FrameLayout.LayoutParams.MATCH_PARENT);
            fl_content.addView(content, params);
            loadService = LoadSir.getDefault().register(content, this);

        }
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
