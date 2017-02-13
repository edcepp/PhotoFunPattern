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

    public int transformPixel(int inPixel) {
        int intensity = (Color.red(inPixel) + Color.green(inPixel) + Color.blue(inPixel)) / 3;
        return Color.argb(Color.alpha(inPixel), intensity, intensity, intensity);
    }

}
