/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package es.educastur.diegoaf65.practicastienda;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Comparator;

/**
 *
 * @author 1dawd21
 */

    //<editor-fold defaultstate="collapsed" desc="CLASES">
public class PracticasTienda {

    private static Scanner sc = new Scanner(System.in);
    private ArrayList<Pedido> pedidos;
    private HashMap<String, Articulo> articulos;
    private HashMap<String, Cliente> clientes;
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="COLECCIONES">
    public PracticasTienda() {
        pedidos = new ArrayList();
        articulos = new HashMap();
        clientes = new HashMap();
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="MAIN">
    public static void main(String[] args) {
        PracticasTienda p = new PracticasTienda();
        p.cargaDatos();
        p.menuOpciones();
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="MENU OPCIONES">
    public void menuOpciones() {
        int opcion;
        do {
            System.out.println("\t MENU DE OPCIONES");
            System.out.println("\t --> 1 - GESTION ARTICULOS");
            System.out.println("\t --> 2 - GESTION CLIENTES");
            System.out.println("\t --> 3 - GESTION PEDIDOS");
            System.out.println("\t --> 4 - SALIR");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1: {
                    menuArticulos();
                    break;
                }
                case 2: {
                    menuClientes();
                    break;
                }
                case 3: {
                    menuPedidos();
                    break;
                }
            }
        } while (opcion != 4);
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="ARTICULOS">
    public void menuArticulos() {
        int opcion;
        do {
            System.out.println("\t MENU DE OPCIONES");
            System.out.println("\t --> 1 - ALTA ARTICULOS");
            System.out.println("\t --> 2 - BAJA ARTICULOS");
            System.out.println("\t --> 3 - REPOSICION ARTICULOS");
            System.out.println("\t --> 4 - LISTADO ARTICULOS");
            System.out.println("\t --> 5 - SALIR");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1: {
                    altaArticulos();
                    break;
                }
                case 2: {
                    bajaArticulos();
                    break;
                }
                case 3: {
                    reposicionArticulos();
                    break;
                }
                case 4: {
                    listadoArticulos();
                    break;
                }
            }
        } while (opcion != 5);
    }

    private void altaArticulos() {
        String idArticulo, descripcion, existencias, pvp;
        System.out.println("ALTA DE NUEVO ARTICULO:");
        do {
            System.out.println("idArticulo (IDENTIFICADOR):");
            idArticulo = sc.nextLine();
        } while (!idArticulo.matches("[1-5][-][0-9][0-9]")
                || articulos.containsKey(idArticulo));
        System.out.println("DESCRIPCION:");
        descripcion = sc.nextLine();
        do {
            System.out.println("EXISTENCIAS:");
            existencias = sc.nextLine();
        } while (!MetodosAux.esInt(existencias));
        do {
            System.out.println("PVP:");
            pvp = sc.nextLine();
        } while (!MetodosAux.esDouble(pvp));

        Articulo a = new Articulo(idArticulo, descripcion, Integer.parseInt(existencias), Double.parseDouble(pvp));
        articulos.put(idArticulo, a);
    }

    public static void bajaArticulos() {

    }

    public static void reposicionArticulos() {

    }

    public static void listadoArticulos() {

    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="CLIENTES">
    public static void menuClientes() {
        int opcion;
        do {
            System.out.println("\t MENU DE OPCIONES");
            System.out.println("\t --> 1 - ALTA CLIENTES");
            System.out.println("\t --> 2 - BAJA CLIENTES");
            System.out.println("\t --> 3 - MODIFICACION DATOS CLIENTES");
            System.out.println("\t --> 4 - LISTADO CLIENTES");
            System.out.println("\t --> 5 - SALIR");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1: {
                    altaClientes();
                    break;
                }
                case 2: {
                    bajaClientes();
                    break;
                }
                case 3: {
                    modificacionClientes();
                    break;
                }
                case 4: {
                    listadoClientes();
                }
            }
        } while (opcion != 5);
    }

    public static void altaClientes() {

    }

    public static void bajaClientes() {

    }

    public static void modificacionClientes() {

    }

    public static void listadoClientes() {

    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="PEDIDOS">
    public void menuPedidos() {
        int opcion;
        do {
            System.out.println("\t MENU DE OPCIONES");
            System.out.println("\t --> 1 - NUEVO PEDIDO");
            System.out.println("\t --> 2 - LSTADO PEDIDOS");
            System.out.println("\t --> 3 - SALIR");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1: {
                    nuevoPedido();
                    break;
                }
                case 2: {
                    listadoPedidos();
                    break;
                }
            }
        } while (opcion != 3);
    }

    private void nuevoPedido() {
        String idCliente;
        System.out.print("\nDNI CLIENTE: ");
        do {
            idCliente = sc.nextLine().toUpperCase();
        } while (!MetodosAux.validarDNI(idCliente));

        ArrayList<LineaPedido> cestaCompra = new ArrayList();
        String idArticulo;
        int unidades = 0;
        System.out.print("\nTeclee el ID del articulo deseado (Teclee FIN para terminar la compra): ");
        idArticulo = sc.next();
        while (!idArticulo.equalsIgnoreCase("FIN")) {
            System.out.print("\nTeclee las unidades deseadas: ");
            unidades = sc.nextInt();
            try {
                chequeadorStock(idArticulo, unidades);
                cestaCompra.add(new LineaPedido(idArticulo, unidades));
            } catch (StockCero ex) {
                System.out.println(ex.getMessage());
            } catch (StockInsuficiente ex) {
                System.out.println(ex.getMessage());
                System.out.print("\nLas quieres (SI/NO): ");
                String respuesta = sc.next();
                if (respuesta.equalsIgnoreCase("SI")) {
                    cestaCompra.add(new LineaPedido(idArticulo, articulos.get(idArticulo).getExistencias()));
                    articulos.get(idArticulo).setExistencias(0);
                }
            }
            System.out.print("\nTeclee el ID del articulo deseado (Teclee FIN para terminar la compra): ");
            idArticulo = sc.next();
        }
        if (!cestaCompra.isEmpty()) {
            System.out.println("\nEste es tu pedido:");
            double totalPedido = 0;
            double totalLinea = 0;
            for (LineaPedido l : cestaCompra) {
                totalLinea = l.getUnidades()*articulos.get(l.getIdArticulo()).getPvp();
                totalPedido += totalLinea;
                System.out.println(l.getIdArticulo() + " - "
                        + articulos.get(l.getIdArticulo()).getDescripcion() + " - "
                        + l.getUnidades() + " - "
                        + articulos.get(l.getIdArticulo()).getPvp() + " - " 
                        + totalLinea);
            }
            System.out.print("Total: " + totalPedido);
            System.out.print("\nProcedemos con la compra (SI/NO): ");
            String respuesta = sc.next();
            if (respuesta.equalsIgnoreCase("SI")) {
                String idPedido = generaIdPedido(idCliente);
                pedidos.add(new Pedido(idPedido, clientes.get(idCliente), LocalDate.now(), cestaCompra));
                for (LineaPedido l : cestaCompra) {
                    articulos.get(l.getIdArticulo()).setExistencias(articulos.get(l.getIdArticulo()).getExistencias() - l.getUnidades());
                }
            }
        }
    }

    private void listadoPedidos() {
        System.out.println("");
        for (Pedido p : pedidos) {
            System.out.println(p + " - Total: " + totalPedidos(p));
        }
        System.out.println("\n");
        pedidos.stream().sorted(Comparator.comparing(p->totalPedidos(p)))
                .forEach(p->System.out.println(p + " - Total: " + totalPedidos(p)));
        System.out.println("\n");
        pedidos.stream().sorted(Comparator.comparing(p->totalPedidos((Pedido)p)).reversed())
                .forEach(p->System.out.println(p + " - Total: " + totalPedidos(p)));
    }

    private double totalPedidos(Pedido p) {
        double totalPedido = 0;
        for (LineaPedido l : p.getCestaCompra()) {
            totalPedido += l.getUnidades() * articulos.get(l.getIdArticulo()).getPvp();
        }
        return totalPedido;
    }

    private String generaIdPedido(String idCliente) {
        int contador = 0;
        String nuevoId;
        for (Pedido p : pedidos) {
            if (p.getClientePedido().getIdCliente().equalsIgnoreCase(idCliente)) {
                contador++;
            }
        }
        contador++;
        nuevoId = idCliente + "-" + String.format("%03d", contador) + "/" + LocalDate.now().getYear();
        return nuevoId;
    }
    
    private void chequeadorStock(String idArticulo, int unidades) throws StockCero, StockInsuficiente {
        if (articulos.get(idArticulo).getExistencias() == 0) {
            throw new StockCero("\n0 unidades disponibles de: "
                    + articulos.get(idArticulo).getDescripcion());
        }
        if (articulos.get(idArticulo).getExistencias() < unidades) {
            throw new StockInsuficiente("\nSolo hay " + articulos.get(idArticulo).getExistencias()
                    + " unidades disponibles de: " + articulos.get(idArticulo).getDescripcion());
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="CARGA DATOS">
    public void cargaDatos() {
        clientes.put("80580845T", new Cliente("80580845T", "ANA ", "658111111", "ana@gmail.com"));
        clientes.put("36347775R", new Cliente("36347775R", "LOLA", "649222222", "lola@gmail.com"));
        clientes.put("63921307Y", new Cliente("63921307Y", "JUAN", "652333333", "juan@gmail.com"));
        clientes.put("02337565Y", new Cliente("02337565Y", "EDU", "634567890", "edu@gmail.com"));

        articulos.put("1-11", new Articulo("1-11", "RATON LOGITECH ST ", 14, 15));
        articulos.put("1-22", new Articulo("1-22", "TECLADO STANDARD  ", 9, 18));
        articulos.put("2-11", new Articulo("2-11", "HDD SEAGATE 1 TB  ", 16, 80));
        articulos.put("2-22", new Articulo("2-22", "SSD KINGSTOM 256GB", 9, 70));
        articulos.put("2-33", new Articulo("2-33", "SSD KINGSTOM 512GB", 0, 200));
        articulos.put("3-22", new Articulo("3-22", "EPSON PRINT XP300 ", 5, 80));
        articulos.put("4-11", new Articulo("4-11", "ASUS  MONITOR  22 ", 5, 100));
        articulos.put("4-22", new Articulo("4-22", "HP MONITOR LED 28 ", 5, 180));
        articulos.put("4-33", new Articulo("4-33", "SAMSUNG ODISSEY G5", 12, 580));

        LocalDate hoy = LocalDate.now();
        pedidos.add(new Pedido("80580845T-001/2025", clientes.get("80580845T"), hoy.minusDays(1), new ArrayList<>(List.of(new LineaPedido("1-11", 3), new LineaPedido("4-22", 3)))));
        pedidos.add(new Pedido("80580845T-002/2025", clientes.get("80580845T"), hoy.minusDays(2), new ArrayList<>(List.of(new LineaPedido("4-11", 3), new LineaPedido("4-22", 2), new LineaPedido("4-33", 4)))));
        pedidos.add(new Pedido("36347775R-001/2025", clientes.get("36347775R"), hoy.minusDays(3), new ArrayList<>(List.of(new LineaPedido("4-22", 1), new LineaPedido("2-22", 3)))));
        pedidos.add(new Pedido("36347775R-002/2025", clientes.get("36347775R"), hoy.minusDays(5), new ArrayList<>(List.of(new LineaPedido("4-33", 3), new LineaPedido("2-11", 3)))));
        pedidos.add(new Pedido("63921307Y-001/2025", clientes.get("63921307Y"), hoy.minusDays(4), new ArrayList<>(List.of(new LineaPedido("2-11", 5), new LineaPedido("2-33", 3), new LineaPedido("4-33", 2)))));
    }
//</editor-fold>

} //Llave final