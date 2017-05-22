package cn.edu.zucc.pb.listfragmentexample.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cn.edu.zucc.pb.listfragmentexample.Item.Item;
import cn.edu.zucc.pb.listfragmentexample.Item.ItemDetail;

/**
 * Created by Administrator on 2016/12/11.
 */

public class DBManager {
    private DBHelper helper;
    private SQLiteDatabase db;
    private Context mContext;
    private int TEXT_CONTENT = 0;//纯文本
    private int LINK_CONTENT = 1;//连接内容
    private int IMAGE_CONTENT = 2;//图片内容

    public DBManager(Context context) {
        helper = new DBHelper(context);
        //因为getWritableDatabase内部调用了mContext.openOrCreateDatabase(mName, 0, mFactory);
        //所以要确保context已初始化,我们可以把实例化DBManager的步骤放在Activity的onCreate里
        db = helper.getWritableDatabase();
        mContext=context;
    }
    //搜索列表项
    public  List<Item> getitem(String value){
        ArrayList<Item> datas = new ArrayList<>();
        SQLiteDatabase dp=helper.getWritableDatabase();
        Cursor cursor = dp.query("Pokemon",null,null,null,null,null,null);
        int i=0;
        if(cursor.moveToFirst()){
            do{
                Item data = new Item();

                String name = cursor.getString(cursor.getColumnIndex("zhName"));
                String id = cursor.getString(cursor.getColumnIndex("pid"));
                String shux1 = cursor.getString(cursor.getColumnIndex("type1"));
                String shux2 = cursor.getString(cursor.getColumnIndex("type2"));
                data.setName(name);
                data.setid(id);
                data.setshux(shux1);
                data.setshux2(shux2);
                if (value==null) {
                    datas.add(data);
                    if(i==0)
                        datas.add(data);
                    i++;
                }
                else if(value==""){
                    datas.add(data);
                    if(i==0)
                        datas.add(data);
                    i++;
                }
                else if(shux1.equals(value)||shux2.equals(value)){
                    datas.add(data);
                    if(i==0)
                        datas.add(data);
                    i++;
                }

                if(i==0)
                    datas.add(data);
                i++;
            }while (cursor.moveToNext());
        }

        datas.size();
        cursor.close();
        return datas;
    }

    public  List<ItemDetail> getitems(){
        ArrayList<ItemDetail> datas2 = new ArrayList<>();
        ArrayList<ItemDetail> datas3 = new ArrayList<>();
        ArrayList<ItemDetail> datas4 = new ArrayList<>();
        ArrayList<ItemDetail> datas7 = new ArrayList<>();
        SQLiteDatabase dp=helper.getWritableDatabase();
        Cursor cursor = dp.query("Pokemon",null,null,null,null,null,null);
        Cursor cursor1 = dp.query("Data",null,null,null,null,null,null);
        Cursor cursor2 = dp.query("EvolveLine",null,null,null,null,null,null);
        Cursor cursor3 = dp.query("Profile",null,null,null,null,null,null);
        int i=0;
        if(cursor.moveToFirst()){
            do{
                ItemDetail data = new ItemDetail();
                String zhName = cursor.getString(cursor.getColumnIndex("zhName"));
                String id = cursor.getString(cursor.getColumnIndex("pid"));
                String shux1 = cursor.getString(cursor.getColumnIndex("type1"));
                String shux2 = cursor.getString(cursor.getColumnIndex("type2"));
                String engName = cursor.getString(cursor.getColumnIndex("engName"));
                data.setZhName(zhName);
                data.setEngName(engName);
                data.setid(id);
                data.setshux(shux1);
                data.setshux2(shux2);
                datas2.add(data);
            }while (cursor.moveToNext());
        }
        cursor.close();

        if(cursor1.moveToFirst()){
            do{
                ItemDetail data = new ItemDetail();
                String ability1 = cursor1.getString(cursor1.getColumnIndex("ability1"));
                String ability2 = cursor1.getString(cursor1.getColumnIndex("ability2"));
                String ability3 = cursor1.getString(cursor1.getColumnIndex("ability3"));
                String  hp = cursor1.getString(cursor1.getColumnIndex("hp"));
                String  atk = cursor1.getString(cursor1.getColumnIndex("atk"));
                String  def = cursor1.getString(cursor1.getColumnIndex("def"));
                String  satk = cursor1.getString(cursor1.getColumnIndex("satk"));
                String  sdef = cursor1.getString(cursor1.getColumnIndex("sdef"));
                String  speed = cursor1.getString(cursor1.getColumnIndex("speed"));
                data.setAbility1(ability1);
                data.setAbility2(ability2);
                data.setAbility3(ability3);
                data.setHp(hp);
                data.setAtk(atk);
                data.setDef(def);
                data.setSatk(satk);
                data.setSdef(sdef);
                data.setSpeed(speed);
                datas3.add(data);
            }while (cursor1.moveToNext());
        }
        cursor1.close();
        if(cursor2.moveToFirst()){
            do{
                ItemDetail data = new ItemDetail();
                String  etype1 = cursor2.getString(cursor2.getColumnIndex("etype1"));
                String  etype2 = cursor2.getString(cursor2.getColumnIndex("etype2"));
                String  etype3 = cursor2.getString(cursor2.getColumnIndex("etype3"));
                data.setType1(etype1);
                data.setType2(etype2);
                data.setType3(etype3);
                if(etype3.equals("无")) {
                    datas7.add(data);
                    datas7.add(data);
                }
                else {
                    datas7.add(data);
                    datas7.add(data);
                    datas7.add(data);
                }
            }while (cursor2.moveToNext());
        }
        cursor2.close();
        if(cursor3.moveToFirst()){
            do{
                ItemDetail data = new ItemDetail();
                String  profile = cursor3.getString(cursor3.getColumnIndex("profile"));
                String  link = cursor3.getString(cursor3.getColumnIndex("link"));
                data.setProfile(profile);
                data.setLink(link);
                datas4.add(data);
            }while (cursor3.moveToNext());
        }
        cursor3.close();
        i=0;
        ArrayList<ItemDetail> datas6 = new ArrayList<>();
        for(int kx=0;kx<datas2.size();kx++){
            ItemDetail datas5 = new ItemDetail();
            datas5.setid(datas2.get(kx).getid());
            datas5.setZhName(datas2.get(kx).getZhName());
            datas5.setEngName(datas2.get(kx).getEngName());
            datas5.setshux(datas2.get(kx).getshux());
            datas5.setshux2(datas2.get(kx).getshux2());
            datas5.setAbility1(datas3.get(kx).getAbility1());
            datas5.setAbility2(datas3.get(kx).getAbility2());
            datas5.setAbility3(datas3.get(kx).getAbility3());
            datas5.setHp(datas3.get(kx).getHp());
            datas5.setAtk(datas3.get(kx).getAtk());
            datas5.setDef(datas3.get(kx).getDef());
            datas5.setSatk(datas3.get(kx).getSatk());
            datas5.setSdef(datas3.get(kx).getSdef());
            datas5.setSpeed(datas3.get(kx).getSpeed());
            datas5.setProfile(datas4.get(kx).getProfile());
            datas5.setLink(datas4.get(kx).getLink());
            datas5.setType1(datas7.get(kx).getType1());
            datas5.setType2(datas7.get(kx).getType2());
            datas5.setType3(datas7.get(kx).getType3());
            datas6.add(datas5);
        }

        datas6.size();
        return datas6;
    }

    public void addflag(){
        ContentValues values=new ContentValues();
        try {
            values.put("flag",1);
            db.insert("Load",null,values);
            values.clear();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public int getflag(){
        int result=0;
        SQLiteDatabase dp=helper.getWritableDatabase();
        Cursor cursor = dp.query("Pokemon",null,null,null,null,null,null);
        if(cursor.moveToFirst()){
            do{
                result=1;
            }while (cursor.moveToNext());
        }
        cursor.close();
        return result;
    }

    public  List<ItemDetail> selectitems(String value){
        ArrayList<ItemDetail> datas2 = new ArrayList<>();
        ArrayList<ItemDetail> datas3 = new ArrayList<>();
        ArrayList<ItemDetail> datas4 = new ArrayList<>();

        SQLiteDatabase dp=helper.getWritableDatabase();
        Cursor cursor = dp.query("Pokemon",null,null,null,null,null,null);
        Cursor cursor1 = dp.query("Data",null,null,null,null,null,null);
        Cursor cursor2 = dp.query("EvolveLine",null,null,null,null,null,null);
        Cursor cursor3 = dp.query("Profile",null,null,null,null,null,null);
        int i=0;
        if(cursor.moveToFirst()){
            do{
                ItemDetail data = new ItemDetail();
                String zhName = cursor.getString(cursor.getColumnIndex("zhName"));
                String id = cursor.getString(cursor.getColumnIndex("pid"));
                String shux1 = cursor.getString(cursor.getColumnIndex("type1"));
                String shux2 = cursor.getString(cursor.getColumnIndex("type2"));
                String engName = cursor.getString(cursor.getColumnIndex("engName"));
                data.setZhName(zhName);
                data.setEngName(engName);
                data.setid(id);
                data.setshux(shux1);
                data.setshux2(shux2);
                if(shux1.equals(value)||shux2.equals(value))
                    datas2.add(data);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return datas2;
    }

    public void initData(){
//        dbHelper=new DatabaseHelper(MainActivity.this,"Pokemon.db",null,1);
//        dbHelper.getWritableDatabase();
//        SQLiteDatabase db=dbHelper.getWritableDatabase();
        ContentValues values=new ContentValues();

        try {
            String Pokemon = InputPokemonData.Pokemon;
            JSONArray jsonArray=new JSONArray(Pokemon);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject=jsonArray.getJSONObject(i);
                String pid = jsonObject.getString("pid");
                String zhName = jsonObject.getString("zhName");
                String engName = jsonObject.getString("engName");
                String type1 = jsonObject.getString("type1");
                String type2 = jsonObject.getString("type2");
                String ability1 = jsonObject.getString("ability1");
                String ability2 = jsonObject.getString("ability2");
                String ability3 = jsonObject.getString("ability3");
                String hp = jsonObject.getString("hp");
                String atk = jsonObject.getString("atk");
                String def = jsonObject.getString("def");
                String satk = jsonObject.getString("satk");
                String sdef = jsonObject.getString("sdef");
                String speed = jsonObject.getString("speed");
                String profile = jsonObject.getString("profile");
                String link = jsonObject.getString("link");
                //写入Pokemon表
                values.put("pid",pid);
                values.put("zhName",zhName);
                values.put("engName",engName);
                values.put("type1",type1);
                values.put("type2",type2);
                db.insert("Pokemon",null,values);
                values.clear();
                //写入Data表
                values.put("did",pid);
                values.put("ability1",ability1);
                values.put("ability2",ability2);
                values.put("ability3",ability3);
                values.put("hp",hp);
                values.put("atk",atk);
                values.put("def",def);
                values.put("satk",satk);
                values.put("sdef",sdef);
                values.put("speed",speed);
                db.insert("Data",null,values);
                values.clear();
                //写入Profile表
                values.put("prid",pid);
                values.put("profile",profile);
                values.put("link",link);
                db.insert("Profile",null,values);
                values.clear();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            String EvolveLine = InputPokemonData.EvolveLine;
            JSONArray jsonArray=new JSONArray(EvolveLine);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject=jsonArray.getJSONObject(i);
                String eid = jsonObject.getString("eid");
                String etype1 = jsonObject.getString("etype1");
                String etype2 = jsonObject.getString("etype2");
                String etype3 = jsonObject.getString("etype3");
                //写入EvolveLine表
                values.put("eid",eid);
                values.put("etype1",etype1);
                values.put("etype2",etype2);
                values.put("etype3",etype3);
                db.insert("EvolveLine",null,values);
                values.clear();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    String key = "";
    public void ReadData(){
        Cursor cursor=db.query("EvolveLine",null,null,null,null,null,null);
        if(cursor.moveToFirst()){

            // key = key + "No."+cursor.getString(cursor.getColumnIndex("did"))+"\n";
            // key = key + "特性1："+cursor.getString(cursor.getColumnIndex("ability1"))+"\n";
            // key = key + "特性2："+cursor.getString(cursor.getColumnIndex("ability2"))+"\n";
            // key = key + "梦特性："+cursor.getString(cursor.getColumnIndex("ability3"))+"\n";
            // key = key + "体力:"+cursor.getString(cursor.getColumnIndex("hp"))+"\n";
            // key = key + "攻击:"+cursor.getString(cursor.getColumnIndex("atk"))+"\n";
            // key = key + "防御:"+cursor.getString(cursor.getColumnIndex("def"))+"\n";
            // key = key + "特攻:"+cursor.getString(cursor.getColumnIndex("satk"))+"\n";
            // key = key + "特防:"+cursor.getString(cursor.getColumnIndex("sdef"))+"\n";
            // key = key + "速度:"+cursor.getString(cursor.getColumnIndex("speed"))+"\n";

            key = key + "EType1:"+cursor.getString(cursor.getColumnIndex("etype1"))+"\n";
            key = key + "EType2:"+cursor.getString(cursor.getColumnIndex("etype2"))+"\n";
            key = key + "EType3:"+cursor.getString(cursor.getColumnIndex("etype3"))+"\n";
        }
        cursor.close();
    }

//    private Long addImageContent(ContentData contentData) {
//        ContentValues values = new ContentValues();
//        values.put("username", contentData.getUsername());
//        values.put("content", contentData.getContent());
//        values.put("type", contentData.getType());
//        Long id = db.insert("friend_content", null, values);
//        for (ImageData data : contentData.getImageDatas()) {
//            ContentValues values2 = new ContentValues();
//            values2.put("resourceId", R.drawable.header);
//            values2.put("name", data.getName());
//            values2.put("url", data.getUrl());
//            values2.put("contentid", id);
//            db.insert("friend_images", null, values2);
//        }
//        return id;
//    }

//    public int getType() {
//        return type;
//    }


}