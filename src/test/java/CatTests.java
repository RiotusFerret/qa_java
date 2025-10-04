import com.example.Cat;
import com.example.Feline;
import com.example.Predator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTests {
    @Mock
    Feline mockFeline;

    Predator predator;

    @Test
    public void getSoundTest(){
        Cat cat = new Cat(mockFeline);
        assertEquals("Мяу", cat.getSound());
    }
    @Test(expected = Exception.class)
    public void getFoodTestTrowsException() throws Exception {
        Cat cat = new Cat(mockFeline);
        try {
            Assert.assertEquals(List.of(), cat.getFood());
        } catch (Exception exception) {
            throw new Exception("Ошибка");
        }
        verify(predator, times(1)).eatMeat();
    }
}
