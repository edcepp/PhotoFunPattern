package net.zdome.cs371.epp.photofun;

import android.graphics.Bitmap;


/**
 * Created by eepp on 2/8/17.
 */

public abstract class PhotoFilter {

    protected int constrain(int color) {
        if (color > 255)
            return 255;
        else if (color < 0)
            return 0;
        else
            return color;
    }

    protected int transformPixel (int inPixel){
        return inPixel;
    }

    public Bitmap apply(Bitmap inBmp) {
        int width = inBmp.getWidth();
        int height = inBmp.getHeight();

        Bitmap newBmp = Bitmap.createBitmap(width, height, inBmp.getConfig());

        for (int w = 0; w < width; w++) {
            for (int h = 0; h < height; h++) {
                int outPixel = transformPixel(inBmp.getPixel(w, h));
                newBmp.setPixel(w, h, outPixel);
            }
        }
        return newBmp;
    }
}
