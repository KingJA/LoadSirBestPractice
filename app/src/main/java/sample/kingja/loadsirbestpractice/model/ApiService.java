package sample.kingja.loadsirbestpractice.model;


import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Path;
import sample.kingja.loadsirbestpractice.model.entiy.Follower;
import sample.kingja.loadsirbestpractice.model.entiy.HttpResult;

/**
 * 项目名称：和Api相关联
 * 类描述：TODO
 * 创建人：KingJA
 * 创建时间：2016/6/12 16:32
 * 修改备注：
 */
public interface ApiService {

    @GET("/users/{user}/followers")
    Observable<HttpResult<List<Follower>>> getFollower(@Path("user") String user);

}
