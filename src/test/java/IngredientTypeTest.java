import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {
    @Test
    public void getIngredientTypeSauceTest() {
        String expected = "SAUCE";
        String actual = IngredientType.SAUCE.name();
        assertEquals("Некорректный ожидаемый тип ингредиента", expected, actual);
    }

    @Test
    public void getIngredientTypeFillingTest() {
        String expected = "FILLING";
        String actual = IngredientType.FILLING.name();
        assertEquals("Некорректный ожидаемый тип ингредиента", expected, actual);
    }
}
