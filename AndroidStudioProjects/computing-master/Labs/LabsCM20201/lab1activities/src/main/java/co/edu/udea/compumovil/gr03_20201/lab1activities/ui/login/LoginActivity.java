package co.edu.udea.compumovil.gr03_20201.lab1activities.ui.login;

import android.app.Activity;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import co.edu.udea.compumovil.gr03_20201.lab1activities.DAOUser;
import co.edu.udea.compumovil.gr03_20201.lab1activities.R;
import co.edu.udea.compumovil.gr03_20201.lab1activities.RegisterActivity;
import co.edu.udea.compumovil.gr03_20201.lab1activities.SiteActivity;
import co.edu.udea.compumovil.gr03_20201.lab1activities.SitesActivity;
import co.edu.udea.compumovil.gr03_20201.lab1activities.User;


public class LoginActivity extends AppCompatActivity {
    private static final String LOG_TAG =
            LoginActivity.class.getSimpleName();
    EditText user, password;
    Button login;
    DAOUser dao;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        dao = new DAOUser(this);
    }



    public void launchSecondActivity(View view) {
        switch (view.getId()){
            case R.id.login:
                String u = user.getText().toString();
                String p = password.getText().toString();
                if(u.equals("")|| p.equals("")){
                    Toast.makeText(this, "Uno o varios campos están vacios.", Toast.LENGTH_SHORT).show();
                }else if(dao.login(u,p)==1){
                    User ul = dao.getUser(u,p);
                    Toast.makeText(this, "Datos correctos.", Toast.LENGTH_SHORT).show();
                    Intent is = new Intent(this, SiteActivity.class);
                    is.putExtra("id", ul.getId());
                    startActivity(is);
                    finish();
                }else{
                    Toast.makeText(this, "Usuario o contraseña incorrectos.", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.register:
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
        }

    }
}
