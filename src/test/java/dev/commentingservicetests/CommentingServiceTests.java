package dev.commentingservicetests;

import com.investing_app.customexceptions.NoValueException;
import com.investing_app.customexceptions.NotValidDate;
import com.investing_app.customexceptions.TooLong;
import com.investing_app.dao.CommentingDAO;
import com.investing_app.dao.CommentingDAOImp;
import com.investing_app.customexceptions.CommentNotFound;
import com.investing_app.entities.Commenting;
import com.investing_app.service.CommentingServices;
import com.investing_app.service.CommentingServicesImp;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class CommentingServiceTests {

    static CommentingDAO commentingDAO = new CommentingDAOImp();
    static CommentingServices commentingServices = new CommentingServicesImp(commentingDAO);
    static Commenting commentingExample;
    static Commenting commentingExample2;
    static Commenting commentingExample3;
    static Commenting commentingExample4;
    static Commenting commentingExample5;
    static Commenting commentingExample6;
    static Commenting commentingExample7;
    static Commenting tooLongComment;
    static Commenting tooLongComment2;
    static Commenting anotherExample;
    static Commenting anotherExample2;
    static List <Commenting> newListTwo;

    @BeforeClass
    public static void setup(){
        commentingDAO = Mockito.mock(CommentingDAO.class);
        commentingServices = new CommentingServicesImp(commentingDAO);
        commentingExample = new Commenting(0, 1, 1, "No deal", "2022/01/01");
        commentingExample2 = new Commenting(0, 1, 1, "No deal", "llkjljkllkjkljljk;jk");
        commentingExample3 = new Commenting(1, 1, 1, "No deal", "llkjljkllkjkljljk;jk");
        commentingExample4 = new Commenting(0, 1, 1, "No deal", "");
        commentingExample5 = new Commenting(1, 1, 1, "No deal", "");
        commentingExample6 = new Commenting(0, 1, 1, "", "2022/01/01");
        commentingExample7 = new Commenting(1, 1, 1, "", "2022/01/01");
        anotherExample = new Commenting(0, 1, 1, "This is very good!", "2022/01/08");
        anotherExample2 = new Commenting(1, 1, 1, "This is very bad! No Deal!", "2022/01/08");
        tooLongComment = new Commenting(0, 1, 1, "asdfjklfdsjkfdjskjksdafjklsdkjlfdsjkl;fdsjklfdjsklfdjsklfdsajklfdsjklfdsjkl;fdsakjlfsdjklfdsjklfsjklfdsjklfdsjklfsajklfdsjklfdsjklfsdjklfsadjklfdsjklfsdajklfdsjklfdsjklfsdjklfsdajklfdsajklfsjklfdsjkldfsajklfdsjklfdskjlfdsjklfdsjklfsdjklfdsjklfdsaljkfsdljksdfjlkfdsjlkfsdjklfdsjkl", "2022/01/01");
        tooLongComment2 = new Commenting(0, 1, 1, "asdfjklfdsjkfdjskjksdafjklsdkjlfdsjkl;fdsjklfdjsklfdjsklfdsajklfdsjklfdsjkl;fdsakjlfsdjklfdsjklfsjklfdsjklfdsjklfsajklfdsjklfdsjklfsdjklfsadjklfdsjklfsdajklfdsjklfdsjklfsdjklfsdajklfdsajklfsjklfdsjkldfsajklfdsjklfdskjlfdsjklfdsjklfsdjklfdsjklfdsaljkfsdljksdfjlkfdsjlkfsdjklfdsjkl", "2022/01/01");
    }

    //  No ID for Find ID
    @Test(expectedExceptions =  CommentNotFound.class)
    public void badIdForCommentMockito() {
        Mockito.when(commentingDAO.getCommentById(2)).thenThrow(new CommentNotFound("Comment not found"));
        commentingServices.getCommentByIdService(2);
    }
    // Create Comment  --  Too long of a date
    @Test(expectedExceptions = TooLong.class)
    public void badCommentDateMockito() {
        Mockito.when(commentingDAO.createComment(commentingExample2)).thenReturn(commentingExample3);
        commentingServices.createCommentService(commentingExample2);
    }

    // Leaving Empty Value for Date
    @Test(expectedExceptions = NotValidDate.class)
    public void noDateMockito(){
        Mockito.when(commentingDAO.createComment(commentingExample4)).thenReturn(commentingExample5);
        commentingServices.createCommentService(commentingExample4);
    }

    //  Leaving Empty Value for Comment
    @Test(expectedExceptions = NoValueException.class)
    public void noCommentMockito(){
        Mockito.when(commentingDAO.createComment(commentingExample6)).thenReturn(commentingExample7);
        commentingServices.createCommentService(commentingExample6);
    }

    //  Too many chars for Comment
    @Test(expectedExceptions = TooLong.class)
    public void tooLongCommentMockito(){
        Mockito.when(commentingDAO.createComment(tooLongComment)).thenReturn(tooLongComment2);
        commentingServices.createCommentService(tooLongComment);
    }

    //  -------------------  Happy Tests Below --------------------------
    @Test
    public void createCommentMockito(){
        Mockito.when(commentingDAO.createComment(anotherExample)).thenReturn(anotherExample2);
        Commenting creation = commentingServices.createCommentService(anotherExample);
        Assert.assertEquals(creation, anotherExample2);
    }

    @Test
    public void getCommentMockito(){
        Mockito.when(commentingDAO.getCommentById(anotherExample.getCommentId())).thenReturn(anotherExample2);
        Commenting result = commentingServices.getCommentByIdService(anotherExample.getCommentId());
        Assert.assertEquals(result, anotherExample2);
    }

    @Test
    public void getAllComments(){
        Mockito.when(commentingDAO.getAllComments()).thenReturn(newListTwo);
        List<Commenting> result = commentingServices.getAllCommentsService();
        Assert.assertEquals(result, newListTwo);
    }
}
