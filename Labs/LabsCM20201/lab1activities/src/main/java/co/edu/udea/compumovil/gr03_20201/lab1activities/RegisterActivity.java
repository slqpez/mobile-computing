package co.edu.udea.compumovil.gr03_20201.lab1activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import co.edu.udea.compumovil.gr03_20201.lab1activities.ui.login.LoginActivity;

public class RegisterActivity extends AppCompatActivity {
    EditText user;
    EditText password;
    DAOUser dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        user = findViewById(R.id.username);
        password = findViewById(R.id.password);
        dao = new DAOUser(this);

    }

    public void  launchSecondActivity(View view){
        switch (view.getId()){
            case R.id.register:
                User u = new User();
                u.setUser(user.getText().toString());
                u.setPassword(password.getText().toString());
                if(!u.isNull()){
                    Toast.makeText(this, "Los campos están vacios.", Toast.LENGTH_SHORT).show();
                }else if(dao.insertUser(u)){
                    Toast.makeText(this, "Registro exitoso.", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "El usuario ya estaba registrado, o no se pudo registrar.", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.cancel:
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                finish();
        }
    }
}