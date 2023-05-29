package com.example.rechargetelephonique;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText _edtLogin,_edtPassword;
    Button _btnConnexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _edtLogin=(EditText) findViewById(R.id.edtLogin);
        _edtPassword=(EditText) findViewById(R.id.edtPassword);
        _btnConnexion=(Button) findViewById(R.id.btnConnexion);
        _btnConnexion.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                if(_edtPassword.getText().toString().equals("")||_edtLogin.getText().toString().equals(""))
                    return;
                if(Float.parseFloat(_edtPassword.getText().toString())==123456) {
                    Intent pp = new Intent(getApplicationContext(), MainActivity2.class);
                    pp.putExtra("login", _edtLogin.getText().toString());
                    startActivity(pp);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Nom d'utilisateur ou mot de passe incorrect", Toast.LENGTH_LONG).show();
                }
            }

        }
        );
    }
}