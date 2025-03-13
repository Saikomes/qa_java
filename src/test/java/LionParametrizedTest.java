import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;

@RunWith(Parameterized.class)
public class LionParametrizedTest extends LionTest {
    private Lion lion;

    boolean hasMane;

    String sex;

    public LionParametrizedTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> LionData() {
        return Arrays.asList(new Object[][]{
                {"Самец", true},
                {"Самка", false},
        });
    }

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        lion = new Lion(sex, feline);
    }

    @Test
    public void getKittensTest() {
        Mockito.when(feline.getKittens()).thenReturn(1);
        assertEquals("Число котят должно быть ожидаемым",1, lion.getKittens());
        Mockito.verify(feline, times(1)).getKittens();
    }

    @Test
    public void haveManeTest() {
        assertEquals("Грива должна быть только у львов", hasMane, lion.doesHaveMane());
    }

    @Test
    public void getFoodTest() throws Exception {
        List<String> catFood = Arrays.asList("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(catFood);
        assertEquals("Львы едят животную пищу", catFood, lion.getFood());
        Mockito.verify(feline, times(1)).getFood("Хищник");
    }
}
