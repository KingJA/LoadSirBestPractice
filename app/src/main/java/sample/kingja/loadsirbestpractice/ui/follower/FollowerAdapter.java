package sample.kingja.loadsirbestpractice.ui.follower;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import sample.kingja.loadsirbestpractice.R;
import sample.kingja.loadsirbestpractice.app.Constants;
import sample.kingja.loadsirbestpractice.base.BaseRvAdaper;
import sample.kingja.loadsirbestpractice.model.entiy.Follower;

/**
 * Description：TODO
 * Create Time：2016/8/16 13:58
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class FollowerAdapter extends BaseRvAdaper<Follower> {

    public FollowerAdapter(Context context, List<Follower> list) {
        super(context, list);
    }

    @Override
    protected ViewHolder createViewHolder(View v) {
        return new PersonManagerViewHolder(v);
    }

    @Override
    protected int getItemView() {
        return R.layout.item_follower;
    }

    @Override
    protected void bindHolder(ViewHolder baseHolder, Follower bean, final int position) {
        final PersonManagerViewHolder holder = (PersonManagerViewHolder) baseHolder;
//        holder.tv_title.setText(bean.getTitle());
    }

    private void setQuestionImg(ImageView iv_img, String imgUrls) {
        if (TextUtils.isEmpty(imgUrls)) {
            return;
        }
        String[] imgArr = imgUrls.split("#");
        iv_img.setVisibility(View.VISIBLE);
        Glide.with(context)
                .load(Constants.BASE_URL + imgArr[0])
                .centerCrop()
                .placeholder(R.drawable.head_default)
                .crossFade()
                .into(iv_img);
    }

    class PersonManagerViewHolder extends ViewHolder {
        public TextView tv_title;

        public PersonManagerViewHolder(View itemView) {
            super(itemView);
//            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }
}
