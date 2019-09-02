package com.app.zagel_;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.Toast;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

public class MyDB extends SQLiteAssetHelper {

    private static final String DaTABASE_NAME = "a5barydatabase.db";
    private static final int DaTABASE_VERSION = 1;

    Context context;
    String TYPE;

    public MyDB(Context context , String TYPE ) {
        super(context, DaTABASE_NAME, null, DaTABASE_VERSION);
        this.context = context;
        this.TYPE = TYPE;
    }

    public ArrayList<DBmodel> getAllData() {

        ArrayList<DBmodel> objDBmodelArrayList = new ArrayList<>();
        try {
            SQLiteDatabase objsqLiteDatabase = getReadableDatabase();
            if (objsqLiteDatabase != null) {
                Cursor objcursor = objsqLiteDatabase.rawQuery("select * from a5bary", null);

                if (objcursor.getCount() != 0) {
                    while (objcursor.moveToNext()) {

                        byte[] imgByte = objcursor.getBlob(0);
                        String imgDes = objcursor.getString(1);
                        String type = objcursor.getString(2);
                        String link = objcursor.getString(3);

                        Bitmap ourImage = BitmapFactory.decodeByteArray(imgByte, 0, imgByte.length);

                        if (type.equals(TYPE)) {
                            objDBmodelArrayList.add(
                                    new DBmodel(
                                            ourImage , imgDes , type , link
                                    )
                            );
                        }


                    }
                } else {
                    Toast.makeText(context, "No Data is retrieved ...", Toast.LENGTH_SHORT).show();
                    return null;
                }
            } else {
                Toast.makeText(context, "Data is null", Toast.LENGTH_SHORT).show();
                return null;
            }

        } catch (Exception e) {
            Toast.makeText(context, "getAllData:-" + e.getMessage(), Toast.LENGTH_SHORT).show();
            return null;
        }

        return objDBmodelArrayList;

    }}
