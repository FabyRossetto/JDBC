/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.jdbc.SERVICIO;

import java.util.ArrayList;
import java.util.Collection;
import tienda.jdbc.ENTIDAD.Producto;
import tienda.jdbc.PERSISTENCIA.ProductoDAO;
/**
 *
 * @author Fabi
 */
public class ProductoServicio {

    public ProductoDAO dao;

    public ProductoServicio() {
        this.dao = new ProductoDAO();
    }

    public void mostrarPorNombre( Collection<Producto> prod) throws Exception {

        try {

            System.out.println(" El nombre de los productos son: ");
            for (Producto producto : prod) {
                System.out.println(producto.getNombre());
                
            }

           
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Collection<Producto> mostrarPorNombreyPrecio() throws Exception{
        try{
       
        Collection <Producto>  col = dao.llamarProducto();
        System.out.println("Los productos mostrados por nombre y precio");
        for (Producto p : col) {
            System.out.println(" " + p.getNombre()+ "   $ " + p.getPrecio());
        }return col;
    }catch (Exception e) {
            throw e;
    }
    }
    public Collection<Producto> listarEntrePrecios() throws Exception{
        
        try{
        Collection <Producto> col=dao.llamarPorPrecio();
        System.out.println("Los productos entre $120 y $202 son ");
        for (Producto producto : col) {
            System.out.println(" " + producto.getNombre()+ "     $" + producto.getPrecio());
            
        }return col;
        
    }catch (Exception e){
        throw e;
    }
    }
    public Collection<Producto>llamarPortatiles() throws Exception{
        try{
            Collection<Producto> portatiles= dao.buscarPortatiles();
            System.out.println("Los productos que contienen la palabra portatil en su interior son ");
            for (Producto portatil : portatiles) {
                System.out.println(" " + portatil);
                
            }return portatiles;
            
        }catch (Exception g){
            throw g;
            
        }
    }
    public Producto mostrarPrecioBarato() throws Exception{
        try{
       
       Producto  col = dao.llamarProductoMasBarato();
        System.out.println("El producto mas barato es " + " " + col.getNombre()+ "   $ " + col.getPrecio());
        return col;
    }catch (Exception e) {
            throw e;
    }
    }
  
     public void crarProducto(int codigo,String nombre,double precio,int codigo_fabricante) throws Exception {

        try {
            //Validamos
            if (codigo == 0 ) {
                throw new Exception("Debe indicar el codigo del producto");
            }
            
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre");
            }
            if (codigo_fabricante == 0) {
                throw new Exception("Debe indicar el codigo del fabricante");
            }
            

            //Creamos el producto
            Producto p = new Producto();
           
            p.setCodigo(codigo);
            p.setNombre(nombre);
            p.setPrecio(precio);
            p.setCodigoFabricante(codigo_fabricante);
            dao.guardarProducto(p);
        } catch (Exception e) {
            throw e;
        }
    
    }
     public Producto buscarProductoporCod(int codigo) throws Exception {

        try {

            

            Producto p = dao.buscarProductoPorCodigo(codigo);

            return p;
        } catch (Exception e) {
            throw e;
        }
    }
     public void modificarPrecio(int codigo,double PrecioViejo,double PrecioNuevo) throws Exception {//me da vacio,ver como lo soluciono!

        try {
           Producto producto= dao.buscarProductoPorCodigo(codigo);
                   producto.setPrecio(PrecioNuevo);
            dao.modificarProducto(producto);
            

           

        } catch (Exception e) {
            throw e;
        }

}
}

