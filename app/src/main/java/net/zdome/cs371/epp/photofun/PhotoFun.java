package net.zdome.cs371.epp.photofun;

import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

public class PhotoFun extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_fun);

        Button grayFilterButton = (Button) findViewById(R.id.grayFilterButton);
        grayFilterButton.setOnClickListener(new grayFilterButtonListener());
        Button brightnessFilterButton = (Button) findViewById(R.id.brightnessFilterButton);
        brightnessFilterButton.setOnClickListener(new brightnessFilterButtonListener());
    }

    private class grayFilterButtonListener implements View.OnClickListener {
        public void onClick(View button) {
            GrayFilter filter = new GrayFilter(PhotoFun.this);
            filter.apply();
        }
    }

    private class brightnessFilterButtonListener implements View.OnClickListener {
        public void onClick(View button) {
            BrightnessFilter filter = new BrightnessFilter(PhotoFun.this);
            filter.apply();
        }
    }
}

