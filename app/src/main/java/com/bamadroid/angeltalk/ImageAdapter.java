package com.bamadroid.angeltalk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.io.File;

/**
 * Created by ray on 12/4/2015.
 */
public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    File[] images;
    File[] files;

    public ImageAdapter(Context c, int folderID) {
        mContext = c;

        File dir = new File(Environment.getExternalStorageDirectory() + "/images");
        files = dir.listFiles();
        images = files[folderID].listFiles();
    }

    public int getCount() {
        return images.length;
    }

    public Object getItem(int position) {

        return images[position].getAbsolutePath();
    }

    public long getItemId(int position) {
        return position;
    }

    public String getAlbumName(int folderID) {
        return files[folderID].getName();
    }
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView imageView;
        Bitmap bm = BitmapFactory
                .decodeFile(images[position].getAbsolutePath());
        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(100, 100));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setPadding(5, 10, 5, 10);
        } else {
            imageView = (ImageView) convertView;
        }
        //imageView.setImageBitmap(bm.decodeFile(images[position].getAbsoluteFile()));
        return imageView;
    }

    // create a new ImageView for each item referenced by the Adapter
//    public View getView(int position, View convertView, ViewGroup parent) {
//        ImageView imageView;
//        if (convertView == null) {  // if it's not recycled, initialize some attributes
//            imageView = new ImageView(mContext);
//            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
//            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//            imageView.setPadding(8, 8, 8, 8);
//        } else {
//            imageView = (ImageView) convertView;
//        }
//
//        imageView.setImageResource(mThumbIds[position]);
//        return imageView;
//    }

    // references to our images
//    private Integer[] mThumbIds = {
//            R.drawable.cat,
//            R.drawable.girl,
//            R.drawable.star,
//            R.drawable.wolf
//    };
}