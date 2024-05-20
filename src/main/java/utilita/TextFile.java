/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilita;

import eccezioni.FileException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Rappresenta un file di testo.
 * Consente di scrivere sul file di testo e di leggere dal file di testo.
 * 
 * @author Nicola
 */
public class TextFile {
    private char mode;
    private BufferedReader reader;
    private BufferedWriter writer;

    /**
     * Costruttore
     * 
     * @param fileName pathname del file fisico da aprire
     * @param mode indica la modalità di apertura del file. 
     *             Può assumere due valori: 'W' (apertura in scrittura) e 'R' (apertura in lettura). 
     *             Qualsiasi altro valore assegnato a questo parametro farà sì che il file venga aperto in lettura.
     * @throws FileNotFoundException sollevata quando il file non viene trovato
     * @throws IOException sollevata quando non è possibile accedere al file
     */
    public TextFile(String fileName, char mode) throws FileNotFoundException, IOException {
        this.mode = 'R';
        if (mode == 'W' || mode == 'w') {
            this.mode = 'W';
        }

        if (this.mode == 'R') {
            reader = new BufferedReader(new FileReader(fileName));
        } else {
            writer = new BufferedWriter(new FileWriter(fileName));
        }
    }

    /**
     * Costruttore
     * 
     * @param fileName pathname del file fisico da aprire
     * @param mode indica la modalità di apertura del file. 
     *             Può assumere due valori: 'W' (apertura in scrittura) e 'R' (apertura in lettura). 
     *             Qualsiasi altro valore assegnato a questo parametro farà sì che il file venga aperto in lettura.
     * @param append specifica se il file, quando è aperto in scrittura, è aperto in append o no.
     *               Valore true = aperto in append, valore false = aperto non in append.
     * @throws FileNotFoundException sollevata quando il file non viene trovato
     * @throws IOException sollevata quando non è possibile accedere al file
     */
    public TextFile(String fileName, char mode, boolean append) throws FileNotFoundException, IOException {
        this.mode = 'R';
        if (mode == 'W' || mode == 'w') {
            this.mode = 'W';
        }

        if (this.mode == 'R') {
            reader = new BufferedReader(new FileReader(fileName));
        } else {
            writer = new BufferedWriter(new FileWriter(fileName, append));
        }
    }

    /**
     * Scrive una stringa sul file aperto in scrittura
     * 
     * @param line stringa da scrivere
     * @throws FileException quando il file è aperto in lettura anziché in scrittura
     * @throws IOException sollevata quando non è possibile accedere al file
     */
    public void toFile(String line) throws FileException, IOException {
        if (mode == 'R') {
            throw new FileException("Il file è aperto in lettura!");
        }
        writer.write(line);
        writer.newLine();
    }

    /**
     * Legge una stringa da un file aperto in lettura
     * 
     * @return stringa letta
     * @throws FileException viene sollevata quando il file è aperto in scrittura anziché in lettura,
     *                       o quando sono state lette tutte le righe
     * @throws IOException sollevata quando non è possibile accedere al file
     */
    public String fromFile() throws FileException, IOException {
        if (mode == 'W') {
            throw new FileException("Il file è aperto in scrittura!");
        }
        String line = reader.readLine();
        if (line == null) {
            throw new FileException("Fine del file");
        }
        return line;
    }

    /**
     * Chiude il file
     * 
     * @throws IOException sollevata quando non è possibile accedere al file
     */
    public void close() throws IOException {
        if (mode == 'R') {
            reader.close();
        } else {
            writer.close();
        }
    }
}
