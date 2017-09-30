package sample.kingja.loadsirbestpractice.ui.follower;


import java.util.List;

import sample.kingja.loadsirbestpractice.base.BasePresenter;
import sample.kingja.loadsirbestpractice.base.BaseView;
import sample.kingja.loadsirbestpractice.model.entiy.Repository;

/**
 * Description：TODO
 * Create Time：2016/10/10 14:38
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public interface RepostoryContract {
    interface View extends BaseView {
        void showRepostories(List<Repository> followers);
    }

    interface Presenter extends BasePresenter<View> {
        void getFollowers(String user);
    }
}
