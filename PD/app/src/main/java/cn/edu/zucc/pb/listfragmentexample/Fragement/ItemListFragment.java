package cn.edu.zucc.pb.listfragmentexample.Fragement;

import android.app.ListFragment;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import cn.edu.zucc.pb.listfragmentexample.DB.DBHelper;
import cn.edu.zucc.pb.listfragmentexample.DB.DBManager;
import cn.edu.zucc.pb.listfragmentexample.DB.ItemProvider;
import cn.edu.zucc.pb.listfragmentexample.Item.Item;
import cn.edu.zucc.pb.listfragmentexample.ItemDetailActivity;
import cn.edu.zucc.pb.listfragmentexample.Other.Change;
import cn.edu.zucc.pb.listfragmentexample.R;

/**
 * Created by Administrator on 2015-07-14.
 */
public class ItemListFragment extends ListFragment {
    private ArrayList<Item> items;
    private DBManager dbManager;
    private DBHelper dbHelper;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getActivity().setTitle(R.string.itemlist_title);
        items = ItemProvider.gets(getActivity()).getItems();
        ItemAdapter adapter = new ItemAdapter(items);
        setListAdapter(adapter);
    }
    public void search(View view){
        EditText editText = (EditText) view.findViewById(R.id.list_search);
        String search=editText.getText().toString();
        if(search.isEmpty()){

        }else{
//           搜索包含搜索内容项
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Item c = (Item)(getListAdapter()).getItem(position);
        Intent i = new Intent(getActivity(), ItemDetailActivity.class);
        i.putExtra(ContentFragment1.EXTRA_ID, c.getId());
        i.putExtra(ItemDetailFragment.EXTRA_ID, c.getId());
        startActivity(i);
    }

    private class ItemAdapter extends ArrayAdapter<Item> {
        public ItemAdapter(ArrayList<Item> list) {
            super(getActivity(), android.R.layout.activity_list_item, list);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // if we weren't given a view, inflate one
            if (null == convertView) {
                convertView = getActivity().getLayoutInflater()
                        .inflate(R.layout.list_item, null);
            }

            // configure the view for this Item
            Item c = getItem(position);

            if(position==0){
                EditText ed = ( EditText)convertView.findViewById(R.id.list_search);
                Button bt = ( Button) convertView.findViewById(R.id.botton_search);
                TextView titleTextView = (TextView)convertView.findViewById(R.id.name);
                TextView dateTextView = (TextView)convertView.findViewById(R.id.pkid);
                TextView shuxTextView = (TextView)convertView.findViewById(R.id.shux);
                TextView shux2TextView = (TextView)convertView.findViewById(R.id.shux1);
                ImageView imageView  =(ImageView)convertView.findViewById(R.id.img);
                if (c.getshux2().equals("无")){
                    shux2TextView.setVisibility(View.INVISIBLE);
                }
                else{
                    shux2TextView.setVisibility(View.VISIBLE);
                }
                ed.setVisibility(View.VISIBLE);
                bt.setVisibility(View.VISIBLE);
                titleTextView.setVisibility(View.GONE);
                dateTextView.setVisibility(View.GONE);
                shuxTextView.setVisibility(View.GONE);
                shux2TextView.setVisibility(View.GONE);
                imageView.setVisibility(View.GONE);

            }
            else {
                EditText ed = ( EditText)convertView.findViewById(R.id.list_search);
                Button bt = ( Button) convertView.findViewById(R.id.botton_search);
                ed.setVisibility(View.GONE);
                bt.setVisibility(View.GONE);
                TextView titleTextView = (TextView)convertView.findViewById(R.id.name);
                TextView dateTextView = (TextView)convertView.findViewById(R.id.pkid);
                TextView shuxTextView = (TextView)convertView.findViewById(R.id.shux);
                TextView shux2TextView = (TextView)convertView.findViewById(R.id.shux1);
                ImageView imageView  =(ImageView)convertView.findViewById(R.id.img);
                titleTextView.setVisibility(View.VISIBLE);
                dateTextView.setVisibility(View.VISIBLE);
                shuxTextView.setVisibility(View.VISIBLE);
                shux2TextView.setVisibility(View.VISIBLE);
                imageView.setVisibility(View.VISIBLE);
                if (c.getshux2().equals("无")){
                    shux2TextView.setVisibility(View.INVISIBLE);
                }
                else{
                    shux2TextView.setVisibility(View.VISIBLE);
                }

                titleTextView = (TextView)convertView.findViewById(R.id.name);
                titleTextView.setText(c.getName());

                 dateTextView = (TextView)convertView.findViewById(R.id.pkid);
                dateTextView.setText(c.getid());

                 shuxTextView = (TextView)convertView.findViewById(R.id.shux);
//            shuxTextView.setText(c.getshux());
//
                 shux2TextView = (TextView)convertView.findViewById(R.id.shux1);
//            shux2TextView.setText(c.getshux2());

                ImageView img = (ImageView)convertView.findViewById(R.id.img);
                int w=Integer.parseInt(c.getid());
                img.setBackgroundResource(R.drawable.p001+w-1);
//            img.setBackground(getResources().getDrawable(R.drawable.p001+w-1));
                Change change = new Change();
                shuxTextView.setBackgroundResource(change.changeback(c.getshux()));
                shux2TextView.setBackgroundResource(change.changeback(c.getshux2()));
            }

            return convertView;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        ((ItemAdapter)getListAdapter()).notifyDataSetChanged();
    }

}
