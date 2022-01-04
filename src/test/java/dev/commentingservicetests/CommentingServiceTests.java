package dev.commentingservicetests;

import dev.java_investing_app.DAO.CommentingDAO;
import dev.java_investing_app.DAO.CommentingDAOImp;
import dev.java_investing_app.customexceptions.CommentNotFound;
import dev.java_investing_app.entities.Commenting;
import dev.java_investing_app.servicelayer.CommentingServices;
import dev.java_investing_app.servicelayer.CommentingServicesImp;
import org.testng.annotations.Test;

import javax.xml.stream.events.Comment;

public class CommentingServiceTests {

    static CommentingDAO commentingDAO = new CommentingDAOImp();
    static CommentingServices commentingServices = new CommentingServicesImp(commentingDAO);

    @Test(expectedExceptions = CommentNotFound.class, expectedExceptionsMessageRegExp = "Comment not found")
    void badIdForComment() {
        Commenting commenting = commentingServices.getCommentByIdService(55678);
    }
}
