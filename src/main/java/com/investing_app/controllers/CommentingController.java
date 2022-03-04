package com.investing_app.controllers;

import com.google.gson.Gson;
import com.investing_app.customexceptions.CommentNotFound;
import com.investing_app.customexceptions.NoValueException;
import com.investing_app.customexceptions.TooLong;
import com.investing_app.entities.Business;
import com.investing_app.entities.Commenting;
import com.investing_app.service.CommentingServices;
import io.javalin.http.Handler;

import java.util.List;

public class CommentingController {
    CommentingServices commentingServices;
    public CommentingController(CommentingServices commentingServices) {
        this.commentingServices = commentingServices;
    }

    public Handler createComment = ctx ->{
        try {
            Gson gson = new Gson();
            Commenting newComment = gson.fromJson(ctx.body(), Commenting.class);
            Commenting createdComment = this.commentingServices.createCommentService(newComment);
            String createdCommentJson = gson.toJson(createdComment);
            ctx.result(createdCommentJson);
            ctx.status(201);
        } catch (TooLong e) {
            ctx.result(e.getMessage());
            ctx.status(404);
        } catch (Exception e) {
            ctx.result(e.getMessage());
            ctx.status(400);
        }
    };

    public Handler getComment = ctx -> {
        int id = Integer.parseInt(ctx.pathParam("id"));
        try {
            Commenting commenting = this.commentingServices.getCommentByIdService(id);
            Gson gson = new Gson();
            String commentJson = gson.toJson(commenting);
            ctx.result(commentJson);
            ctx.status(200);
        } catch (CommentNotFound e){
            ctx.result(e.getMessage());
            ctx.status(404);
        } catch (Exception e) {
            ctx.result(e.getMessage());
            ctx.status(404);
        }
    };

    public Handler getAllComments = ctx ->{
        List<Commenting> comments = this.commentingServices.getAllCommentsService();
        Gson gson = new Gson();
        String commentsJSONs = gson.toJson(comments);
        ctx.result(commentsJSONs);
        ctx.status(200);
    };
}
