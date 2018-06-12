package com.shrinvi.example.databinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;

/**
 * A class (usually a model class) that gets bound to UI. this class will have properties/fields
 * whose values are shown on the UI.hence it is called Observable class in Observer design pattern.
 * The Android binder observes this class objects for any state change and updates the UI accordingly.
 */
public class KemperatureData extends BaseObservable {
    private String celsius;
    private String location;

    public KemperatureData(String celsius, String location) {
        this.celsius = celsius;
        this.location = location;
    }

    @Bindable
    public String getCelsius() {
        return celsius;
    }

    public void setCelsius(String celsius) {
        this.celsius = celsius;
        notifyPropertyChanged(BR.celsius);
    }

    @Bindable
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
        notifyPropertyChanged(BR.location);
    }

    @Bindable
    public View.OnClickListener getOnClickListener() {
        return onClickListener;
    }

    public View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            System.out.println("clicked");
        }
    };

}