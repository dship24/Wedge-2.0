package com.example.ShipatonRemastered.Items;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ItemsConfig {

    @Bean
    CommandLineRunner commandLineRunner(ItemsRepository repository) {
        return args -> {
            Items water = new Items("Water", 2.15, "Drinks");
            Items kidsDrink = new Items("Kids Drink", 0.99, "Drinks");
            Items coffee = new Items("Coffee", 1.49, "Drinks");
            Items fountainDrink = new Items("Fountain Drink", 2.25, "Drinks");
            Items twoLiter = new Items("2 Liter", 4.49, "Drinks");
            Items cinnamonStix = new Items("Cinnamon Stix", 4.49, "Desserts");
            Items fruitPizza = new Items("Fruit Pizza", 6.49, "Desserts");
            Items chocolatePizza = new Items("Chocolate Pizza", 5.49, "Desserts");
            Items smoresPizza = new Items("Smores Pizza", 5.49, "Desserts");
            Items appleBites = new Items("Apple Bites", 4.99, "Desserts");
            Items loadedSweetPotatoFries = new Items("Loaded Sweet Potato Fries", 6.49, "Desserts");
            Items brownies = new Items("Brownies", 1.49, "Desserts");
            Items bananaPudding = new Items("Banana Pudding", 3.99, "Desserts");
            Items breadPudding = new Items("Bread Pudding", 3.99, "Desserts");
            Items grilledCheese = new Items("Kids Grilled Cheese", 5.99, "Kids Menu");
            Items kidsNachos = new Items("Kids Nachos", 4.99, "Kids Menu");
            Items kidsNuggets = new Items("Kids Chicken Nuggets", 5.99, "Kids Menu");
            Items kidsSpaghet = new Items("Kids Spaghetti", 5.99, "Kids Menu");
            Items kidsMac = new Items("Kids Mac & Cheese", 3.99, "Kids Menu");
            Items kidsCheesePizza = new Items("Kids Cheese Pizza", 5.49, "Kids Menu");
            Items lasagna = new Items("Lasagna", 8.49, "Pasta");
            Items chickenAlfredo = new Items("Chicken Alfredo", 8.49, "Pasta");
            Items rotelSpaghet = new Items("Rotel Chicken Spaghetti", 8.49, "Pasta");
            Items meatSpaghet = new Items("Spaghetti & Meat Sauce", 8.49, "Pasta");
            Items meatballSpaghet = new Items("Spaghetti & Meatballs", 9.99, "Pasta");
            Items chickenParmesan = new Items("Chicken Parmesan", 8.99, "Pasta");
            Items familyPasta = new Items("Family Pasta", 27.99, "Pasta");
            Items phillyCheeseSteak = new Items("Philly Cheese Steak", 6.99, "Hoagies, Subs, Wraps, and Burgers");
            Items phillyChickenSteak = new Items("Philly Chicken Steak", 6.99, "Hoagies, Subs, Wraps, and Burgers");
            Items italianSub = new Items("Italian Sub", 6.99, "Hoagies, Subs, Wraps, and Burgers");
            Items meatballSub = new Items("Meatball Sub", 6.99, "Hoagies, Subs, Wraps, and Burgers");
            Items pizzaSub = new Items("Pizza Sub", 5.99, "Hoagies, Subs, Wraps, and Burgers");
            Items chickenBaconRanchHoagie = new Items("Chicken Bacon Ranch Hoagie", 6.99, "Hoagies, Subs, Wraps, and Burgers");
            Items grilledBuffaloChickenHoagie = new Items("Grilled Buffalo Chicken Hoagie", 6.99, "Hoagies, Subs, Wraps, and Burgers");
            Items hamAndCheese = new Items("Ham & Cheese Hoagie", 6.99, "Hoagies, Subs, Wraps, and Burgers");
            Items chickenSaladWrap = new Items("Chicken Salad Wrap", 6.99, "Hoagies, Subs, Wraps, and Burgers");
            Items burger = new Items("Burger", 6.49, "Hoagies, Subs, Wraps, and Burgers");
            Items cheeseburger = new Items("Cheeseburger", 6.99, "Hoagies, Subs, Wraps, and Burgers");
            Items italianWedgie = new Items("Italian Wedgie", 7.49, "Wedgies");
            Items porkyWedgie = new Items("Porky Wedgie", 7.49, "Wedgies");
            Items gregsWedgie = new Items("Gregs Cheese Wedgie", 5.99, "Wedgies");
            Items veggieWedgie = new Items("Veggie Wedgie", 6.49, "Wedgies");
            Items valleyGreekWedgie = new Items("Valley Greek Wedgie", 7.49, "Wedgies");
            Items largeCalzoli = new Items("Large Cal-zoli", 8.49, "Cal-zoli");
            Items regularCalzoli = new Items("Regular Cal-zoli", 6.49, "Cal-zoli");
            Items bonelessWings = new Items("Boneless Wings", 8.99, "Appetizers");
            Items boneinWings = new Items("Bone-In Wings", 8.99, "Appetizers");
            Items beefNachos = new Items("Beef Nachos", 8.99, "Appetizers");
            Items chickenNachos = new Items("Chicken Nachos", 9.49, "Appetizers");
            Items porkNachos = new Items("BBQ Pork Nachos", 9.49, "Appetizers");
            Items rotelChips = new Items("Rotel Cheese Dip & Chips", 3.99, "Appetizers");
            Items phillyChickenFries = new Items("Philly Chicken Fries", 7.24, "Appetizers");
            Items phillySteakFries = new Items("Philly Steak Fries", 7.24, "Appetizers");
            Items rotelFries = new Items("Rotel Cheese Fries", 6.99, "Appetizers");
            Items bbqFries = new Items("BBQ Fries", 7.24, "Appetizers");
            Items cheesestix = new Items("Cheesestix", 5.99, "Appetizers");
            Items hometownRolls = new Items("Hometown Rolls", 6.49, "Appetizers");
            Items breadsticksAlfredo = new Items("Breadsticks With Alfredo", 5.99, "Appetizers");
            Items sideSalad = new Items("Side Salad", 3.99, "Appetizers");
            Items hometownFavoritePizza = new Items("Hometown Favorite Pizza", 7.49, "Pizzas");
            Items allMeatPizza = new Items("All Meat Pizza", 7.49, "Pizzas");
            Items supremePizza = new Items("Supreme Pizza", 7.49, "Pizzas");
            Items veggiePizza = new Items("Veggie Pizza", 7.49, "Pizzas");
            Items phillyCheeseSteakPizza = new Items("Philly Cheese Steak Pizza", 7.49, "Pizzas");
            Items phillyChickenSteakPizza = new Items("Philly Chicken Steak Pizza", 7.49, "Pizzas");
            Items chickenParmesanPizza = new Items("Chicken Parmesan Pizza", 7.49, "Pizzas");
            Items specialtyCheesePizza = new Items("Specialty Cheese Pizza", 7.49, "Pizzas");
            Items cheeseburgerPizza = new Items("Cheeseburger Pizza", 7.49, "Pizzas");
            Items bbqPorkPizza = new Items("BBQ Pork Pizza", 7.49, "Pizzas");
            Items bbqBaconChickenPizza = new Items("BBQ Bacon Chicken Pizza", 7.49, "Pizzas");
            Items chickenBaconRanchPizza = new Items("Chicken Bacon Ranch Pizza", 7.49, "Pizzas");
            Items hawaiianPizza = new Items("Hawaiian Pizza", 7.49, "Pizzas");
            Items spicyBuffaloChickenPizza = new Items("Spicy Buffalo Chicken Pizza", 7.49, "Pizzas");
            Items chickenAlfredoPizza = new Items("Chicken Alfredo Pizza", 7.49, "Pizzas");
            Items macCheesePizza = new Items("Mac & Cheese Pizza", 7.49, "Pizzas");
            Items createYourOwnPizza = new Items("Create Your Own Pizza", 5.49, "Pizzas");
            repository.saveAll(
                    List.of(water, kidsDrink, coffee, fountainDrink, twoLiter, cinnamonStix, fruitPizza, chocolatePizza, smoresPizza, appleBites, loadedSweetPotatoFries, brownies, bananaPudding, breadPudding, grilledCheese, kidsNachos, kidsNuggets, kidsSpaghet, kidsMac, kidsCheesePizza, lasagna, chickenAlfredo, rotelSpaghet, meatSpaghet, meatballSpaghet, chickenParmesan, familyPasta, phillyCheeseSteak, phillyChickenSteak, italianSub, meatballSub, pizzaSub, chickenBaconRanchHoagie, grilledBuffaloChickenHoagie, hamAndCheese, chickenSaladWrap, burger, cheeseburger, italianWedgie, porkyWedgie, gregsWedgie, veggieWedgie, valleyGreekWedgie, largeCalzoli, regularCalzoli, bonelessWings, boneinWings, beefNachos, chickenNachos, porkNachos, rotelChips, phillyChickenFries, phillySteakFries, rotelFries, bbqFries, cheesestix, hometownRolls, breadsticksAlfredo, sideSalad, hometownFavoritePizza, allMeatPizza, supremePizza , veggiePizza, phillyCheeseSteakPizza, phillyChickenSteakPizza, chickenParmesanPizza, specialtyCheesePizza, cheeseburgerPizza, bbqPorkPizza, bbqBaconChickenPizza, chickenBaconRanchPizza, hawaiianPizza, spicyBuffaloChickenPizza, chickenAlfredoPizza, macCheesePizza, createYourOwnPizza)
            );
        };
    }
}
