package sample.kingja.loadsirbestpractice.loadsir.callback;

import android.content.Context;
import android.view.View;

import com.kingja.loadsir.callback.Callback;

import sample.kingja.loadsirbestpractice.R;


/**
 * Description:TODO
 * Create Time:2017/9/4 10:22
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */

public class GithubCallback extends Callback {

    @Override
    protected int onCreateView() {
        return R.layout.layout_github;
    }

    @Override
    protected boolean onRetry(Context context, View view) {
        return true;
    }
}
