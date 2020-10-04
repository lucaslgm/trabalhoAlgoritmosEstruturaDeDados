package Entities;

import Lists.LinkedListOfAcidentes;

public class Street {
    String nome;
    LinkedListOfAcidentes acidentes;

    public Street(String nome, LinkedListOfAcidentes acidentes) {
        this.nome = nome;
        this.acidentes = acidentes;
    }
    public Street() {
        this.acidentes = new LinkedListOfAcidentes();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LinkedListOfAcidentes getAcidentes() {
        return acidentes;
    }

    public void setAcidentes(LinkedListOfAcidentes acidentes) {
        this.acidentes = acidentes;
    }
}
