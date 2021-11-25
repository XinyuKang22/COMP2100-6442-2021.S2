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

    @Test(timeout = 1000)
    public void getNameTest(){
        Assert.assertEquals("Alice", p.getName());
    }

    @Test(timeout = 1000)
    public void getAgeTest(){
        Assert.assertEquals(23, p.getAge().intValue());
    }

    @Test(timeout = 1000)
    public void getOccupationTest(){
        Assert.assertEquals("student", p.getOccupation());
    }

    @Test(timeout = 1000)
    public void getDiabetesTest(){
        Assert.assertFalse(p.getDiabetes());
    }

    @Test(timeout = 1000)
    public void getHeartDiseaseTest(){
        Assert.assertFalse(p.getHeartDisease());
    }

    @Test(timeout = 1000)
    public void getHealthInsurancePriceTest(){
        Assert.assertEquals(350, p.getHealthInsurancePrice().intValue());
    }

    @Test(timeout = 1000)
    public void calcInsurancePriceTest(){
        Person p;
        p = new Person("", 50, null, true, true);
        Assert.assertEquals(1100, p.getHealthInsurancePrice().intValue());

        p = new Person("", 50, null, false, false);
        Assert.assertEquals(360, p.getHealthInsurancePrice().intValue());

        p = new Person("", 50, "", false, true);
        Assert.assertEquals(500, p.getHealthInsurancePrice().intValue());

        p = new Person("", 50, "", true, false);
        Assert.assertEquals(400, p.getHealthInsurancePrice().intValue());

        p = new Person("", 20, "policeman", false, false);
        Assert.assertEquals(200, p.getHealthInsurancePrice().intValue());

        p = new Person("", 78, "president", false, false);
        Assert.assertEquals(350, p.getHealthInsurancePrice().intValue());
    }

    // ########## YOUR CODE ENDS HERE ##########

}
