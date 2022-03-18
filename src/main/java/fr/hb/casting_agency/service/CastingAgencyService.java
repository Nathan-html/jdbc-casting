package fr.hb.casting_agency.service;

import fr.hb.casting_agency.dao.CastingDAO;
import fr.hb.casting_agency.utils.ConsoleManager;
import fr.hb.casting_agency.utils.DataConnect;

import java.sql.SQLException;

public class CastingAgencyService {

    public static void run() throws SQLException {
        welcome();
        selectAction();
        goodbye();
    }

    private static void welcome() throws SQLException {
        DataStartService.createTablesIfNotExists();
        ConsoleManager.getInstance().printToConsole("   ☼   Jdbc   ☼   ", true);
        DataStartService.addDataIfIsEmpty();
    }

    private static void goodbye() throws SQLException {
        DataConnect.getInstance().close();
    }

    private static void selectAction() throws SQLException {

        Boolean exit = false;
        ActorService actorService = new ActorService();
        CastingService castingService = new CastingService();

        do {
            printMenu();
            ConsoleManager.getInstance().printToConsole("> ", false);
            String action = ConsoleManager.getInstance().readUserInput();
            switch (action) {
                case "" :
                    ConsoleManager.getInstance().printToConsole("please : type a number", true);
                    break;
                case "0" :
                    exit = true;
                    break;
                case "1" :
                    actorService.getAll();
                    break;
                case "2" :
                    actorService.create();
                    break;
                case "3":
                    actorService.updateById();
                    break;
                case "4" :
                    actorService.deleteByID();
                    break;
                case "5" :
                    castingService.create();
                    break;
                case "6" :
                    castingService.deleteById();
            }
        } while (exit != true);
    }

    private static void printMenu() {
        for (Menu item : Menu.values()) {
            ConsoleManager.getInstance().printToConsole(item.toString(), true);
        }
    }
}
