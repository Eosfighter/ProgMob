package com.example.bancodevacinas;

import java.io.Serializable;

public class Vacinados implements Serializable {

    private int numVacinado;
    private int vacinaId;
    private String nomePessoa;
    private String cpf;
    private int idade;

    public int getNumVacinado() {
        return numVacinado;
    }

    public void setNumVacinado(int numVacinado) {
        this.numVacinado = numVacinado;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public int getVacinaId() {
        return vacinaId;
    }

    public void setVacinaId(int vacinaId) {
        this.vacinaId = vacinaId;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
