package fr.hb.casting_agency;

import fr.hb.casting_agency.service.CastingAgencyService;
import fr.hb.casting_agency.service.CastingAgencyTesting;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        CastingAgencyService.run();
//        CastingAgencyTesting.run();
    }
}
