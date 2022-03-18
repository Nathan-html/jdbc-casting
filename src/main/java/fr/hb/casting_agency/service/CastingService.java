package fr.hb.casting_agency.service;

import fr.hb.casting_agency.dao.ActorDAO;
import fr.hb.casting_agency.dao.CastingDAO;
import fr.hb.casting_agency.model.Casting;
import fr.hb.casting_agency.utils.ConsoleManager;

import java.sql.SQLException;
import java.util.List;

public class CastingService {

    public void create() throws SQLException {

        ConsoleManager.getInstance().printToConsole("Type the appreciation", true);
        ConsoleManager.getInstance().printToConsole("> ", false);
        String appreciation = ConsoleManager.getInstance().readUserInput();

        ConsoleManager.getInstance().printToConsole("Type the score", true);
        ConsoleManager.getInstance().printToConsole("> ", false);
        Integer score = ConsoleManager.getInstance().readUserInputInteger();

        new ActorService().getAll();

        ConsoleManager.getInstance().printToConsole("Type the id og the actor choose", true);
        ConsoleManager.getInstance().printToConsole("> ", false);
        Integer id = ConsoleManager.getInstance().readUserInputInteger();

        new CastingDAO().save(new Casting(null, appreciation, score, new ActorDAO().getById(id)));

    }

    public void getAll() throws SQLException {

        ConsoleManager.getInstance().printLine();
        List<Casting> castings = new CastingDAO().get();
        for (Casting item : castings) {
            ConsoleManager.getInstance().printToConsole(item.toString(), true);
        }
        ConsoleManager.getInstance().printLine();

    }

    public void deleteById() throws SQLException {

        getAll();

        ConsoleManager.getInstance().printToConsole("Type the id of the actor you want delete", true);
        ConsoleManager.getInstance().printToConsole("> ", false);
        Integer id = ConsoleManager.getInstance().readUserInputInteger();

        new CastingDAO().deleteById(id);
    }
}
