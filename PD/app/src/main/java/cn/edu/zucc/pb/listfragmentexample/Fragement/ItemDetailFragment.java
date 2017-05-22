package cn.edu.zucc.pb.listfragmentexample.Fragement;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.UUID;

import cn.edu.zucc.pb.listfragmentexample.DB.ItemProvider;
import cn.edu.zucc.pb.listfragmentexample.Item.Item;
import cn.edu.zucc.pb.listfragmentexample.Item.ItemDetail;
import cn.edu.zucc.pb.listfragmentexample.Other.Change;
import cn.edu.zucc.pb.listfragmentexample.R;


public class ItemDetailFragment extends Fragment {
    public static final String EXTRA_ID = "cn.edu.zucc.pb.item_id";
    private static final int RESULT_DATE = 0;
    Item item;
    static ItemDetail itemDetail;
    TextView mTitleField;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID id = (UUID)getArguments().getSerializable(EXTRA_ID);
        item = ItemProvider.get(getActivity()).getItem(id);
        itemDetail =  ItemProvider.get(getActivity()).getItems(item.getid());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_item_detail, parent, false);
        mTitleField = (TextView)v.findViewById(R.id.chname);
        String zhname = itemDetail.getZhName();
        mTitleField.setText(zhname);

        TextView EngName = (TextView)v.findViewById(R.id.jpname);
        String engName = itemDetail.getEngName();
        EngName.setText(engName);

        Button Shuxing1 = (Button)v.findViewById(R.id.shuxing1);
        String shuxing1 = itemDetail.getshux();
        Shuxing1.setText(shuxing1);

        Button Shuxing2 = (Button)v.findViewById(R.id.shuxing2);
        String shuxing2 = itemDetail.getshux2();
        Shuxing2.setText(shuxing2);

        ImageButton imageButton  =(ImageButton)v.findViewById(R.id.cwimg);
        imageButton.setBackgroundResource(itemDetail.getImg());

        TextView Pid = (TextView)v.findViewById(R.id.pid);
        String pid = "NO."+itemDetail.getid();
        Pid.setText(pid);

        Change change = new Change();
        if(shuxing2.equals("无")){
            Shuxing2.setVisibility(View.INVISIBLE);
        }
        Shuxing1.setBackgroundResource(change.changeback(shuxing1));
        Shuxing2.setBackgroundResource(change.changeback(shuxing2));


        mTitleField.addTextChangedListener(new TextWatcher() {
            public void onTextChanged(CharSequence c, int start, int before, int count) {
                item.setName(c.toString());
            }

            public void beforeTextChanged(CharSequence c, int start, int count, int after) {
                // this space intentionally left blank
            }

            public void afterTextChanged(Editable c) {
                // this one too
            }
        });

//        mDateButton = (Button)v.findViewById(R.id.item_date);
//        mDateButton.setText(item.getDate().toString());
        //mDateButton.setEnabled(false);
//        mDateButton.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                FragmentManager fragmentManager = getActivity().getFragmentManager();
//                DatePickerFragment dialogFragment = DatePickerFragment.newInstance(item.getDate());
//                dialogFragment.setTargetFragment(ItemDetailFragment.this, RESULT_DATE);
//                dialogFragment.show(fragmentManager, "selectDateDialog");
//            }
//        });


//        mSolvedCheckBox = (CheckBox)v.findViewById(R.id.item_solved);
//        mSolvedCheckBox.setChecked(item.isSolved());
//        mSolvedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                // set the crime's solved property
//                item.setSolved(isChecked);
//            }
//        });

         return v;
    }

    public ItemDetail Re(){
        return  itemDetail;
    }
    public static ItemDetailFragment newInstance(UUID itemid) {
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_ID, itemid);

        ItemDetailFragment fragment = new ItemDetailFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode != Activity.RESULT_OK){
            return;
        }

    }
}
