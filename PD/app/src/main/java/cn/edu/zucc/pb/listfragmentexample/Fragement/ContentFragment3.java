package cn.edu.zucc.pb.listfragmentexample.Fragement;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cn.edu.zucc.pb.listfragmentexample.Item.ItemDetail;
import cn.edu.zucc.pb.listfragmentexample.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContentFragment3 extends Fragment {
    ItemDetail itemDetail;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ItemDetailFragment itemDetailFragment = new ItemDetailFragment();
        itemDetail = itemDetailFragment.Re();
        View v3 = inflater.inflate(R.layout.frament_content3, container, false);
        TextView Profile = (TextView)v3.findViewById(R.id.profile);
        String value = itemDetail.getProfile();
        Profile.setText(value);
        return v3;
    }


}
