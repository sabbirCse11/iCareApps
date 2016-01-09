package Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Mobile App Develop on 7-1-16.
 */
public class DBHandler extends SQLiteOpenHelper {
    static final String DB_NAME = "DB_iCare";
    static final String TABLE_HCARE_USER= "HCARE_USER";

    static final String TABLE_USER_PROFILE= "USER_PROFILE";
    public static final String COL_USER_ID="UserId";
    public static final String COL_USER_NAME="userName";
    public static final String COL_GENDER="gender";
    public static final String COL_DOB="dob";
    public static final String COL_AGE="age";
    public static final String COL_BLOOD_GROUP="bloodGroup";
    public static final String COL_HEIGHT_CM="heightCm";
    public static final String COL_WEIGHT_KG="weightKg";

    static final String TABLE_DIET_INFO= "DIET_INFO";
    public static final String COL_DIET_ID="dietId";
    public static final String COL_DIET_TYPE="dietType";
    public static final String COL_FOOD_MENU="foodMenu";
    public static final String COL_ALERM_DATE="alermDate";
    public static final String COL_ALERM_TIME="alermTime";
    public static final String COL_DI_REF_USER_ID="refUserId";


    static final String TABLE_VACCINE_INFO= "VACCINE_INFO";
    public static final String COL_VACCINE_ID="vaccineId";
    public static final String COL_VACCINE_NAME="vaccineName";
    public static final String COL_VACCINE_DATE="vaccineDate";
    public static final String COL_VACCINE_TIME="vaccineTime";
    public static final String COL_VACCINE_DETAILS="vaccineDetails";
    public static final String COL_VACCINE_ALERT="vaccineAlert";
    public static final String COL_VAC_REF_USER_ID="refUserId";

    static final String TABLE_DOCTOR_INFO = "DOCTOR_INFO";
    public static final String COL_DOCTOR_ID="doctorId";
    public static final String COL_DR_NAME="doctorName";
    public static final String COL_DR_SPECIALITY="drSpeciality";
    public static final String COL_DR_ADDRESS ="drAddress";
    public static final String COL_DR_CONTACT_NO ="drContactNo";
    public static final String COL_DR_EMAIL="drEmail";
    public static final String COL_DR_APPOINTMENT_DATE="drAppointmentDate";
    public static final String COL_DR_APPOINTMENT_TIME="drAppointmentTime";
    public static final String COL_DR_REF_USER_ID="refUserId";

    static final String TABLE_MEDICAL_RECORD= "MEDICAL_RECORD";
    public static final String COL_MED_RECORD_ID="medRecId";
    public static final String COL_VISIT_DATE="visitDate";
    public static final String COL_PROBLEM_SUMMARY="problemSummary";
    public static final String COL_PRESCRIPTION_PHOTO ="prescriptionPhoto";
    public static final String COL_MED_REF_USER_ID="refUserId";
    public static final String COL_MED_REF_DR_ID="refDrId";


    static final String TABLE_HOSPITAL_INFO = "HOSPITAL_INFO";
    public static final String COL_HOSPITAL_NAME="hospitalName";
    public static final String COL_HOSPITAL_ADDRESS="HospitalAddress";
    public static final String COL_HOS_PHONE="hospitalPhone";
    public static final String COL_HOS_REF_USER_ID="refUserId";

    static final String TABLE_EMERGENCY_CONTACT = "EMERGENCY_CONTACT";
    public static final String COL_EMRG_ID="emrgId";
    public static final String COL_EMRG_NAME="emrgName";
    public static final String COL_RELATION="relation";
    public static final String COL_CONTACT_NO="contactNo";
    public static final String COL_EMRG_REF_USER_ID="refUserId";


    public DBHandler(Context context) {
        super(context, DB_NAME, null, 1);

    }

    static final String CREATE_TABLE_USER_PROFILE ="CREATE TABLE "+TABLE_USER_PROFILE +" ( " +
            COL_USER_ID +" INTEGER PRIMARY KEY,"+ COL_USER_NAME +" TEXT,"+ COL_GENDER+" TEXT ," +
            COL_DOB +" TEXT , " + COL_AGE +" REAL ," + COL_BLOOD_GROUP + " TEXT , " +
            COL_HEIGHT_CM + " REAL , " + COL_WEIGHT_KG + " REAL )";




    static final String CREATE_TABLE_DIET_INFO="CREATE TABLE "+TABLE_DIET_INFO +" ( " +
            COL_DIET_ID +" INTEGER PRIMARY KEY,"+ COL_DIET_TYPE +" TEXT,"+ COL_FOOD_MENU+" TEXT ," +
            COL_ALERM_DATE +" TEXT , " + COL_ALERM_TIME + " TEXT, "+
            " FOREIGN KEY(" + COL_DI_REF_USER_ID + ") REFERENCES "+ TABLE_USER_PROFILE + "("+ COL_USER_ID +"))";


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE_USER_PROFILE);
        db.execSQL(CREATE_TABLE_DIET_INFO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST"+ CREATE_TABLE_DIET_INFO);

    }
}
