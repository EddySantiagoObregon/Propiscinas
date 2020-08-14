/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modelo.Datos.DatosProducto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import com.itextpdf.text.pdf.PdfPTable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author PAULA
 */
@WebServlet(name = "pdfCodigosPorGrupo", urlPatterns = {"/pdfCodigosPorGrupo"})
public class pdfCodigosPorGrupo extends HttpServlet {
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
        Producto unProducto = new Producto();
         response.setContentType("application/pdf");
        OutputStream out = response.getOutputStream();
        int cb_Grupo = Integer.parseInt(request.getParameter("cb_Grupo"));
        ArrayList<Producto> lista= dProducto.generarCodigoBarrasPorGrupo(cb_Grupo);
       int numero = lista.size();
       if (numero%2!=0){
           numero++;
           String a="dsad";
           unProducto.setIdProducto("0000000000000");
           unProducto.setNombre("xxxxxxxxxx");
              lista.add(unProducto);
            }
      try  {
            try{
                Document documento = new Document();
                documento.setMargins(0, 0, 30, 0);
                 PdfWriter pdf = PdfWriter.getInstance(documento,out);
                documento.open();
                 Barcode128 code128 = new Barcode128();
                 

          PdfPTable table = new PdfPTable(4);  
          table.getDefaultCell().setBorderWidth(0f);

        float[] columnWidths = new float[]{40f, 40f, 40f, 40f};
        table.setWidths(columnWidths);
                for(int x=0;x<numero;x++){
            

                 
                 code128.setCode(lista.get(x).getIdProducto());
                   
               Image img128 = code128.createImageWithBarcode(pdf.getDirectContentUnder(), BaseColor.BLACK, BaseColor.BLACK);
                   table.addCell(lista.get(x).getNombre());
                   table.addCell(img128);
                 
                  
                  
               
                 
            } 
                documento.add(table);
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
