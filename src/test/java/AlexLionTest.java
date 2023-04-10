import com.example.AlexLion;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class AlexLionTest {

    @Mock
    Feline feline;

    @Test
    public void  getPlaceOfLiving() throws Exception {

        AlexLion alexLion = new AlexLion(feline);
        String actualPlace= alexLion.getPlaceOfLiving();
        String expectedPlace = "Нью-Йоркский зоопарк";
        Assert.assertEquals(expectedPlace,actualPlace);
    }

    @Test
    public void getFriendsReturnCorrectValue() {

        try {
            AlexLion alexLion = new AlexLion(feline);
            List<String> actualFriends   = alexLion.getFriends();
            List<String> expectedFriends = List.of("Марти", "Глория","Мелман");
            Assert.assertEquals(expectedFriends, actualFriends);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void getKittensReturnCorrectValue() {

        try {
            AlexLion alexLion = new AlexLion(feline);
            int actualKittens  = alexLion.getKittens();
            int expectedKittens = 0;
            Assert.assertEquals(expectedKittens, actualKittens);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
