package br.edu.fateczl;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import br.edu.fateczl.controller.MaiorMenor;

public class MainActivity extends AppCompatActivity {

    private EditText etNum1;
    private EditText etNum2;
    private Button btMaiorMenor;
    private Button btCalcular;
    private Button btLimpar;
    private TextView tvResultado;
    private TextView tvMaiorV;
    private TextView tvMenorV;
    private MaiorMenor cont = new MaiorMenor();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etNum1 = findViewById(R.id.etNum1);
        etNum2 = findViewById(R.id.etNum2);
        btMaiorMenor = findViewById(R.id.btMaior);
        btCalcular = findViewById(R.id.btCalcular);
        btLimpar = findViewById(R.id.btLimpar);
        tvResultado = findViewById(R.id.tvResultado);
        tvMaiorV = findViewById(R.id.tvMaiorV);
        tvMenorV = findViewById(R.id.tvMenorV);

        MaiorMenor cont = new MaiorMenor();

        btMaiorMenor.setOnClickListener(click -> setMaiorMenor());

        tvMaiorV.setVisibility(View.VISIBLE);
        tvMenorV.setVisibility(View.VISIBLE);

        btCalcular.setOnClickListener(click -> tvResultado.setText(cont.soma(etNum1, etNum2)));
        tvResultado.setVisibility(View.VISIBLE);

        btLimpar.setOnClickListener(click -> limpar());
    }
    public void setMaiorMenor(){
        tvMaiorV.setText(cont.verificaMaior(etNum1,etNum2));
        tvMenorV.setText(cont.verificaMenor(etNum1,etNum2));
    }

    private void limpar() {
        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);
        this.finish();
    }
}