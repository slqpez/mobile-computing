package co.edu.udea.compumovil.gr03_20201.lab1activities;

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
    String bd = "BDUsers";
    String table = "create table if not exists users(id integer primary key autoincrement, user text, password text)";
    String tableS = "create table if not exists sites(id_site integer primary key autoincrement, id_user integer, photo text, name text, info text,punt varchar, location text, tempe text, sitesR text, FOREIGN KEY(id_user) REFERENCES users(id))";

    public DAOUser(Context c) {
        this.c = c;
        sql = c.openOrCreateDatabase(bd, c.MODE_PRIVATE, null);
        sql.execSQL(table);
        sql.execSQL(tableS);
        u = new User();
    }

    public boolean insertUser(User u) {
        if (search(u.getUser()) == 0) {
            ContentValues cv = new ContentValues();
            cv.put("user", u.getUser());
            cv.put("password", u.getPassword());
            return (sql.insert("users", null, cv) > 0);
        } else {
            return false;
        }
    }

    public boolean insertSite(Sites s) {
            ContentValues cv = new ContentValues();
            cv.put("name", s.getName());
            cv.put("location", s.getLocation());
            return (sql.insert("sites", null, cv) > 0);
    }

    public int search(String u) {
        int x = 0;
        lista = selectUsers();
        for (User us : lista) {
            if (us.getUser().equals(u)) {
                x++;
            }
        }
        return x;
    }

    public ArrayList<User> selectUsers() {
        ArrayList<User> lista = new ArrayList<User>();
        lista.clear();
        Cursor cr = sql.rawQuery("select * from users", null);
        if (cr != null && cr.moveToFirst()) {
            do {
                User u = new User();
                u.setId(cr.getInt(0));
                u.setUser(cr.getString(1));
                u.setPassword(cr.getString(2));
                lista.add(u);
            } while (cr.moveToNext());
        }
        return lista;
    }
    public ArrayList<Sites> selectSites() {
        ArrayList<Sites> lista = new ArrayList<Sites>();
        lista.clear();
        Cursor cr = sql.rawQuery("select * from sites", null);
        if (cr != null && cr.moveToFirst()) {
            do {
                Sites s = new Sites();
                s.setId(cr.getInt(0));
                s.setPhoto(cr.getString(1));
                s.setName(cr.getString(2));
                s.setInfo(cr.getString(3));
                s.setPunt(cr.getInt(4));
                s.setLocation(cr.getString(5));
                s.setTempe(cr.getString(6));
                s.setSitesR(cr.getString(7));
                lista.add(s);
            } while (cr.moveToNext());
        }
        return lista;
    }



    public int login(String u, String p) {
        int a = 0;
        Cursor cr = sql.rawQuery("select * from users", null);
        if (cr != null && cr.moveToFirst()) {
            do {
                if (cr.getString(1).equals(u) && cr.getString(2).equals(p)) {
                    a++;
                }
            } while (cr.moveToNext());
        }
        return a;
    }

    public  User getUser(String u, String p){
        lista = selectUsers();
        for (User us:lista) {
            if(us.getUser().equals(u)&& us.getPassword().equals(p)){
                return us;
            }
        }
        return  null;
    }

    public  User getUserById(int i){
        lista = selectUsers();
        for (User us:lista) {
            if(us.getId() == i){
                return us;
            }
        }
        return  null;
    }
}