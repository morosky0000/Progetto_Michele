/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progettone_michele;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

/**
 *
 * @author Studente
 */
public class IPhone {
     private String tipo;
    private String colore;
    private int quantita;
    private LocalDate dataAcquisto;
    private int costo;
    
    private int codice;
    
    /**
     * Costruttore per creare un nuovo oggetto IPhone con i dati forniti.
     * @param tipo Il tipo di iPhone.
     * @param colore Il colore dell'iPhone.
     * @param quantita La quantità di iPhone disponibili.
     * @param anno L'anno di acquisto dell'iPhone.
     * @param mese Il mese di acquisto dell'iPhone.
     * @param giorno Il giorno di acquisto dell'iPhone.
     * @param costo Il costo dell'iPhone.
     * @param codice Il codice identificativo dell'iPhone.
     */
    

    public IPhone(String tipo, String colore, int quantita,int anno, int mese, int giorno, int costo,int codice) 
    {
        this.codice=codice;
        this.tipo = tipo;
        this.colore = colore;
        this.quantita = quantita;
        dataAcquisto = LocalDate.of(anno,mese, giorno);
        this.costo = costo;
    }

    public IPhone(IPhone ip) 
    {
        this.tipo=ip.getTipo();
        this.colore=ip.getColore();
        this.quantita=ip.getQuantita();
        this.costo=ip.getCosto();
        this.codice=ip.getCodice();
        this.dataAcquisto=ip.getDataAcquisto();
    }
    /**
     * Restituisce la data di acquisto dell'iPhone.
     * @return La data di acquisto dell'iPhone.
     */
    public LocalDate getDataAcquisto()
    {
        return this.dataAcquisto;
    }

    public String getTipo() 
    {
        return tipo;
    }
    public void setCodice(int codice)
    {
        this.codice=codice;
    }
    public void setTipo(String tipo) 
    {
        this.tipo = tipo;
    }

    public String getColore() 
    {
        return colore;
    }

    public void setColore(String colore) 
    {
        this.colore = colore;
    }

    public int getQuantita() 
    {
        return quantita;
    }

    public void setQuantita(int quantita) 
    {
        this.quantita = quantita;
    }

    public int getCosto() 
    {
        return costo;
    }

    public void setCosto(int costo) 
    {
        this.costo = costo;
    }

    public int getCodice() {
        return codice;
    }
    
    public void setDataAcquisto(LocalDate dataAcquisto)
    {
        this.dataAcquisto=dataAcquisto;
    }
    
    /**
     * Restituisce una stringa che rappresenta l'oggetto IPhone.
     * @return Una stringa che rappresenta l'oggetto IPhone.
     */
    @Override
    public String toString() {
        return "IPhone{" + "tipo=" + tipo + ", colore=" + colore + ", quantita=" + quantita + ", dataAcquisto=" + dataAcquisto + ", costo=" + costo + ", codice=" + codice + '}';
    }
    /**
    * Determina se l'oggetto specificato è uguale all'oggetto IPhone corrente.
     * Due oggetti IPhone sono considerati uguali se hanno lo stesso tipo, colore, quantità e data di acquisto.
     * @param o L'oggetto da confrontare con l'oggetto IPhone corrente.
     * @return true se l'oggetto specificato è uguale all'oggetto IPhone corrente, false altrimenti.
     */
    @Override
    public boolean equals(Object o)
    {
        IPhone iphone;
        iphone=(IPhone)o;
        if (iphone.getTipo()==getTipo()&& iphone.getColore()==getColore()&& iphone.getQuantita()==getQuantita()&& iphone.getDataAcquisto()==getDataAcquisto())
            return true;
        else
            return false;
    }
}
