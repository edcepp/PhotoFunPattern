package net.zdome.cs371.epp.photofun;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.Color;
import android.widget.ImageView;


/**
 * Created by eepp on 2/8/17.
 */

public class PhotoFilter {

    public Activity rootActivity;

    public PhotoFilter(Activity a) {
        rootActivity = a;
    }

    protected int constrain(int color) {
        if (color > 255)
            return 255;
        else if (color < 0)
            return 0;
        else
            return color;
    }

    public Bitmap createTransform(Bitmap inBmp) {
        return inBmp;
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
