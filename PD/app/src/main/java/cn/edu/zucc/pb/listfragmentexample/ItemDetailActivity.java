package cn.edu.zucc.pb.listfragmentexample;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import cn.edu.zucc.pb.listfragmentexample.DB.DBManager;
import cn.edu.zucc.pb.listfragmentexample.Fragement.ContentFragment1;
import cn.edu.zucc.pb.listfragmentexample.Fragement.ContentFragment2;
import cn.edu.zucc.pb.listfragmentexample.Fragement.ContentFragment3;
import cn.edu.zucc.pb.listfragmentexample.Fragement.ItemDetailFragment;
import cn.edu.zucc.pb.listfragmentexample.Item.ItemDetail;


public class ItemDetailActivity extends Activity {
    public static final String EXTRA_ID = "cn.edu.zucc.pb.item_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        FragmentManager fm = getFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);
        if (fragment == null) {
            Bundle args = new Bundle();
            args.putSerializable(ItemDetailFragment.EXTRA_ID,
                    getIntent().getSerializableExtra(ItemDetailFragment.EXTRA_ID));
            fragment = new ItemDetailFragment();
            fragment.setArguments(args);
            fm.beginTransaction()
                    .add(R.id.fragmentContainer, fragment)
                    .commit();
        }
       setFragment(new ContentFragment1());
    }
    private void setFragment(Fragment contentFragment) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.content_fragment, contentFragment);
        transaction.commit();

    }
    public void onClick(View v) {
        Button button1 = (Button) findViewById(R.id.btn1);
        Button button2 = (Button) findViewById(R.id.btn2);
        Button button4 = (Button) findViewById(R.id.btn4);
        switch (v.getId()) {
            case R.id.btn1:
                button1.setBackgroundColor(Color.rgb(102,179,255));
                button2.setBackgroundColor(Color.rgb(35,35,142));
                button4.setBackgroundColor(Color.rgb(35,35,142));
                setFragment(new ContentFragment1());
                break;
            case R.id.btn2:
                button2.setBackgroundColor(Color.rgb(102,179,255));
                button1.setBackgroundColor(Color.rgb(35,35,142));
                button4.setBackgroundColor(Color.rgb(35,35,142));
                setFragment(new ContentFragment2());
                break;

            case R.id.btn4:
                button4.setBackgroundColor(Color.rgb(102,179,255));
                button2.setBackgroundColor(Color.rgb(35,35,142));
                button1.setBackgroundColor(Color.rgb(35,35,142));
                setFragment(new ContentFragment3());
                break;

        }
    }
    public void shuxing(View view){
        Button bt = (Button)findViewById(R.id.shuxing1);
        CharSequence c=  bt.getText();
        String value = (String) c;
        DBManager dbManager = new DBManager(getBaseContext());
        dbManager.selectitems(value);
        Intent i = new Intent( ItemDetailActivity.this,MainActivity.class);
        i.putExtra("value",value);
        startActivity(i);
    }
    public void shuxing2(View view){
        Button bt = (Button)findViewById(R.id.shuxing2);
        CharSequence c=  bt.getText();
        String value = (String) c;
        DBManager dbManager = new DBManager(getBaseContext());
        dbManager.selectitems(value);
        Intent i = new Intent( ItemDetailActivity.this,MainActivity.class);
        i.putExtra("value",value);
        startActivity(i);
    }
    public void menu(View view){
        Intent i = new Intent( ItemDetailActivity.this,MainActivity.class);
        startActivity(i);
    }
    public void more(View view){
        ItemDetailFragment itemDetailFragment = new ItemDetailFragment();
        ItemDetail d =itemDetailFragment.Re();
        Intent i = new Intent( ItemDetailActivity.this,WebActivity.class);
        i.putExtra("url",d.getLink());
        startActivity(i);
    }
}
