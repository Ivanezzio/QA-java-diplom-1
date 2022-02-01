import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Database database = new Database();
    Burger burger = new Burger();

    @Mock
    Bun mockBun;

    @Mock
    private Ingredient ingredientMock;

    @Test
    public void isBunSetTest() {
        burger.setBuns(mockBun);
        assertNotNull("Булочка не добавлена",burger.bun);
    }

    @Test
    public void isIngredientAddedTest() {
        burger.addIngredient(ingredientMock);
        assertNotNull("Ингредиенты не добавлены",burger.ingredients.size());
    }

    @Test
    public void RemoveIngredientTest() {
        burger.addIngredient(ingredientMock);
        burger.removeIngredient(0);
        assertTrue("Ингредиенты не удалены",burger.ingredients.isEmpty());
    }

    @Test
    public void MoveIngredientTest() {
        Ingredient firstIngredient = new Ingredient(IngredientType.SAUCE, "chili sauce", 300);
        Ingredient secondIngredient = new Ingredient(IngredientType.FILLING, "cutlet", 100);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(0, 1);
        assertEquals("Ингредиенты не перемещены", burger.ingredients.get(0), secondIngredient);
    }

    @Test
    public void GetPriceTest() {
        burger.setBuns(mockBun);
        Mockito.when(mockBun.getPrice()).thenReturn(100f);
        burger.addIngredient(ingredientMock);
        Mockito.when(ingredientMock.getPrice()).thenReturn(200f);
        assertEquals("Стоимость вычеслена неверно", burger.getPrice(), 400f, 0);

    }

    @Test
    public void GetReceiptTest() {
        burger.setBuns(mockBun);
        Mockito.when(mockBun.getName()).thenReturn("white bun");
        burger.addIngredient(ingredientMock);
        Mockito.when(ingredientMock.getName()).thenReturn("hot sauce");
        burger.addIngredient(ingredientMock);
        Mockito.when(ingredientMock.getName()).thenReturn("cutlet");
        assertTrue("Рецепт не содержит добавленные ингредиенты", (burger.getReceipt().contains("white bun"))
                & (burger.getReceipt().contains("hot sauce"))
                & (burger.getReceipt().contains("cutlet")));

    }

}
