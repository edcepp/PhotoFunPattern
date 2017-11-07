package net.zdome.cs371.epp.photofun;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import android.widget.Button;
import android.view.View;

/**
 *  class PhotoFun controls this photo manipulation app.
 *
 *  @author Edward C. Epp
 *  @version November 2017
 *  https://github.com/edcepp/PhotoFunPattern
 */

public class PhotoFun extends AppCompatActivity {

    // Image resources
    private Bitmap myOriginalBmp;
    private ImageView myNewImageView;

    /*
    * onCreate This construtor creates the app layout, initialezes the original image resouce, and
    * links buttons to their action.
    *
    * @param savedInstanceState Required by parent object
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_fun);

        ImageView originalImageView = (ImageView) findViewById(R.id.originalImage);
        BitmapDrawable originalDrawableBmp = (BitmapDrawable) originalImageView.getDrawable();
        myOriginalBmp = originalDrawableBmp.getBitmap();

        myNewImageView = (ImageView) findViewById(R.id.newImage);

        Button grayFilterButton = (Button) findViewById(R.id.grayFilterButton);
        grayFilterButton.setOnClickListener(new grayFilterButtonListener());
        Button brightnessFilterButton = (Button) findViewById(R.id.brightnessFilterButton);
        brightnessFilterButton.setOnClickListener(new brightnessFilterButtonListener());
    }

    /*
    * class grayFilterButtonListener defines the action for the gray filter button.
    */
    private class grayFilterButtonListener implements View.OnClickListener {
        public void onClick(View button) {
            GrayFilter filter = new GrayFilter();
            myNewImageView.setImageBitmap(filter.apply(myOriginalBmp));
        }
    }

    /*
    * class grayFilterButtonListener defines the action for the brightness filter button.
    */
    private class brightnessFilterButtonListener implements View.OnClickListener {
        public void onClick(View button) {
            BrightnessFilter filter = new BrightnessFilter();
            myNewImageView.setImageBitmap(filter.apply(myOriginalBmp));
        }
    }
}

