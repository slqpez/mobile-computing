package co.edu.udea.compumovil.gr03_20201.lab2.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import co.edu.udea.compumovil.gr03_20201.lab2.Entity.Site;
import co.edu.udea.compumovil.gr03_20201.lab2.R;

public class SiteAdapter extends RecyclerView.Adapter<SiteAdapter.SiteHolder> {
    private List<Site> sites = new ArrayList<Site>();

    @NonNull
    @Override
    public SiteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.site_item, parent,false);
        return  new SiteHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SiteHolder holder, int position) {
        Site  currentSite = sites.get(position);
        holder.name.setText(currentSite.getName());
        holder.description.setText(currentSite.getDescription());
    }

    @Override
    public int getItemCount() {
        return sites.size();
    }

    public void setSites(List<Site> sites){
            this.sites = sites;
            notifyDataSetChanged();
    }

    class SiteHolder extends RecyclerView.ViewHolder{
        private TextView name;
        private TextView description;
        private ImageView image;

        public SiteHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.text_view_name);
            description= itemView.findViewById(R.id.text_view_description);
            image = itemView.findViewById(R.id.image);
        }
    }
}
