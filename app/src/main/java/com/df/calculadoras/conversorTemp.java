package com.df.calculadoras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class conversorTemp extends AppCompatActivity implements View.OnClickListener {

    Spinner valorConvertir1;
    Spinner valorConvertir2;
    Button calcularTemperatura;
    EditText valor;
    private String nombreUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversor_temp);
        Intent intent = getIntent();
        nombreUsuario = intent.getStringExtra("nombre");
        valorConvertir1 = findViewById(R.id.spinner1);
        valorConvertir2 = findViewById(R.id.spinner2);
        calcularTemperatura = findViewById(R.id.btnConvertir);
        valor = findViewById(R.id.TextValor);
        calcularTemperatura.setOnClickListener(this);
        Toast.makeText(this, "Bienvenido: " + nombreUsuario, Toast.LENGTH_SHORT).show();
    }

    public Double calcularTemperatura (double valor, String temp1, String temp2){
        double resultado = 0.0;
        switch (temp1){
            case "Celsius": {
                switch (temp2){
                    case "Celsius":{
                        resultado = valor;
                    }
                    case "Fahrenheit":{
                        resultado = (valor * 1.8) +32;
                    }
                    case "Kelvin":{
                        resultado = valor + 273.15;
                    }
                    case "Rankine":{
                        resultado = valor * 493.47;
                    }
                }
            }
            case "Fahrenheit":{
                switch (temp2){
                    case "Celsius":{
                        resultado = 0.55 * (valor - 32);
                    }
                    case "Fahrenheit":{
                        resultado = valor;
                    }
                    case "Kelvin":{
                        resultado = (valor - 32) * 0.55 + 273.15;
                    }
                    case "Rankine":{
                        resultado = valor * 459.67;
                    }
                }
            }
            case "Kelvin":{
                switch (temp2){
                    case "Celsius":{
                        resultado = valor - 213.15;
                    }
                    case "Fahrenheit":{
                        resultado = (valor - 273.15) * 14 + 32;
                    }
                    case "Kelvin":{
                        resultado = valor;
                    }
                    case "Rankine":{
                        resultado = valor * 0.6;
                    }
                }
            }
            case "Rankine":{
                switch (temp2){
                    case "Celsius":{
                        resultado = (valor - 491.67) * 0.55;
                    }
                    case "Fahrenheit":{
                        resultado = valor - 459.67;
                    }
                    case "Kelvin":{
                        resultado = valor * 0.55;
                    }
                    case "Rankine":{
                        resultado = valor;
                    }
                }
            }
        }
        return resultado;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnConvertir: {
                Double valorIng = Double.parseDouble(valor.getText().toString());
                String temperatura1 = valorConvertir1.getSelectedItem().toString();
                String temperatura2 = valorConvertir2.getSelectedItem().toString();
                Double calcTemp = calcularTemperatura(valorIng, temperatura1, temperatura2);
                Toast.makeText(this, "El valor es: " + calcTemp, Toast.LENGTH_LONG).show();
            }
        }
    }
}