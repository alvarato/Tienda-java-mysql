package main;


import java.sql.SQLException;
import java.util.Scanner;

import servicios.ServicioFabricante;
import servicios.ServicioProducto;

public class main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		ServicioProducto servicioproducto = new ServicioProducto();
		ServicioFabricante serviciofabricante = new ServicioFabricante();
        int aux;
        int salida;
        do {
        	System.out.println("listado de opciones ");
        	System.out.println("1:Buscar los P  |2: Buscar  P por nombre");
        	System.out.println("3:Buscar P por rango de precio | 4:Editar P");
        	System.out.println("5:Borrar P | 6:Crear P");
        	System.out.println("7:Buscar F |8:Nuevo F");
        	aux = sc.nextInt();
            switch (aux) 
            {
                case 1:  servicioproducto.btodos();
                         break;
                case 2:  servicioproducto.b1();
                         break;
                case 3:  servicioproducto.buscarXprecio();
                         break;
                case 4:  servicioproducto.editar();
                         break;
                case 5:  servicioproducto.borrar();
                         break;
                case 6:  servicioproducto.nuevoProducto();
                         break;
                case 7:  serviciofabricante.btodos();
                         break;
                case 8:  serviciofabricante.nuevoProducto();
                break;
                default: System.out.println("ninguna funcion a sido ingresada");;
                         break;
            }
            
        System.out.println("ingrese 1 para cerrar el programa");
        	salida = sc.nextInt();
        	
        }while(salida != 1);
        System.out.println("fin de la ejecucion del programa");


		

	}
}
	

