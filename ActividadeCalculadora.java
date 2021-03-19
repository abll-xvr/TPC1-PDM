package mz.ac.isutc.tpc1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ActividadeCalculadora extends AppCompatActivity {
    private Button btTelaInicial_java, btCalcular_java;
    private EditText num1_java, num2_java;
    private TextView resultado_java;
    private RadioButton rdAdicao_java, rdSubtracao_java, rdDecimal, rdRomano;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_calculadora);

        btTelaInicial_java = findViewById(R.id.btIrTelaInicial);
        btCalcular_java = findViewById(R.id.btCalcular);
        num1_java = findViewById(R.id.txtNum1);
        num2_java = findViewById(R.id.txtNum2);
        rdAdicao_java = findViewById(R.id.rdAdicao);
        rdSubtracao_java = findViewById(R.id.rdSubtracao);
        resultado_java = findViewById(R.id.lblResultado);
        rdDecimal = findViewById(R.id.rdOpDecimal);
        rdRomano = findViewById(R.id.rdOpRomana);


        btTelaInicial_java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inicial = new Intent(getApplicationContext(), ActividadeTelaInicial.class);
                startActivity(inicial);
            }
        });
        btCalcular_java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rdAdicao_java.isChecked()) {
                    try {
                        int resultado = somar(Integer.parseInt(num1_java.getText().toString()), Integer.parseInt(num2_java.getText().toString()));
                        resultado_java.setText("" + resultado);
                    }catch (NullPointerException e) {
                        Toast.makeText(ActividadeCalculadora.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
                if (rdSubtracao_java.isChecked()) {
                    try {
                        int resultado = subtrair(Integer.parseInt(num1_java.getText().toString()), Integer.parseInt(num2_java.getText().toString()));
                        resultado_java.setText("" + resultado);
                    } catch (NullPointerException e) {
                        Toast.makeText(ActividadeCalculadora.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    public int somar(int num1, int num2) {
        int result = 0;
        if (rdRomano.isChecked()) {
            num1 = Integer.parseInt(num1_java.getText().toString());
            num2 = Integer.parseInt(num2_java.getText().toString());
            result = num1 + num2;
            StringBuilder temp = MainActivity.decimalParaRomano(result);
            result = Integer.parseInt(temp.toString());
        }
        if (rdDecimal.isChecked()) {
            result = num1 + num2;
        }
        return result;
    }

    public int subtrair(int num1, int num2) {
        int result = 0;
        if (rdRomano.isChecked()) {
            num1 = Integer.parseInt(num1_java.getText().toString());
            num2 = Integer.parseInt(num2_java.getText().toString());
            result = num1 - num2;
            StringBuilder temp = MainActivity.decimalParaRomano(result);
            result = Integer.parseInt(temp.toString());
        }
        if (rdDecimal.isChecked()) {
            result = num1 - num2;
        }
        return result;
    }
}
