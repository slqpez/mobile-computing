package co.edu.udea.compumovil.gr03_20201.lab1activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceScreen;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class SitesActivity extends AppCompatActivity {
    Button crear;
    EditText name, location;
    FloatingActionButton settings;


    @SuppressLint("WrongViewCast")
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

    }
    @Override
    public void onBackPressed() {

    }

}