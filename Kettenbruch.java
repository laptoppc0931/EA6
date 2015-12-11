/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EA6;

/**
 *
 * @author v990461
 */
public class Kettenbruch {

    // die lineare Darstellung des Kettenbruchs
    private int[] werte;

    /**
     * erzeugt einen Kettenbruch aus der linearen Darstellung
     *
     * @param werte
     */
    public Kettenbruch(int[] werte) {
        this.werte = werte;
    }

    /**
     * berechnet rekursiv den Wert des Kettenbruchs
     *
     * @return den rekursiv berechneten Wert des Kettenbruchs, bei fehlenden
     * Werten 0
     */
    public double werteRekursivAus() {
        if (werte.length == 0) {
            return 0;
        } else {
        return werteRekursivAus(werte, werte.length, 0.0);
        }
    }

    /**
     * berechnet iterativ den Wert des Kettenbruchs
     *
     * @return den iterativ berechneten Wert des Kettenbruchs, bei fehlenden
     * Werten 0
     */
    public double werteIterativAus() {
        if (werte.length == 0) {
            return 0;
        }
        double erg = 0;
        for (int i = werte.length - 1; i >= 1; i--) {
            erg = (double) 1 / (werte[i] + erg);
        }
        return erg += werte[0];
    }

    /**
     * approximiert den Wert der Quadratwurzel von 2 mit Hilfe der
     * Kettenbruchdarstellung mit n Elementen
     *
     * @param n die Anzahl der fuer die Approximation verwendeten Elemente
     * @return der approximierte Wert von Wurzel 2
     */
    public static double approximiereWurzel2(int n) {
        //int[] wurzel = new int[n];
        int[] wurzel = berechneWurzel2Folge(n);
        Kettenbruch square = new Kettenbruch(wurzel);
        return square.werteRekursivAus();
        }

    /**
     * approximiert den Wert der eulerschen Zahl mit Hilfe der
     * Kettenbruchdarstellung mit n Elementen
     *
     * @param n die Anzahl der fuer die Approximation verwendeten Elemente
     * @return der approximierte Wert fuer die eulersche Zahl
     */
    public static double approximiereE(int n) {
        // TODO
        return 0;
    }

    /**
     * berechnet die Folge fuer die Kettenbruch-Darstellung der Quadratwurzel
     * von 2 mit den ersten n Elementen
     *
     * @param n die Anzahl der Elemente
     * @return die Folge als Array, bei n <= 0 ein leeres Array
     */
    public static int[] berechneWurzel2Folge(int n) {
        int [] elemente = new int[n];
        // bei n >= 1 
        if (n >= 1) {
            elemente[0] = 1;
            for (int i = 1; i < n; i++) {
                elemente[i] = 2;
            }
        }   
        return elemente;
    }

    /**
     * berechnet die Folge fuer die Kettenbruch-Darstellung der eulerschen Zahl
     * mit den ersten n Elementen
     *
     * @param n die Anzahl der Elemente
     * @return die Folge als Array, bei n <= 0 ein leeres Array
     */
    public static int[] berechneEFolge(int n) {
        int [] elemente = new int[n];
        // bei n >= 1 werden zuerst alle Elemente mit 1 gefüllt
        if (n >= 1) {
            elemente[0] = 2;
            for (int i = 1; i < n; i++) {
                elemente[i] = elemente[0];
            }
            // Falls das Array größer als 5 werder die Werte auf dem index 5, 8, 11 usw.
            // mit einem im Vergelich zu j-2 um 2 erhöhten Wert gefüllt
            for (int j = 5; j < elemente.length; j++) {
                elemente[j] = elemente[j-2] + 2;
                j++;
            }
            // Index 2 berichtigen
        if (n == 2) {
            elemente[n] = elemente [0];
        }    
        }   
        return elemente;
    }

    private double werteRekursivAus(int[] werte, int steps, double init) {
        // Basisfall: Nur ein Wert im Array vorhanden
        if (werte.length == 1) {
            return (double) werte[0];
        }
        // Rekursion
        if (steps > 1) {
           // Vor dem Aufruf ist 
           init = Kettenbruch(werte[steps-1] + init);
           // rekursiver Aufruf mit letzter-1 und dem berechneten Nachkommastellen
           return werteRekursivAus(werte, steps-1, init);
        }
        // Der Wert des Array bei Index = 0 ist mit den bisherigen 
        return (double) werte[0] + init;
    }
    
    private double Kettenbruch(double zahl) {
        double erg;
        // Berechne den Quotien aus 1 und (b[letzter]+Kettenbruch)
        erg = (double) 1 / zahl;
        return erg;
    }

} // EOF
