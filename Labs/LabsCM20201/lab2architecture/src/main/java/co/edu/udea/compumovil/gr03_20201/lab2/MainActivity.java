package co.edu.udea.compumovil.gr03_20201.lab2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import co.edu.udea.compumovil.gr03_20201.lab2.Adapter.SiteAdapter;
import co.edu.udea.compumovil.gr03_20201.lab2.Entity.Site;
import co.edu.udea.compumovil.gr03_20201.lab2.ViewModel.SiteViewModel;

public class MainActivity extends AppCompatActivity {
    private SiteViewModel siteViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final SiteAdapter adapter = new SiteAdapter();
        recyclerView.setAdapter(adapter);

        siteViewModel = ViewModelProviders.of(this).get(SiteViewModel.class);
        siteViewModel.getAllSites().observe(this, new Observer <List<Site>>(){
            @Override
            public void onChanged(@Nullable List<Site> sites){
                adapter.setSites(sites);
            }
        });
    }
}
