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
    
    @Test
    public void testCargaDatos() {
        assertAll(
            () -> assertEquals(10, p.getArticulos().size()),
            () -> assertEquals(4, p.getClientes().size()),
            () -> assertEquals(5, p.getPedidos().size())
        );
    }
    
    @Test
    public void testGeneraIdPedido() {
        assertAll(
            () -> assertEquals("80580845T-003/2026", p.generaIdPedido("80580845T")),
            () -> assertEquals("36347775R-003/2026", p.generaIdPedido("36347775R")),
            () -> assertEquals("63921307Y-002/2026", p.generaIdPedido("36347775R")),
            () -> assertEquals("02337565Y-001/2026", p.generaIdPedido("02337565Y"))
        );
    }
    
    @Test
    public void testTotalPedido() {
        assertAll(
            () -> assertEquals(585, p.totalPedidos(p.getPedidos().get(0))),
            () -> assertEquals(2980, p.totalPedidos(p.getPedidos().get(1))),
            () -> assertEquals(390, p.totalPedidos(p.getPedidos().get(2))),
            () -> assertEquals(1980, p.totalPedidos(p.getPedidos().get(3))),
            () -> assertEquals(2160, p.totalPedidos(p.getPedidos().get(4)))   
        );
    }
    
    @Test
    public void testTotalCliente() {
        assertAll(
            () -> assertEquals(3565, p.totalCliente2(p.getClientes().get("80580845T"))),
            () -> assertEquals(2370, p.totalCliente2(p.getClientes().get("36347775R"))),
            () -> assertEquals(2160, p.totalCliente2(p.getClientes().get("36347775R"))),
            () -> assertEquals(0, p.totalCliente2(p.getClientes().get("02337565Y")))
        );
    }
}