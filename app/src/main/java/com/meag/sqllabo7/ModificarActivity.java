package com.meag.sqllabo7;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.meag.sqllabo7.Datos.Persona;
import com.meag.sqllabo7.Entidades.DBHelper;

/**
 * Created by uca on 05-16-18.
 */

public class ModificarActivity extends AppCompatActivity {

    private EditText id, nombre;
    private Button btnBuscar, btnELiminar, btnActualizar, btnLimpiar;

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_modificar);

        inicializarControles();

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Persona p = DBHelper.myDB.findUser(id.getText().toString());
                if(p == null){
                    Toast.makeText(getApplicationContext(), "El usuario no fue encontrado", Toast.LENGTH_LONG).show();
                    limpiar();
                }else {
                    nombre.setText(p.getNombre());
                }
            }
        });


        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper.myDB.editUser(new Persona(id.getText().toString(),nombre.getText().toString()));
            }
        });

        btnELiminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper.myDB.deleteUser(id.getText().toString());
                limpiar();
            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpiar();
            }
        });
        }


    public void inicializarControles(){
        id= findViewById(R.id.txtIdM);
        nombre= findViewById(R.id.txtNombreM);
        btnELiminar= findViewById(R.id.btnEliminarM);
        btnActualizar= findViewById(R.id.btnActualizarM);
        btnLimpiar= findViewById(R.id.btnLimpiarM);
        btnBuscar= findViewById(R.id.btnBuscarM);}

        public void limpiar(){
        nombre.setText("");
        id.setText("");
        }
    }

