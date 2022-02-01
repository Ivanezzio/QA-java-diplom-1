import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {

    Bun bun = new Bun("звездный хлеб", 123f);

    @Test
    public void getNameTest() {
        String actual = bun.getName();
        String expected = "звездный хлеб";
        assertEquals("Имя булочки отличается",expected, actual);
    }

    @Test
    public void getPriceTest() {
        float actual = bun.getPrice();
        float expected = 123f;
        assertEquals("Стоимость булочки отличается",expected, actual, 0);
    }


}
