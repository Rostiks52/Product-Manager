package ru.netology.manager;

import ru.netology.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductManagerTest {
    private ProductManager manager = new ProductManager();
    Book first = new Book(1, "Real Boys", 899,"G.Mathew");
    Book second = new Book(2, "Lolita", 1500, "V.Nabokov");
    Book third = new Book(3, "Poems", 460, "A.Bartho");
    Smartphone fourth = new Smartphone(4, "Krutoy # 1", 23500,"SPM#1");
    Smartphone fifth = new Smartphone(5, "Very Krutoy", 99900, "SPM#1");
    Smartphone sixth = new Smartphone(6, "Most Krutoy", 123500, "NeSamSung");

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
    }

   @Test
    void shouldSearchByAuthor(){
        String text = "A.Bartho";
        Product[] expected = new Product[]{third};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
   }

   @Test
    void shouldSearchByBooksName(){
        String text = "Lolita";
        Product[] expected = new Product[]{second};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
   }
   @Test
    void shouldSearchBySmartphonesName(){
       String text = "Most Krutoy";
       Product[] expected = new Product[]{sixth};
       Product[] actual = manager.searchBy(text);
       assertArrayEquals(expected, actual);
   }
   @Test
    void shouldSearchBySmartFabricator(){
       String text = "NeSamSung";
       Product[] expected = new Product[]{sixth};
       Product[] actual = manager.searchBy(text);
       assertArrayEquals(expected, actual);
   }
   @Test
   void shouldSearchNonExistentProduct(){
        String text = "Gold Phone";
        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
        System.out.println("No such product exists. Try changing your query");
   }
   @Test
    void shouldDisplayAllBooks(){
        String text = "All";
        Product[] expected =new Product[]{first, second, third, fourth, fifth, sixth};
        Product[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
   }
    @Test
    void shouldRemoveIfExists() {
        int idToRemove = 4;
        manager.removeById(idToRemove);
        Product[] expected = new Product[]{first, second, third, fifth, sixth};
        Product[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }
}
