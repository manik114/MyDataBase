package com.mk.manik.mydatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class MySQLite extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "products.sqLiteDatabase";
    public static final String TABLE_PRODUCTS = "products";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_PRODUCTNAME= "productName";

    private static final String[] COLUMNS =new String[] {COLUMN_ID,COLUMN_PRODUCTNAME};


    public static final String query = "CREATE TABLE "+ TABLE_PRODUCTS +" ("+
            COLUMN_ID +" integer primary key autoincrement, "+
            COLUMN_PRODUCTNAME + " TEXT );";

    public MySQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_PRODUCTS);
        this.onCreate(sqLiteDatabase);
    }
                    //--------------Adding----------------//
    public void addProduct (Products products){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_PRODUCTNAME,products.getProductName());
        sqLiteDatabase.insert(TABLE_PRODUCTS,null,values);
        sqLiteDatabase.close();
    }
                    //------------Deleting------------------//

    public void deleteProduct(String productname){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.execSQL("DELETE FROM " + TABLE_PRODUCTS +" WHERE " + COLUMN_PRODUCTNAME + "=\"" + productname +"\";" );
    }

    public String dataBaseToString(){
        int a=1;
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String dataBase = "";
     Cursor cursor =  sqLiteDatabase.query(TABLE_PRODUCTS,COLUMNS,null,null,null,null,null);


        if(cursor!=null)
            cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            if(cursor.getString(cursor.getColumnIndex(COLUMN_PRODUCTNAME))!=null){
                dataBase+= a++ + " ";
                dataBase+=cursor.getString(cursor.getColumnIndex(COLUMN_PRODUCTNAME));
                dataBase+="\n";
            }
            cursor.moveToNext();
        }

        sqLiteDatabase.close();
        return dataBase;
    }
}
