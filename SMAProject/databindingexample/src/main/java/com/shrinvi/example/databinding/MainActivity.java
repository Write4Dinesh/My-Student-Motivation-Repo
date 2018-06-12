package com.shrinvi.example.databinding;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.shrinvi.example.databinding.databinding.DinSample;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // generates a class that maps to R.layout.activity_temp
        DinSample binding = DataBindingUtil.setContentView(this, R.layout.activity_hello);
        KemperatureData kemperatureData = new KemperatureData("12", "bangalore");
        binding.setDin(kemperatureData);//pass an observable class object whose state change & hence should be listened to.

    }

    @BindingAdapter("android:onClick")
    public static void setOnClickListener(View view, View.OnLayoutChangeListener oldValue,
                                          View.OnLayoutChangeListener newValue) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            if (oldValue != null) {
                view.removeOnLayoutChangeListener(oldValue);
            }
            if (newValue != null) {
                view.addOnLayoutChangeListener(newValue);
            }
        }
    }
}
