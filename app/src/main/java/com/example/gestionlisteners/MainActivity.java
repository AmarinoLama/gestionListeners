package com.example.gestionlisteners;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView tvRespuesta;
    Button btn_act_2_depre, btn_camara, btn_act_2, btn_camara_depre;
    ActivityResultLauncher<Intent> intentCallAct2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_act_2 = findViewById(R.id.btn_act_2);
        btn_act_2_depre = findViewById(R.id.btn_act_2_depre);
        btn_camara = findViewById(R.id.btn_camara);
        btn_camara_depre = findViewById(R.id.btn_camara_depre);
        tvRespuesta = findViewById(R.id.tvRespuesta);

        // LÓGICA DEL BOTÓN UNO - ABRIR ACTIVITY 2 CON UN MÉTODO NO DEPRECATED

        intentCallAct2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    tvRespuesta.setText("Activity Result OK: Callback" + result.getData().getStringExtra(Activity2.ACTIVITY_RES_MSG));
                });

        btn_act_2.setOnClickListener(view -> {
            Intent act2 = new Intent(view.getContext(), Activity2.class);
            intentCallAct2.launch(act2);
        });

        // LÓGICA DEL BOTÓN DOS - ABRIR ACTIVITY 2 CON UN MÉTODO DEPRECATED

        btn_act_2_depre.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Activity2.class);
            intent.putExtra("name", "Aman");
            startActivityForResult(intent,100);
        });

        // LÓGICA DEL BOTÓN TRES - ABRIR CÁMARA CON UN MÉTODO NO DEPRECATED

        btn_camara.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Activity2.class);
            startActivity(intent);
        });

        // LÓGICA DEL CUATRO TRES - ABRIR CÁMARA CON UN MÉTODO DEPRECATED

        btn_camara_depre.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Activity2.class);
            startActivity(intent);
        });
    }

    // LÓGICA DEL BOTÓN DOS - ABRIR ACTIVITY 2 CON UN MÉTODO DEPRECATED

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 100 && resultCode == MainActivity.RESULT_OK){
            tvRespuesta.setText(data.getStringExtra(getString(R.string.mensaje)));
        }
    }
}