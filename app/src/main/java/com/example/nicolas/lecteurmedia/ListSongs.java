package com.example.nicolas.lecteurmedia;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nicolas on 08/11/2016.
 */

public class ListSongs {

    private List<String> path;
    private List<String> name;

    public ListSongs() {
        path = new ArrayList<String>();
        name = new ArrayList<String>();
    }

    public void selectAllSongs(Context ctx, String criteria, String[] selection) {
        ContentResolver crx = ctx.getContentResolver();
        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        String order = MediaStore.Audio.Media.TITLE + " ASC";
        Cursor cur = crx.query(uri, selection, criteria, null, order);

        while(cur.moveToNext()) {
            path.add(cur.getString(0));
            name.add(cur.getString(1));
        }
    }

    public List<String> getPath() {
        return path;
    }

    public List<String> getName() {
        return name;
    }


}
