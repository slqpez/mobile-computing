package co.edu.udea.compumovil.gr03_20201.lab2.Repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import co.edu.udea.compumovil.gr03_20201.lab2.DAO.relationDao;
import co.edu.udea.compumovil.gr03_20201.lab2.DAO.siteDao;
import co.edu.udea.compumovil.gr03_20201.lab2.Database.DatabaseLab2;
import co.edu.udea.compumovil.gr03_20201.lab2.Entity.RelationUserSite;
import co.edu.udea.compumovil.gr03_20201.lab2.Entity.Site;

public class Repository {
    private relationDao relationDao; //TODO
    private siteDao siteDao; //TODO
    private LiveData<List<Site>> allSites;  //TODO Hay que mirar qué tenemos que traer.

    public Repository(Application application){
        DatabaseLab2  database = DatabaseLab2.getInstance(application);
        relationDao = database.relationDao(); //TODO
        siteDao = database.siteDao(); //TODO ojo, no sabemos cuál usar.
        allSites = siteDao.getAllSites();
    }

    public void insert(Site site){
        new InsertSiteAsync(siteDao).execute(site);
    }

    public void update(Site site){
        new  UpdateSiteAsync(siteDao).execute(site);
    }

    public void delete (Site site){
        new DeleteSiteAsync(siteDao).execute(site);
    }

    public void deleteAllSites(){
        new DeleteAllSitesAsync(siteDao).execute();
    }

    public  LiveData<List<Site>> getAllSites(){
        return allSites;
    }

    private static class InsertSiteAsync extends AsyncTask<Site, Void,Void> {
        private siteDao siteDao;

        private InsertSiteAsync(siteDao siteDao){
            this.siteDao = siteDao;
        }

        @Override
        protected Void doInBackground(Site... sites) {
            siteDao.insert(sites[0]);
            return null;
        }
    }

    private static class UpdateSiteAsync extends AsyncTask<Site, Void,Void> {
        private siteDao siteDao;

        private UpdateSiteAsync(siteDao siteDao){
            this.siteDao = siteDao;
        }

        @Override
        protected Void doInBackground(Site... sites) {
            siteDao.update(sites[0]);
            return null;
        }
    }
    private static class DeleteSiteAsync extends AsyncTask<Site, Void,Void> {
        private siteDao siteDao;

        private DeleteSiteAsync(siteDao siteDao){
            this.siteDao = siteDao;
        }

        @Override
        protected Void doInBackground(Site... sites) {
            siteDao.delete(sites[0]);
            return null;
        }
    }

    private static class DeleteAllSitesAsync extends AsyncTask<Void, Void,Void> {
        private siteDao siteDao;

        private DeleteAllSitesAsync(siteDao siteDao){
            this.siteDao = siteDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            siteDao.deleteAll();
            return null;
        }
    }
}
