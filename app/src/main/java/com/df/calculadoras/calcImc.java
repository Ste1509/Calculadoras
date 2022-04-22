package com.df.calculadoras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class calcImc extends AppCompatActivity implements View.OnClickListener {

    ImageView imagenEstado;
    EditText txtAltura;
    EditText txtPeso;
    Button btnCalcularimc;
    TextView txtResultado;
    private String nombreUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_imc);
        Intent intent = getIntent();
        nombreUsuario = intent.getStringExtra("nombre");
        txtPeso = findViewById(R.id.editTextPeso);
        txtAltura = findViewById(R.id.editTextAltura);
        btnCalcularimc = findViewById(R.id.btnCalcular);
        btnCalcularimc.setOnClickListener(this);
        Toast.makeText(this, "Bienvenido: " + nombreUsuario, Toast.LENGTH_SHORT).show();
    }

    public Double calcularImcdouble(double peso, double altura){
        double imc = 0;
        imc = peso / (altura*altura);
        return imc;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCalcular: {
                Double peso = Double.parseDouble(txtPeso.getText().toString());
                Double altura = Double.parseDouble(txtAltura.getText().toString());
                Double imc = calcularImcdouble(peso, altura);
                Toast.makeText(this, "Su imc es: " + imc, Toast.LENGTH_LONG).show();

            }
        }
    }
}