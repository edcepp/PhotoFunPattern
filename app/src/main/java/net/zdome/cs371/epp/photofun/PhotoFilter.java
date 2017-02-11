package net.zdome.cs371.epp.photofun;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.Color;
import android.widget.ImageView;


/**
 * Created by eepp on 2/8/17.
 */

public abstract class PhotoFilter {

    protected Activity myRootActivity;

    public PhotoFilter(Activity a) {
        myRootActivity = a;
    }

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

    public void apply() {
        ImageView originalImageView = (ImageView) myRootActivity.findViewById(R.id.originalImage);
        BitmapDrawable originalDrawableBmp = (BitmapDrawable) originalImageView.getDrawable();
        Bitmap originalBmp = originalDrawableBmp.getBitmap();
        int width = originalBmp.getWidth();
        int height = originalBmp.getHeight();

        Bitmap newBmp = Bitmap.createBitmap(width, height, originalBmp.getConfig());

        for (int w = 0; w < width; w++) {
            for (int h = 0; h < height; h++) {
                int outPixel = transformPixel(originalBmp.getPixel(w, h));
                newBmp.setPixel(w, h, outPixel);
            }
        }
        ImageView newImageView = (ImageView) myRootActivity.findViewById(R.id.newImage);
        newImageView.setImageBitmap(newBmp);
    }
}
