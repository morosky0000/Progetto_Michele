/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.progettone_michele;

import eccezioni.EccezioneCodeNonPresente;
import eccezioni.FileException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilita.ConsoleInput;
import static utilita.ConsoleInput.readLocalDate;
import utilita.Menu;
import utilita.Ordinatore;

/**
 *
 * @author Studente
 */
public class Progettone_Michele {

    public static void main(String[] args) throws EccezioneCodeNonPresente 
    {
        
       String[] vociMenu;
        int numeroVoci=11;
        vociMenu=new String[numeroVoci];
        Menu menu;
        int voceScelta;
        NegozioIPhone n1=new NegozioIPhone(); 
        int esito;
        
        ConsoleInput tastiera = new ConsoleInput();
        String tipo = null,colore = null;
        int quantita = 0,anno = 0,mese = 0,giorno = 0,codice = 0,costo = 0;
        LocalDate dataAcquisto;
        IPhone iph;
        int ripiano, posizione;
        
        IPhone[] iPhonePresenti;
        String nomeFile = "volumi.CSV";
        String nomeFileBinario = "iPhone.bin";
        
        vociMenu[0]="\t--> Esci";
        vociMenu[1]="\t--> visulizza iPhone";
        vociMenu[2]="\t--> Aggiungi iPhone";
        vociMenu[3]="\t--> elimina iPhone ";
        vociMenu[4]="\t--> cerca iPhone codice";
        vociMenu[5]="\t--> ordina iPhone da quelo con la quantità più alta";
        vociMenu[6]="\t--> Esporta i volumi su file CSV";
        vociMenu[7]="\t--> importa i volumi su file CSV";
        vociMenu[8]="\t--> salva dati ";
        vociMenu[9]="\t--> carica dati ";
        
        menu=new Menu(vociMenu);
       
        
        //Gestione menu
        do
        {
            System.out.println("Menu:");
            voceScelta=menu.sceltaMenu();
            switch (voceScelta) 
            {
                            case 0: //esci
                                System.out.println("Arrivederci!");    
                                break;
                            case 1: //visualizza tutti
                                System.out.println(n1.toString());
                                break;
                            case 2: //aggiungi iPhone


                                    System.out.println("tipo --> ");
                                    {
                                        try {
                                            tipo=tastiera.readString();
                                        } catch (IOException ex) 
                                        {

                                        } catch (NumberFormatException ex) 
                                        {

                                        }
                                    }

                                    System.out.println("colore --> ");
                                        {
                                            try {
                                                colore=tastiera.readString();
                                            } catch (IOException ex) 
                                            {

                                            } catch (NumberFormatException ex) 
                                            {
                                            }
                                        }

                                    System.out.println("quantita --> ");
                                    {
                                        try {
                                            quantita=tastiera.readInt();
                                        } catch (IOException ex) 
                                        {

                                        } catch (NumberFormatException ex) 
                                        {

                                        }
                                    }
                                    System.out.println("costo --> ");
                                    {
                                        try {
                                            costo=tastiera.readInt();
                                        } catch (IOException ex) 
                                        {

                                        } catch (NumberFormatException ex) 
                                        {

                                        }
                                    }
                                    System.out.println("inserisci l'anno di acquisto");
                                    {
                                        try {
                                            anno=tastiera.readInt();
                                        } catch (IOException ex) 
                                        {

                                        } catch (NumberFormatException ex) 
                                        {

                                        }
                                    }
                                    System.out.println("inserisci il mese di acquisto");
                                    {
                                        try {
                                            mese=tastiera.readInt();
                                        } catch (IOException ex) 
                                        {

                                        } catch (NumberFormatException ex) 
                                        {

                                        }
                                    }
                                    System.out.println("inserisci il giorno di acquisto");
                                    {
                                        try {
                                            giorno=tastiera.readInt();
                                        } catch (IOException ex) 
                                        {

                                        } catch (NumberFormatException ex) 
                                        {

                                        }
                                    }


                                    codice++;
                                    IPhone iPhone= new IPhone(tipo, colore, quantita, anno, mese, giorno, costo,codice);
                                    n1.aggiungiIPhone(iPhone);
                                    System.out.println("iPhone aggiunto");
                                    break;       
                            case 3: //elimina personaggio
                                int e;
                                System.out.println("codice");
                            {
                                try {
                                    codice=tastiera.readInt();
                                } catch (IOException ex) 
                                {

                                    

                                } catch (NumberFormatException ex) 
                                {

                                }
                            }
                                e=n1.eliminaIPhone(codice);
                                if(e==0)
                                    System.out.println("iPhone eliminato correttamente");
                                else
                                    System.out.println("non è stato tolto nessun iPhone");
                                break;

                            case 4: //cerca personaggio con codice
                                System.out.println("inserisci il codice");
                            {
                                try {
                                    codice=tastiera.readInt();
                                } catch (IOException ex) 
                                {

                                } catch (NumberFormatException ex) 
                                {

                                }
                            }
                                IPhone codiceTrovato =n1.cercaIPhone(codice);
                                if (codiceTrovato != null) 
                                        {
                                            System.out.println("codice trovato");
                                            System.out.println(codiceTrovato);
                                        } else 
                                        {
                                            System.out.println("codice non trovato");
                                        }

                                break;
                    
                            case 5: //ordina pr quantita maggiore

                                IPhone[] iphoneOrdine = Ordinatore.selectionSortPerQuantitaDecrescente(n1.getIPhone());
                                System.out.println("iPhone ordinati per quantità più alta:");
                                for (int i = 0; i < iphoneOrdine.length; i++)
                                {
                                    IPhone iphone = iphoneOrdine[i];
                                    System.out.println(iphone);
                                }     


                                break;

                            case 6:
                                // Esportazione CSV
                                System.out.print("Inserisci il nome del CSV da esportare");
                                String nomeFileC=null;
                                try {
                                    nomeFileC = tastiera.readString();
                                } catch (IOException ex) {

                                } catch (NumberFormatException ex) {

                                }

                                {
                                    try {
                                        n1.esportaCSV(nomeFileC);
                                    } catch (IOException ex) {
                                        
                                    } catch (FileException ex) {
                                        
                                    }
                                }
                                System.out.println("Esportazione");
                                break;


                            case 7:
                                // Importazione CSV
                                System.out.print("Inserisci il nome del file CSV da importare  ");
                                String nomeFileI = null;
                                try {
                                    nomeFileI = tastiera.readString();
                                } catch (IOException ex) {

                                } catch (NumberFormatException ex) {

                                }

                                try {
                                    n1.importaCSV(nomeFileI);
                                } catch (IOException ex) {

                                }
                                System.out.println("Importazione");
                                break;


                            case 8:
                            try
                                {

                                    n1.salvaNegozio(nomeFileBinario);
                                    System.out.println("Salvataggio avvenuto correttamente");
                                } 
                                catch (IOException ex) 
                                {
                                    System.out.println("Impossibile salvare su file");
                                }
                                break;
                            case 9: 
                                try 
                                {
                                    
                                    n1=n1.caricaNegozio(nomeFileBinario);
                                    System.out.println("Caricamento avvenuto con successo");
                                } 
                                catch (IOException ex) 
                                {
                                    System.out.println("Impossibile leggere da file");
                                } 
                                catch (ClassNotFoundException ex) 
                                {
                                    System.out.println("Impossibile leggere i dati del videogioco");
                                }

                                break;
                
            }
            
        
        }while(voceScelta != 0);
    }
}
