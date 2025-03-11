import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FelineParametrizedTest {

    private final int kittensCount;
    Feline feline;

    public FelineParametrizedTest(int kittensCount) {
        this.kittensCount = kittensCount;

    }

    @Before
    public void setUp() {
        feline = new Feline();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> kittensData() {
        return Arrays.asList(new Object[][]{
                {1},
                {10},
                {3}
        });
    }

    @Test
    public void getKittensWithCount() {
        assertEquals("Количество котят должно быть верным", kittensCount , feline.getKittens(kittensCount));
    }
}
