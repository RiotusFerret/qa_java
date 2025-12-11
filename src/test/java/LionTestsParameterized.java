import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class LionTestsParameterized {
    private final String sex;
    private final boolean hasManeExp;
    boolean hasMane;

    Feline feline;

    public LionTestsParameterized(String sex, boolean hasManeExp) {
    this.sex = sex;
    this.hasManeExp = hasManeExp;
    }
    @Parameterized.Parameters
    public static Object[][] hasManeData() {
        return new Object[][]{
                {"Самка", false},
                {"Самец", true},
        };
    }

    @Test
    public void doesHaveManeTest() throws Exception {
            Lion lion = new Lion(sex, feline);
            hasMane = lion.doesHaveMane();
            Assert.assertEquals(hasManeExp, hasMane);
    }
}

