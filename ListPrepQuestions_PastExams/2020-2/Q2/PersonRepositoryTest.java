
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonRepositoryTest {

    SequenceGenerator sequenceGenerator;
    PersonRepository personRepository;

    @Before
    public void before() {
        sequenceGenerator = new SequenceGenerator();
        personRepository = new PersonRepository();
        personRepository.setSequenceGenerator(sequenceGenerator);
    }

    // Implement your test cases
    // Hint: The java.lang.Integer.intValue() is an inbuilt method in Java that returns the value of an Integer as an int.

    // ########## YOUR CODE STARTS HERE ##########
    @Test(timeout = 1000)
    public void saveTest(){
        Person p = new Person("Alice", 23, "student", false, false);
        assertEquals(1, personRepository.save(p).getId().intValue());
    }

    @Test(expected = RuntimeException.class)
    public void saveExceptionTest(){
        Person p = new Person("Alice", 23, "student", false, false);
        p.setId(3);
        personRepository.save(p);
    }

    @Test(timeout = 1000)
    public void findByIdTest(){
        Person p1 = new Person("Alice", 23, "student", false, false);
        personRepository.save(p1);
        assertEquals(p1, personRepository.findById(p1.getId()));
        Person p2 = new Person("Bob", 30, "student", false, false);
        personRepository.save(p2);
        assertEquals(p2, personRepository.findById(p2.getId()));;
    }

    @Test(timeout = 1000)
    public void setSequenceGeneratorTest(){
        assertTrue(personRepository.setSequenceGenerator(new SequenceGenerator()));
    }
    // ########## YOUR CODE ENDS HERE ##########


}
