
import UserRegistration.UserRegistration;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class EmailTest {

    private String emailId;
    String expectedResult;

    public EmailTest(String emailId, String expectedResult) {
        this.emailId = emailId;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection emailsCollections() {

        return Arrays.asList(new Object[][]{

                {"abc@yahoo.com","valid"},
                {"abc-100@yahoo.com","valid"},
                {"abc.100@yahoo.com","valid"},
                {"abc111@abc.com","valid"},
                {"abc-100@abc.net","valid"},
                {"abc.100@abc.com.au","valid"},
                {"abc@1.com","valid"},
                {"abc@gmail.com.com","valid"},
                {"abc-gmail.com","invalid"},
                {"abc@.com.my","invalid"},
                {"abc123@gmail.a","invalid"},
                {"abc123@.com","invalid"},
                {"abc123@.com.com","invalid"},
                {".abc@abc.com","invalid"},
                {"abc()*@gmail.com","invalid"},
                {"abc@%*.com","invalid"},
                {"abc..2002@gmail.com","invalid"},
                {"abc.@gmail.com","invalid"},
                {"abc@abc@gmail.com","invalid"},
                {"abc@gmail.com.1a","invalid"},
                {"abc@gmail.com.aa.au","invalid"}
        });
    }

    @Test
    public void whenGivenEmailIds_WithAllCases_ShouldReturnTrueOrFalse() {

        UserRegistration testUserRegistration = new UserRegistration();
        String emailIds = testUserRegistration.checkEmail(emailId);
        Assert.assertEquals(emailIds,expectedResult);
    }
}