package co.edu.udea.compumovil.gr03_20201.lab1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DAOUser {
    Context c;
    User u;
    ArrayList<User> lista;
    SQLiteDatabase sql;
    String bd="BDUsers";
    String table ="create table users(id integer primary key autoincrement, user text, password text)";

    public DAOUser(Context c){
        this.c=c;
        sql = c.openOrCreateDatabase(bd, c.MODE_PRIVATE,null);
        sql.execSQL(table);
        u = new User();
    }

    public boolean insertUser(User u){
        if(search(u.getUser())==0){
            ContentValues cv = new ContentValues();
            cv.put("user", u.getUser());
            cv.put("password", u.getPassword());
            return(sql.insert("users",null, cv)>0);
        }else{
            return  false;
        }
    }

    public int search(String u){
        int x=0;
        lista = selectUsers();
        for(User us:lista){
            if(us.getUser().equals(u)){
                x++;
            }
        }
        return  x;
    }
    public ArrayList<User> selectUsers(){
        ArrayList<User> lista = new ArrayList<User>();
        lista.clear();
        Cursor cr = sql.rawQuery("select * from users",null);
        if(cr!= null && cr.moveToFirst()){
            do{
                User u = new User();
                u.setId(cr.getInt(0));
                u.setUser(cr.getString(1));
                u.setPassword(cr.getString(2));
                lista.add(u);
            }while(cr.moveToNext());
        }
        return lista;
    }

}
