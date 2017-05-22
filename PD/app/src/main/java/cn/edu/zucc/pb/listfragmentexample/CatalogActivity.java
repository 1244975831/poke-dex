package cn.edu.zucc.pb.listfragmentexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

public class CatalogActivity extends AppCompatActivity {
    private SeekBar seekBar;
    int Progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Progress=progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                start(Progress);
            }
        });
    }
//    public void clicktujian(View v) {
//
//        Intent intent = new Intent(CatalogActivity.this,MainActivity.class);
//        startActivity(intent);
//    }
    public void start(int progress){
        if(progress>70){
            seekBar.setProgress(10);
            Intent intent1 = new Intent();
            intent1.setClass(CatalogActivity.this,MainActivity.class);
            startActivity(intent1);
        }
        else{
            seekBar.setProgress(10);
        }
    }
}
