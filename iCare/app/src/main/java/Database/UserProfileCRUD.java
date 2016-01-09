package Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Mobile App Develop on 7-1-16.
 */
public class UserProfileCRUD extends DBHandler {

    private SQLiteDatabase db;

    public UserProfileCRUD(Context context) {
        super(context);
        db = getWritableDatabase();
    }

    public void insertIntoUserProfile(UserProfileTable userProfileTable){

        ContentValues values = new ContentValues();
        values.put(COL_USER_NAME, userProfileTable.getUserName());
        values.put(COL_GENDER, userProfileTable.getGender());
        values.put(COL_DOB, userProfileTable.getDateOfBirth());
        values.put(COL_AGE, userProfileTable.getAge());
        values.put(COL_BLOOD_GROUP, userProfileTable.getBloodGroup());
        values.put(COL_HEIGHT_CM, userProfileTable.getHeight());
        values.put(COL_WEIGHT_KG, userProfileTable.getWeight());
        db.insert(TABLE_USER_PROFILE, null, values);
    }
}
