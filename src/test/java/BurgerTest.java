import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;
import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Database database = new Database();

    @Mock
    Bun mockBun;

@Test
    public void SetBunTest(){
    Burger burger = new Burger();
    burger.setBuns(mockBun);
    assertNotNull(burger.bun);
}


@Test
    public void AddIngredientTest(){
    Burger burger = new Burger();
    burger.addIngredient(database.availableIngredients().get(0));
    assertNotNull(burger.ingredients.size());
}

@Test
    public void RemoveIngredientTest(){
    Burger burger = new Burger();
    burger.addIngredient(database.availableIngredients().get(0));
    burger.removeIngredient(0);
    assertTrue(burger.ingredients.isEmpty());
}

@Test
    public void MoveIngredientTest(){
    Burger burger = new Burger();
    burger.addIngredient(database.availableIngredients().get(0));
    burger.addIngredient(database.availableIngredients().get(3));
    burger.moveIngredient(0,1);
    assertEquals(burger.ingredients.get(1),database.availableIngredients().get(0));
}

@Test
    public void GetPriceTest(){
    Burger burger = new Burger();
    burger.setBuns(database.availableBuns().get(1));
    burger.addIngredient(database.availableIngredients().get(3));
    assertEquals(burger.getPrice(),500f,0);

}

@Test
    public void GetReceiptTest(){
    Burger burger = new Burger();
    burger.setBuns(database.availableBuns().get(1));
    burger.addIngredient(database.availableIngredients().get(3));
    burger.addIngredient(database.availableIngredients().get(0));
    assertTrue((burger.getReceipt().contains("white bun"))
            &(burger.getReceipt().contains("hot sauce"))
            &(burger.getReceipt().contains("cutlet")));

}

}
