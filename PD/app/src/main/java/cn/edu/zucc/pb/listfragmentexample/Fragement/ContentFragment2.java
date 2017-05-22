package cn.edu.zucc.pb.listfragmentexample.Fragement;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import cn.edu.zucc.pb.listfragmentexample.Item.ItemDetail;
import cn.edu.zucc.pb.listfragmentexample.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContentFragment2 extends Fragment {
    ItemDetail itemDetail;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ItemDetailFragment itemDetailFragment = new ItemDetailFragment();
        itemDetail = itemDetailFragment.Re();
        View v2 = inflater.inflate(R.layout.frament_content2, container, false);
        TextView ability1 = (TextView)v2.findViewById(R.id.type1);
        String value = itemDetail.getType1();
        ability1.setText(value);
        TextView ability2 = (TextView)v2.findViewById(R.id.type2);
        ability2.setText(itemDetail.getType2());
        TextView ability2s = (TextView)v2.findViewById(R.id.type2s);
        ability2s.setText(itemDetail.getType2());
        TextView ability3 = (TextView)v2.findViewById(R.id.type3);
        ability3.setText(itemDetail.getType3());
        ImageView to = (ImageView)v2.findViewById(R.id.to);
        if(itemDetail.getType3().equals("无")){
            ability2s.setVisibility(View.GONE);
            ability3.setVisibility(View.GONE);
            to.setVisibility(View.GONE);
        }
        return v2;
    }


}
