package sample.kingja.loadsirbestpractice.model.entiy;

/**
 * Description：TODO
 * Create Time：2016/11/30 10:56
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class Gift {
    private long giftId;
    private String giftName;
    private String giftDes;
    private int giftCost;
    private int giftCount;
    private int giftRank;
    private String giftUrl;
    public int getGiftCount() {
        return giftCount;
    }

    public void setGiftCount(int giftCount) {
        this.giftCount = giftCount;
    }
    public String getGiftDes() {
        return giftDes;
    }

    public void setGiftDes(String giftDes) {
        this.giftDes = giftDes;
    }
    public long getGiftId() {
        return giftId;
    }

    public void setGiftId(long giftId) {
        this.giftId = giftId;
    }

    public String getGiftName() {
        return giftName;
    }

    public void setGiftName(String giftName) {
        this.giftName = giftName;
    }

    public int getGiftCost() {
        return giftCost;
    }

    public void setGiftCost(int giftCost) {
        this.giftCost = giftCost;
    }

    public int getGiftRank() {
        return giftRank;
    }

    public void setGiftRank(int giftRank) {
        this.giftRank = giftRank;
    }

    public String getGiftUrl() {
        return giftUrl;
    }

    public void setGiftUrl(String giftUrl) {
        this.giftUrl = giftUrl;
    }
}
