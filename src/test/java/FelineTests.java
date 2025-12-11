import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineTests {

Feline feline = new Feline();

    @Test
    public void getFamilyTest() {
    String family = feline.getFamily();
    Assert.assertEquals("Кошачьи", family);
    }
    @Test
    public void getKittensWithArg() {
    int arg = 2;
    int result = feline.getKittens(arg);
    Assert.assertEquals(arg, result);
    }
    @Test
    public void getKittensWithoutArg() {
    Assert.assertEquals(1, feline.getKittens());
    }
    @Test
    public void eatMeatTest() throws Exception {
    List<String> foodList = feline.eatMeat();
    Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), foodList);
    }
}
