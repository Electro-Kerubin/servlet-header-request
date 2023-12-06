package org.nerfilin.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/despachar")
public class DespacharServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
        protected void doGet(HttpServletRequest req, HttpServletResponse resp): Define el método para manejar solicitudes HTTP GET. Este método se llama automáticamente cuando el servlet recibe una solicitud GET.
        HttpServletRequest req: Objeto que representa la solicitud del cliente. Contiene datos como parámetros de la solicitud, encabezados, etc.
        HttpServletResponse resp: Objeto que se utiliza para enviar una respuesta al cliente.
        throws ServletException, IOException: Indica que este método puede lanzar estas excepciones durante su ejecución.
        getServletContext().getRequestDispatcher("/productos.html").forward(req, resp);:
        getServletContext(): Obtiene el contexto del servlet actual, que es un objeto que proporciona información sobre el entorno del servlet.
        getRequestDispatcher("/productos.html"): Obtiene un RequestDispatcher para el recurso en la ruta /productos.html. Este objeto permite reenviar la solicitud a otro recurso en el servidor.
        **forward(req, resp)
        */
        getServletContext().getRequestDispatcher("/productos.html").forward(req, resp);
    }
}
