package dev.db;

import dev.model.Lab;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class LabJDBC {

    public int save(Lab lab) {
        try(Connection connection = JDBCConnection.getConnnection()){

            PreparedStatement ps = connection.prepareStatement("insert into lab (id) values (?)");
            ps.setInt(1, lab.getId());
            return ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return -1;
    }

    public List<Lab> getAll() {
        try(Connection connection = JDBCConnection.getConnnection()){

            ResultSet resultSet = connection.createStatement().executeQuery("select id from lab");
            List<Lab> list = new LinkedList();
            while (resultSet.next()) {
                list.add(new Lab(resultSet.getInt("id")));
            }
            return list;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public int remove(Lab lab) {
        try(Connection connection = JDBCConnection.getConnnection()){
            PreparedStatement prepareStatement = connection.prepareStatement("delete from lab where (id = ?)");
            prepareStatement.setInt(1, lab.getId());
            return prepareStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return -1;
    }

}
