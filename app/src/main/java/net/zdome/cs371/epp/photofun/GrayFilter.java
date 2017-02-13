package net.zdome.cs371.epp.photofun;

import android.graphics.Color;

public class GrayFilter extends PhotoFilter {

    public int transformPixel(int inPixel) {
        int intensity = (Color.red(inPixel) + Color.green(inPixel) + Color.blue(inPixel)) / 3;
        return Color.argb(Color.alpha(inPixel), intensity, intensity, intensity);
    }

}
