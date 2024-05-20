/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.progettone_michele;

import java.io.IOException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class NegozioIPhoneTest {
    private NegozioIPhone n;

    @BeforeEach
    public void setUp() {
        n = new NegozioIPhone();
    }

    public NegozioIPhoneTest() {
        // Costruttore vuoto
    }

    @Test
    public void testGetIPhone_0args() {
        // Implementa il test per ottenere gli iPhone (metodo specifico se esiste)
    }

    @Test
    public void testGetNIPhonePresenti() {
        int expected = 0;
        int result = n.getNIPhonePresenti();
        assertEquals(expected, result);
    }

    @Test
    public void testGetN_MAX_IPHONE() {
        int expected = 20;
        int result = n.getN_MAX_IPHONE();
        assertEquals(expected, result);
    }

    @Test
    public void testAggiungiIPhone() {
        IPhone iphone = new IPhone("iPhone 12", "Black", 5, 2022, 1, 1, 999, 1001);
        assertEquals(0, n.aggiungiIPhone(iphone));
    }

    @Test
    public void testEliminaIPhone() {
        IPhone iphone = new IPhone("iPhone 12", "Black", 5, 2022, 1, 1, 999, 1001);
        n.aggiungiIPhone(iphone);
        assertEquals(0, n.eliminaIPhone(1001));
    }

    

    @Test
    public void testToString() {
        // Implementa il test per il metodo toString della classe NegozioIPhone
    }
}
