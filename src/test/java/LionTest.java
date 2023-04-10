import com.example.Cat;
import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class LionTest {
    private final String sex;
    private final boolean hasMane;

    @Mock
    Feline feline;
    public LionTest(String sex, boolean hasMane){
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
        Object[][] data = new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
        return Arrays.asList(data);
    }

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getFoodReturnCorrectValue() {

        try {
            Lion lion = new Lion("Самка",feline);
            Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Мясо"));
            List<String> actualFood = lion.getFood();
            List<String> expectedFood = List.of("Мясо");
            Assert.assertEquals(expectedFood, actualFood);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getHasManeReturnCorrectValue() {

        try {
            Lion lion = new Lion(sex,feline);
            boolean actualHasMane = lion.doesHaveMane();
            Assert.assertEquals(hasMane, actualHasMane);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getHasManeReturnException() {

        try {
            Lion lion = new Lion("Нечто",feline);
            boolean actualHasMane = lion.doesHaveMane();
        } catch (Exception e) {
            Assert.assertNotEquals("", e.getMessage());
        }
    }

    @Test
    public void getKittenSingleReturnCorrectValue(){

        try {
            Lion lion = new Lion("Самка",feline);
            Mockito.when(feline.getKittens()).thenReturn(1);
            int actualValue= lion.getKittens();
            int expectedValue = 1;
            Assert.assertEquals(expectedValue,actualValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
