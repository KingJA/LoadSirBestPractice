package sample.kingja.loadsirbestpractice.model.entiy;


/**
 * Description：TODO
 * Create Time：2017/3/24 13:13
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class OtherUser {
    private long accountId;
    private String name;
    private String avatar;
    private int experience;
    private String des;
    private int isAttention;
    private int attentionCount;
    private int fansCount;
    private RankInfo rankInfo;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getAttentionCount() {
        return attentionCount;
    }

    public void setAttentionCount(int attentionCount) {
        this.attentionCount = attentionCount;
    }

    public int getFansCount() {
        return fansCount;
    }

    public void setFansCount(int fansCount) {
        this.fansCount = fansCount;
    }

    public RankInfo getRankInfo() {
        return new RankInfo(experience);
    }

    public void setRankInfo(RankInfo rankInfo) {
        this.rankInfo = rankInfo;
    }

    public int getIsAttention() {
        return isAttention;
    }

    public void setIsAttention(int isAttention) {
        this.isAttention = isAttention;
    }
}
