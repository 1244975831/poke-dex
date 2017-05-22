package cn.edu.zucc.pb.listfragmentexample;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import cn.edu.zucc.pb.listfragmentexample.DB.DBManager;
import cn.edu.zucc.pb.listfragmentexample.Fragement.ItemListFragment;
import cn.edu.zucc.pb.listfragmentexample.Item.Item;
import cn.edu.zucc.pb.listfragmentexample.Item.ItemDetail;

/**
 * Created by Administrator on 2015-07-14.
 */
public class MainActivity extends Activity {
    public static final String Search = "cn.edu.zucc.pb.search";
    private DBManager dbManager;
    static  ArrayList<Item> data = new ArrayList<>();
    static ArrayList<ItemDetail> datas = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String value=null;
        dbManager = new DBManager(getBaseContext());
            dbManager.initData();
//        dbManager.ReadData();
        Intent intent = getIntent();
        value = intent.getStringExtra("value");
        datas.clear();
        datas.addAll(dbManager.getitems());
        data.clear();
        data.addAll(dbManager.getitem(value));
        data.size();
        ret();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        FragmentManager fm = getFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);

        if (fragment == null) {
            fragment = new ItemListFragment();
            fm.beginTransaction()
                    .replace(R.id.fragmentContainer, fragment)
                    .commit();
        }
    }
    public ArrayList<Item>  ret(){
//        dbManager.add();
        return data;
    }
    public ArrayList<ItemDetail>  rets(){
//        dbManager.add();
        return datas;
    }
    public void search(View view){
        Button bt = (Button)findViewById(R.id.botton_search);
        EditText ed = (EditText)findViewById(R.id.list_search) ;
        ed.clearFocus();
        Editable c=  ed.getText();

        String value = c.toString();
        if(value.equals("")){
            value=null;
        }
        Intent i = new Intent( MainActivity.this,MainActivity.class);
        i.putExtra("value",value);
        startActivity(i);
    }

    public void ed(View view){
        EditText ed = (EditText)findViewById(R.id.list_search) ;
        ed.setFocusable(true);
        ed.setFocusableInTouchMode(true);
        ed.requestFocus();
    }
}
