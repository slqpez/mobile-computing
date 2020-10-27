package co.edu.udea.compumovil.gr03_20201.lab1activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import co.edu.udea.compumovil.gr03_20201.lab1activities.ui.login.Adaptador;
import co.edu.udea.compumovil.gr03_20201.lab1activities.ui.login.Sitio;

public class SitesActivity extends AppCompatActivity {
    Button crear;
    DAOUser dao;
    Sitio s;
    Adaptador adapter;
    ArrayList<Sitio> lista = new ArrayList<Sitio>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sites);
        crear = findViewById(R.id.crear);
        crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(SitesActivity.this, SettingsActivity.class);
                startActivity(in);
                Toast.makeText(SitesActivity.this, "Enviando a configuraciones", Toast.LENGTH_SHORT).show();
            }
        });



        dao = new DAOUser(SitesActivity.this);
        lista = dao.verTodos();
        adapter = new Adaptador(lista, this,dao);
        ListView list = (ListView)findViewById(R.id.Sitios);
        Button agregar = (Button)findViewById(R.id.btn_insertar);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog sitio = new Dialog(SitesActivity.this);
                sitio.setTitle("Nuevo registro");
                sitio.setCancelable(true);
                sitio.setContentView(R.layout.fragment_insertar_datos);
                sitio.show();
                final EditText foto = (EditText)sitio.findViewById(R.id.infoto);
                final EditText nombre = (EditText)sitio.findViewById(R.id.innombre);
                final EditText descripcion = (EditText)sitio.findViewById(R.id.indescripcion);
                final EditText puntuacion = (EditText)sitio.findViewById(R.id.inpuntuacion);
                final EditText informacion = (EditText)sitio.findViewById(R.id.ininformacion);
                final EditText ubicacion = (EditText)sitio.findViewById(R.id.inubicacion);
                final EditText temp = (EditText)sitio.findViewById(R.id.intemperatura);
                final EditText recomendados = (EditText)sitio.findViewById(R.id.inrecomendados);

                Button guardar = (Button)sitio.findViewById(R.id.btn_insertar);
                guardar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            s = new Sitio(//adapter.getId(),
                                    foto.getText().toString(),
                                    nombre.getText().toString(),
                                    descripcion.getText().toString(),
                                    puntuacion.getText().toString(),
                                    informacion.getText().toString(),
                                    ubicacion.getText().toString(),
                                    temp.getText().toString(),
                                    recomendados.getText().toString(),
                                    "");
                            dao.insertSite(s);
                            lista = dao.verTodos();
                            adapter.notifyDataSetChanged();
                            sitio.dismiss();
                        }catch (Exception e){
                            Toast.makeText(getApplication(),"Error Madafaka",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
    @Override
    public void onBackPressed() {

    }
}