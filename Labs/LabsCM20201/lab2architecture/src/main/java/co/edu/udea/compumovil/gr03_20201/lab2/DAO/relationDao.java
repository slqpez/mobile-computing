package co.edu.udea.compumovil.gr03_20201.lab2.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

import co.edu.udea.compumovil.gr03_20201.lab2.Entity.RelationUserSite;
import co.edu.udea.compumovil.gr03_20201.lab2.Entity.Site;
@Dao
public interface relationDao {
   /* @Transaction
    @Query("SELECT * FROM site_table")
    public LiveData<List<RelationUserSite>> getAllSites();*/

}
