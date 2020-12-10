package co.edu.udea.compumovil.gr03_20201.lab2.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import co.edu.udea.compumovil.gr03_20201.lab2.Entity.Site;
import co.edu.udea.compumovil.gr03_20201.lab2.Repository.Repository;

public class SiteViewModel extends AndroidViewModel {
    private Repository repository;
    private LiveData<List<Site>> allSites;

    public SiteViewModel(@NonNull Application application) {
        super(application);
        repository = new  Repository(application);
        allSites = repository.getAllSites();
    }

    public void insert(Site site){
        repository.insert(site);
    }

    public void update(Site site){
        repository.update(site);
    }

    public void delete(Site site){
        repository.delete(site);
    }
    public void deleteAllSites(){
        repository.deleteAllSites();
    }

    public LiveData<List<Site>> getAllSites() {
        return allSites;
    }
}
