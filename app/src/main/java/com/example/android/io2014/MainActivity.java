package com.example.android.io2014;

import android.annotation.TargetApi;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

import com.example.android.io2014.ui.Utils;
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.ViewPropertyAnimator;

public class MainActivity extends ActionBarActivity {

    // Bitmaps will only be decoded once and stored in this cache
    public static SparseArray<Bitmap> sPhotoCache = new SparseArray<Bitmap>(4);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Used to get the dimensions of the image views to load scaled down bitmaps
        final View parent = findViewById(R.id.parent);
        parent.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                Utils.removeOnGlobalLayoutListenerCompat(parent, this);
                setImageBitmap((ImageView) findViewById(R.id.card_photo_1).findViewById(R.id.photo), R.drawable.photo1);
                setImageBitmap((ImageView) findViewById(R.id.card_photo_2).findViewById(R.id.photo), R.drawable.photo2);
                setImageBitmap((ImageView) findViewById(R.id.card_photo_3).findViewById(R.id.photo), R.drawable.photo3);
                setImageBitmap((ImageView) findViewById(R.id.card_photo_4).findViewById(R.id.photo), R.drawable.photo4);
                setImageBitmap((ImageView) findViewById(R.id.card_photo_5).findViewById(R.id.photo), R.drawable.photo5);
                setImageBitmap((ImageView) findViewById(R.id.card_photo_6).findViewById(R.id.photo), R.drawable.photo6);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!Utils.hasLollipop()) {
            // The activity transition animates the clicked image alpha to zero, reset that value when
            // you come back to this activity
            ViewHelper.setAlpha(findViewById(R.id.card_photo_1), 1.0f);
            ViewHelper.setAlpha(findViewById(R.id.card_photo_2), 1.0f);
            ViewHelper.setAlpha(findViewById(R.id.card_photo_3), 1.0f);
            ViewHelper.setAlpha(findViewById(R.id.card_photo_4), 1.0f);
            ViewHelper.setAlpha(findViewById(R.id.card_photo_5), 1.0f);
            ViewHelper.setAlpha(findViewById(R.id.card_photo_6), 1.0f);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent=new Intent(this,About.class);
           startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
       // Intent intent=new Intent(this, ABout.class);
       // startActivity(intent);
        return true;
    }
    /**
     * Loads drawables into the given image view efficiently. Uses the method described
     * <a href="http://developer.android.com/training/displaying-bitmaps/load-bitmap.html">here.</a>
     *
     * @param imageView
     * @param resId     Resource identifier of the drawable to load from memory
     */
    private void setImageBitmap(ImageView imageView, int resId) {
        Bitmap bitmap = Utils.decodeSampledBitmapFromResource(getResources(),
                resId, imageView.getMeasuredWidth(), imageView.getMeasuredHeight());
        sPhotoCache.put(resId, bitmap);
        imageView.setImageBitmap(bitmap);
    }

    /**
     * When the user clicks a thumbnail, bundle up information about it and launch the
     * details activity.
     */
    @SuppressWarnings("UnusedDeclaration")
    public void showPhoto(View view) {
        Intent intent = new Intent();
        intent.setClass(this, DetailActivity.class);

        // Interesting data to pass across are the thumbnail location, the map parameters,
        // the picture title & description, and the key to retrieve the bitmap from the cache
        int resId = 0;
        switch (view.getId()) {
            case R.id.show_photo_1:
                intent.putExtra("lat", 37.6329946)
                        .putExtra("lng", -122.4938344)
                        .putExtra("zoom", 14.0f)
                        .putExtra("title", "Facebook Developer AI masterclass")
                        .putExtra("description", getResources().getText(R.string.lorem))
                        .putExtra("photo", R.drawable.photo1);
                resId = R.id.card_photo_1;
                break;

            case R.id.show_photo_2:
                intent.putExtra("lat", 37.73284)
                        .putExtra("lng", -122.503065)
                        .putExtra("zoom", 15.0f)
                        .putExtra("title", "YoungActs Hackathon ")

                        .putExtra("description", getResources().getText(R.string.lorem2))
                        .putExtra("photo", R.drawable.photo2);
                resId = R.id.card_photo_2;
                break;

            case R.id.show_photo_3:
                intent.putExtra("lat", 37.73284)
                        .putExtra("lng", -122.503065)
                        .putExtra("zoom", 15.0f)
                        .putExtra("title", "Geekulcha Hackathon ")

                        .putExtra("description", getResources().getText(R.string.lorem2))
                        .putExtra("photo", R.drawable.photo3);
                resId = R.id.card_photo_3;
                break;
            case R.id.show_photo_4:
                intent.putExtra("lat", 37.73284)
                        .putExtra("lng", -122.503065)
                        .putExtra("zoom", 15.0f)
                        .putExtra("title", "Google cloud onboard ")

                        .putExtra("description", getResources().getText(R.string.lorem4))
                        .putExtra("photo", R.drawable.photo4);
                resId = R.id.card_photo_4;
                break;



            case R.id.show_photo_5:
                intent.putExtra("lat", 37.73284)
                        .putExtra("lng", -122.503065)
                        .putExtra("zoom", 15.0f)
                        .putExtra("title", "Science Forum South Africa ")

                        .putExtra("description", getResources().getText(R.string.lorem5))
                        .putExtra("photo", R.drawable.photo5);
                resId = R.id.card_photo_4;
                break;


            case R.id.show_photo_6:
                intent.putExtra("lat", 37.73284)
                        .putExtra("lng", -122.503065)
                        .putExtra("zoom", 15.0f)
                        .putExtra("title", "DSIDE Project Presentations ")

                        .putExtra("description", getResources().getText(R.string.lorem6))
                        .putExtra("photo", R.drawable.photo6);
                resId = R.id.card_photo_6;
                break;

        }

        if (Utils.hasLollipop()) {
            startActivityLollipop(view, intent);
        } else {
            startActivityGingerBread(view, intent, resId);
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void startActivityLollipop(View view, Intent intent) {
        intent.setClass(this, DetailActivityL.class);
        ImageView hero = (ImageView) ((View) view.getParent()).findViewById(R.id.photo);
        ((ViewGroup) hero.getParent()).setTransitionGroup(false);

        sPhotoCache.put(intent.getIntExtra("photo", -1),
                ((BitmapDrawable) hero.getDrawable()).getBitmap());

        ActivityOptions options =
                ActivityOptions.makeSceneTransitionAnimation(this, hero, "photo_hero");
        startActivity(intent, options.toBundle());
    }


    private void startActivityGingerBread(View view, Intent intent, int resId) {
        int[] screenLocation = new int[2];
        view.getLocationOnScreen(screenLocation);
        intent.
                putExtra("left", screenLocation[0]).
                putExtra("top", screenLocation[1]).
                putExtra("width", view.getWidth()).
                putExtra("height", view.getHeight());

        startActivity(intent);

        // Override transitions: we don't want the normal window animation in addition to our
        // custom one
        overridePendingTransition(0, 0);

        // The detail activity handles the enter and exit animations. Both animations involve a
        // ghost view animating into its final or initial position respectively. Since the detail
        // activity starts translucent, the clicked view needs to be invisible in order for the
        // animation to look correct.
        ViewPropertyAnimator.animate(findViewById(resId)).alpha(0.0f);
    }
}
