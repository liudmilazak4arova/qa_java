import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FelineTest {

    @Test
    public void getFamilyReturnCorrectValue(){
        Feline feline = new Feline();
        String actualFamily = feline.getFamily();
        String expectedFamily = "Кошачьи";
        Assert.assertEquals(expectedFamily,actualFamily);
    }

    @Test
    public void eatMeatReturnCorrectValue(){
        Feline feline = new Feline();
        try {
            List<String> expectedEat = List.of("Животные", "Птицы", "Рыба");
            Assert.assertEquals(expectedEat, feline.eatMeat());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void getKittenSingleReturnCorrectValue(){
        Feline feline = new Feline();
        int actualValue= feline.getKittens();
        int expectedValue = 1;
        Assert.assertEquals(expectedValue,actualValue);
    }

    @Test
    public void getKittenManyReturnCorrectValue(){
        Feline feline = new Feline();
        int expectedValue = 5;
        int actualValue= feline.getKittens(expectedValue);
        Assert.assertEquals(expectedValue,actualValue);
    }
}
