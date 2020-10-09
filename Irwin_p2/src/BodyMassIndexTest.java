import static org.junit.jupiter.api.Assertions.*;
import org.testng.annotations.Test;

public class BodyMassIndexTest {
    //
    // Considering what is in my BodyMassIndex Class, Doesn't the follow category tests
    // also show that the methods in said Class work properly?
    //
    @Test
    public void testBmiCalcUnderweight(){
        BodyMassIndex bmi = new BodyMassIndex(68,100);

        double answer = bmi.calculateBmi();

        assertEquals(15.20, answer, 0.01);
    }

    @Test
    public void testBmiCalcOverweight(){
        BodyMassIndex bmi = new BodyMassIndex(50,100);

        double answer = bmi.calculateBmi();

        assertEquals(28.12, answer, 0.01);
    }

    @Test
    public void testBmiCalcNormalWeight(){
        BodyMassIndex bmi = new BodyMassIndex(55,100);

        double answer = bmi.calculateBmi();

        assertEquals(23.24, answer, 0.01);
    }

    @Test
    public void testBmiCalcObese(){
        BodyMassIndex bmi = new BodyMassIndex(40,100);

        double answer = bmi.calculateBmi();

        assertEquals(43.94, answer, 0.01);
    }


}