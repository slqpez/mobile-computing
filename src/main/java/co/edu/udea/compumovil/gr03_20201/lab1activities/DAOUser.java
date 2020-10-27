package co.edu.udea.compumovil.gr03_20201.lab1activities;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import co.edu.udea.compumovil.gr03_20201.lab1activities.ui.login.Sitio;

public class DAOUser {
    Context c;
    User u;
    Sitio s;
    ArrayList<User> lista = new ArrayList<User>();
    ArrayList<Sitio> listaSitios = new ArrayList<Sitio>();
    SQLiteDatabase sql;
    String bd = "BDUsers";
    String table = "create table if not exists users(id integer primary key autoincrement, user text, password text)";
    String tableS = "create table if not exists sites(id_site integer primary key autoincrement, id_user integer, photo text, name text, info text, description text, punt text, location text, tempe text, sitesR text, FOREIGN KEY(id_user) REFERENCES users(id))";

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

    public boolean insertSite(Sitio s) {
        ContentValues cv = new ContentValues();
        cv.put("photo", s.getFoto());
        cv.put("name", s.getNombre());
        cv.put("description", s.getDescripcion());
        cv.put("punt", s.getPuntuacion());
        cv.put("info", s.getInformacion());
        cv.put("location", s.getUbicacion());
        cv.put("tempe", s.getTemperatura());
        cv.put("sitesR", s.getRecomendados());
        return (sql.insert("sites", null, cv) > 0);
    }

    public boolean editar(Sitio s) {
        ContentValues cv = new ContentValues();
        cv.put("photo", s.getFoto());
        cv.put("name", s.getNombre());
        cv.put("description", s.getDescripcion());
        cv.put("punt", s.getPuntuacion());
        cv.put("info", s.getInformacion());
        cv.put("location", s.getUbicacion());
        cv.put("tempe", s.getTemperatura());
        cv.put("sitesR", s.getRecomendados());
        return (sql.update("sites", cv, "id_site="+s.getId(), null) > 0);
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

    public ArrayList<Sitio> selectSites() {
        ArrayList<Sitio> lista = new ArrayList<Sitio>();
        lista.clear();
        Cursor cr = sql.rawQuery("select * from sites", null);
        if (cr != null && cr.moveToFirst()) {
            do {
                Sitio s = new Sitio();
                s.setId(cr.getInt(0));
                s.setFoto(cr.getString(1));
                s.setNombre(cr.getString(2));
                s.setInformacion(cr.getString(3));
                s.setDescripcion(cr.getString(4));
                s.setPuntuacion(cr.getString(5));
                s.setUbicacion(cr.getString(6));
                s.setTemperatura(cr.getString(7));
                s.setRecomendados(cr.getString(8));
                lista.add(s);
            } while (cr.moveToNext());
        }
        return lista;
    }

    public ArrayList<Sitio> verTodos(){
        listaSitios.clear();
        Cursor cursor=sql.rawQuery("select * from sites", null);
        if(cursor != null && cursor.getCount() >0) {
            cursor.moveToFirst();
            do{
                listaSitios.add(new Sitio(cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6),
                        cursor.getString(7),
                        cursor.getString(8),
                        cursor.getString(9)));
            }while (cursor.moveToNext());
        }
        return listaSitios;
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

    public Sitio verUno(int pos){
        Cursor cr = sql.rawQuery("select * from sites", null);
        cr.moveToPosition(pos);
        s = new Sitio(cr.getInt(0),
                cr.getString(1),
                cr.getString(2),
                cr.getString(3),
                cr.getString(4),
                cr.getString(5),
                cr.getString(6),
                cr.getString(7),
                cr.getString(8),
                cr.getString(9));
        return s;
    }

    public Boolean eliminar(int id){
        return (sql.delete("sites", "id_site="+id,null)>0);
    }
}