import org.junit.Assert;
import org.junit.Test;

public class PersonTest {
     // Implement your test cases
    // Hint: The java.lang.Integer.intValue() is an inbuilt method in Java that returns the value of an Integer as an int.

    // ########## YOUR CODE STARTS HERE ##########
    //To test the `calcInsurancePrice()` method, which returns void, you can use the `getHealthInsurancePrice()` method, for example:
    //Person p = new Person("XYZ", 10, "XYZ", true, true);
    //assertEquals(0, p.getHealthInsurancePrice().intValue());

    Person p = new Person("Alice", 23, "student", false, false);

    @Test(timeout = 1000)
    public void setGetIdTest(){
        p.setId(1);
        Assert.assertEquals(1, p.getId().intValue());
    }

    // ########## YOUR CODE ENDS HERE ##########

}
