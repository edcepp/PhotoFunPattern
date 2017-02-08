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

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int p = originalBmp.getPixel(i, j);
            }
        }

        Bitmap newBmp = Bitmap.createBitmap(width,height,originalBmp.getConfig());
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                //newBmp.setPixel(i, j, Color.BLACK);
                newBmp.setPixel(i, j, 0xff000000);
            }
        }
        newImageView = (ImageView) findViewById(R.id.newImage);
        newImageView.setImageBitmap(newBmp);

    }
}

