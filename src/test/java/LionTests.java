import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTests {
    @Spy
    Feline feline;

    public LionTests() throws Exception {
    }

    @Test
    public void getKittensTest() throws Exception {
    Lion lion = new Lion("Самка", feline);
    Assert.assertEquals(1, lion.getKittens());
    }

    @Test(expected = Exception.class)
    public void doesHaveManeTestTrowsException() throws Exception {
        try {
            Lion lion = new Lion("null", feline);
            Assert.assertEquals(false, lion.doesHaveMane());
        } catch (Exception exception) {
         throw new Exception("Используйте допустимые значения пола животного - самей или самка");
        }
    }
    @Test
    public void getFoodTest() throws Exception {
    Lion lion = new Lion("Самец", feline);
    Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }
    @Test // Дублирует тест с параметризацией т.к. иначе не засчитывалось покрытие в jacoco
    public void doesHaveManeTest() throws Exception {
        Lion lion = new Lion("Самка", feline);
        boolean hasMane = lion.doesHaveMane();
        Assert.assertEquals(false, hasMane);
    }
    @Test(expected = Exception.class)
    public void getFoodTestTrowsException() throws Exception {
            Lion lion = new Lion("Самец", feline);
            try {
                String animalKind = "Ксеноморф";
             feline.getFood(animalKind);
            } catch (Exception exception) {
                throw new Exception("Неизвестный вид животного, используйте значение Травоядное или Хищник");
            }
    }

}
