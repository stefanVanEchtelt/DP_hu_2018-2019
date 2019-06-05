package hu.nl.hibernate;

import hu.nl.hibernate.dao.OVChipkaartService;
import hu.nl.hibernate.dao.ReizigerService;

import java.sql.Date;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;

@SuppressWarnings("ConstantConditions")
public class Main {

    public static void main(String[] args) {
        OVChipkaart ovChipkaart = OVChipkaartService.getInstance().findById(35283);
        ConsoleColor.log("---- Get OVChipkaart (KAARTNUMMER=35283)", ConsoleColor.ANSI_BLUE);

        ConsoleColor.log(ovChipkaart, ConsoleColor.ANSI_CYAN);
        ConsoleColor.log(ovChipkaart.getReiziger(), ConsoleColor.ANSI_CYAN);


        ConsoleColor.log("\n---- Get Reiziger (ID=5)", ConsoleColor.ANSI_BLUE);
        ReizigerService.getInstance().getReizigerDao().openCurrentSession();
        Reiziger reiziger = ReizigerService.getInstance().getReizigerDao().findById(5);
        ConsoleColor.log(reiziger, ConsoleColor.ANSI_CYAN);

        ConsoleColor.log("\n---- Get Reiziger's OVChipkaarten (same instance as previous)", ConsoleColor.ANSI_BLUE);
        reiziger.getOVChipkaarten().forEach(r -> ConsoleColor.log(r, ConsoleColor.ANSI_CYAN));


        ConsoleColor.log("\n---- Update Reiziger (same instance as previous; achternaam=TEST)", ConsoleColor.ANSI_BLUE);
        reiziger.setAchternaam("TEST");
        ReizigerService.getInstance().getReizigerDao().update(reiziger);
        ReizigerService.getInstance().getReizigerDao().closeCurrentSession();

        // Load object from database
        reiziger = ReizigerService.getInstance().findById(5);
        ConsoleColor.log(reiziger, ConsoleColor.ANSI_CYAN);

        // Revert back
        reiziger.setAchternaam("Piccardo");
        ReizigerService.getInstance().update(reiziger);

        if (true) {
            ConsoleColor.log("\n---- Create Reiziger with OVChipkaart", ConsoleColor.ANSI_BLUE);
            reiziger = new Reiziger(6, "Stefan", "van", "Echtelt",
                    Date.valueOf(new GregorianCalendar(2000, Calendar.FEBRUARY, 10)
                            .toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate()));

            ovChipkaart = new OVChipkaart(12345,
                    Date.valueOf(new GregorianCalendar(2019, Calendar.DECEMBER, 10)
                            .toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate()),
                    2, 50f, reiziger);
            reiziger.setOVChipkaarten(new ArrayList<>(Collections.singletonList(ovChipkaart)));

            ReizigerService.getInstance().persist(reiziger);

            reiziger = ReizigerService.getInstance().findById(6);
            ConsoleColor.log(reiziger, ConsoleColor.ANSI_CYAN);
        }


        if (true) {
            ConsoleColor.log("\n---- Delete Reiziger", ConsoleColor.ANSI_BLUE);

            ReizigerService.getInstance().delete(reiziger);

            reiziger = ReizigerService.getInstance().findById(6);

            if (reiziger == null) {
                ConsoleColor.log("Reiziger verwijderd", ConsoleColor.ANSI_CYAN);
            } else {
                ConsoleColor.log("Reiziger NIET verwijderd", ConsoleColor.ANSI_CYAN);
            }
        }

        ConsoleColor.log("\n---- Shutdown", ConsoleColor.ANSI_BLUE);
        HibernateUtil.shutdown();
    }

}
