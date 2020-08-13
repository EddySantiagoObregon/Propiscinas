/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modelo.Datos.DatosProducto;
import Modelo.Entidad.Producto;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author PAULA
 */
@WebServlet(name = "pdfTodosLosCodigos", urlPatterns = {"/pdfTodosLosCodigos"})
public class pdfTodosLosCodigos extends HttpServlet {
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
            throws ServletException, IOException, DocumentException {
     
      response.setContentType("application/pdf");
        OutputStream out = response.getOutputStream();
        ArrayList<Producto> lista= dProducto.generarCodigoBarras();
       int numero = lista.size();
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
                 
                  Font fontitulo = new Font(Font.FontFamily.HELVETICA,7,Font.BOLD,BaseColor.BLACK);
                 Paragraph par1= new Paragraph();
                 Phrase pr = new Phrase();
                 for(int x=0;x<numero;x++){
                   
                      pr.add(new Phrase(lista.get(x).getNombre().substring(0,27)+"         |",fontitulo));
                 }
                 par1.add(pr);
                
                 
            
                 par1.add(new Paragraph(Chunk.NEWLINE));
                 
 
                 documento.add(par1);
                for(int x=0;x<numero;x++){
              
                 
                 code128.setCode(lista.get(x).getIdProducto());
                 
                 
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
    try {
        processRequest(request, response);
    } catch (DocumentException ex) {
        Logger.getLogger(pdfTodosLosCodigos.class.getName()).log(Level.SEVERE, null, ex);
    }
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
    try {
        processRequest(request, response);
    } catch (DocumentException ex) {
        Logger.getLogger(pdfTodosLosCodigos.class.getName()).log(Level.SEVERE, null, ex);
    }
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
