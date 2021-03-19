package mz.ac.isutc.tpc1;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ActividadeTelaInicial extends AppCompatActivity {

    private Button btCalculadora_java, btConversor_java;

    @Override
    public void onCreate(Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_principal);

        btCalculadora_java=findViewById(R.id.btCalculad);
        btConversor_java=findViewById(R.id.btConversor);


        btCalculadora_java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent conversor = new Intent(getApplicationContext(),ActividadeCalculadora.class);
                startActivity(conversor);
            }
        });
        btConversor_java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent calculadora = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(calculadora);
            }
        });

    }
}
