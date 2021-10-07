package com.example.bancodevacinas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CadastroVacina extends AppCompatActivity {
    private EditText edtVacinaId, edtNomeVacina, edtFabricante;
    private Button btnVariavel;
    Vacina vacina, altVacina;
    Vacina VacinaHelper;
    long retornoBD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_vacina);

        Intent it = getIntent();
        altVacina = (Vacina) it.getSerializableExtra("chave_contato");

        vacina = new Vacina();
        VacinaHelper = new Vacina(CadastroVacina.this);

        edtVacinaId = findViewById(R.id.edtVacinaId);
        edtNomeVacina = findViewById(R.id.edtNomeVacina);
        edtFabricante = findViewById(R.id.edtFabricante);
        btnVariavel = findViewById(R.id.btnVariavel);

        if (altVacina != null) {
            btnVariavel.setText("ALTERAR");
            edtNomeVacina.setText(altVacina.getNomeVacina());
            edtVacinaId.setText(altVacina.getVacinaId()+ "");
            edtFabricante.setText(altVacina.getFabricante());
            // vacina.setId(altVacina.getId());
        } else {
            btnVariavel.setText("SALVAR");
        }
        btnVariavel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String VACINAID = edtVacinaId.getText().toString();
                String NOMEVACINA = edtNomeVacina.getText().toString();
                String FABRICANTE = edtFabricante.getText().toString();

                long retornoBD;
                vacina.setVacinaId(VACINAID);
                vacina.setNomeVacina(NOMEVACINA);
                vacina.setFabricante(FABRICANTE);
                if (btnVariavel.getText().toString().equals("SALVAR")) {
                    retornoBD = VacinaHelper.insert_Vacina(vacina);
                    if (retornoBD == -1) {
                        alert("Erro ao Cadastrar!");
                    } else {
                        alert("Cadastro realizado com sucesso!");
                    }
                } else {
                    VacinaHelper.updateVacina(vacina);
                    VacinaHelper.close();
                }
                finish();
            }
        });
    }
    private void alert(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}


