package co.edu.udea.compumovil.gr03_20201.lab2.Entity;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class RelationUserSite {
    @Embedded
    public User user;
    @Relation(
            parentColumn = "userId",
            entityColumn = "SiteId"
    )
    public List<Site> sites;
}
