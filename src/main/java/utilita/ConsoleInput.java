/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilita;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * rappresenta un dispositivo per acquisire dati di input di ciascun tipo nativo
 * e di tipo String dalla console di input, ossia dalla tastiera.
 * 
 * Ad esempio: 
 * ConsoleInput tastiera = new ConsoleInput();
 * tastiera.readString --> restituisce una stringa inserita con la tastiera
 * tastiera.readInt --> restituisce un int inserito con la tastiera
 * @author Studente
 */
public class ConsoleInput 
{
    private InputStreamReader reader;
    private BufferedReader tastiera;
    
    /**
     * Costruttore
     */
    public ConsoleInput()
    {
        reader = new InputStreamReader(System.in);
        tastiera = new BufferedReader(reader);
    }
    
    /**
     * Legge una stringa
     * @return una stringa
     * @throws IOException errore di input
     * @throws NumberFormatException input inserito non coerente 
     * viene inserito un valore che non è un numero intero 
     */
    public String readString() throws IOException, NumberFormatException
    {
        return tastiera.readLine();
    }
    
    /**
     * legge un intero
     * @return un intero
     * @throws IOException errore di input
     * @throws NumberFormatException input inserito non coerente 
     */
    public int readInt() throws IOException, NumberFormatException
    {
        String s = tastiera.readLine();
        int x = Integer.parseInt(s);
        return x;
    }
    
    /**
     * legge uno short 
     * @return uno short 
     * @throws IOException errore di input
     * @throws NumberFormatException input inserito non coerente 
     */
    public short readShort() throws IOException, NumberFormatException
    {
        return Short.parseShort(tastiera.readLine());
    }
    
    /**
     * legge un char 
     * @return un char
     * @throws IOException errore di input
     * @throws NumberFormatException input inserito non coerente 
     */
    public char readChar() throws IOException, NumberFormatException
    {
        return tastiera.readLine().charAt(0);
    }
    
    /**
     * legge un long
     * @return un long 
     * @throws IOException errore di input
     * @throws NumberFormatException input inserito non coerente 
     */
    public Long readLong() throws IOException, NumberFormatException
    {
        return Long.parseLong(tastiera.readLine());
    }
    
    public static LocalDate readLocalDate(ConsoleInput tastiera) throws IOException {
        String input = tastiera.readString();
        // Aggiungi qui la logica per convertire la stringa in LocalDate
        return null; // Modifica questo valore restituito
    }
    
    /**
     * legge un float
     * @return un float
     * @throws IOException errore di input
     * @throws NumberFormatException input inserito non coerente 
     */
    public float readFloat() throws IOException, NumberFormatException
    {
        return Float.parseFloat(tastiera.readLine());
    }
    
    /**
     * legge un double
     * @return un double 
     * @throws IOException errore di input
     * @throws NumberFormatException input inserito non coerente 
     */
    public double readDouble() throws IOException, NumberFormatException
    {
        return Double.parseDouble(tastiera.readLine());
    }
    
    /**
     * legge un boolean 
     * @return un boolean
     * @throws IOException errore di input
     * qualunque valore diverso da true restituisce false
     */
    public Boolean readBoolean() throws IOException, NumberFormatException
    {
        return Boolean.parseBoolean(tastiera.readLine());
    }
    
    /**
     * legge un byte
     * @return un byte
     * @throws IOException errore di input
     * @throws NumberFormatException input inserito non coerente 
     */
    public byte readByte() throws IOException, NumberFormatException
    {
        return Byte.parseByte(tastiera.readLine());
    }
}
