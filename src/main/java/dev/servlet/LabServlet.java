package dev.servlet;

import com.google.gson.Gson;
import dev.model.Lab;
import dev.service.ApplicationService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/lab", "/lab/*"})
public class LabServlet extends HttpServlet {

    ApplicationService applicationService = new ApplicationService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String path = req.getPathInfo();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        if (path == null) {
            resp.getWriter().write(new Gson().toJson(applicationService.getAllLab()));
        }
        else {
            int labId = Integer.parseInt(path.substring(1));
            resp.getWriter().write(new Gson().toJson(applicationService.getAllTribbleByLabId(labId)));
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Gson gson = new Gson();
        Lab lab = gson.fromJson(req.getReader(), Lab.class);
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(Integer.toString(applicationService.addLab(lab.getId())));
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Gson gson = new Gson();
        Lab lab = gson.fromJson(req.getReader(), Lab.class);
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(Integer.toString(applicationService.removeLab(lab.getId())));
    }


}
