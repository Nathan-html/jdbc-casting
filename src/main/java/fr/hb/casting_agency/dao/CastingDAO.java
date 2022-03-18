package fr.hb.casting_agency.dao;

import fr.hb.casting_agency.model.Actor;
import fr.hb.casting_agency.model.Casting;
import fr.hb.casting_agency.utils.DataConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CastingDAO implements DAO<Casting, Integer>{
    @Override
    public List<Casting> get() throws SQLException {
        String query = "SELECT * FROM `cast` LEFT JOIN actor ON actor_id = actor.id";
        PreparedStatement ps = DataConnect.getInstance().prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        List<Casting> castings = new ArrayList<>();

        while (rs.next() == true) {
            castings.add(new Casting(
                    rs.getInt("id"),
                    rs.getString("appreciation"),
                    rs.getInt("score"),
                    new Actor(
                            rs.getInt("actor_id"),
                            rs.getString("name"),
                            rs.getInt("age")
                    )
            ));
        }
        ps.close();

        return castings;
    }

    @Override
    public Casting getById(Integer integer) throws SQLException {
        return null;
    }

    @Override
    public void save(Casting casting) throws SQLException {
        String query = "INSERT INTO `cast` (appreciation, score, actor_id) VALUES (?, ?, ?)";
        PreparedStatement ps = DataConnect.getInstance().prepareStatement(query);
        ps.setString(1, casting.getAppreciation());
        ps.setInt(2, casting.getScore());
        ps.setInt(3, casting.getActor().getId());

        ps.executeUpdate();
        ps.close();
    }

    @Override
    public Integer update(Casting casting) throws SQLException {
        return null;
    }

    @Override
    public void updateById(Integer integer) {

    }

    @Override
    public void deleteById(Integer integer) throws SQLException {
        String query = "DELETE FROM cast WHERE id = ?";
        PreparedStatement ps = DataConnect.getInstance().prepareStatement(query);
        ps.setInt(1, integer);
        ps.executeUpdate();
        ps.close();
    }

}
