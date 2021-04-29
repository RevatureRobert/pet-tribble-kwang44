package dev.service;

import dev.db.LabJDBC;
import dev.db.TribbleJDBC;
import dev.model.Lab;
import dev.model.Tribble;

import java.util.List;

public class ApplicationService {
    LabJDBC labJDBC;
    TribbleJDBC tribbleJDBC;

    public static void main(String[] args) {
        System.out.println(new ApplicationService().removeTribble(1));
    }

    public ApplicationService() {
        labJDBC = new LabJDBC();
        tribbleJDBC = new TribbleJDBC();
    }

    public int addLab(int id) {
        return labJDBC.save(new Lab(id));
    }

    public List<Lab> getAllLab() {
        return labJDBC.getAll();
    }

    public int removeLab(int id) {
        return labJDBC.remove(new Lab(id));
    }

    public int addTribble(int id, int labId) {
        return tribbleJDBC.save(new Tribble(id, labId));
    }

    public List<Tribble> getAllTribble() {
        return tribbleJDBC.getAll();
    }

    public List<Tribble> getAllTribbleByLabId(int labId) {
        return tribbleJDBC.getAllByLab(new Lab(labId));
    }

    public int removeTribble(int id) {
        return tribbleJDBC.remove(new Tribble(id));
    }
}
