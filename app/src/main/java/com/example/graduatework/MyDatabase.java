package com.example.graduatework;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MyDatabase extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "museum.db";
    public static final String TABLE_NAME = "Exhibit";

    public static final String KEY_ID = "Number";
    public static final String KEY_FullNameExhibit = "FullNameExhibit";
    public static final String KEY_Country = "Country";
    public static final String KEY_Year = "Year";
    public static final String KEY_Size = "Size";
    public static final String KEY_Material = "Material";
    public static final String KEY_Description = "Description";
    public static final String KEY_PngExhibit = "PngExhibit";

    public MyDatabase(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        copyDatabaseIfNeeded(context);

    }

    private void copyDatabaseIfNeeded(Context context) {
        File dbFile = context.getDatabasePath(DATABASE_NAME);
        if (!dbFile.exists()) {
            dbFile.getParentFile().mkdirs();
            try (InputStream is = context.getAssets().open(DATABASE_NAME);
                 OutputStream os = new FileOutputStream(dbFile)) {
                byte[] buffer = new byte[1024];
                int length;
                while ((length = is.read(buffer)) > 0) {
                    os.write(buffer, 0, length);
                }
                os.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onCreate(SQLiteDatabase sqLitedatabase){

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLitedatabase, int oldVersion, int newVersion){

    }

    public Cursor getExhibitById(String exhibitId) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM Exhibit WHERE Number = ?", new String[]{exhibitId});
    }

}
