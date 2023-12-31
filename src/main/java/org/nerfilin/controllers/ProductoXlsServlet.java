package org.nerfilin.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.nerfilin.models.Producto;
import org.nerfilin.services.ProductoService;
import org.nerfilin.services.ProductoServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet({"/productos.xls", "/productos.html", "/productos"})
public class ProductoXlsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductoService service = new ProductoServiceImpl();
        List<Producto> productos = service.listar();

        resp.setContentType("text/html;charset=UTF-8");
        String servletPath = req.getServletPath();
        boolean esXls = servletPath.endsWith(".xls");
        if(esXls) {
            resp.setContentType("application/vnd.ms-excel");
            resp.setHeader("Content-Disposition", "attachment;filename=Productos.xls");
        }

        try (PrintWriter out = resp.getWriter()) {

            if(!esXls) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("    <head>");
                out.println("        <meta charset=\"UTF-8\">");
                out.println("        <title>Listado de productos</title>");
                out.println("    </head>");
                out.println("    <body>");
                out.println("        <h1>Listado de productos</h1>");
                out.println("<p><a href=\"" + req.getContextPath() + "/productos.xls" + "\">Exportar a xls</a></p>");
                out.println("<p><a href=\"" + req.getContextPath() + "/productos.json" + "\">Mostrar Json</a></p>");
            }

            out.println("<table>");
            out.println("<tr>");
            out.println("<th>id: </th>");
            out.println("<th>Nombre: </th>");
            out.println("<th>Categoria: </th>");
            out.println("<th>Precio: </th>");
            out.println("</tr>");
            productos.forEach(p -> {
                out.println("<tr>");
                out.print("<td>" + p.getId() + "</td>");
                out.print("<td>" + p.getNombre() + "</td>");
                out.print("<td>" + p.getTipo() + "</td>");
                out.print("<td>" + p.getPrecio() + "</td>");
                out.println("</tr>");
            });
            out.println("</table>");

            if(!esXls) {
                out.println("    </body>");
                out.println("</html>");
            }
        }

    }
}
