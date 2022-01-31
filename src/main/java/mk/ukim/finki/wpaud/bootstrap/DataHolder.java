package mk.ukim.finki.wpaud.bootstrap;

import lombok.Getter;
import mk.ukim.finki.wpaud.model.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class DataHolder {
    public static List<Category> categories = new ArrayList<>();
    public static List<User> users = new ArrayList<>();
    public static List<Manufacturer> manufacturers = new ArrayList<>();
    public static List<Product> products = new ArrayList<>();
    public static List<ShoppingCart> shoppingCarts = new ArrayList<>();

//    @PostConstruct
//    public void init() {
//        categories.add(new Category("Movies", "Movies Category"));
//        categories.add(new Category("Books", "Books Category"));
//
//        users.add(new User("markosladic", "ms", "Marko", "Sladic"));
//        users.add(new User("kostadinmishev", "km", "Kostadin", "Mishev"));
//
//        Manufacturer manufacturer = new Manufacturer("Nike", "NY");
//        manufacturers.add(manufacturer);
//        Category category = new Category("Sport", "Sport category");
//        categories.add(category);
//
//        products.add(new Product("Ball", 250.85, 5, category, manufacturer));
//        products.add(new Product("Ball2", 230.85, 10, category, manufacturer));
//        products.add(new Product("Ball3", 100.85, 1, category, manufacturer));
//    }
}
