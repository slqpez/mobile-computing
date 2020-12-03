package co.edu.udea.compumovil.gr03_20201.lab2.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import co.edu.udea.compumovil.gr03_20201.lab2.Entity.Site;
import co.edu.udea.compumovil.gr03_20201.lab2.Entity.User;

public interface userDao {
    @Insert
    void insert(User user);

    @Update
    void update(User user);

    @Delete
    void delete(User user);

    @Query("DELETE FROM site_table")
    void deleteAll();

    @Query("SELECT * FROM site_table ")  //TODO Acá tenemos que organizar la consulta, para que sean los sitios de cada usuario.
    LiveData<List<Site>> getAllSites();

}
