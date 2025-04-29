package com.ariccardi;

import java.util.Objects;

public class Prodotto {
    private String nome;
    private double prezzo;
    private int quantita;

    public Prodotto(String nome, double prezzo, int quantita) {
        setNome(nome);
        setPrezzo(prezzo);
        setQuantita(quantita);
    }

    // Getter e Setter con controlli
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        Objects.requireNonNull(nome, "Il nome non può essere nullo");
        this.nome = nome;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        if (prezzo <= 0) {
            throw new IllegalArgumentException("Il prezzo deve essere positivo");
        }
        this.prezzo = prezzo;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        if (quantita < 0) {
            throw new IllegalArgumentException("La quantità non può essere negativa");
        }
        this.quantita = quantita;
    }

    public double calcolaValoreTotale() {
        return prezzo * quantita;
    }

    @Override
    public String toString() {
        return String.format("Prodotto: %s, Prezzo: %.2f€, Quantità: %d, Valore totale: %.2f€", 
                            nome, prezzo, quantita, calcolaValoreTotale());
    }
}