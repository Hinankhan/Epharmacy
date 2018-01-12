package icsc.epharmacy;

import android.content.ContentValues;
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
}
