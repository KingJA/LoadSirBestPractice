package sample.kingja.loadsirbestpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.kingja.loadsir.callback.Callback;
import com.kingja.loadsir.core.LoadService;
import com.kingja.loadsir.core.LoadSir;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements Callback.OnReloadListener {
    @BindView(R.id.tv)
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View rootView = View.inflate(this, R.layout.activity_main, null);
        setContentView(rootView);
        ButterKnife.bind(this);

//        LoadService loadService = LoadSir.getDefault().register(this, this);
        tv.setText("rootView");
    }

    @Override
    public void onReload(View v) {

    }
}
