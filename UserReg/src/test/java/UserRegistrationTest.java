import UserRegistration.UserRegistration;
import org.junit.Assert;
import org.junit.Test;


public class UserRegistrationTest {

    //Test case for FirstName//
    @Test
    public void whenGivenFirstName_shouldReturnFirsLatterCaptial() {
        UserRegistration FirstName = new UserRegistration();
        String message = FirstName.checkFirstName("Sonam");
        Assert.assertEquals("valid", message);
    }
    @Test
    public void whenGivenFirstName_shouldReturnFirsLatterNotCaptial() {
        UserRegistration FirstName = new UserRegistration();
        String message = FirstName.checkFirstName("sonam");
        Assert.assertEquals("Invalid", message);
    }
    @Test
    public void whenGivenFirstName_shouldReturnIsMinumMum3Char() {
        UserRegistration FirstName = new UserRegistration();
        String message = FirstName.checkFirstName("wo");
        Assert.assertEquals("Invalid", message);
    }
    @Test
    public void whenGivenFirstName_shouldReturnFirstNameIsOnalyCharacter() {
        UserRegistration FirstName = new UserRegistration();
        String message = FirstName.checkFirstName("12345");
        Assert.assertEquals("Invalid", message);
    }
    //Test case for LastName//
    @Test
    public void whenGivenlastName_shouldReturnLastNameStartWithCaptial() {
        UserRegistration LastName = new UserRegistration();
        String message = LastName.checkLastName("SonamSingh");
        Assert.assertEquals("valid", message);
    }
    @Test
    public void whenGivenlastName_shouldReturnLastNameStartWithSmall() {
        UserRegistration LastName = new UserRegistration();
        String message = LastName.checkLastName("Sonamsingh");
        Assert.assertEquals("Invalid", message);
    }
    @Test
    public void whenGivenlastName_shouldReturnLastNameStartWithNumber() {
        UserRegistration LastName = new UserRegistration();
        String message = LastName.checkLastName("Sonam123Singh");
        Assert.assertEquals("Invalid", message);
    }
    @Test
    public void whenGivenlastName_shouldReturnLastNameEndingtWithNumber() {
        UserRegistration LastName = new UserRegistration();
        String message = LastName.checkLastName("SonamSingh1234");
        Assert.assertEquals("Invalid", message);
    }
    @Test
    public void whenGivenlastName_shouldReturnLastNameMaxmum3Wcharcater() {
        UserRegistration LastName = new UserRegistration();
        String message = LastName.checkLastName("SonamSingh");
        Assert.assertEquals("valid", message);
    }
    //Test case for Email//
    @Test
    public void whenGivenEmail_shouldReturnVaildMail() {
        UserRegistration Email = new UserRegistration();
        String message = Email.checkEmail("SonamSingh1528@gmail.com");
        Assert.assertEquals("valid", message);
    }
    @Test
    public void whenGivenEmail_shouldReturnInvaildMail() {
        UserRegistration Email = new UserRegistration();
        String message = Email.checkEmail(".SonamSingh1528@gmail.com");
        Assert.assertEquals("invalid", message);
    }
    //test case for PhoneNumber//
    @Test
    public void whenGivenPhoneNumber_shouldReturnValidPhoneNumber() {
        UserRegistration phoneNumber = new UserRegistration();
        String message = phoneNumber.checkPhoneNumber("+91 9955755760");
        Assert.assertEquals("valid", message);
    }
    @Test
    public void whenGivenPhoneNumber_shouldReturnValidPhoneNumberWithoutUsingPlusSymbol() {
        UserRegistration phoneNumber = new UserRegistration();
        String message = phoneNumber.checkPhoneNumber("91 9955755760");
        Assert.assertEquals("valid", message);
    }
    @Test
    public void whenGivenPhoneNumber_shouldReturnValidPhoneNumberWithoutUsingISDno() {
        UserRegistration phoneNumber = new UserRegistration();
        String message = phoneNumber.checkPhoneNumber("9955755760");
        Assert.assertEquals("invalid", message);
    }
    //Test case for password character//
    @Test
    public void whenGivenPasswordCharacters_shouldReturnMinmum8CharacterIsValid() {
        UserRegistration characters = new UserRegistration();
        String message = characters.checkPassword("sonamSingh@12");
        Assert.assertEquals("valid", message);
    }
    @Test
    public void whenGivenPasswordCharacters_shouldReturnLessThan8CharacterIsInValid() {
        UserRegistration characters = new UserRegistration();
        String message = characters.checkPassword("A7O");
        Assert.assertEquals("invalid", message);
    }
    //Test case One Should we upper case//
    @Test
    public void whenGivenPasswordCharacters_shouldReturnPasswordCharWithouUsngUpperCaseIsInvalid() {
        UserRegistration characters = new UserRegistration();
        String message = characters.checkPassword("adghciufhdjn5376");
        Assert.assertEquals("invalid", message);
    }
    //Test case At least one Numeric Number//
    @Test
    public void whenGivenPasswordCharacters_shouldReturnPasswordCharWithouUingNumericValue() {
        UserRegistration characters = new UserRegistration();
        String message = characters.checkPassword("adghcABufhdjn");
        Assert.assertEquals("invalid", message);
    }

    @Test
    public void whenGivenPasswordCharacters_shouldReturnPasswordCharWithouUingSpecialCharacters() {
        UserRegistration characters = new UserRegistration();
        String message = characters.checkPassword("A123RTsadfsh");
        Assert.assertEquals("invalid", message);
    }

}