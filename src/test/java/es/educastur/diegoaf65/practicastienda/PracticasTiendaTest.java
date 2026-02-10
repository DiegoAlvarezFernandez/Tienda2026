/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package es.educastur.diegoaf65.practicastienda;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author 1dawd21
 */
public class PracticasTiendaTest {
    
    PracticasTienda p = new PracticasTienda();
    
    public PracticasTiendaTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        p.cargaDatos();
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of main method, of class PracticasTienda.
     */
    
    @Test
    public void testTotalPedidos() {
        assertAll(
            () -> assertEquals(1000, p.totalPedidos(p.getPedidos().get(0))),
            () -> assertEquals(1500, p.totalPedidos(p.getPedidos().get(1))),
            () -> assertEquals(2000, p.totalPedidos(p.getPedidos().get(2))),
            () -> assertEquals(2500, p.totalPedidos(p.getPedidos().get(3)))
        );
    }
}