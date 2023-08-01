/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import dao.AdminDAO;
import dto.StudentCredDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Shreyanshi
 */
public class RetriveResultControllerServlet extends HttpServlet {

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
        RequestDispatcher rd = null;
        HttpSession session = request.getSession();
        String userid = (String)session.getAttribute("userid");
        if(userid == null){
            session.invalidate();
            response.sendRedirect("accessdenied.html");
            return;
        }
        String roll_no = (String)request.getParameter("roll_no");
        String name = (String)request.getParameter("name");
        System.out.println("roll no"+roll_no+" and name is"+name);
        try{
            StudentCredDTO student = new StudentCredDTO();
            student.setRoll_no(roll_no);
            student.setName(name);
            boolean tf = AdminDAO.searchStudent(student);
            request.setAttribute("result", tf);
            session.setAttribute("roll_no", roll_no);
            rd = request.getRequestDispatcher("sendresult.jsp");
        }
        catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("Some exception ocuured in EVAnswerSheetControllerServlet"+ex);
            request.setAttribute("Exception", ex);
            rd = request.getRequestDispatcher("showexception.jsp");
        }
        finally{
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
