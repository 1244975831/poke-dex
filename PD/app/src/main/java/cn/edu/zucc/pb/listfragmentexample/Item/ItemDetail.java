package cn.edu.zucc.pb.listfragmentexample.Item;

import java.util.UUID;

/**
 * Created by Administrator on 2016/12/24.
 */

public class ItemDetail {
    private UUID mId;
    private String id;
    private String zhName;
    private String engName;
    private String shux;
    private String shux2;
    private String ability1;
    private String ability2;
    private String ability3;
    private String  hp;
    private String  atk;
    private String  def;
    private String  satk;
    private String  sdef;
    private String  speed;
    private String profile;
    private String link;
    private String type1;
    private String type2;
    private String type3;
    private Integer img;

    public ItemDetail() {
        mId = UUID.randomUUID();
    }

    public String idtoString() {
        return id;
    }

    public String getid() {
        return id;
    }

    public void setid(String title) {
        id = title;
    }

    public String shuxtoString() {
        return shux;
    }

    public String getshux() {
        return shux;
    }

    public void setshux(String title) {
        shux = title;
    }

    public String shux2toString() {
        return shux2;
    }

    public String getshux2() {
        return shux2;
    }

    public void setshux2(String title) {
        shux2 = title;
    }

    public UUID getId() {
        return mId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getZhName() {
        return zhName;
    }

    public void setZhName(String zhName) {
        this.zhName = zhName;
    }

    public String getEngName() {
        return engName;
    }

    public void setEngName(String engName) {
        this.engName = engName;
    }

    public String getAbility1() {
        return ability1;
    }

    public void setAbility1(String ability1) {
        this.ability1 = ability1;
    }

    public String getAbility2() {
        return ability2;
    }

    public void setAbility2(String ability2) {
        this.ability2 = ability2;
    }

    public String getAbility3() {
        return ability3;
    }

    public void setAbility3(String ability3) {
        this.ability3 = ability3;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public String getAtk() {
        return atk;
    }

    public void setAtk(String atk) {
        this.atk = atk;
    }

    public String getDef() {
        return def;
    }

    public void setDef(String def) {
        this.def = def;
    }

    public String getSatk() {
        return satk;
    }

    public void setSatk(String satk) {
        this.satk = satk;
    }

    public String getSdef() {
        return sdef;
    }

    public void setSdef(String sdef) {
        this.sdef = sdef;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public String getType3() {
        return type3;
    }

    public void setType3(String type3) {
        this.type3 = type3;
    }

    public Integer getImg() {
        return img;
    }

    public void setImg(Integer img) {
        this.img = img;
    }

}
