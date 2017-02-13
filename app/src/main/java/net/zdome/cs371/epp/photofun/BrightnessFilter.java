package net.zdome.cs371.epp.photofun;

import android.graphics.Color;


public class BrightnessFilter extends PhotoFilter {

    private final int ADJUSTMENT = 100;

    public int transformPixel(int inPixel) {
        int red = constrain(Color.red(inPixel) + ADJUSTMENT);
        int green = constrain(Color.green(inPixel) + ADJUSTMENT);
        int blue = constrain(Color.blue(inPixel) + ADJUSTMENT);
        return Color.argb(Color.alpha(inPixel), red, green, blue);
    }

}
