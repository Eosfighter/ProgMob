package com.example.bancodevacinas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CadastroVacinados {
    public class CadastroVacina extends AppCompatActivity {
        private EditText edtNumVacinados, edtVacinaId, edtNomePessoa, edtCpf, edtIdade;
        private Button btnVariavel;
        Vacinados vacinados, altVacinados;
        Vacinados VacinadosHelper;
        long retornoBD;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_cadastro_vacinados);

            Intent it = getIntent();
            altVacinados = (Vacinados) it.getSerializableExtra("chave_contato");

            vacinados = new Vacinados();
            VacinadosHelper = new Vacina(com.example.bancodevacinas.CadastroVacinados.this);

            edtNumVacinados = findViewById(R.id.edtNumVacinados);
            edtVacinaId = findViewById(R.id.edtVacinaId);
            edtNomePessoa = findViewById(R.id.edtNomePessoa);
            edtCpf = findViewById(R.id.edtCpf);
            edtIdade = findViewById(R.id.edtIdade);
            btnVariavel = findViewById(R.id.btnVariavel);

            if (altVacinados != null) {
                btnVariavel.setText("ALTERAR");
                edtNumVacinados.setText(altVacinados.getNumVacinado());
                edtVacinaId.setText(altVacinados.getVacinaId() + "");
                edtNomePessoa.setText(altVacinados.getNomePessoa());
                edtCpf.setText(altVacinados.getCpf());
                edtIdade.setText(altVacinados.getIdade());
                // vacina.setId(altVacina.getId());
            } else {
                btnVariavel.setText("SALVAR");
            }
            btnVariavel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String NUMVACINADOS = edtNumVacinados.getText().toString();
                    String VACINAID = edtVacinaId.getText().toString();
                    String NOMEPESSOA = edtNomePessoa.getText().toString();
                    String CPF = edtCpf.getText().toString();
                    String IDADE = edtIdade.getText().toString();

                    long retornoBD;
                    vacinados.setNumVacinado(NUMVACINADOS);
                    vacinados.setVacinaId(VACINAID);
                    vacinados.setNomePessoa(NOMEPESSOA);
                    vacinados.setCpf(CPF);
                    vacinados.setIdade(IDADE);
                    if (btnVariavel.getText().toString().equals("SALVAR")) {
                        retornoBD = VacinadosHelper.insert_Vacinados(vacinados);
                        if (retornoBD == -1) {
                            alert("Erro ao Cadastrar!");
                        } else {
                            alert("Cadastro realizado com sucesso!");
                        }
                    } else {
                        VacinadosHelper.updateVacinados(vacinados);
                        VacinadosHelper.close();
                    }
                    finish();
                }
            });
        }
        private void alert(String s) {
            Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
        }
    }


