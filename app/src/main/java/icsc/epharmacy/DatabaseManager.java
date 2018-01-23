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

    private final String USERS_TABLE = "Users";
    private final String USERS_COL1 = "Email";
    private final String USERS_COL2 = "Username";
    private final String USERS_COL3 = "Password";
    private final String USERS_COL4 = "UserType";
    private final String RETAILERS_TABLE = "Retailer";
    private final String RETAILERS_COL1 = "StoreID";
    private final String RETAILERS_COL2 = "StoreName";
    private final String RETAILERS_COL3 = "Address";
    private final String RETAILERS_COL4 = "PhoneNumber";
    private final String RETAILERS_COL5 = "Website";


    public DatabaseManager(Context context) {
        super(context, "Epharmacy", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table "+ USERS_TABLE+"("+USERS_COL1+" varchar(30) Primary key,"+USERS_COL2+" varchar(30),"+USERS_COL3+" varchar(30), "+USERS_COL4+" varchar(30) ) ");
        db.execSQL("Create table "+ RETAILERS_TABLE+"("+RETAILERS_COL1+" varchar(30) Primary key,"+RETAILERS_COL2+" varchar(30),"+RETAILERS_COL3+" varchar(30), "+RETAILERS_COL4+" integer(30), "+RETAILERS_COL5+" varchar(30) ) ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("Drop table if exists"+ USERS_TABLE);
        onCreate(db);
    }
    // Stores the information of a new user in database table
    public boolean registerUser(String email, String username, String password, String type){
        ContentValues cv = new ContentValues();
        cv.put(USERS_COL1,email);
        cv.put(USERS_COL2,username);
        cv.put(USERS_COL3,password);
        cv.put(USERS_COL4,type);

        SQLiteDatabase db = this.getWritableDatabase();
       long r = db.insert(USERS_TABLE,null,cv);
        if(r == -1)
            return false;
        else
            return true;

    }
// checks whether user is registered or not an returs the type of user
    public String isUserRegistered(String username, String password) {
        Log.d("Database", username + password);
        SQLiteDatabase db = this.getReadableDatabase();
       Cursor cur = db.rawQuery("select * from "+USERS_TABLE+" where "+USERS_COL2+" = '" + username+ "' and "+USERS_COL3+" = '" +password+ "'",null);
        Log.d("Database", cur.toString());
        if(cur != null) {
                cur.moveToFirst();
                if(cur.getCount() > 0 ) {
                    Log.d("Database",cur.getString(3));

                    return cur.getString(3);
                }
                else
                    return null;
            }

        return null;
    }
}
