package dev.java_investing_app.controllers;

import io.javalin.http.Handler;

public class AppController {

    // change this handler to return the home page (home.html)
    public Handler hello = (ctx) -> {
        ctx.result("Hello there!");
        ctx.status(200);
    };

    // change this handler to return the business page (business.html)
    public Handler business = (ctx) -> {
        ctx.result("Hello from business page!");
        ctx.status(200);
    };

    // change this handler to return the shark page (shark.html)
    public Handler shark = (ctx) -> {
        ctx.result("Hello from shark page!");
        ctx.status(200);
    };
}
