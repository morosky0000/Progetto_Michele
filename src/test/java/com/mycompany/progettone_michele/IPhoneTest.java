/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.progettone_michele;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class IPhoneTest {
    private IPhone iphone;
    
    @BeforeEach
    public void setUp() {
        iphone = new IPhone("iPhone 12", "Black", 5, 2022, 1, 1, 999, 1);
    }
    
    public IPhoneTest() {
        // Costruttore vuoto
    }
    
    @Test
    public void testCostruttore() {
        IPhone i1 = new IPhone("iPhone 13", "White", 1, 2020, 1, 1, 1099, 1);
        assertEquals("iPhone 13", i1.getTipo());
        assertEquals("White", i1.getColore());
        assertEquals(1, i1.getQuantita());
        LocalDate dataAcquistoAttesa = LocalDate.of(2020, 1, 1);
        assertEquals(dataAcquistoAttesa, i1.getDataAcquisto());
        assertEquals(1099, i1.getCosto());
        assertEquals(1, i1.getCodice());
    }

    @Test
    public void testGetTipo() {
        assertEquals("iPhone 12", iphone.getTipo());
    }

    @Test
    public void testSetTipo() {
        iphone.setTipo("iPhone 13");
        assertEquals("iPhone 13", iphone.getTipo());
    }

    @Test
    public void testGetColore() {
        assertEquals("Black", iphone.getColore());
    }

    @Test
    public void testSetColore() {
        iphone.setColore("White");
        assertEquals("White", iphone.getColore());
    }

    @Test
    public void testGetQuantita() {
        assertEquals(5, iphone.getQuantita());
    }

    @Test
    public void testSetQuantita() {
        iphone.setQuantita(10);
        assertEquals(10, iphone.getQuantita());
    }

    @Test
    public void testGetCosto() {
        assertEquals(999, iphone.getCosto());
    }

    @Test
    public void testSetCosto() {
        iphone.setCosto(1099);
        assertEquals(1099, iphone.getCosto());
    }

    @Test
    public void testGetCodice() {
        assertEquals(1, iphone.getCodice());
    }

    @Test
    public void testSetCodice() {
        iphone.setCodice(2);
        assertEquals(2, iphone.getCodice());
    }

    @Test
    public void testGetDataAcquisto() {
        assertEquals(LocalDate.of(2022, 1, 1), iphone.getDataAcquisto());
    }

    @Test
    public void testSetDataAcquisto() {
        iphone.setDataAcquisto(LocalDate.of(2023, 2, 2));
        assertEquals(LocalDate.of(2023, 2, 2), iphone.getDataAcquisto());
    }

    @Test
    public void testToString() {
        String expected = "IPhone{tipo=iPhone 12, colore=Black, quantita=5, dataAcquisto=2022-01-01, costo=999, codice=1}";
        assertEquals(expected, iphone.toString());
    }
    
    @Test
    public void testEquals() {
        IPhone i1 = new IPhone("iPhone 12", "Black", 5, 2022, 1, 1, 999, 1);
        IPhone i2 = new IPhone("iPhone 12", "Black", 5, 2022, 1, 1, 999, 1);

        assertFalse(i1.equals(i2));
    }
}
