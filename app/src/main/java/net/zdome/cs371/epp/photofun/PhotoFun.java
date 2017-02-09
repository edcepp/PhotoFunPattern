package net.zdome.cs371.epp.photofun;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.graphics.Bitmap;
        import android.graphics.drawable.BitmapDrawable;
        import android.graphics.Color;
        import android.widget.ImageView;

public class PhotoFun extends AppCompatActivity {

    private ImageView originalImageView;
    private ImageView newImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_fun);

        originalImageView = (ImageView) findViewById(R.id.originalImage);
        BitmapDrawable originalDrawableBmp = (BitmapDrawable) originalImageView.getDrawable();
        Bitmap originalBmp = originalDrawableBmp.getBitmap();

        int width = originalBmp.getWidth();
        int height = originalBmp.getHeight();
        Bitmap newBmp = Bitmap.createBitmap(width,height,originalBmp.getConfig());

        for (int w = 0; w < width; w++) {
            for (int h = 0; h < height; h++) {
                int pixel = originalBmp.getPixel(w, h);
                int intensity = (Color.red(pixel) + Color.green(pixel) + Color.blue(pixel)) / 3;
                int grayPixel = Color.argb (Color.alpha(pixel), intensity, intensity, intensity);
                newBmp.setPixel(w, h, grayPixel);
            }
        }

        newImageView = (ImageView) findViewById(R.id.newImage);
        newImageView.setImageBitmap(newBmp);

    }
}

