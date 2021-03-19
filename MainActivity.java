package mz.ac.isutc.tpc1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btConverter_java, btConversor_java2;
    private static TextView  txtResultado_java;
    private static EditText txtValor_java;
    private RadioButton rdDecimal, rdRomano;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_linear);

        btConverter_java = findViewById(R.id.btConverter2);
        txtValor_java = findViewById(R.id.txtNumero2);
        rdDecimal = findViewById(R.id.rdDecimal2);
        rdRomano = findViewById(R.id.rdRomano2);
        txtResultado_java= findViewById(R.id.txtValorConvertido);
        btConversor_java2=findViewById(R.id.btIrConversor);

        btConverter_java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rdDecimal.isChecked()) {
                    Toast.makeText(getApplicationContext(), "Decimal", Toast.LENGTH_SHORT).show();
                    int resultado = romanoParaDecimal(txtValor_java.getText().toString());
                    txtResultado_java.setText(""+resultado);

                }
                if (rdRomano.isChecked()){
                    Toast.makeText(getApplicationContext(), "Romano", Toast.LENGTH_SHORT).show();
                    StringBuilder resultado;
                    try {
                        resultado =  decimalParaRomano(Integer.parseInt(txtValor_java.getText().toString()));
                        txtResultado_java.setText(""+resultado);
                    } catch (NumberFormatException e) {
                        Toast.makeText(getApplicationContext(),e.getCause().toString(),Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
        btConversor_java2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent calculadora = new Intent(getApplicationContext(), ActividadeCalculadora.class);
                startActivity(calculadora);
            }
        });
    }

public static StringBuilder decimalParaRomano(int num) {

    int[] valores = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    String[] letrasRomanas = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

    StringBuilder romano = new StringBuilder();

    for(int i=0;i<valores.length;i++) {
        while(num >= valores[i]) {
            num -= valores[i];
            romano.append(letrasRomanas[i]);
        }
    }
    return  romano;
}
    public static int romanoParaDecimal(String romanNum) {
        int decimal = 0;
        int ultimoNumero = 0;
        String numeralRomano = romanNum.toUpperCase();
        for (int x = numeralRomano.length() - 1; x >= 0 ; x--) {
            char converterParaDecimal = numeralRomano.charAt(x);

            switch (converterParaDecimal) {
                case 'M':
                    decimal = processarDecimal(1000, ultimoNumero, decimal);
                    ultimoNumero = 1000;
                    break;

                case 'D':
                    decimal = processarDecimal(500, ultimoNumero, decimal);
                    ultimoNumero = 500;
                    break;

                case 'C':
                    decimal = processarDecimal(100, ultimoNumero, decimal);
                    ultimoNumero = 100;
                    break;

                case 'L':
                    decimal = processarDecimal(50, ultimoNumero, decimal);
                    ultimoNumero = 50;
                    break;

                case 'X':
                    decimal = processarDecimal(10, ultimoNumero, decimal);
                    ultimoNumero = 10;
                    break;

                case 'V':
                    decimal = processarDecimal(5, ultimoNumero, decimal);
                    ultimoNumero = 5;
                    break;

                case 'I':
                    decimal = processarDecimal(1, ultimoNumero, decimal);
                    ultimoNumero = 1;
                    break;
            }
        }
        return decimal;
    }

    public static int processarDecimal(int decimal, int lastNumber, int lastDecimal) {
        if (lastNumber > decimal) {
            return lastDecimal - decimal;
        } else {
            return lastDecimal + decimal;
        }
    }
}