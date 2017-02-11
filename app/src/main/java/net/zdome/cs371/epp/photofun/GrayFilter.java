package net.zdome.cs371.epp.photofun;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.Color;
import android.widget.ImageView;

/**
 * Created by eepp on 2/10/17.
 */


public class GrayFilter extends PhotoFilter {

    GrayFilter(Activity a) {
        super(a);
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
}
