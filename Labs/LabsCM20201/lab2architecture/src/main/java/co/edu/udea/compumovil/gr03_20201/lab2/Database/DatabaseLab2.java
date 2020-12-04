package co.edu.udea.compumovil.gr03_20201.lab2.Database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import co.edu.udea.compumovil.gr03_20201.lab2.DAO.relationDao;
import co.edu.udea.compumovil.gr03_20201.lab2.DAO.siteDao;
import co.edu.udea.compumovil.gr03_20201.lab2.Entity.Site;
import co.edu.udea.compumovil.gr03_20201.lab2.Entity.User;

@Database(entities = {Site.class, User.class}, version = 1)
public abstract class DatabaseLab2 extends RoomDatabase {
    
    private static DatabaseLab2 instance;
    public abstract siteDao siteDao();  //TODO
    public abstract relationDao relationDao(); //TODO

    public static synchronized DatabaseLab2 getInstance(Context context) {
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), DatabaseLab2.class, "lab2_Database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback =new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new populateDbAsync(instance).execute();
        }
    };

    private static class populateDbAsync extends AsyncTask <Void,Void,Void>{

        private siteDao siteDao;
        private populateDbAsync(DatabaseLab2 db){
            siteDao = db.siteDao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            siteDao.insert(new Site("link", "metro", "El unico metro de C.", "5","medallo", "5g","No se tire"));
            siteDao.insert(new Site("link2", "bello", "es como afganistan.", "3","bello", "100g","No valla"));
            siteDao.insert(new Site("link3", "pueblito paisa", "Eun pueblito", "7","medallo", "9g","valla"));
            return null;
        }
    }


}
