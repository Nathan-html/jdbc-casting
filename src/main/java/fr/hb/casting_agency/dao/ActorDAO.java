package fr.hb.casting_agency.dao;

import fr.hb.casting_agency.model.Actor;
import fr.hb.casting_agency.utils.DataConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ActorDAO implements DAO<Actor, Integer> {

    @Override
    public List<Actor> get() throws SQLException {
        String query = "SELECT * FROM actor";
        PreparedStatement ps = DataConnect.getInstance().prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        List<Actor> actors = new ArrayList<>();

        while (rs.next() == true) {
            actors.add(new Actor(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("age")
            ));
        }
        ps.close();

        return actors;
    }

    @Override
    public Actor getById(Integer integer) throws SQLException {
        String query = "SELECT * FROM actor WHERE id = ?";

        PreparedStatement ps = DataConnect.getInstance().prepareStatement(query);
        ps.setInt(1, integer);
        ResultSet rs = ps.executeQuery();

        Actor actor = null;

        if (rs.next()) {
            actor = new Actor(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("age"));
//            actor.setId(rs.getInt("id"));
        }
        ps.close();
        return actor;
    }

    @Override
    public void save(Actor actor) throws SQLException {
        String query = "INSERT INTO actor (name, age) VALUES (?, ?)";
        PreparedStatement ps = DataConnect.getInstance().prepareStatement(query);

        ps.setString(1, actor.getName());
        ps.setInt(2, actor.getAge());

        ps.executeUpdate();
        ps.close();
    }

    @Override
    public Integer update(Actor actor) throws SQLException {
        String query = "UPDATE actor SET name = ?, age = ? WHERE id = ?";
        Integer nbUpdated = 0;

        try{
            PreparedStatement ps = DataConnect.getInstance().prepareStatement(query);
            ps.setString(1, actor.getName());
            ps.setDouble(2, actor.getAge());
            ps.setInt(3, actor.getId());

            nbUpdated = ps.executeUpdate();
            ps.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return nbUpdated;
    }

    @Override
    public void updateById(Integer integer) {

    }

    @Override
    public void deleteById(Integer integer) throws SQLException {
        String query = "DELETE FROM actor WHERE id = ?";
        PreparedStatement ps = DataConnect.getInstance().prepareStatement(query);
        ps.setInt(1, integer);
        ps.executeUpdate();
        ps.close();
    }
}
