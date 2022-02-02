import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientParameterizedTest {
    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientParameterizedTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[] getData() {
        return new Object[][]{
                {IngredientType.SAUCE, "hot sauce", 100},
                {IngredientType.FILLING, "cutlet", 100},
        };
    }

    @Test
    public void getIngredientTypeTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Тип ингредиента не получен",ingredient.type, type);
    }

    @Test
    public void getNameIngredientTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Имя ингредиента не получено",ingredient.getName(), name);
    }

    @Test
    public void getIngredientPriceTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Стоимость ингредиента не получена",ingredient.price, price, 0);
    }
}