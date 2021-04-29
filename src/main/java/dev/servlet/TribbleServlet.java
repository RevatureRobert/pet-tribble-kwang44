package dev.servlet;

import com.google.gson.Gson;
import dev.model.Lab;
import dev.model.Tribble;
import dev.service.ApplicationService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/tribble"})
public class TribbleServlet extends HttpServlet {

    ApplicationService applicationService = new ApplicationService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {


        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(new Gson().toJson(applicationService.getAllTribble()));
//        String path = req.getPathInfo();
//        if (path == null) {
//            resp.getWriter().write(new Gson().toJson(applicationService.getAllLab()));
//        }
//        else {
//            int tribbleId = Integer.parseInt(path.substring(1));
//            resp.getWriter().write(new Gson().toJson(applicationService.get(tribbleId)));
//        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Gson gson = new Gson();
        Tribble tribble = gson.fromJson(req.getReader(), Tribble.class);
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(Integer.toString(applicationService.addTribble(tribble.getId(), tribble.getLab())));
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Gson gson = new Gson();
        Tribble tribble = gson.fromJson(req.getReader(), Tribble.class);
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(Integer.toString(applicationService.removeTribble(tribble.getId())));
    }
}
