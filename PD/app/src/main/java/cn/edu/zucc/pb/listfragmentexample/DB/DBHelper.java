package cn.edu.zucc.pb.listfragmentexample.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/12/11.
 */

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "dbdemo.db";
    private static final int DATABASE_VERSION = 4;
    private Context mContext;
    public DBHelper(Context context) {
        //CursorFactory设置为null,使用默认值
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mContext = context;
    }

    //数据库第一次被创建时onCreate会被调用
    @Override
    public void onCreate(SQLiteDatabase db) {
        //Pokemon 中文名 英文名 属性1 属性2
        db.execSQL("CREATE TABLE IF NOT EXISTS Pokemon" +
                "(_id INTEGER PRIMARY KEY AUTOINCREMENT, pid TEXT, zhName TEXT, engName TEXT , type1 TEXT ,type2 TEXT )");
        //Pokemon Data 特性、种族值
        db.execSQL("CREATE TABLE IF NOT EXISTS Data" +
                "(_id INTEGER PRIMARY KEY AUTOINCREMENT, did TEXT, ability1 TEXT, ability2 TEXT , ability3 TEXT ,hp TEXT ,atk TEXT ," +
                " def TEXT ,satk TEXT ,sdef TEXT ,speed TEXT  )");
        //Pokemon EvolveLine 低阶、中阶、高阶
        db.execSQL("CREATE TABLE IF NOT EXISTS EvolveLine" +
                "(_id INTEGER PRIMARY KEY AUTOINCREMENT, eid TEXT, etype1 TEXT, etype2 TEXT , etype3 TEXT  )");
        //Pokemon Profile 图鉴说明
        db.execSQL("CREATE TABLE IF NOT EXISTS Profile" +
                "(_id INTEGER PRIMARY KEY AUTOINCREMENT, prid TEXT, profile TEXT,link TEXT  )");

        db.execSQL("CREATE TABLE IF NOT EXISTS Load" +
                "(flag int  )");

        //创建图片表
//        db.execSQL("CREATE TABLE IF NOT EXISTS friend_images" +
//                "(_id INTEGER PRIMARY KEY AUTOINCREMENT, url VARCHAR,contentid INTEGER,name VARCHAR,resourceId INTEGER)");
//        //创建链接表
//        db.execSQL("CREATE TABLE IF NOT EXISTS friend_links" +
//                "(_id INTEGER PRIMARY KEY AUTOINCREMENT, title VARCHAR,imgurl VARCHAR,url VARCHAR,contentid INTEGER)");


        Toast.makeText(mContext, "success", Toast.LENGTH_SHORT).show();

    }

    //如果DATABASE_VERSION值被改为2,系统发现现有数据库版本不同,即会调用onUpgrade
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }
}