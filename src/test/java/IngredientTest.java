import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType type;
    private final String name;
    private final float price;

    //Ingredient ingredient = new Ingredient(SAUCE,"кетчунез",852);

    public IngredientTest(IngredientType type, String name, float price) {
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
    public void getIngredientTypeTest(){
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(ingredient.type, type);
    }

    @Test
    public void getNameIngredientTest(){
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(ingredient.getName(),name);
    }

    @Test
    public void getIngredientPriceTest(){
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(ingredient.price, price,0);
    }
}
