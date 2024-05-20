package com.mycompany.progettone_michele;

import eccezioni.EccezioneCodeNonPresente;
import eccezioni.FileException;
import java.io.*;
import utilita.ConsoleInput;
import utilita.Menu;
import utilita.Ordinatore;
import utilita.TextFile;

/**
 * La classe NegozioIPhone rappresenta un negozio di iPhone.
 * Implementa la serializzazione per la memorizzazione su file.
 */
public class NegozioIPhone implements Serializable {
    
    private IPhone[] elencoIPhone;
    private final int N_MAX_IPHONE = 20;
    private int nIPhonePresenti;

    /**
     * Costruttore predefinito che inizializza un nuovo NegozioIPhone con un array di iPhone vuoto.
     */
    public NegozioIPhone() {
        elencoIPhone = new IPhone[N_MAX_IPHONE];
        nIPhonePresenti = 0;
    }

    /**
     * Costruttore di copia che crea un nuovo NegozioIPhone copiando gli iPhone da un altro negozio.
     * 
     * @param negozio L'oggetto NegozioIPhone da copiare.
     */
    public NegozioIPhone(NegozioIPhone negozio) {
        this();
        for (int i = 0; i < negozio.nIPhonePresenti; i++) {
            this.elencoIPhone[i] = new IPhone(negozio.elencoIPhone[i]);
        }
        this.nIPhonePresenti = negozio.nIPhonePresenti;
    }

    public IPhone[] getIPhone() {
        return elencoIPhone;
    }

    public int getNIPhonePresenti() {
        return nIPhonePresenti;
    }

    public int getN_MAX_IPHONE() {
        return N_MAX_IPHONE;
    }

    /**
     * Restituisce l'iPhone con il codice specificato.
     * 
     * @param code Il codice dell'iPhone da cercare.
     * @return L'iPhone con il codice specificato.
     * @throws EccezioneCodeNonPresente se l'iPhone con il codice specificato non è presente nel negozio.
     */
    public IPhone getIPhone(int code) throws EccezioneCodeNonPresente {
        IPhone iphone;
        for (int i = 0; i < nIPhonePresenti; i++) {
            if (elencoIPhone[i].getCodice() == code) {
                iphone = new IPhone(elencoIPhone[i]);
                return iphone;
            }
        }
        throw new EccezioneCodeNonPresente();
    }

    /**
     * Aggiunge un nuovo iPhone al negozio.
     * 
     * @param ip L'iPhone da aggiungere.
     * @return 0 se l'iPhone è stato aggiunto con successo, -1 se il negozio è pieno.
     */
    public int aggiungiIPhone(IPhone ip) {
        if (nIPhonePresenti >= N_MAX_IPHONE) {
            return -1;
        } else {
            elencoIPhone[nIPhonePresenti] = new IPhone(ip);
            nIPhonePresenti++;
            return 0;
        }
    }

    /**
     * Cerca un iPhone nel negozio con il codice specificato.
     * 
     * @param codiceDaCercare Il codice dell'iPhone da cercare.
     * @return L'iPhone con il codice specificato, o null se non è stato trovato.
     */
    public IPhone cercaIPhone(int codiceDaCercare) {
        for (int i = 0; i < N_MAX_IPHONE; i++) {
            try {
                if (elencoIPhone[i].getCodice() == codiceDaCercare) {
                    return new IPhone(elencoIPhone[i]);
                }
            } catch (NullPointerException e) {
                System.out.println("");
            }
        }
        return null;
    }

    /**
     * Elimina un iPhone dal negozio in base alla sua posizione nell'array.
     * 
     * @param pos La posizione dell'iPhone da eliminare.
     */
    public void eliminaIPhonePosizione(int pos) {
        for (int i = pos; i < nIPhonePresenti - 1; i++) {
            elencoIPhone[i] = elencoIPhone[i + 1];
        }
        elencoIPhone[nIPhonePresenti] = null;
        nIPhonePresenti--;
    }

    /**
     * Elimina un iPhone dal negozio in base al suo codice.
     * 
     * @param codiceDaEliminare Il codice dell'iPhone da eliminare.
     * @return 0 se l'iPhone è stato eliminato con successo, -1 se l'iPhone non è stato trovato.
     */
    public int eliminaIPhone(long codiceDaEliminare) {
        for (int i = 0; i < nIPhonePresenti; i++) {
            if (elencoIPhone[i].getCodice() == codiceDaEliminare) {
                eliminaIPhonePosizione(i);
                return 0;
            }
        }
        return -1;
    }

    /**
     * Esporta i dati degli iPhone presenti nel negozio in un file CSV.
     * 
     * @param fileName Il nome del file CSV di destinazione.
     * @throws IOException Se si verifica un errore di I/O durante l'esportazione.
     * @throws FileException Se si verifica un errore generico durante l'operazione di file.
     */
    public void esportaCSV(String fileName) throws IOException, FileException {
        TextFile f1 = new TextFile(fileName, 'W');
        IPhone iphone;
        String datiIPhone;

        for (int i = 0; i < N_MAX_IPHONE; i++) {
            if (elencoIPhone[i] != null) {
                iphone = elencoIPhone[i];
                datiIPhone = iphone.getCodice() + ";" + iphone.getTipo() + ";" + iphone.getColore() + ";" + iphone.getCosto() + ";" + iphone.getDataAcquisto() + ";" + iphone.getQuantita();
                f1.toFile(datiIPhone);
            }
        }
        f1.close();
    }

    /**
     * Importa i dati degli iPhone da un file CSV e aggiunge gli iPhone al negozio.
     * 
     * @param fileName Il nome del file CSV da cui importare i dati degli iPhone.
     * @throws IOException Se si verifica un errore di I/O durante l'importazione.
     */
    public void importaCSV(String fileName) throws IOException {
        TextFile f1 = new TextFile(fileName, 'R');
        String rigaLetta;
        String[] datiIPhone;
        String modello, colore;
        int codice, quantita, prezzo, anno, mese, giorno;
        IPhone iphone;

        try {
            while (true) {
                rigaLetta = f1.fromFile();
                datiIPhone = rigaLetta.split(";");

                modello = datiIPhone[0];
                colore = datiIPhone[1];
                quantita = Integer.parseInt(datiIPhone[2]);
                anno = Integer.parseInt(datiIPhone[3]);
                mese = Integer.parseInt(datiIPhone[4]);
                giorno = Integer.parseInt(datiIPhone[5]);
                prezzo = Integer.parseInt(datiIPhone[6]);
                codice = Integer.parseInt(datiIPhone[7]);

                iphone = new IPhone(modello, colore, quantita, anno, mese, giorno, prezzo, codice);

                try {
                    aggiungiIPhone(iphone);
                } catch (ArrayIndexOutOfBoundsException ex) {
                    // Ignora l'iPhone se il numero massimo di iPhone è stato raggiunto
                }
            }
        } catch (FileException ex) {
            // Fine del file di testo
            f1.close();
        }
    }

    /**
     * Salva lo stato corrente del negozio in un file specificato.
     * 
     * @param fileName Il nome del file in cui salvare lo stato del negozio.
     * @throws FileNotFoundException Se il file specificato non è trovato.
     * @throws IOException Se si verifica un errore durante la scrittura del file.
     */
    public void salvaNegozio(String fileName) throws FileNotFoundException, IOException {
        ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(fileName));
        writer.writeObject(this);
        writer.flush();
        writer.close();
    }

    /**
     * Carica lo stato di un negozio da un file specificato.
     * 
     * @param fileName Il nome del file da cui caricare lo stato del negozio.
     * @return Un oggetto NegozioIPhone con lo stato caricato.
     * @throws FileNotFoundException Se il file specificato non è trovato.
     * @throws IOException Se si verifica un errore durante la lettura del file.
     * @throws ClassNotFoundException Se la classe dell'oggetto letto non può essere trovata.
     */
    public NegozioIPhone caricaNegozio(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException {
        NegozioIPhone n1;
        ObjectInputStream reader = new ObjectInputStream(new FileInputStream(fileName));
       n1 = (NegozioIPhone) reader.readObject();
       reader.close();
       return n1;
    } 
     
     public String toString()
     {
        String s="";
        for(int i=0; i<nIPhonePresenti;i++)
        {
            s=s+elencoIPhone[i].toString()+"\n";
            
        }
        return s;
     }
     
    
}

       
