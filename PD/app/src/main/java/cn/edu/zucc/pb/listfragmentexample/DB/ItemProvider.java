package cn.edu.zucc.pb.listfragmentexample.DB;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

import cn.edu.zucc.pb.listfragmentexample.Item.Item;
import cn.edu.zucc.pb.listfragmentexample.Item.ItemDetail;
import cn.edu.zucc.pb.listfragmentexample.MainActivity;
import cn.edu.zucc.pb.listfragmentexample.R;

/**
 * Created by Administrator on 2015-07-14.
 */
public class ItemProvider {
    private ArrayList<Item> items;
    private ArrayList<ItemDetail> items2;
    private DBManager dbManager;
    private static ItemProvider provider;
    private Context context;
    ArrayList<Item> data = new ArrayList<>();
    ArrayList<ItemDetail> datas = new ArrayList<>();
    private ItemProvider(Context appContext) {
        context = appContext;
        MainActivity m=new MainActivity();
        data=m.ret();
        datas=m.rets();
        items = new ArrayList<Item>();
        items2 = new ArrayList<ItemDetail>();

        for (int i = 0; i <data.size(); i++) {
            Item c = new Item();
            c.setName(data.get(i).getName());
            c.setid(data.get(i).getid());
            c.setshux(data.get(i).getshux());
            c.setshux2(data.get(i).getshux2());
            int w=Integer.parseInt(data.get(i).getid());
            c.setImg(R.drawable.p001+w-1);
//            c.setImg(R.drawable.p001+i-1);
            items.add(c);
        }

        for (int i = 0; i <datas.size(); i++) {
            ItemDetail d = new ItemDetail();
            d.setid(datas.get(i).getid());
            d.setZhName(datas.get(i).getZhName());
            d.setEngName(datas.get(i).getEngName());
            d.setshux(datas.get(i).getshux());
            d.setshux2(datas.get(i).getshux2());
            d.setAbility1(datas.get(i).getAbility1());
            d.setAbility2(datas.get(i).getAbility2());
            d.setAbility3(datas.get(i).getAbility3());
            d.setHp(datas.get(i).getHp());
            d.setAtk(datas.get(i).getAtk());
            d.setDef(datas.get(i).getDef());
            d.setSatk(datas.get(i).getSatk());
            d.setSdef(datas.get(i).getSdef());
            d.setSpeed(datas.get(i).getSpeed());
            d.setProfile(datas.get(i).getProfile());
            d.setType1(datas.get(i).getType1());
            d.setType2(datas.get(i).getType2());
            d.setType3(datas.get(i).getType3());
            d.setLink(datas.get(i).getLink());
            d.setImg(R.drawable.ph001+i);
            items2.add(d);
        }
    }

    public static ItemProvider get(Context c) {
        if (provider == null) {
            provider = new ItemProvider(c.getApplicationContext());
        }
        return provider;
    }
    public static ItemProvider gets(Context c) {
        provider = new ItemProvider(c.getApplicationContext());
        return provider;
    }
    public ArrayList<Item> getItems() {
        return items;
    }

    public Item getItem(UUID id) {
        for (Item c : items) {
            if (c.getId().equals(id))
                return c;
        }
        return null;
    }


    public ItemDetail getItems(String id) {
        for (ItemDetail w: items2) {
            if (w.getid().equals(id)) {
                return w;
            }
        }
        return null;
    }
}
