package com.example.gestionlisteners;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvRespuesta;
    Button btn_interna, btn_anonima, btn_3en1, btn_implements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvRespuesta = findViewById(R.id.tvRespuesta);
        btn_3en1 = findViewById(R.id.btn_3en1);
        btn_interna = findViewById(R.id.btn_interna);
        btn_anonima = findViewById(R.id.btn_anonima);
        btn_implements = findViewById(R.id.btn_implements);

        //METODO 1
        //crear objeto de la clase auxiliar
        Auxiliar escuchador1 = new Auxiliar();
        //asociar el escuchador a la vista correspondiente
        btn_interna.setOnClickListener(escuchador1);

        //METODO 2
        //asociar el escuchador2 (clase anónima) a la vista correspondiente
        btn_anonima.setOnClickListener(escuchador2);

        //METODO 3 - 3 EN 1
        btn_3en1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvRespuesta.setText("Botón clase 3 en 1");
            }
        });

        //METODO 4
        btn_implements.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        tvRespuesta.setText("Botón método implements pulsado");
    }

    //MÉTODO 1
    //crear una clase interna auxiliar para implementar el escuchador
    private class Auxiliar implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            //gestionar la pulsación del botón 1
            tvRespuesta.setText("Botón clase interna pulsado");
        }
    } //end clase auxiliar

    //METODO 2
    //objeto escuchador mediante una CLASE ANONIMA / ES UNA SENTENCIA LO DE ABAJO
    private View.OnClickListener escuchador2 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            tvRespuesta.setText("Botón clase Anónima");
        }
    };
}