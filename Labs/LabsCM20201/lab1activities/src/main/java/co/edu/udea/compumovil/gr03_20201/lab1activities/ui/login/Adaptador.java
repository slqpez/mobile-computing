package co.edu.udea.compumovil.gr03_20201.lab1activities.ui.login;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import co.edu.udea.compumovil.gr03_20201.lab1activities.DAOUser;
import co.edu.udea.compumovil.gr03_20201.lab1activities.R;

public class Adaptador extends BaseAdapter {
    ArrayList<Sitio> lista = new ArrayList<Sitio>();
    DAOUser dao;
    Sitio s;
    Activity a;
    int id;

    public Adaptador(ArrayList<Sitio> lista, Activity a, DAOUser dao) {
        this.lista = lista;
        this.a = a;
        this.dao = dao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Sitio getItem(int i) {
        s=lista.get(i);
        return null;
    }

    @Override
    public long getItemId(int i) {
        s=lista.get(i);
        return s.getId();
    }

    @Override
    public View getView(int pos, View view, ViewGroup viewGroup) {
        View v=view;
        if (v==null){
            LayoutInflater li=(LayoutInflater) a.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v=li.inflate(R.layout.item, null);
        }
        s=lista.get(pos);
        final ImageView foto=(ImageView) v.findViewById(R.id.fotoitem);
        final TextView nombre=(TextView)v.findViewById(R.id.nombreitem);
        final TextView descripcion=(TextView)v.findViewById(R.id.descitem);
        final TextView puntuacion=(TextView)v.findViewById(R.id.puntitem);
        Button editar=(Button)v.findViewById(R.id.editar);
        Button eliminar=(Button)v.findViewById(R.id.eliminar);
        Button vermas=(Button)v.findViewById(R.id.vermas);
        /*foto.setText(s.getFoto());
        nombre.setText(s.getNombre());
        descripcion.setText(s.getDescripcion());
        puntuacion.setText(s.getPuntuacion());*/

        switch (s.getNombre()){
            case "torre":
                foto.setImageResource(R.mipmap.ic_launcher_round);
                break;
            case "museo":
                foto.setImageResource(R.mipmap.museo);
                break;
            case "notredame":
                foto.setImageResource(R.mipmap.notredame);
                break;
            case "santacapilla":
                foto.setImageResource(R.mipmap.capilla);
                break;
            case "opera":
                foto.setImageResource(R.mipmap.opera);
                break;
            default:
                foto.setImageResource(R.mipmap.edit);
        }



        nombre.setText(s.getDescripcion());
        descripcion.setText(s.getPuntuacion());
        puntuacion.setText(s.getUbicacion());

        editar.setTag(pos);
        eliminar.setTag(pos);
        vermas.setTag(pos);
        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = Integer.parseInt(view.getTag().toString());
                final Dialog sitio = new Dialog(a);
                sitio.setTitle("Editar registro");
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
                s = lista.get(pos);
                setId(s.getId());
                /*foto.setText(s.getFoto());
                nombre.setText(s.getNombre());
                descripcion.setText(s.getDescripcion());
                puntuacion.setText(s.getPuntuacion());
                ubicacion.setText(s.getUbicacion());
                informacion.setText(s.getInformacion());
                temp.setText(s.getTemperatura());
                recomendados.setText(s.getRecomendados());*/

                foto.setText(s.getNombre());
                nombre.setText(s.getDescripcion());
                descripcion.setText(s.getPuntuacion());
                puntuacion.setText(s.getUbicacion());
                ubicacion.setText(s.getInformacion());
                informacion.setText(s.getTemperatura());
                temp.setText(s.getRecomendados());
                recomendados.setText(s.getAux());

                Button guardar = (Button)sitio.findViewById(R.id.btn_insertar);
                guardar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            s = new Sitio(getId(),
                                    foto.getText().toString(),
                                    nombre.getText().toString(),
                                    descripcion.getText().toString(),
                                    puntuacion.getText().toString(),
                                    informacion.getText().toString(),
                                    ubicacion.getText().toString(),
                                    temp.getText().toString(),
                                    recomendados.getText().toString(),
                                    "");
                            dao.editar(s);
                            lista = dao.verTodos();
                            notifyDataSetChanged();
                            sitio.dismiss();
                        }catch (Exception e){
                            Toast.makeText(a,"Error Madafaka",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int posi = Integer.parseInt(view.getTag().toString());
                s = lista.get(posi);
                setId(s.getId());
                AlertDialog.Builder del = new AlertDialog.Builder(a);
                del.setMessage("Eliminar registro?");
                del.setCancelable(false);
                del.setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dao.eliminar(getId());
                        lista = dao.verTodos();
                        notifyDataSetChanged();
                    }
                });
                del.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                del.show();
            }
        });
        vermas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = Integer.parseInt(view.getTag().toString());
                final Dialog sitio = new Dialog(a);
                sitio.setTitle("Mostrar registro");
                sitio.setCancelable(true);
                sitio.setContentView(R.layout.fragment_mostrar_datos);
                sitio.show();
                final TextView foto = (TextView)sitio.findViewById(R.id.foto);
                final TextView nombre = (TextView)sitio.findViewById(R.id.nombre);
                final TextView descripcion = (TextView)sitio.findViewById(R.id.descripcion);
                final TextView puntuacion = (TextView)sitio.findViewById(R.id.puntuacion);
                final TextView informacion = (TextView)sitio.findViewById(R.id.informacion);
                final TextView ubicacion = (TextView)sitio.findViewById(R.id.ubicacion);
                final TextView temp = (TextView)sitio.findViewById(R.id.temperatura);
                final TextView recomendados = (TextView)sitio.findViewById(R.id.recomendados);
                s = lista.get(pos);
                setId(s.getId());
                /*foto.setText(s.getFoto());
                nombre.setText(s.getNombre());
                descripcion.setText(s.getDescripcion());
                puntuacion.setText(s.getPuntuacion());
                ubicacion.setText(s.getUbicacion());
                informacion.setText(s.getInformacion());
                temp.setText(s.getTemperatura());
                recomendados.setText(s.getRecomendados());*/
                foto.setText(s.getNombre());
                nombre.setText(s.getDescripcion());
                descripcion.setText(s.getPuntuacion());
                puntuacion.setText(s.getUbicacion());
                ubicacion.setText(s.getInformacion());
                informacion.setText(s.getTemperatura());
                temp.setText(s.getRecomendados());
                recomendados.setText(s.getAux());

                /*for(int i = 0; i < lista.size(); i++)
                    Log.d("TAG", );*/
                //Log.d("TAG", s.getNombre());
            }
        });
        return v;
    }
}