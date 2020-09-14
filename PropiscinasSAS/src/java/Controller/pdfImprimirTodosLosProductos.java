/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modelo.Datos.DatosProducto;
import Modelo.Entidad.DetalleProducto;
import Modelo.Entidad.Producto;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.itextpdf.text.BaseColor;
import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
/**
 *
 * @author PAULA
 */
@WebServlet(name = "pdfImprimirTodosLosProductos", urlPatterns = {"/pdfImprimirTodosLosProductos"})
public class pdfImprimirTodosLosProductos extends HttpServlet {
DatosProducto dProducto = new DatosProducto();  
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        DetalleProducto unDetalleProducto = new DetalleProducto();
         response.setContentType("application/pdf");
        OutputStream out = response.getOutputStream();
   ArrayList<DetalleProducto> lista= dProducto.Listar();
       int numero = lista.size();

      try  {
            try{
                Document documento = new Document();
                documento.setMargins(30, 0, 30, 30);
                 PdfWriter pdf = PdfWriter.getInstance(documento,out);
                documento.open();
               
                 

         
                for(int x=0;x<numero;x++){
            Paragraph parametro=new Paragraph();
                   String forma=lista.get(x).getUnaForma().getDescripcion();
                   double cantidadUnidad = lista.get(x).getCantidadUnidad();
                   if(forma.equals("SOLO")&&cantidadUnidad==0){
                       parametro = (new Paragraph(lista.get(x).getIdProducto()+" "+lista.get(x).getNombre()+" "+lista.get(x).getUnaUnidadMedida().getDescripcion()+" "+lista.get(x).getUnaPresentacion().getDescripcion()+". Grupo: "+lista.get(x).getUnGrupo().getDescripcion(),FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD, BaseColor.BLACK)));
               
                   }
                    if(forma.equals("SOLO")&&cantidadUnidad>0){
                        parametro =(new Paragraph(lista.get(x).getIdProducto()+"  "+lista.get(x).getNombre()+" "+lista.get(x).getCantidadUnidad()+" "+lista.get(x).getUnaUnidadMedida().getDescripcion()+" "+lista.get(x).getUnaPresentacion().getDescripcion()+". Grupo: "+lista.get(x).getUnGrupo().getDescripcion(),FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD, BaseColor.BLACK)));
         
                   }
                   if(!"SOLO".equals(forma)&&cantidadUnidad>0){
                           parametro =(new Paragraph(lista.get(x).getIdProducto()+" "+lista.get(x).getUnaForma().getDescripcion()+" DE "+lista.get(x).getNombre()+" "+lista.get(x).getCantidadUnidad()+" "+lista.get(x).getUnaUnidadMedida().getDescripcion()+" "+lista.get(x).getUnaPresentacion().getDescripcion()+". Grupo: "+lista.get(x).getUnGrupo().getDescripcion(),FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD, BaseColor.BLACK)));
         
                   }
                   
                 documento.add(parametro);
              
          
                    
               
                 
            } 
       
 
            
                documento.close();
                }catch (DocumentException ex) {
                Logger.getLogger(DatosProducto.class.getName()).log(Level.SEVERE, null, ex);
                ex.getMessage();
            }
        
        }finally{
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
