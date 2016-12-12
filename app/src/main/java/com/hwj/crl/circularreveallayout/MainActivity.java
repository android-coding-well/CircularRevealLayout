package com.hwj.crl.circularreveallayout;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hwj.crl.circularreveallayout.databinding.ActivityMainBinding;
import com.junmeng.crl.ViewAnimationCompatUtils;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);

    }

    public void onClickStart(View view) {
        ViewAnimationCompatUtils.createCircularReveal(
                binding.rlImg,
                binding.rlImg.getWidth()/2,
                binding.rlImg.getHeight()/2,
                0,1000
        ).setDuration(1000).start();
    }
}
