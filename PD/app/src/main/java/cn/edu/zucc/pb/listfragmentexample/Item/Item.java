package cn.edu.zucc.pb.listfragmentexample.Item;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Administrator on 2015-07-14.
 */
public class Item {
    private UUID mId;
    private String name;
    private Integer img;
    private String id;
    private String shux;
    private String shux2;
    public Item() {
        mId = UUID.randomUUID();
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String title) {
        name = title;
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

    public Integer getImg() {
        return img;
    }

    public void setImg(Integer img) {
        this.img = img;
    }
}
