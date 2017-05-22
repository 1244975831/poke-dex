package cn.edu.zucc.pb.listfragmentexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

public class HelloActivity extends AppCompatActivity {
    ImageView welcomeImg;
    static int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);
        ImageView welcomeImg = (ImageView) this.findViewById(R.id.welcome);
        AlphaAnimation anima = new AlphaAnimation(0.3f, 1.0f);
        anima.setDuration(2000);// 设置动画显示时间
        welcomeImg.startAnimation(anima);
        if (i%2==0) {
            welcomeImg.setBackgroundResource(R.drawable.sun);
        }
        else {
            welcomeImg.setBackgroundResource(R.drawable.moon);
        }
        anima.setAnimationListener(new AnimationImpl());
    }

    private class AnimationImpl implements Animation.AnimationListener {

        @Override
        public void onAnimationStart(Animation animation) {
//           welcomeImg.setBackgroundResource(R.drawable.welcome);
        }

        @Override
        public void onAnimationEnd(Animation animation) {
            skip(); // 动画结束后跳转到别的页面
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }

    }

    private void skip() {
        if(i%2==0){
            startActivity(new Intent(this, HelloActivity.class));
            finish();
            i++;
        }else {
            startActivity(new Intent(this, CatalogActivity.class));
            finish();
        }
    }


}
