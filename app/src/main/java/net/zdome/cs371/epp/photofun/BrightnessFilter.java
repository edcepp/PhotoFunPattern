package net.zdome.cs371.epp.photofun;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;

/**
 * Created by eepp on 2/10/17.
 */


public class BrightnessFilter extends PhotoFilter {

    final int adjustment = 100;

    BrightnessFilter(Activity a) {
        super(a);
    }

    public int transformPixel(int inPixel) {
        int red = constrain(Color.red(inPixel) + adjustment);
        int green = constrain(Color.green(inPixel) + adjustment);
        int blue = constrain(Color.blue(inPixel) + adjustment);
        return Color.argb(Color.alpha(inPixel), red, green, blue);
    }

}
