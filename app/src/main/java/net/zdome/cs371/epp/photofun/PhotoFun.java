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
        grayFilterButton.setOnClickListener(new filterButtonListener());
        Button brightnessFilterButton = (Button) findViewById(R.id.brightnessFilterButton);
        brightnessFilterButton.setOnClickListener(new filterButtonListener());
    }

    private class filterButtonListener implements View.OnClickListener {
        public void onClick(View button) {
            Filter filter = new Filter(PhotoFun.this);
            filter.apply();
        }
    }
}

