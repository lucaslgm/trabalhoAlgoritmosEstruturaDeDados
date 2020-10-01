package Entities;

import Lists.ArrayListOfAcidente;

public class Street {
    String nome;
    ArrayListOfAcidente acidentes;

    public Street(String nome, ArrayListOfAcidente acidentes) {
        this.nome = nome;
        this.acidentes = acidentes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayListOfAcidente getAcidentes() {
        return acidentes;
    }

    public void setAcidentes(ArrayListOfAcidente acidentes) {
        this.acidentes = acidentes;
    }
}
