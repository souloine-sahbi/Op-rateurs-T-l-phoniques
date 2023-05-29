package com.example.rechargetelephonique;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    TextView _txtLogname,_edtTypeLigne;
    EditText _edtNumeroTel,_edtCode,_edtRecharge,_edtSolde;

    Button _btnAppelerRech,_btnSolde;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        _txtLogname=(TextView)findViewById(R.id.txtLogname);
        Bundle extras=getIntent().getExtras();
        _txtLogname.setText(extras.getString("login"));
        _edtNumeroTel=(EditText) findViewById(R.id.edtNumeroTel);
        _edtCode=(EditText) findViewById(R.id.edtCode);
        _edtRecharge=(EditText) findViewById(R.id.edtRecharge);
        _edtSolde=(EditText) findViewById(R.id.edtSolde);
        _edtTypeLigne=(TextView) findViewById(R.id.edtTypeLigne);
        _btnAppelerRech=(Button) findViewById(R.id.btnAppelerRech);
        _btnSolde=(Button) findViewById(R.id.btnSolde);
        _edtNumeroTel.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String phoneNumber=_edtNumeroTel.getText().toString();
                if(phoneNumber.startsWith("9")){
                    _edtTypeLigne.setText("votre ligne est Tunisie Telecom");
                    _edtTypeLigne.setTextColor(getResources().getColor(android.R.color.holo_blue_light));
                    _edtRecharge.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));
                    _edtRecharge.setText("*123*"+"#");
                    _edtSolde.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));
                    _edtSolde.setText("*122#");
                }
                else if(phoneNumber.startsWith("2")){
                    _edtTypeLigne.setText("votre ligne est Ooredoo");
                    _edtTypeLigne.setTextColor(getResources().getColor(android.R.color.holo_red_light));
                    _edtRecharge.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
                    _edtRecharge.setText("*101*"+"#");
                    _edtSolde.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
                    _edtSolde.setText("*100#");
                } else if (phoneNumber.startsWith("5")) {
                    _edtTypeLigne.setText("votre ligne est Orange");
                    _edtTypeLigne.setTextColor(getResources().getColor(android.R.color.holo_orange_light));
                    _edtRecharge.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                    _edtRecharge.setText("*100*"+"#");
                    _edtSolde.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                    _edtSolde.setText("*111#");
                }else {
                    Toast.makeText(getApplicationContext(),"operateur invalide",Toast.LENGTH_LONG).show();
                }
                if(phoneNumber.length()>8)
                    Toast.makeText(getApplicationContext(),"le numero doit etre de 8 chiffre",Toast.LENGTH_LONG).show();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        _edtCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String phoneNumber=_edtNumeroTel.getText().toString();
                String code=_edtCode.getText().toString();
                if(phoneNumber.startsWith("9"))
                    _edtRecharge.setText("*123*"+code+"#");
                else if (phoneNumber.startsWith("2")) {
                    _edtRecharge.setText("*101*"+code+"#");
                }else
                    _edtRecharge.setText("*100*"+code+"#");

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        _btnAppelerRech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String code = _edtCode.getText().toString();
                Uri uri= Uri.parse(_edtRecharge.getText().toString());
                Intent intent=new Intent(Intent.ACTION_CALL,uri );
                startActivity(intent);
            }
        });

    }
}