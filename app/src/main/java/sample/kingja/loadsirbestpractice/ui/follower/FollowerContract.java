package sample.kingja.loadsirbestpractice.ui.follower;


import java.util.List;

import sample.kingja.loadsirbestpractice.base.BasePresenter;
import sample.kingja.loadsirbestpractice.base.BaseView;
import sample.kingja.loadsirbestpractice.model.entiy.Follower;

/**
 * Description：TODO
 * Create Time：2016/10/10 14:38
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public interface FollowerContract {
    interface View extends BaseView {
        void showFollowers(List<Follower> followers);
    }

    interface Presenter extends BasePresenter<View> {
        void getFollowers(String user);
    }
}
