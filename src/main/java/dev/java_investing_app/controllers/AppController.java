package dev.java_investing_app.controllers;

import io.javalin.http.Handler;

public class AppController {

    // change this handler to return the home page (home.html)
    public Handler hello = (ctx) -> {
        ctx.result("Hello there!");
        ctx.status(200);
    };
}
