package dev.db;

import dev.model.Lab;
import dev.model.Tribble;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class TribbleJDBC {

    public int save(Tribble tribble) {
        try(Connection connection = JDBCConnection.getConnnection()){

            PreparedStatement ps = connection.prepareStatement("insert into tribble (id, lab_id) values (?,?)");
            ps.setInt(1, tribble.getId());
            ps.setInt(2, tribble.getLab());
            return ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return -1;
    }

    public List<Tribble> getAll() {
        try(Connection connection = JDBCConnection.getConnnection()){

            ResultSet resultSet = connection.createStatement().executeQuery("select id, lab_id from tribble");
            List<Tribble> list = new LinkedList();

            while (resultSet.next()) {
                list.add(new Tribble(resultSet.getInt("id"), resultSet.getInt("lab_id")));
            }

            return list;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public List<Tribble> getAllByLab(Lab lab) {
        try(Connection connection = JDBCConnection.getConnnection()){

            PreparedStatement preparedStatement = connection.prepareStatement("select id, lab_id from tribble where lab_id = ?");
            preparedStatement.setInt(1, lab.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Tribble> list = new LinkedList();

            while (resultSet.next()) {
                list.add(new Tribble(resultSet.getInt("id"), resultSet.getInt("lab_id")));
            }

            return list;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    public int remove(Tribble tribble) {
        try(Connection connection = JDBCConnection.getConnnection()){
            PreparedStatement prepareStatement = connection.prepareStatement("delete from tribble where (id = ?)");
            prepareStatement.setInt(1, tribble.getId());
            return prepareStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return -1;
    }

}
