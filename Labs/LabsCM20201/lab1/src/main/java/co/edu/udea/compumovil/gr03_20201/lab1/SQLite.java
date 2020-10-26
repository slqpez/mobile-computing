package co.edu.udea.compumovil.gr03_20201.lab1;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SQLite extends SQLiteOpenHelper {

    public SQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table if not exists users(id integer primary key autoincrement, user text, password text)");
            db.execSQL("create table if not exists sites(id_site integer primary key autoincrement, id_user integer, photo text,name text,info text,location text,tempe, text, sitesR text, FOREIGN KEY(id_user) REFERENCES users(id))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
