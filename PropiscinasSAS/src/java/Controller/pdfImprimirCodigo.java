/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modelo.Datos.DatosProducto;
import Modelo.Entidad.Producto;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.Barcode128;
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

/**
 *
 * @author PAULA
 */
@WebServlet(name = "pdfImprimirCodigo", urlPatterns = {"/pdfImprimirCodigo"})
public class pdfImprimirCodigo extends HttpServlet {
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
       response.setContentType("application/pdf");
         String codigo = request.getParameter("codigo");
      int cantidad= Integer.parseInt(request.getParameter("cantidad"));
        OutputStream out = response.getOutputStream();
      
       int positionx=50;
       int positiony=750;
       int nuevahoja=59;
       int contador=3;
        try  {
            try{
                Document documento = new Document();
           
                PdfWriter pdf = PdfWriter.getInstance(documento,out);
                documento.open();
                 Barcode128 code128 = new Barcode128();
                for(int x=0;x<cantidad;x++){
              
                 
                 code128.setCode(codigo);
                 
                 
                 Image img128 = code128.createImageWithBarcode(pdf.getDirectContentUnder(), BaseColor.BLACK, BaseColor.BLACK);
                   
                   img128.setAbsolutePosition(positionx,positiony);
                  documento.add(img128);
                    positionx+=130;
                  
               
                if((x%10==(contador%10))){
                    positionx=50;
                    positiony-=50;
                    contador=contador+4;
                  }
                 if(x==nuevahoja){
                      nuevahoja+=60;
                      documento.newPage();
                      positionx=50;
                      positiony=750;
                  }
                 
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
