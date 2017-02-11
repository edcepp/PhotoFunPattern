package net.zdome.cs371.epp.photofun;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;

/**
 * Created by eepp on 2/10/17.
 */


public class BrightnessFilter extends PhotoFilter {

    BrightnessFilter(Activity a) {
        super(a);
    }

    public Bitmap createTransform(Bitmap inBmp) {
        int width = inBmp.getWidth();
        int height = inBmp.getHeight();
        Bitmap outBmp = Bitmap.createBitmap(width, height, inBmp.getConfig());
        int adjustment = 100;

        for (int w = 0; w < width; w++) {
            for (int h = 0; h < height; h++) {
                int inPixel = inBmp.getPixel(w, h);
                int red   = super.constrain(Color.red(inPixel) + adjustment);
                int green = super.constrain(Color.green(inPixel) + adjustment);
                int blue  = super.constrain(Color.blue(inPixel) + adjustment);
                int outPixel = Color.argb(Color.alpha(inPixel), red, green, blue);
                outBmp.setPixel(w, h, outPixel);
            }
        }
        return outBmp;
    }
}
