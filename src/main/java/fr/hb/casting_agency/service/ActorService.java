package fr.hb.casting_agency.service;

import fr.hb.casting_agency.dao.ActorDAO;
import fr.hb.casting_agency.model.Actor;
import fr.hb.casting_agency.utils.ConsoleManager;

import java.sql.SQLException;
import java.util.List;

public class ActorService {

    public void getAll() throws SQLException {

        ConsoleManager.getInstance().printLine();
        List<Actor> actors = new ActorDAO().get();
        for (Actor item : actors) {
            ConsoleManager.getInstance().printToConsole(item.toString(), true);
        }
        ConsoleManager.getInstance().printLine();

    }

    public void create() throws SQLException {

        ConsoleManager.getInstance().printToConsole("Type the name", true);
        ConsoleManager.getInstance().printToConsole("> ", false);
        String name = ConsoleManager.getInstance().readUserInput();

        ConsoleManager.getInstance().printToConsole("Type the age", true);
        ConsoleManager.getInstance().printToConsole("> ", false);
        Integer age = ConsoleManager.getInstance().readUserInputInteger();

        new ActorDAO().save(new Actor(null, name, age));

    }

    public void updateById() throws SQLException {

        getAll();

        ConsoleManager.getInstance().printToConsole("Type the id of the actor you want update :", false);
        int choice = ConsoleManager.getInstance().readUserInputInteger();

        ConsoleManager.getInstance().printToConsole("Type the name :", false);
        String name = ConsoleManager.getInstance().readUserInput();

        ConsoleManager.getInstance().printToConsole("Type the age :", false);
        int age = ConsoleManager.getInstance().readUserInputInteger();

        Actor actor  = new ActorDAO().getById(choice);
        actor.setName(name);
        actor.setAge(age);

        new ActorDAO().update(actor);
    }

    public void deleteByID() throws SQLException {

        getAll();

        ConsoleManager.getInstance().printToConsole("Type the id of the actor you want delete", true);
        ConsoleManager.getInstance().printToConsole("> ", false);
        Integer id = ConsoleManager.getInstance().readUserInputInteger();

        new ActorDAO().deleteById(id);

    }
}
