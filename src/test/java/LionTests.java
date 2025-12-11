import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class LionTests {
    @Mock
    Feline feline;

    public LionTests() throws Exception {
    }

    @Test
    public void getKittensTest() throws Exception {
    Lion lion = new Lion("Самка", feline);
    Mockito.when(lion.getKittens()).thenReturn(1);
    Assert.assertEquals(1, lion.getKittens());
    }

    @Test(expected = Exception.class)
    public void doesHaveManeTestTrowsException() throws Exception {
        try {
            Lion lion = new Lion("null", feline);
            Assert.assertEquals(false, lion.doesHaveMane());
        } catch (Exception exception) {
         throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
    }

    @Test(expected = Exception.class)
    public void getFoodTestTrowsException() throws Exception {
            Lion lion = new Lion("Самец", feline);
            String animalKind = "Ксеноморф";
            Mockito.when(feline.getFood(animalKind)).thenThrow(new Exception("Неизвестный вид животного, используйте значение Травоядное или Хищник"));
            feline.getFood(animalKind);
    }

}
