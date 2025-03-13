import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    private Cat cat;

    @Mock
    Feline feline;

    @Before
    public void setUp() {
        cat = new Cat(feline);
    }

    @Test
    public void getSoundTest() {
        assertEquals("Кот должен издавать 'Мяу'", "Мяу", cat.getSound());
    }

    @Test
    public void getFoodTest() throws Exception {
        List<String> catFood = Arrays.asList("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(catFood);
        assertEquals("Кот должен есть животную пищу",catFood, cat.getFood());
        Mockito.verify(feline, times(1)).eatMeat();
    }
}
