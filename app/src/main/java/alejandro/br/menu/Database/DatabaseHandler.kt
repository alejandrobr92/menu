package alejandro.br.menu.Database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import kotlinx.coroutines.flow.DEFAULT_CONCURRENCY

class DatabaseHandler(context: Context) :  SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {


    override fun onCreate(db: SQLiteDatabase?) {
        var CREATE_CURRENT_ORDER_TABLE = "create table " + TABLE_NAME +"("+ KEY_ID_INSIDE_TABLE +" integer primary key, " + KEY_CURRENT_ORDER_ID + " String"+")"
        db?.execSQL(CREATE_CURRENT_ORDER_TABLE)
    }


    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS TABLE_NAME")
        onCreate(db)
    }

    fun addCurrentOrderId(currentOrderId:String){
        var db : SQLiteDatabase = writableDatabase
        val values = ContentValues()
        values.put(KEY_ID_INSIDE_TABLE,0)
        values.put(KEY_CURRENT_ORDER_ID, currentOrderId)
        db.insert(TABLE_NAME, null, values)
        Log.e("SQLite", "Curren Order ID stored successfully")
        db.close()
    }

}