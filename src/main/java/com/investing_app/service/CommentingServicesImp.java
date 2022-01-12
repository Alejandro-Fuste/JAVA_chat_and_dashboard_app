package com.investing_app.service;

import com.investing_app.customexceptions.*;
import com.investing_app.dao.CommentingDAO;
import com.investing_app.entities.Commenting;

import java.util.List;
import java.util.regex.Pattern;

public class CommentingServicesImp implements CommentingServices {
    CommentingDAO commentingDAO;
    public CommentingServicesImp (CommentingDAO commentingDAO){
        this.commentingDAO = commentingDAO;
    }

    @Override
    public Commenting createCommentService(Commenting commenting) {
        try {
            if(commenting.getCreateDate().length() > 10){
                throw new TooLong("Your input is too many characters");
            } else if(commenting.getCreateDate().length() < 10){
                throw new NotValidDate("Must be 10 digits long");
            } else if(commenting.getCommenting().length() == 0){
                throw new NoValueException("Cannot leave boxes empty");
            } else if(commenting.getCommenting().length() > 200){
                throw new TooLong("Your input is too many characters");
            } else if (!Pattern.matches("^[0-9-/]*$", commenting.getCreateDate())){
                throw new OnlyNumbers("Create a valid date");
            } else {
                return this.commentingDAO.createComment(commenting);
            }
        } catch (CreateCommentException e) {
            throw new CreateCommentException("Unable to create comment");
        }
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

