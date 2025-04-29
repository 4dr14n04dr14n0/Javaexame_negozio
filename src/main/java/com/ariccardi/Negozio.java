package com.ariccardi;

public class Negozio {
    private Prodotto[] scaffale;
    private int dimensione;

    public Negozio() {
        scaffale = new Prodotto[50];
        dimensione = 0;
    }

    public void aggiungiProdotto(Prodotto p) {
        if (dimensione >= scaffale.length) {
            throw new IllegalStateException("Scaffale pieno!");
        }
        scaffale[dimensione++] = p;
    }

    public double valoreInventario() {
        double totale = 0;
        for (int i = 0; i < dimensione; i++) {
            totale += scaffale[i].calcolaValoreTotale();
        }
        return totale;
    }

    public void mostraProdotti() {
        for (int i = 0; i < dimensione; i++) {
            System.out.println(scaffale[i].toString());
        }
    }
}