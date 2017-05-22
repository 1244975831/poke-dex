package cn.edu.zucc.pb.listfragmentexample.Other;

import android.widget.TextView;

import cn.edu.zucc.pb.listfragmentexample.R;

import static cn.edu.zucc.pb.listfragmentexample.R.drawable.cao;
import static cn.edu.zucc.pb.listfragmentexample.R.drawable.feix;
import static cn.edu.zucc.pb.listfragmentexample.R.drawable.welcome;

/**
 * Created by Administrator on 2016/12/26.
 */

public class Change {
    public Integer changeback(String value){
        Integer res = R.drawable.s1;
        if (value.equals("冰")){
            res= R.drawable.s1;
        }
        else if (value.equals("草")){
            res= R.drawable.s2;
        }
        else if (value.equals("超能力")){
            res= R.drawable.s3;
        }
        else if (value.equals("虫")){
            res= R.drawable.s4;
        }
        else if (value.equals("地面")){
            res= R.drawable.s5;
        }
        else if (value.equals("电")){
            res= R.drawable.s6;
        }
        else if (value.equals("毒")){
            res= R.drawable.s7;
        }
        else if (value.equals("恶")){
            res= R.drawable.s8;
        }
        else if (value.equals("飞行")){
            res= R.drawable.s9;
        }
        else if (value.equals("钢")){
            res= R.drawable.s10;
        }
        else if (value.equals("格斗")){
            res= R.drawable.s11;
        }
        else if (value.equals("火")){
            res= R.drawable.s12;
        }
        else if (value.equals("龙")){
            res= R.drawable.s13;
        }
        else if (value.equals("水")){
            res= R.drawable.s14;
        }
        else if (value.equals("岩石")){
            res= R.drawable.s15;
        }
        else if (value.equals("妖精")){
            res= R.drawable.s16;
        }
        else if (value.equals("一般")){
            res= R.drawable.s17;
        }
        else if (value.equals("幽灵")){
            res= R.drawable.s18;
        }
        return res;
    }
}
