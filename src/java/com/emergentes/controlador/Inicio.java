 
package com.emergentes.controlador;

import com.emergentes.dao.ProductoDAO;
import com.emergentes.dao.ProductoDAOimpl;
import com.emergentes.modelo.Producto;
import java.io.IOException;
import java.util.List;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
@WebServlet(name = "Inicio", urlPatterns = {"/Inicio"})
public class Inicio extends HttpServlet {

     
     
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          try {
            ProductoDAO dao = new ProductoDAOimpl();
            Producto avi = new Producto();
            int id;
            String action = (request.getParameter("action") != null) ? request.getParameter("action") :"view";
            
            switch(action){
                case "add":
                    request.setAttribute("producto", avi);
                    request.getRequestDispatcher("frmproducto.jsp").forward(request, response);
                    break;
                case "edit":
                    id=Integer.parseInt(request.getParameter("id"));
                    avi=dao.getById(id);
                    System.out.println(avi);
                    request.setAttribute("producto", avi);
                    request.getRequestDispatcher("frmproducto.jsp").forward(request, response);
                    break;
                case "delete":
                    id=Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("Inicio");
                    break;
                case "view":
                    List<Producto> lista =dao.getAll();
                    request.setAttribute("productos",lista);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                default:
                    break;
                    
            }
        } catch (Exception ex) {
            System.out.println("Error" +ex.getMessage());
        }
    }

   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         ProductoDAO dao= new  ProductoDAOimpl();
        
         int id = Integer.parseInt(request.getParameter("id"));
         String descripcion = request.getParameter("descripcion");
         int stock =Integer.parseInt(request.getParameter("stock"));
         
          Producto avi= new   Producto();
         
         avi.setId(id);
         avi.setDescripcion(descripcion);
         avi.setStock(stock);
         
         if (id==0) {
             try {
                  
                 dao.insert(avi);
                 response.sendRedirect("Inicio");
             } catch (Exception ex) {
                 System.out.println("Error"+ ex.getMessage());
             }
        }else{
             try {
                
                 dao.update(avi);
                 response.sendRedirect("Inicio");
             } catch (Exception ex) {
                 System.out.println("Error"+ ex.getMessage());
             }
         }
    }

     

}
