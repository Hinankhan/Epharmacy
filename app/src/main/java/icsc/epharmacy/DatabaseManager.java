package icsc.epharmacy;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by HINAN on 1/11/2018.
 */

public class DatabaseManager extends SQLiteOpenHelper{


    public DatabaseManager(Context context) {
        super(context, "Epharmacy", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table Users(Email varchar(30) Primary key,Username varchar(30),Password varchar(30) ) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
