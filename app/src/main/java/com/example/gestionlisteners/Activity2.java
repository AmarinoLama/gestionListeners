package com.example.gestionlisteners;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {

    private Button btn_volver;
    private TextView tv_salida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        btn_volver = findViewById(R.id.btn_volver);
        tv_salida = findViewById(R.id.tv_salida);

        btn_volver.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), MainActivity.class);
            intent.putExtra("mensaje","cerre");
            setResult(Activity2.RESULT_OK,intent);
            finish();
        });

        Intent intent = getIntent();
        String strDatoRecibido = intent.getStringExtra("name");
        tv_salida.setText(strDatoRecibido);
    }

}