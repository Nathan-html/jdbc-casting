package fr.hb.casting_agency.service;

import fr.hb.casting_agency.model.Actor;
import fr.hb.casting_agency.model.Casting;
import fr.hb.casting_agency.utils.DataConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataStartService {
    public static void createTablesIfNotExists() throws SQLException {
        createActorTableIfNotExists();
        createCastTableIfNotExists();
    }

    private static void createActorTableIfNotExists() throws SQLException {
        String query =
            "CREATE TABLE IF NOT EXISTS actor ( id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, " +
            "name VARCHAR(50) NOT NULL, " +
            "age INT NOT NULL)";
        Statement statement = DataConnect.getInstance().createStatement();
        statement.execute(query);
        statement.close();
    }

    private static void createCastTableIfNotExists() throws SQLException {
        String query =
            "CREATE TABLE IF NOT EXISTS cast ( id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, " +
            "appreciation VARCHAR(255) NOT NULL, " +
            "score INT NOT NULL, " +
            "actor_id INT, " +
            "FOREIGN KEY(actor_id) REFERENCES actor(id));";
        Statement statement = DataConnect.getInstance().createStatement();
        statement.execute(query);
        statement.close();
    }

    public static void addDataIfIsEmpty() throws SQLException {

        String testExistActor = "SELECT * FROM actor";
        String testExistCast = "SELECT * FROM `cast`";

        String insertDataActor = "INSERT INTO actor(name, age) VALUES (?,?)";
        String insertDataCast = "INSERT INTO `cast`(appreciation, score, actor_id) VALUES (?,?,?)";

        // ---------------------------

        PreparedStatement ps = DataConnect.getInstance().prepareStatement(testExistActor);
        ResultSet rs = ps.executeQuery();

        rs.next();

        if (rs.getRow() == 0) {

            List<Actor> actors = new ArrayList<>();
            actors.add(new Actor(null,"Mr.One", 19));
            actors.add(new Actor(null, "Mr.two", 36));
            actors.add(new Actor(null,"Mr.three", 59));

            ps = DataConnect.getInstance().prepareStatement(insertDataActor);


            for (Actor actor : actors) {
                ps.setString(1, actor.getName());
                ps.setInt(2, actor.getAge());
                ps.executeUpdate();
            }
        }

        // ------------------------------

        ps = DataConnect.getInstance().prepareStatement(testExistCast);
        rs = ps.executeQuery();
        rs.next();

        if (rs.getRow() == 0) {
            List<Casting> castings = new ArrayList<>();
            castings.add(new Casting(null,"Bon", 17, new Actor(2,"Mr.two", 36)));
            castings.add(new Casting(null,"Ok", 12, new Actor(3,"Mr.three", 19)));
            castings.add(new Casting(null,"Mauvais", 6, new Actor(1,"Mr.One", 36)));
            castings.add(new Casting(null,"Excellent", 20, new Actor(2,"Mr.two", 36)));

            ps = DataConnect.getInstance().prepareStatement(insertDataCast);

            for (Casting casting : castings) {
                ps.setString(1, casting.getAppreciation());
                ps.setInt(2, casting.getScore());
                ps.setInt(3, casting.getActor().getId());
                ps.executeUpdate();
            }
        }
        ps.close();
    }
}
