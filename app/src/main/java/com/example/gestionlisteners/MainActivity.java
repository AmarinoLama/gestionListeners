package com.example.gestionlisteners;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView tvRespuesta;
    Button btn_act_2_depre, btn_camara, btn_act_2, btn_camara_depre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_act_2 = findViewById(R.id.btn_act_2);
        btn_act_2_depre = findViewById(R.id.btn_act_2_depre);
        btn_camara = findViewById(R.id.btn_camara);
        btn_camara_depre = findViewById(R.id.btn_camara_depre);
        tvRespuesta = findViewById(R.id.tvRespuesta);

        btn_act_2.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Activity2.class);
            intent.putExtra("name", "Aman");
            startActivityForResult(intent,100);
        });

        btn_act_2_depre.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Activity2.class);
            intent.putExtra("name", "Aman");
            startActivity(intent);
        });

        btn_camara.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Activity2.class);
            startActivity(intent);
        });

        btn_camara_depre.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Activity2.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 100 && resultCode == MainActivity.RESULT_OK){
            tvRespuesta.setText(data.getStringExtra(getString(R.string.mensaje)));
        }
    }
}