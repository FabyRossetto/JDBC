/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.jdbc.PERSISTENCIA;
import tienda.jdbc.ENTIDAD.Producto;
import java.util.ArrayList;
import java.util.Collection;


/**
 *
 * @author Fabi
 */
public class ProductoDAO extends DAO {
    
    public void guardarProducto(Producto p) throws Exception {
        try {
            if (p == null) {
                throw new Exception("Debe indicar el producto");
            }

            String sql = "INSERT INTO Producto (codigo,nombre,precio,codigo_fabricante)"
                    + "VALUES ( '" + p.getCodigo() + "' , '" + p.getNombre() + "' , '" + p.getPrecio()+"' , '" + p.getCodigoFabricante()+ "' );";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }
      public void modificarProducto(Producto p) throws Exception {
           
        try {
            
             String sql = "UPDATE Producto SET "
                    + "precio = '" + p.getPrecio() + "' WHERE codigo = '" + p.getCodigo() + "'";

            insertarModificarEliminar(sql);
          
          
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }
       public Producto buscarProductoPorCodigo(int codigo) throws Exception {
        try {

            String sql = "SELECT * FROM Producto "
                    + " WHERE codigo = '" + codigo + "'";

            consultarBase(sql);

            Producto p = null;
            while (resultado.next()) {
                p = new Producto();
                p.setCodigo(resultado.getInt(1));
                
            }
            desconectarBase();
            return p;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }


    public Collection< Producto> llamarProducto() throws Exception {
        try {
            String sql = "SELECT * FROM producto";
            
            consultarBase(sql);
            Producto producto = null;
////
            Collection<Producto> prod = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getNString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
////                
////               
                prod.add(producto);
            }
            desconectarBase();
            return prod;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }
    }
    
    public Collection<Producto> llamarPorPrecio() throws Exception {
        try {
            String sql = "SELECT NOMBRE, PRECIO FROM PRODUCTO WHERE PRECIO BETWEEN 120 AND 202";

            consultarBase(sql);
            Producto p = null; //lo inicializo null para despues llenarlo
            
            
            Collection<Producto> precio = new ArrayList();
            while (resultado.next()) {
                p = new Producto();
               
                p.setNombre(resultado.getNString(1));
                p.setPrecio(resultado.getDouble(2));
                
////                
////               
                precio.add(p);
            }
            desconectarBase();
            return precio;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
           throw e; 
        }
    }
    

    
   
    public Collection<Producto> buscarPortatiles() throws Exception{
       try {
           String sql = "SELECT * FROM producto WHERE nombre like '%portatil%' ";

            consultarBase(sql);
           Producto producto = null;
           Collection <Producto> port= new ArrayList();
           while (resultado.next()) {
                producto = new Producto();
                producto. setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getNString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
                port.add(producto);
            }
                desconectarBase();
                return port;
       } catch (Exception e) {
            
            desconectarBase();
            throw e;
}
    }
     public Producto llamarProductoMasBarato() throws Exception { //lo puedo hacer como producto porque me va a devolver solo uno
        try {
            String sql = "SELECT NOMBRE, PRECIO FROM PRODUCTO  order by precio ASC limit 1 ";

            consultarBase(sql);
            Producto p = null; //lo inicializo null para despues llenarlo

            while (resultado.next()) {
                p = new Producto();

                p.setNombre(resultado.getNString(1));
                p.setPrecio(resultado.getDouble(2));

////                
////               
            }
            desconectarBase();
            return p;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
}
}
        


    
