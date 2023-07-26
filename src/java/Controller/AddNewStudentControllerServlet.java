/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import dao.IVAppDAO;
import dto.StudentDTO;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

/**
 *
 * @author Shreyanshi
 */
public class AddNewStudentControllerServlet extends HttpServlet {

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
        RequestDispatcher rd =null;
        try{
            DiskFileItemFactory df = new DiskFileItemFactory();
            ServletFileUpload sfu = new ServletFileUpload(df);
            ServletRequestContext srq = new ServletRequestContext(request);
            List<FileItem> multiList =sfu.parseRequest(srq);
            ArrayList<String> objValues = new ArrayList<String>();
            InputStream inp = null;
            for(FileItem fit : multiList){
                if(fit.isFormField())
                {
                    String fname = fit.getFieldName();
                    String value = fit.getString();
                    objValues.add(value);
                }
                else
                {
                    inp = fit.getInputStream();
                    String key = fit.getFieldName();
                    String fileName = fit.getName();
                }
            }
            StudentDTO student = new StudentDTO();
            System.out.println("AddNewStudentControllerServlet");
            System.out.println(objValues);
            student.setPhoto(inp);
            student.setRoll_no(objValues.get(0));
            student.setName(objValues.get(1));
            student.setGrade(objValues.get(2));
            student.setBoard(objValues.get(3));
            student.setCenter_id(objValues.get(4));
            student.setSchool(objValues.get(5));
            student.setFather_name(objValues.get(6));
            student.setMother_name(objValues.get(7));
            boolean result = IVAppDAO.addStudent(student);
            if(result)
                rd = request.getRequestDispatcher("success.jsp");
            else
                rd = request.getRequestDispatcher("failure.jsp");
        }
        catch(Exception e){
            System.out.println("Exception occured in AddNewCandidateControllerServlet"+e);
            e.printStackTrace();
            request.setAttribute("Exception", e);
            rd = request.getRequestDispatcher("showexception.jsp");
        }
        finally{
            if(rd != null)
                rd.forward(request, response);
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
