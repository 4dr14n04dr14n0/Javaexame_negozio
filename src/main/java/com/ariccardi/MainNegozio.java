package com.ariccardi;

import java.time.LocalDate;
import java.util.Scanner;

public class MainNegozio {
    public static void main(String[] args) {
        Negozio negozio = new Negozio();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== MENU NEGOZIO ===");
            System.out.println("1. Inserisci prodotto");
            System.out.println("2. Visualizza prodotti");
            System.out.println("3. Calcola valore totale negozio");
            System.out.println("4. Esci");
            System.out.print("Scelta: ");

            int scelta = scanner.nextInt();
            scanner.nextLine(); // Consuma il newline

            switch (scelta) {
                case 1:
                    inserisciProdotto(negozio, scanner);
                    break;
                case 2:
                    negozio.mostraProdotti();
                    break;
                case 3:
                    System.out.printf("Valore totale inventario: %.2f€\n", negozio.valoreInventario());
                    break;
                case 4:
                    System.out.println("Arrivederci!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Scelta non valida!");
            }
        }
    }

    private static void inserisciProdotto(Negozio negozio, Scanner scanner) {
        System.out.print("Tipo prodotto (1-Normale / 2-Alimentare): ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Prezzo: ");
        double prezzo = scanner.nextDouble();

        System.out.print("Quantità: ");
        int quantita = scanner.nextInt();

        if (tipo == 1) {
            negozio.aggiungiProdotto(new Prodotto(nome, prezzo, quantita));
        } else {
            System.out.print("Anno scadenza: ");
            int anno = scanner.nextInt();
            System.out.print("Mese scadenza: ");
            int mese = scanner.nextInt();
            System.out.print("Giorno scadenza: ");
            int giorno = scanner.nextInt();
            LocalDate scadenza = LocalDate.of(anno, mese, giorno);
            negozio.aggiungiProdotto(new ProdottoAlimentare(nome, prezzo, quantita, scadenza));
        }
        System.out.println("Prodotto aggiunto con successo!");
    }
}