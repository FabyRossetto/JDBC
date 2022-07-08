/*
  Nos han pedido que hagamos una aplicación Java para una tienda con sus 
productos. El objetivo es realizar consultas para saber el stock de ciertos productos 
o que productos hay, etc
 */
package tienda.jdbc.principal;

import java.util.Scanner;
import tienda.jdbc.SERVICIO.ProductoServicio;
import tienda.jdbc.SERVICIO.FabricanteServicio;

import tienda.jdbc.PERSISTENCIA.ProductoDAO;
/**
 *
 * @author Fabi
 */
public class TiendaJDBC {

     
    public static void main(String[] args) throws Exception {
        try {
            Scanner Leer = new Scanner(System.in);
            ProductoServicio p = new ProductoServicio();
            FabricanteServicio f = new FabricanteServicio();

            System.out.println("*****MENU****");
            System.out.println("Ingrese la opcion de la consulta que desea realizar");
            System.out.println("a) Lista el nombre de todos los productos que hay en la tabla producto. \n"
                    + "b) Lista los nombres y los precios de todos los productos de la tabla producto. \n"
                    + "c) Listar aquellos productos que su precio esté entre 120 y 202. \n"
                    + "d) Buscar y listar todos los Portátiles de la tabla producto. \n"
                    + "e) Listar el nombre y el precio del producto más barato. \n"
                    + "f) Ingresar un producto a la base de datos.\n"
                    + "g) Ingresar un fabricante a la base de datos\n"
                    + "h) Editar un producto con datos a elección");

            String Opcion = Leer.next();
            
            ProductoDAO D = new ProductoDAO();
            
           
            switch (Opcion.toLowerCase()) {
                
                case "a":
                    p.mostrarPorNombre(D.llamarProducto());
                break;
                    
                case "b":
                    p.mostrarPorNombreyPrecio();
                break;
                    
                case "c":
                    p.listarEntrePrecios();
                    break;
                case "d":

                    p.llamarPortatiles();
                    break;
                case "e":
                    p.mostrarPrecioBarato();
                    break;
                case "f":
                //            p.crarProducto(20, "computadora" , 25.000, 8); 
                //esta comentado porque solo se puede ingresar una vez
                    break;
                case "g":
                    //f.crarProducto(10, "faby");
                    //tambien va comentado porque ya esta agregado
                    break;
                case "h":
                  p.modificarPrecio(2,120,180);
                  //ya esta modificado
                    break;
                default:
                    System.out.println("La opcion indicada no es correcta");
            }

        } catch (Exception e) {
            throw e;
            
        }

    }

}

