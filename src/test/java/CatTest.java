import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;

    @Test
    public void getSoundReturnCorrectValue(){

        Cat cat = new Cat(feline);
        String actualSound = cat.getSound();
        String expectedSound = "Мяу";
        Assert.assertEquals(expectedSound,actualSound);
    }


    @Test
    public void getFoodReturnCorrectValue() {

        try {
            Cat cat = new Cat(feline);
            Mockito.when(feline.eatMeat()).thenReturn(List.of("Мясо"));
            List<String> actualFood = cat.getFood();
            List<String> expectedFood = List.of("Мясо");
            Assert.assertEquals(expectedFood, actualFood);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
