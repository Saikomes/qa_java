import com.example.Feline;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FelineRegularTest {

    private Feline feline;

    @Before
    public void setUp() {
        feline = new Feline();
    }

    @Test
    public void eatMeatTest() throws Exception {
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        assertEquals("Еда должна быть подходящей", expectedFood, feline.eatMeat());
    }

    @Test
    public void getFamilyTest() {
        assertEquals("Семейство должно быть 'Кошачьи'", "Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensTest() {
        assertEquals(1, feline.getKittens());
    }
}