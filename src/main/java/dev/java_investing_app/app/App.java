package dev.java_investing_app.app;

import dev.java_investing_app.DAO.BusinessDAO;
import dev.java_investing_app.DAO.BusinessDAOImp;
import dev.java_investing_app.controllers.AppController;
import dev.java_investing_app.controllers.BusinessController;
import dev.java_investing_app.servicelayer.BusinessServices;
import dev.java_investing_app.servicelayer.BusinessServicesImp;
import io.javalin.Javalin;

public class App {
    public static void main(String[] args) {
        // app variable to creates Javalin connection
        Javalin app = Javalin.create(config -> {
            config.enableCorsForAllOrigins();
            config.enableDevLogging();
        });

        // need to do dependency injection for DAO & service layer here
        BusinessDAO businessDAO = new BusinessDAOImp();
        BusinessServices businessServices = new BusinessServicesImp(businessDAO);
        BusinessController businessController = new BusinessController(businessServices);
        // create appController variable
        AppController appController = new AppController();

        // routes
        // home route
        app.get("/", appController.hello);

        // business route
        app.get("/business", appController.business);
        app.get("/business/{id}", businessController.getBusiness);
        app.get("/business", businessController.getAllBusinesses);
        app.post("/business", businessController.createBusiness);

        // shark route
        app.get("/shark", appController.shark);

        // start app connection
        app.start();
    }

}
