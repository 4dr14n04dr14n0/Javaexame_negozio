package com.ariccardi;

import java.time.LocalDate;
import java.util.Objects;

public class ProdottoAlimentare extends Prodotto {
    private LocalDate dataScadenza;

    public ProdottoAlimentare(String nome, double prezzo, int quantita, LocalDate dataScadenza) {
        super(nome, prezzo, quantita);
        setDataScadenza(dataScadenza);
    }

    public LocalDate getDataScadenza() {
        return dataScadenza;
    }

    public void setDataScadenza(LocalDate dataScadenza) {
        Objects.requireNonNull(dataScadenza, "La data di scadenza non può essere nulla");
        this.dataScadenza = dataScadenza;
    }

    public boolean èScaduto() {
        return LocalDate.now().isAfter(dataScadenza);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Scadenza: %s, Stato: %s", 
                            dataScadenza, èScaduto() ? "SCADUTO" : "Valido");
    }
}
