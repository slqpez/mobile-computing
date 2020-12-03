package co.edu.udea.compumovil.gr03_20201.lab2.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import co.edu.udea.compumovil.gr03_20201.lab2.DAO.siteDao;
import co.edu.udea.compumovil.gr03_20201.lab2.Entity.Site;
import co.edu.udea.compumovil.gr03_20201.lab2.Entity.User;

@Database(entities = {Site.class, User.class}, version = 1)
public abstract class DatabaseLab2 extends RoomDatabase {
    
    private static DatabaseLab2 instance;
    public abstract siteDao siteDao();

    public static synchronized DatabaseLab2 getInstance(Context context) {
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), DatabaseLab2.class, "lab2_Database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
