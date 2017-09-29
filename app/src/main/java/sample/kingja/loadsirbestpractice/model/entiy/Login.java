package sample.kingja.loadsirbestpractice.model.entiy;

/**
 * Description：TODO
 * Create Time：2016/10/621:02
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class Login {

    private String userName;
    /**
     * accountId : 9
     * name : aaa
     * password : bbb
     * createTime : 2016-11-18 01:34:13
     * modifyTime : 2017-02-28 09:36:48
     * nickName :
     * phone :
     * token : ed2e901f31de42e5ab0c963966851410
     * avatar : /upload/avatar/head_9.jpg
     * coin : 99814
     * experience : 146
     * rankInfo : {"rank":3,"upExperience":420,"title":"初出茅庐3","currentExperience":146}
     */

    private int accountId;
    private String name;
    private String password;
    private String createTime;
    private String modifyTime;
    private String nickName;
    private String phone;
    private String token;
    private String avatar;
    private int coin;
    private int experience;
    /**
     * rank : 3
     * upExperience : 420
     * title : 初出茅庐3
     * currentExperience : 146
     */

    private RankInfoEntity rankInfo;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public RankInfoEntity getRankInfo() {
        return rankInfo;
    }

    public void setRankInfo(RankInfoEntity rankInfo) {
        this.rankInfo = rankInfo;
    }

    public static class RankInfoEntity {
        private int rank;
        private int upExperience;
        private String title;
        private int currentExperience;

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public int getUpExperience() {
            return upExperience;
        }

        public void setUpExperience(int upExperience) {
            this.upExperience = upExperience;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getCurrentExperience() {
            return currentExperience;
        }

        public void setCurrentExperience(int currentExperience) {
            this.currentExperience = currentExperience;
        }
    }
}
