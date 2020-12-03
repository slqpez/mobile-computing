package co.edu.udea.compumovil.gr03_20201.lab2.DAO;

import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

import co.edu.udea.compumovil.gr03_20201.lab2.Entity.RelationUserSite;

public interface relationDao {
    @Transaction
    @Query("SELECT * FROM site_table")
    public List<RelationUserSite> getSitesForUser();
}
