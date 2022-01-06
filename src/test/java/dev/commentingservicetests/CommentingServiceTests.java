package dev.commentingservicetests;

import com.investing_app.databaseinteraction.CommentingDAO;
import com.investing_app.databaseinteraction.CommentingDAOImp;
import com.investing_app.customexceptions.CommentNotFound;
import com.investing_app.entities.Commenting;
import com.investing_app.service.CommentingServices;
import com.investing_app.service.CommentingServicesImp;
import org.testng.annotations.Test;

public class CommentingServiceTests {

    static CommentingDAO commentingDAO = new CommentingDAOImp();
    static CommentingServices commentingServices = new CommentingServicesImp(commentingDAO);

    @Test(expectedExceptions = CommentNotFound.class, expectedExceptionsMessageRegExp = "Comment not found")
    void badIdForComment() {
        Commenting commenting = commentingServices.getCommentByIdService(55678);
    }
}
