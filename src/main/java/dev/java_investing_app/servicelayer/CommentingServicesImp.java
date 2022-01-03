package dev.java_investing_app.servicelayer;

import dev.java_investing_app.DAO.CommentingDAO;
import dev.java_investing_app.entities.Commenting;

import java.util.List;

public class CommentingServicesImp implements CommentingServices{
    CommentingDAO commentingDAO;
    public CommentingServicesImp (CommentingDAO commentingDAO){
        this.commentingDAO = commentingDAO;
    }

    @Override
    public Commenting createCommentService(Commenting commenting) {
        return this.commentingDAO.createComment(commenting);
    }

    @Override
    public Commenting getCommentByIdService(int id) {
        return null;
    }

    @Override
    public List<Commenting> getAllCommentsService() {
        return null;
    }
}
