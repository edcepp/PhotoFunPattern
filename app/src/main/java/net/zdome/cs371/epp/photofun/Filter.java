package net.zdome.cs371.epp.photofun;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.Color;
import android.widget.ImageView;


/**
 * Created by eepp on 2/8/17.
 */

public class Filter {

    Activity rootActivity;

    Filter(Activity a) {
        rootActivity = a;
    }

    private int constrain(int color) {
        if (color > 255)
            return 255;
        else if (color < 0)
            return 0;
        else
            return color;
    }

    public Bitmap createTransform(Bitmap inBmp) {
        int width = inBmp.getWidth();
        int height = inBmp.getHeight();
        Bitmap outBmp = Bitmap.createBitmap(width, height, inBmp.getConfig());

        for (int w = 0; w < width; w++) {
            for (int h = 0; h < height; h++) {
                int pixel = inBmp.getPixel(w, h);
                int intensity = (Color.red(pixel) + Color.green(pixel) + Color.blue(pixel)) / 3;
                int grayPixel = Color.argb(Color.alpha(pixel), intensity, intensity, intensity);
                outBmp.setPixel(w, h, grayPixel);
            }
        }
        return outBmp;

    }

    public void apply() {

        ImageView originalImageView = (ImageView) rootActivity.findViewById(R.id.originalImage);
        BitmapDrawable originalDrawableBmp = (BitmapDrawable) originalImageView.getDrawable();
        Bitmap originalBmp = originalDrawableBmp.getBitmap();

        Bitmap newBmp = createTransform(originalBmp);
        ImageView newImageView = (ImageView) rootActivity.findViewById(R.id.newImage);
        newImageView.setImageBitmap(newBmp);

    }


}
