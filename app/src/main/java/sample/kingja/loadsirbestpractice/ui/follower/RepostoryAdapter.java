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
import sample.kingja.loadsirbestpractice.imgaeloader.ImageLoader;
import sample.kingja.loadsirbestpractice.model.entiy.Repository;

/**
 * Description：TODO
 * Create Time：2016/8/16 13:58
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class RepostoryAdapter extends BaseRvAdaper<Repository> {

    public RepostoryAdapter(Context context, List<Repository> list) {
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
    protected void bindHolder(ViewHolder baseHolder, Repository bean, final int position) {
        final PersonManagerViewHolder holder = (PersonManagerViewHolder) baseHolder;
        holder.tv_user.setText(bean.getOwner().getLogin());
        holder.tv_repostory.setText(bean.getFull_name());
//        setQuestionImg(holder.iv_avator, bean.getOwner().getAvatar_url());
        ImageLoader.getDefault().loadImage(context,bean.getOwner().getAvatar_url(),R.drawable.head_default,holder.iv_avator);
    }

    private void setQuestionImg(ImageView iv_img, String imgUrls) {
        if (TextUtils.isEmpty(imgUrls)) {
            return;
        }
        Glide.with(context)
                .load(imgUrls)
                .centerCrop()
                .placeholder(R.drawable.head_default)
                .crossFade()
                .into(iv_img);
    }

    class PersonManagerViewHolder extends ViewHolder {
        public TextView tv_user;
        public TextView tv_repostory;
        public ImageView iv_avator;

        public PersonManagerViewHolder(View itemView) {
            super(itemView);
            tv_user = (TextView) itemView.findViewById(R.id.tv_user);
            tv_repostory = (TextView) itemView.findViewById(R.id.tv_repostory);
            iv_avator = (ImageView) itemView.findViewById(R.id.iv_avator);
        }
    }
}
