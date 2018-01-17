package icsc.epharmacy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

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
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("Drop table if exists Users");
        onCreate(db);
    }

    public boolean registerUser(String email, String username, String password){
        ContentValues cv = new ContentValues();
        cv.put("Email",email);
        cv.put("Username",username);
        cv.put("Password",password);

        SQLiteDatabase db = this.getWritableDatabase();
       long r = db.insert("Users",null,cv);
        if(r == -1)
            return false;
        else
            return true;

    }

    public boolean isUserRegistered(String username, String password) {
        Log.d("Database", username + password);
        SQLiteDatabase db = this.getReadableDatabase();
       Cursor cur = db.rawQuery("select * from Users where Username = '" + username+ "' and Password = '" +password+ "'",null);
        Log.d("Database", cur.toString());
        if(cur != null) {
                cur.moveToFirst();
                if(cur.getCount() > 0 ) {
                    Log.d("Database",cur.getString(0)+" "+cur.getString(1)+" "+cur.getString(2));
                    return true;
                }
                else
                    return false;
            }

        return false;
    }
}
