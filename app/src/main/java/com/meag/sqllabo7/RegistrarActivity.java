package com.meag.sqllabo7;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.meag.sqllabo7.Datos.Persona;
import com.meag.sqllabo7.Entidades.DBHelper;

/**
 * Created by uca on 05-16-18.
 */

public class RegistrarActivity extends AppCompatActivity {

    private EditText txtId, txtNombre;
    private Button btnEnviar;

    @Override

    protected void onCreate(Bundle savedInstance) {

        super.onCreate(savedInstance);
        setContentView(R.layout.activity_registrar);

        inicializarControles();

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag = DBHelper.myDB.add(new Persona(txtId.getText().toString(), txtNombre.getText().toString()));

                if(flag){
                    Log.d("Edit", txtNombre.getText().toString());
                }
      }
        });
    }

    public void inicializarControles(){
        btnEnviar= findViewById(R.id.btnRegistrar);
        txtId= findViewById(R.id.txtId);
        txtNombre= findViewById(R.id.txtNombre); }
}
