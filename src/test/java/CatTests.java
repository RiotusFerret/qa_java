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
public class CatTests {
    @Mock
    Feline mockFeline;

    @Test
    public void getSoundTest(){
        Cat cat = new Cat(mockFeline);
        Assert.assertEquals("Мяу", cat.getSound());
    }
    @Test
    public void getFoodTest() throws Exception {
        Cat cat = new Cat(mockFeline);
        Mockito.when(mockFeline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), cat.getFood());
    }
    @Test(expected = Exception.class)
        public void getFoodTestTrowsException() throws Exception {
        Cat cat = new Cat(mockFeline);
        Mockito.when(mockFeline.eatMeat()).thenThrow(new Exception("Неизвестный вид животного, используйте значение Травоядное или Хищник"));
        cat.getFood();
    }
}
