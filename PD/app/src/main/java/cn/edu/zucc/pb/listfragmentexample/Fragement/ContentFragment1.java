package cn.edu.zucc.pb.listfragmentexample.Fragement;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.UUID;

import cn.edu.zucc.pb.listfragmentexample.DB.ItemProvider;
import cn.edu.zucc.pb.listfragmentexample.Item.Item;
import cn.edu.zucc.pb.listfragmentexample.Item.ItemDetail;
import cn.edu.zucc.pb.listfragmentexample.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContentFragment1 extends Fragment {
    public static final String EXTRA_ID = "cn.edu.zucc.pb.item_id";
    Item item;
    ItemDetail itemDetail;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ItemDetailFragment itemDetailFragment = new ItemDetailFragment();
        itemDetail = itemDetailFragment.Re();
        View v2 = inflater.inflate(R.layout.frament_content1, container, false);

        TextView Hp = (TextView)v2.findViewById(R.id.hp);
        String value = itemDetail.getHp();
        Hp.setText(value);
        ProgressBar progressBar1 = (ProgressBar)v2.findViewById(R.id.progressBar1);
        int vs=Integer.valueOf(value);
        progressBar1.setProgress(vs);

        TextView Atk = (TextView)v2.findViewById(R.id.atk);
        value = itemDetail.getAtk();
        Atk.setText(value);
        ProgressBar progressBar2 = (ProgressBar)v2.findViewById(R.id.progressBar2);
        vs=Integer.valueOf(value);
        progressBar2.setProgress(vs);

        TextView Def = (TextView)v2.findViewById(R.id.def);
        value = itemDetail.getDef();
        Def.setText(value);
        ProgressBar progressBar3 = (ProgressBar)v2.findViewById(R.id.progressBar3);
        vs=Integer.valueOf(value);
        progressBar3.setProgress(vs);

        TextView Satk = (TextView)v2.findViewById(R.id.satk);
        value = itemDetail.getSatk();
        Satk.setText(value);
        ProgressBar progressBar4 = (ProgressBar)v2.findViewById(R.id.progressBar4);
        vs=Integer.valueOf(value);
        progressBar4.setProgress(vs);

        TextView Sdef = (TextView)v2.findViewById(R.id.sdef);
        value = itemDetail.getSdef();
        Sdef.setText(value);
        ProgressBar progressBar5 = (ProgressBar)v2.findViewById(R.id.progressBar5);
        vs=Integer.valueOf(value);
        progressBar5.setProgress(vs);

        TextView Speed = (TextView)v2.findViewById(R.id.speed);
        value = itemDetail.getSpeed();
        Speed.setText(value);
        ProgressBar progressBar6 = (ProgressBar)v2.findViewById(R.id.progressBar6);
        vs=Integer.valueOf(value);
        progressBar6.setProgress(vs);

        TextView ability1 = (TextView)v2.findViewById(R.id.ability1);
        value = itemDetail.getAbility1();
        ability1.setText(value);
        TextView ability2 = (TextView)v2.findViewById(R.id.ability2);
        value = itemDetail.getAbility2();
        if (value.equals("无"))
            ability2.setVisibility(View.INVISIBLE);
        ability2.setText(value);
        TextView ability3 = (TextView)v2.findViewById(R.id.ability3);
        value = itemDetail.getAbility3();
        ability3.setText(value);
        return v2;
    }


}
