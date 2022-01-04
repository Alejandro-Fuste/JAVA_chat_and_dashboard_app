package dev.java_investing_app.servicelayer;

import dev.java_investing_app.DAO.CommentingDAO;
import dev.java_investing_app.customexceptions.CommentNotFound;
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
        try {
            Commenting commenting = this.commentingDAO.getCommentById(id);
            return commenting;
        }
        catch (CommentNotFound e){
            throw new CommentNotFound("Comment not found");
        }
    }

    @Override
    public List<Commenting> getAllCommentsService() {
        return this.commentingDAO.getAllComments();
    }
}

