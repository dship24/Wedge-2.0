package com.example.ShipatonRemastered;


import com.example.ShipatonRemastered.Items.ItemsRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.*;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome To Wedge!!!!");
        int ch;
        List<String> ticket = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        Scanner i = new Scanner(System.in);
        boolean on = true;
        do {
            System.out.println();
            System.out.println("---------------");
            System.out.println("1. Add Item");
            System.out.println("2. View Ticket");
            System.out.println("3. Past Orders");
            System.out.println("4. Quit");
            System.out.println("---------------");
            System.out.println();

            System.out.print("> ");
            ch = i.nextInt();
            switch (ch) {
                case 1 -> {
                    boolean active = true;
                    do {
                        System.out.println();
                        System.out.println(" Hometown Pizza Menu: ");
                        System.out.println("----------------------");
                        System.out.println("1. APPETIZERS");
                        System.out.println("2. PIZZA");
                        System.out.println("3. CAL-ZOLI");
                        System.out.println("4. WEDGIES");
                        System.out.println("5. HOAGIES, SUBS, WRAPS, AND BURGERS");
                        System.out.println("6. PASTA");
                        System.out.println("7. KIDS MENU");
                        System.out.println("8. DESSERTS");
                        System.out.println("9. DRINKS");
                        System.out.println("10. GO BACK");
                        System.out.println("----------------------");
                        System.out.println();
                        System.out.print("> ");
                        int c = i.nextInt();
                        switch (c) {
                            case 1:
                                try {
                                    Connection connection = DriverManager.getConnection("jdbc:postgresql:slice");
                                    PreparedStatement st = connection.prepareStatement("SELECT * FROM items WHERE items.category = ?");
                                    st.setString(1, "Appetizers");
                                    ResultSet rs = st.executeQuery();
                                    System.out.println();
                                    System.out.println("--------------------------------------");
                                    while (rs.next()) {
                                        System.out.print(rs.getString("id") + " | ");
                                        System.out.print(rs.getString("name") + " | $");
                                        System.out.println(rs.getString("price"));
                                    }
                                    rs.close();
                                    st.close();
                                    System.out.println("100 | Go Back");
                                    do {
                                        System.out.println("--------------------------------------");
                                        System.out.println();
                                        System.out.println("What would you like to order?");
                                        System.out.print("> ");
                                        int item_no = i.nextInt();
                                        if (item_no == 100) {
                                            break;
                                        } else if (item_no >= 46 && item_no <= 59) {
                                            PreparedStatement si = connection.prepareStatement("SELECT * FROM items WHERE id = ?");
                                            si.setInt(1, item_no);
                                            ResultSet is = si.executeQuery();
                                            while (is.next()) {
                                                StringBuilder notes = new StringBuilder();
                                                double price = Double.parseDouble(is.getString("price"));
                                                do {
                                                    System.out.println();
                                                    System.out.println("---" + is.getString("name") + "---");
                                                    System.out.println("1. Done");
                                                    System.out.println("2. Notes");
                                                    if ((item_no == 46 || item_no == 47) && !notes.toString().contains("Sauce: ")) {
                                                        System.out.println("3. Sauce");
                                                    }
                                                    if ((item_no == 46 || item_no == 47) && !notes.toString().contains("Type: ")) {
                                                        System.out.println("4. Type");
                                                    }
                                                    if ((item_no == 46 || item_no == 47) && !notes.toString().contains("Count: ")) {
                                                        System.out.println("5. Count");
                                                    }
                                                    if (item_no == 56 && !notes.toString().contains("Size: ")) {
                                                        System.out.println("3. Size");
                                                    }
                                                    System.out.print("> ");
                                                    int user = i.nextInt();
                                                    if (user == 2) {
                                                        System.out.println();
                                                        System.out.println("----Notes----");
                                                        System.out.print("> ");
                                                        notes.append(s.nextLine()).append("; ");
                                                    } else if (user == 1) {
                                                        break;
                                                    } else if (user == 3 && item_no == 56) {
                                                        do {
                                                            System.out.println();
                                                            System.out.println("What size would you like? ");
                                                            System.out.println("1. Small  -Current");
                                                            System.out.println("2. Large  +$4");
                                                            System.out.println("3. Quit");
                                                            System.out.print("> ");
                                                            int size = i.nextInt();
                                                            if (size == 1) {
                                                                notes.append("Size: Small; ");
                                                                break;
                                                            } else if (size == 2) {
                                                                notes.append("Size: Large; ");
                                                                price += 4;
                                                                break;
                                                            } else if (size == 3) {
                                                                break;
                                                            } else {
                                                                System.out.println("Error!! Invalid Action!!");
                                                            }
                                                        } while (true);
                                                    } else if (user == 3 && (item_no == 46 || item_no == 47) && !notes.toString().contains("Sauce: ")){
                                                        boolean active2 = true;
                                                        do {
                                                            System.out.println();
                                                            System.out.println("What sauce would you like?");
                                                            System.out.println("1. Plain");
                                                            System.out.println("2. BBQ");
                                                            System.out.println("3. Honey BBQ");
                                                            System.out.println("4. Sweet & Spicy");
                                                            System.out.println("5. Teriyaki");
                                                            System.out.println("6. Buffalo Mild");
                                                            System.out.println("7. Buffalo Hot");
                                                            System.out.println("8. Garlic Parmesan");
                                                            System.out.println("9. Spicy Asian");
                                                            System.out.println("10. Lemon Pepper");
                                                            System.out.println("11. Reaper");
                                                            System.out.println("12. Mango Habanero");
                                                            System.out.println("13. Honey Gold");
                                                            System.out.println("14. Quit");
                                                            System.out.print("> ");
                                                            int sauce = i.nextInt();
                                                            switch (sauce) {
                                                                case 1 -> {
                                                                    notes.append("Sauce: Plain; ");
                                                                    active2 = false;
                                                                }
                                                                case 2 -> {
                                                                    notes.append("Sauce: BBQ; ");
                                                                    active2 = false;
                                                                }
                                                                case 3 -> {
                                                                    notes.append("Sauce: Honey BBQ; ");
                                                                    active2 = false;
                                                                }
                                                                case 4 -> {
                                                                    notes.append("Sauce: Sweet & Spicy; ");
                                                                    active2 = false;
                                                                }
                                                                case 5 -> {
                                                                    notes.append("Sauce: Teriyaki; ");
                                                                    active2 = false;
                                                                }
                                                                case 6 -> {
                                                                    notes.append("Sauce: Buffalo Mild; ");
                                                                    active2 = false;
                                                                }
                                                                case 7 -> {
                                                                    notes.append("Sauce: Buffalo Hot; ");
                                                                    active2 = false;
                                                                }
                                                                case 8 -> {
                                                                    notes.append("Sauce: Garlic Parmesan; ");
                                                                    active2 = false;
                                                                }
                                                                case 9 -> {
                                                                    notes.append("Sauce: Spicy Asian; ");
                                                                    active2 = false;
                                                                }
                                                                case 10 -> {
                                                                    notes.append("Sauce: Lemon Pepper; ");
                                                                    active2 = false;
                                                                }
                                                                case 11 -> {
                                                                    notes.append("Sauce: Reaper; ");
                                                                    active2 = false;
                                                                }
                                                                case 12 -> {
                                                                    notes.append("Sauce: Mango Habanero; ");
                                                                    active2 = false;
                                                                }
                                                                case 13 -> {
                                                                    notes.append("Sauce: Honey Gold; ");
                                                                    active2 = false;
                                                                }
                                                                case 14 -> active2 = false;
                                                                default -> System.out.println("Error!! Invalid Action!!");
                                                            }
                                                        } while (active2);
                                                    } else if (user == 4 && (item_no == 46 || item_no == 47) && !notes.toString().contains("Type: ")){
                                                        boolean active2 = true;
                                                        do {
                                                            System.out.println();
                                                            System.out.println("What type would you like?");
                                                            System.out.println("1. Regular  -Current");
                                                            System.out.println("2. Extra Crispy");
                                                            System.out.println("3. Quit");
                                                            System.out.print("> ");
                                                            int type = i.nextInt();
                                                            if (type == 1) {
                                                                notes.append("Type: Regular; ");
                                                                active2 = false;
                                                            } else if (type == 2) {
                                                                notes.append("Type: Extra Crispy; ");
                                                                active2 = false;
                                                            } else if (type == 3) {
                                                                active2 = false;
                                                            } else {
                                                                System.out.println("Error!! Invalid Action!!");
                                                            }
                                                        } while (active2);
                                                    } else if (user == 5 && (item_no == 46 || item_no == 47) && !notes.toString().contains("Count: ")){
                                                        boolean active2 = true;
                                                        do {
                                                            System.out.println();
                                                            System.out.println("How many wings would you like? ");
                                                            System.out.println("1. 8 pc.  -Current");
                                                            System.out.println("2. 16 pc.   +$7");
                                                            System.out.println("3. 24 pc.   +$13");
                                                            System.out.println("4. 32 pc.   +$18");
                                                            System.out.println("5. Quit");
                                                            System.out.print("> ");
                                                            int count = i.nextInt();
                                                            switch (count) {
                                                                case 1 -> {
                                                                    notes.append("Count: 8pc; ");
                                                                    active2 = false;
                                                                }
                                                                case 2 -> {
                                                                    notes.append("Count: 16pc; ");
                                                                    price += 7;
                                                                    active2 = false;
                                                                }
                                                                case 3 -> {
                                                                    notes.append("Count: 24pc; ");
                                                                    price += 13;
                                                                    active2 = false;
                                                                }
                                                                case 4 -> {
                                                                    notes.append("Count: 32pc; ");
                                                                    price += 18;
                                                                    active2 = false;
                                                                }
                                                                case 5 -> active2 = false;
                                                                default -> System.out.println("Error!! Invalid Action!!");
                                                            }
                                                        } while (active2);
                                                    } else {
                                                        System.out.println("Error! Invalid Action!!");
                                                    }
                                                } while (true);
                                                if (!notes.isEmpty()) {
                                                    notes.delete(notes.length() - 2, notes.length());
                                                }
                                                ticket.add(is.getString("name") + " | $" + price + " | " + notes);
                                            }
                                            System.out.println();
                                            System.out.println("-------------------------------");
                                            System.out.println("| Your ticket has been updated |");
                                            System.out.println("-------------------------------");
                                            System.out.println();
                                            break;
                                        } else {
                                            System.out.println();
                                            System.out.println("-------------------------------");
                                            System.out.println("That item id does not exist!!");
                                            System.out.println("-------------------------------");
                                            System.out.println();
                                        }
                                    } while (true);
                                } catch (SQLException ex) {
                                    ex.printStackTrace();
                                    System.exit(1);
                                }
                                break;
                            case 2:
                                try {
                                    Connection connection = DriverManager.getConnection("jdbc:postgresql:slice");
                                    PreparedStatement st = connection.prepareStatement("SELECT * FROM items WHERE items.category = ?");
                                    st.setString(1, "Pizzas");
                                    ResultSet rs = st.executeQuery();
                                    System.out.println();
                                    System.out.println("--------------------------------------");
                                    while (rs.next()) {
                                        System.out.print(rs.getString("id") + " | ");
                                        System.out.print(rs.getString("name") + " | $");
                                        System.out.println(rs.getString("price"));
                                    }
                                    rs.close();
                                    st.close();
                                    System.out.println("100 | Go Back");
                                    do {
                                        System.out.println("--------------------------------------");
                                        System.out.println();
                                        System.out.println("What would you like to order?");
                                        System.out.print("> ");
                                        int item_no = i.nextInt();
                                        if (item_no == 100) {
                                            break;
                                        } else if (item_no >= 60 && item_no <= 76) {
                                            PreparedStatement si = connection.prepareStatement("SELECT * FROM items WHERE id = ?");
                                            si.setInt(1, item_no);
                                            ResultSet is = si.executeQuery();
                                            while (is.next()) {
                                                StringBuilder notes = new StringBuilder();
                                                double price = Double.parseDouble(is.getString("price"));
                                                do {
                                                    System.out.println();
                                                    System.out.println("---" + is.getString("name") + "---");
                                                    System.out.println("1. Done");
                                                    System.out.println("2. Notes");
                                                    if (!notes.toString().contains("Size: ")) {
                                                        System.out.println("3. Size");
                                                    }
                                                    if (!notes.toString().contains("Sauce: ")) {
                                                        System.out.println("4. Sauce");
                                                    }
                                                    if (!notes.toString().contains("Toppings: ")) {
                                                        System.out.println("5. Toppings");
                                                    }
                                                    System.out.print("> ");
                                                    int user = i.nextInt();
                                                    if (user == 2) {
                                                        System.out.println();
                                                        System.out.println("----Notes----");
                                                        System.out.print("> ");
                                                        notes.append(s.nextLine()).append("; ");
                                                    } else if (user == 1) {
                                                        break;
                                                    } else if (user == 3 && !notes.toString().contains("Size: ")) {
                                                        boolean active2 = true;
                                                        do {
                                                            System.out.println();
                                                            System.out.println("What size would you like?");
                                                            System.out.println("1. Small  -Current");
                                                            System.out.println("2. Large  +$8");
                                                            System.out.println("3. Quit");
                                                            System.out.print("> ");
                                                            int size = i.nextInt();
                                                            switch (size) {
                                                                case 1:
                                                                    boolean active3 = true;
                                                                    do {
                                                                        notes.append("Size: Small; ");
                                                                        System.out.println();
                                                                        System.out.println("What crust would you like?");
                                                                        System.out.println("1. Original");
                                                                        System.out.println("2. Thin");
                                                                        System.out.println("3. Cauliflower  +$5");
                                                                        System.out.println("> ");
                                                                        int crust = i.nextInt();
                                                                        switch (crust) {
                                                                            case 1 -> {
                                                                                notes.append("Crust: Original; ");
                                                                                active3 = false;
                                                                            }
                                                                            case 2 -> {
                                                                                notes.append("Crust: Thin; ");
                                                                                active3 = false;
                                                                            }
                                                                            case 3 -> {
                                                                                notes.append("Crust: Cauliflower; ");
                                                                                price += 5;
                                                                                active3 = false;
                                                                            }
                                                                            default -> System.out.println("Error!! Invalid Action!!");
                                                                        }
                                                                    } while (active3);
                                                                    active2 = false;
                                                                    break;
                                                                case 2:
                                                                    active3 = true;
                                                                    price += 8;
                                                                    do {
                                                                        notes.append("Size: Large; ");
                                                                        System.out.println();
                                                                        System.out.println("What crust would you like?");
                                                                        System.out.println("1. Original");
                                                                        System.out.println("2. Thin");
                                                                        System.out.println("3. Deep Dish  +$2.50");
                                                                        System.out.println("4. Stuffed Crust  +$2.50");
                                                                        System.out.print("> ");
                                                                        int crust = i.nextInt();
                                                                        switch (crust) {
                                                                            case 1 -> {
                                                                                notes.append("Crust: Original; ");
                                                                                active3 = false;
                                                                            }
                                                                            case 2 -> {
                                                                                notes.append("Crust: Thin; ");
                                                                                active3 = false;
                                                                            }
                                                                            case 3 -> {
                                                                                notes.append("Crust: Deep Dish; ");
                                                                                price += 2.50;
                                                                                active3 = false;
                                                                            }
                                                                            case 4 -> {
                                                                                notes.append("Crust: Stuffed Crust; ");
                                                                                price += 2.50;
                                                                                active3 = false;
                                                                            }
                                                                            default -> System.out.println("Error!! Invalid Action!!");
                                                                        }
                                                                    } while (active3);
                                                                    active2 = false;
                                                                    break;
                                                                case 3:
                                                                    active2 = false;
                                                                    break;
                                                                default:
                                                                    System.out.println("Error!! Invalid Action!!");
                                                            }
                                                        } while (active2);
                                                    } else if (user == 4 && !notes.toString().contains("Sauce: ")) {
                                                        boolean active2 = true;
                                                        do {
                                                            System.out.println();
                                                            System.out.println("What sauce would you like? ");
                                                            System.out.println("1. Marinara");
                                                            System.out.println("2. BBQ");
                                                            System.out.println("3. Ranch");
                                                            System.out.println("4. Alfredo");
                                                            System.out.println("5. Garlic Butter");
                                                            System.out.println("6. Pesto");
                                                            System.out.println("7. Quit");
                                                            System.out.println("> ");
                                                            int sauce = i.nextInt();
                                                            switch (sauce) {
                                                                case 1 -> {
                                                                    notes.append("Sauce: Marinara; ");
                                                                    active2 = false;
                                                                }
                                                                case 2 -> {
                                                                    notes.append("Sauce: BBQ; ");
                                                                    active2 = false;
                                                                }
                                                                case 3 -> {
                                                                    notes.append("Sauce: Ranch; ");
                                                                    active2 = false;
                                                                }
                                                                case 4 -> {
                                                                    notes.append("Sauce: Alfredo; ");
                                                                    active2 = false;
                                                                }
                                                                case 5 -> {
                                                                    notes.append("Sauce: Garlic Butter; ");
                                                                    active2 = false;
                                                                }
                                                                case 6 -> {
                                                                    notes.append("Sauce: Pesto; ");
                                                                    active2 = false;
                                                                }
                                                                case 7 -> active2 = false;
                                                                default -> System.out.println("Error!! Invalid Action!!");
                                                            }
                                                        } while (active2);
                                                    } else if (user == 5 && !notes.toString().contains("Toppings: ")) {
                                                        StringBuilder list_of_toppings = new StringBuilder();
                                                        System.out.println();
                                                        System.out.println("What toppings would you like? ");
                                                        System.out.println("(Separate using ',')");
                                                        System.out.println("(Each costs $0.50)");
                                                        System.out.println("1. Extra Cheese");
                                                        System.out.println("2. Bacon");
                                                        System.out.println("3. Beef");
                                                        System.out.println("4. Canadian Bacon");
                                                        System.out.println("5. Sauteed Onions & Peppers");
                                                        System.out.println("6. Grilled Chicken");
                                                        System.out.println("7. Sausage");
                                                        System.out.println("8. Pepperoni");
                                                        System.out.println("9. Onions");
                                                        System.out.println("10. Tomatoes");
                                                        System.out.println("11. Black Olives");
                                                        System.out.println("12. Spinach");
                                                        System.out.println("13. Mushrooms");
                                                        System.out.println("14. Green Peppers");
                                                        System.out.println("15. Jalapeno Peppers");
                                                        System.out.println("16. Banana Peppers");
                                                        System.out.println("17. Quit");
                                                        System.out.print("> ");
                                                        String toppings = s.nextLine();
                                                        if (toppings.equals("17")) {
                                                            break;
                                                        }
                                                        for (int u = 0; u < toppings.split(",").length; u++) {
                                                            String topping = toppings.split(",")[u].trim();
                                                            switch (topping) {
                                                                case "1" -> {
                                                                    list_of_toppings.append("Extra Cheese+");
                                                                    price += 0.50;
                                                                }
                                                                case "2" -> {
                                                                    list_of_toppings.append("Bacon+");
                                                                    price += 0.50;
                                                                }
                                                                case "3" -> {
                                                                    list_of_toppings.append("Beef+");
                                                                    price += 0.50;
                                                                }
                                                                case "4" -> {
                                                                    list_of_toppings.append("Canadian Bacon+");
                                                                    price += 0.50;
                                                                }
                                                                case "5" -> {
                                                                    list_of_toppings.append("Sauteed Onions & Peppers+");
                                                                    price += 0.50;
                                                                }
                                                                case "6" -> {
                                                                    list_of_toppings.append("Grilled Chicken+");
                                                                    price += 0.50;
                                                                }
                                                                case "7" -> {
                                                                    list_of_toppings.append("Sausage+");
                                                                    price += 0.50;
                                                                }
                                                                case "8" -> {
                                                                    list_of_toppings.append("Pepperoni+");
                                                                    price += 0.50;
                                                                }
                                                                case "9" -> {
                                                                    list_of_toppings.append("Onions+");
                                                                    price += 0.50;
                                                                }
                                                                case "10" -> {
                                                                    list_of_toppings.append("Tomatoes+");
                                                                    price += 0.50;
                                                                }
                                                                case "11" -> {
                                                                    list_of_toppings.append("Black Olives+");
                                                                    price += 0.50;
                                                                }
                                                                case "12" -> {
                                                                    list_of_toppings.append("Spinach+");
                                                                    price += 0.50;
                                                                }
                                                                case "13" -> {
                                                                    list_of_toppings.append("Mushrooms+");
                                                                    price += 0.50;
                                                                }
                                                                case "14" -> {
                                                                    list_of_toppings.append("Green Peppers+");
                                                                    price += 0.50;
                                                                }
                                                                case "15" -> {
                                                                    list_of_toppings.append("Jalapeno Peppers+");
                                                                    price += 0.50;
                                                                }
                                                                case "16" -> {
                                                                    list_of_toppings.append("Banana Peppers+");
                                                                    price += 0.50;
                                                                }
                                                                default -> {
                                                                }
                                                            }
                                                        }
                                                        if (!list_of_toppings.isEmpty()) {
                                                            notes.append("Toppings: ").append(list_of_toppings.delete(list_of_toppings.length()-1, list_of_toppings.length())).append("; ");
                                                        }
                                                    } else {
                                                        System.out.println("Error! Invalid Action!!");
                                                    }
                                                } while (true);
                                                if (!notes.isEmpty()) {
                                                    notes.delete(notes.length() - 2, notes.length());
                                                }
                                                Formatter formatter = new Formatter();
                                                formatter.format("%.2f", price);
                                                ticket.add(is.getString("name") + " | $" + formatter + " | " + notes);
                                            }
                                            System.out.println();
                                            System.out.println("-------------------------------");
                                            System.out.println("| Your ticket has been updated |");
                                            System.out.println("-------------------------------");
                                            System.out.println();
                                            break;
                                        } else {
                                            System.out.println();
                                            System.out.println("-------------------------------");
                                            System.out.println("That item id does not exist!!");
                                            System.out.println("-------------------------------");
                                            System.out.println();
                                        }
                                    } while (true);
                                } catch (SQLException ex) {
                                    ex.printStackTrace();
                                    System.exit(1);
                                }
                                break;
                            case 3:
                                try {
                                    Connection connection = DriverManager.getConnection("jdbc:postgresql:slice");
                                    PreparedStatement st = connection.prepareStatement("SELECT * FROM items WHERE items.category = ?");
                                    st.setString(1, "Cal-zoli");
                                    ResultSet rs = st.executeQuery();
                                    System.out.println();
                                    System.out.println("--------------------------------------");
                                    while (rs.next()) {
                                        System.out.print(rs.getString("id") + " | ");
                                        System.out.print(rs.getString("name") + " | $");
                                        System.out.println(rs.getString("price"));
                                    }
                                    rs.close();
                                    st.close();
                                    System.out.println("100 | Go Back");
                                    do {
                                        System.out.println("--------------------------------------");
                                        System.out.println();
                                        System.out.println("What would you like to order?");
                                        System.out.print("> ");
                                        int item_no = i.nextInt();
                                        if (item_no == 100) {
                                            break;
                                        } else if (item_no >= 44 && item_no <= 45) {
                                            PreparedStatement si = connection.prepareStatement("SELECT * FROM items WHERE id = ?");
                                            si.setInt(1, item_no);
                                            ResultSet is = si.executeQuery();
                                            while (is.next()) {
                                                StringBuilder notes = new StringBuilder();
                                                do {
                                                    System.out.println();
                                                    System.out.println("---" + is.getString("name") + "---");
                                                    System.out.println("1. Done");
                                                    System.out.println("2. Notes");
                                                    if (!notes.toString().contains("Toppings: ")) {
                                                        System.out.println("3. Toppings");
                                                    }
                                                    if (!notes.toString().contains("Sauce: ")) {
                                                        System.out.println("4. Sauce");
                                                    }
                                                    System.out.print("> ");
                                                    int user = i.nextInt();
                                                    if (user == 2) {
                                                        System.out.println();
                                                        System.out.println("----Notes----");
                                                        System.out.print("> ");
                                                        notes.append(s.nextLine()).append("; ");
                                                    } else if (user == 1) {
                                                        break;
                                                    } else if (user == 3 && !notes.toString().contains("Toppings: ")) {
                                                        boolean active2 = true;
                                                        int u;
                                                        String topping1 = null;
                                                        String topping2 = null;
                                                        String topping3 = null;
                                                        boolean error = false;
                                                        do {
                                                            System.out.println();
                                                            System.out.println("What toppings would you like? ");
                                                            System.out.println("Choose Up To 3: ");
                                                            System.out.println("(Separate using ',')");
                                                            System.out.println("1. Extra Cheese");
                                                            System.out.println("2. Bacon");
                                                            System.out.println("3. Beef");
                                                            System.out.println("4. Canadian Bacon");
                                                            System.out.println("5. Sauteed Onions & Peppers");
                                                            System.out.println("6. Grilled Chicken");
                                                            System.out.println("7. Sausage");
                                                            System.out.println("8. Pepperoni");
                                                            System.out.println("9. Onions");
                                                            System.out.println("10. Tomatoes");
                                                            System.out.println("11. Black Olives");
                                                            System.out.println("12. Spinach");
                                                            System.out.println("13. Mushrooms");
                                                            System.out.println("14. Green Peppers");
                                                            System.out.println("15. Jalapeno Peppers");
                                                            System.out.println("16. Banana Peppers");
                                                            System.out.println("17. Quit");
                                                            System.out.print("> ");
                                                            String toppings = s.nextLine();
                                                            if (toppings.equals("17")) {
                                                                break;
                                                            }
                                                            for (u = 0; u < toppings.split(",").length; u++) {
                                                                String topping = toppings.split(",")[u].trim();
                                                                switch (topping) {
                                                                    case "1":
                                                                        if (topping1 == null) {
                                                                            topping1 = "Extra Cheese";
                                                                        } else if (topping2 == null) {
                                                                            topping2 = "Extra Cheese";
                                                                        } else if (topping3 == null) {
                                                                            topping3 = "Extra Cheese";
                                                                        }
                                                                        break;
                                                                    case "2":
                                                                        if (topping1 == null) {
                                                                            topping1 = "Bacon";
                                                                        } else if (topping2 == null) {
                                                                            topping2 = "Bacon";
                                                                        } else if (topping3 == null) {
                                                                            topping3 = "Bacon";
                                                                        }
                                                                        break;
                                                                    case "3":
                                                                        if (topping1 == null) {
                                                                            topping1 = "Beef";
                                                                        } else if (topping2 == null) {
                                                                            topping2 = "Beef";
                                                                        } else if (topping3 == null) {
                                                                            topping3 = "Beef";
                                                                        }
                                                                        break;
                                                                    case "4":
                                                                        if (topping1 == null) {
                                                                            topping1 = "Canadian Bacon";
                                                                        } else if (topping2 == null) {
                                                                            topping2 = "Canadian Bacon";
                                                                        } else if (topping3 == null) {
                                                                            topping3 = "Canadian Bacon";
                                                                        }
                                                                        break;
                                                                    case "5":
                                                                        if (topping1 == null) {
                                                                            topping1 = "Sauteed Onions & Peppers";
                                                                        } else if (topping2 == null) {
                                                                            topping2 = "Sauteed Onions & Peppers";
                                                                        } else if (topping3 == null) {
                                                                            topping3 = "Sauteed Onions & Peppers";
                                                                        }
                                                                        break;
                                                                    case "6":
                                                                        if (topping1 == null) {
                                                                            topping1 = "Grilled Chicken";
                                                                        } else if (topping2 == null) {
                                                                            topping2 = "Grilled Chicken";
                                                                        } else if (topping3 == null) {
                                                                            topping3 = "Grilled Chicken";
                                                                        }
                                                                        break;
                                                                    case "7":
                                                                        if (topping1 == null) {
                                                                            topping1 = "Sausage";
                                                                        } else if (topping2 == null) {
                                                                            topping2 = "Sausage";
                                                                        } else if (topping3 == null) {
                                                                            topping3 = "Sausage";
                                                                        }
                                                                        break;
                                                                    case "8":
                                                                        if (topping1 == null) {
                                                                            topping1 = "Pepperoni";
                                                                        } else if (topping2 == null) {
                                                                            topping2 = "Pepperoni";
                                                                        } else if (topping3 == null) {
                                                                            topping3 = "Pepperoni";
                                                                        }
                                                                        break;
                                                                    case "9":
                                                                        if (topping1 == null) {
                                                                            topping1 = "Onions";
                                                                        } else if (topping2 == null) {
                                                                            topping2 = "Onions";
                                                                        } else if (topping3 == null) {
                                                                            topping3 = "Onions";
                                                                        }
                                                                        break;
                                                                    case "10":
                                                                        if (topping1 == null) {
                                                                            topping1 = "Tomatoes";
                                                                        } else if (topping2 == null) {
                                                                            topping2 = "Tomatoes";
                                                                        } else if (topping3 == null) {
                                                                            topping3 = "Tomatoes";
                                                                        }
                                                                        break;
                                                                    case "11":
                                                                        if (topping1 == null) {
                                                                            topping1 = "Black Olives";
                                                                        } else if (topping2 == null) {
                                                                            topping2 = "Black Olives";
                                                                        } else if (topping3 == null) {
                                                                            topping3 = "Black Olives";
                                                                        }
                                                                        break;
                                                                    case "12":
                                                                        if (topping1 == null) {
                                                                            topping1 = "Spinach";
                                                                        } else if (topping2 == null) {
                                                                            topping2 = "Spinach";
                                                                        } else if (topping3 == null) {
                                                                            topping3 = "Spinach";
                                                                        }
                                                                        break;
                                                                    case "13":
                                                                        if (topping1 == null) {
                                                                            topping1 = "Mushrooms";
                                                                        } else if (topping2 == null) {
                                                                            topping2 = "Mushrooms";
                                                                        } else if (topping3 == null) {
                                                                            topping3 = "Mushrooms";
                                                                        }
                                                                        break;
                                                                    case "14":
                                                                        if (topping1 == null) {
                                                                            topping1 = "Green Peppers";
                                                                        } else if (topping2 == null) {
                                                                            topping2 = "Green Peppers";
                                                                        } else if (topping3 == null) {
                                                                            topping3 = "Green Peppers";
                                                                        }
                                                                        break;
                                                                    case "15":
                                                                        if (topping1 == null) {
                                                                            topping1 = "Jalapeno Peppers";
                                                                        } else if (topping2 == null) {
                                                                            topping2 = "Jalapeno Peppers";
                                                                        } else if (topping3 == null) {
                                                                            topping3 = "Jalapeno Peppers";
                                                                        }
                                                                        break;
                                                                    case "16":
                                                                        if (topping1 == null) {
                                                                            topping1 = "Banana Peppers";
                                                                        } else if (topping2 == null) {
                                                                            topping2 = "Banana Peppers";
                                                                        } else if (topping3 == null) {
                                                                            topping3 = "Banana Peppers";
                                                                        }
                                                                        break;
                                                                    default:
                                                                        System.out.println("Error!! Invalid Action!! (" + topping + ")");
                                                                        active2 = false;
                                                                        error = true;
                                                                        break;
                                                                }
                                                            }
                                                            if (topping1 != null) {
                                                                break;
                                                            }
                                                        } while (active2);
                                                        if (!error) {
                                                            if (topping1 != null) {
                                                                notes.append("Toppings: ").append(topping1).append("; ");
                                                            }
                                                            if (topping2 != null) {
                                                                notes.delete(notes.length() - 2, notes.length());
                                                                notes.append("+").append(topping2).append("; ");
                                                            }
                                                            if (topping3 != null) {
                                                                notes.delete(notes.length() - 2, notes.length());
                                                                notes.append("+").append(topping3).append("; ");
                                                            }
                                                        }
                                                    } else if (user == 4 && !notes.toString().contains("Sauce: ")) {
                                                        boolean active2 = true;
                                                        do {
                                                            System.out.println();
                                                            System.out.println("What sauce would you like? ");
                                                            System.out.println("1. Marinara");
                                                            System.out.println("2. BBQ");
                                                            System.out.println("3. Ranch");
                                                            System.out.println("4. Alfredo");
                                                            System.out.println("5. Garlic Butter");
                                                            System.out.println("6. Pesto");
                                                            System.out.println("7. Quit");
                                                            System.out.println("> ");
                                                            int sauce = i.nextInt();
                                                            switch (sauce) {
                                                                case 1 -> {
                                                                    notes.append("Sauce: Marinara; ");
                                                                    active2 = false;
                                                                }
                                                                case 2 -> {
                                                                    notes.append("Sauce: BBQ; ");
                                                                    active2 = false;
                                                                }
                                                                case 3 -> {
                                                                    notes.append("Sauce: Ranch; ");
                                                                    active2 = false;
                                                                }
                                                                case 4 -> {
                                                                    notes.append("Sauce: Alfredo; ");
                                                                    active2 = false;
                                                                }
                                                                case 5 -> {
                                                                    notes.append("Sauce: Garlic Butter; ");
                                                                    active2 = false;
                                                                }
                                                                case 6 -> {
                                                                    notes.append("Sauce: Pesto; ");
                                                                    active2 = false;
                                                                }
                                                                case 7 -> active2 = false;
                                                                default -> System.out.println("Error!! Invalid Action!!");
                                                            }
                                                        } while (active2);
                                                    } else {
                                                        System.out.println("Error! Invalid Action!!");
                                                    }
                                                } while (true);
                                                if (!notes.isEmpty()) {
                                                    notes.delete(notes.length() - 2, notes.length());
                                                }
                                                ticket.add(is.getString("name") + " | $" + is.getString("price") + " | " + notes);
                                            }
                                            System.out.println();
                                            System.out.println("-------------------------------");
                                            System.out.println("| Your ticket has been updated |");
                                            System.out.println("-------------------------------");
                                            System.out.println();
                                            break;
                                        } else {
                                            System.out.println();
                                            System.out.println("-------------------------------");
                                            System.out.println("That item id does not exist!!");
                                            System.out.println("-------------------------------");
                                            System.out.println();
                                        }
                                    } while (true);
                                } catch (SQLException ex) {
                                    ex.printStackTrace();
                                    System.exit(1);
                                }
                                break;
                            case 4:
                                try {
                                    Connection connection = DriverManager.getConnection("jdbc:postgresql:slice");
                                    PreparedStatement st = connection.prepareStatement("SELECT * FROM items WHERE items.category = ?");
                                    st.setString(1, "Wedgies");
                                    ResultSet rs = st.executeQuery();
                                    System.out.println();
                                    System.out.println("--------------------------------------");
                                    while (rs.next()) {
                                        System.out.print(rs.getString("id") + " | ");
                                        System.out.print(rs.getString("name") + " | $");
                                        System.out.println(rs.getString("price"));
                                    }
                                    rs.close();
                                    st.close();
                                    System.out.println("100 | Go Back");
                                    do {
                                        System.out.println("--------------------------------------");
                                        System.out.println();
                                        System.out.println("What would you like to order?");
                                        System.out.print("> ");
                                        int item_no = i.nextInt();
                                        if (item_no == 100) {
                                            break;
                                        } else if (item_no >= 39 && item_no <= 43) {
                                            PreparedStatement si = connection.prepareStatement("SELECT * FROM items WHERE id = ?");
                                            si.setInt(1, item_no);
                                            ResultSet is = si.executeQuery();
                                            while (is.next()) {
                                                StringBuilder notes = new StringBuilder();
                                                do {
                                                    System.out.println();
                                                    System.out.println("---" + is.getString("name") + "---");
                                                    System.out.println("1. Done");
                                                    System.out.println("2. Notes");
                                                    System.out.print("> ");
                                                    int user = i.nextInt();
                                                    if (user == 2) {
                                                        System.out.println();
                                                        System.out.println("----Notes----");
                                                        System.out.print("> ");
                                                        notes.append(s.nextLine()).append("; ");
                                                    } else if (user == 1) {
                                                        break;
                                                    } else {
                                                        System.out.println("Error! Invalid Action!!");
                                                    }
                                                } while (true);
                                                if (!notes.isEmpty()) {
                                                    notes.delete(notes.length() - 2, notes.length());
                                                }
                                                ticket.add(is.getString("name") + " | $" + is.getString("price") + " | " + notes);
                                            }
                                            System.out.println();
                                            System.out.println("-------------------------------");
                                            System.out.println("| Your ticket has been updated |");
                                            System.out.println("-------------------------------");
                                            System.out.println();
                                            break;
                                        } else {
                                            System.out.println();
                                            System.out.println("-------------------------------");
                                            System.out.println("That item id does not exist!!");
                                            System.out.println("-------------------------------");
                                            System.out.println();
                                        }
                                    } while (true);
                                } catch (SQLException ex) {
                                    ex.printStackTrace();
                                    System.exit(1);
                                }
                                break;
                            case 5:
                                try {
                                    Connection connection = DriverManager.getConnection("jdbc:postgresql:slice");
                                    PreparedStatement st = connection.prepareStatement("SELECT * FROM items WHERE items.category = ?");
                                    st.setString(1, "Hoagies, Subs, Wraps, and Burgers");
                                    ResultSet rs = st.executeQuery();
                                    System.out.println();
                                    System.out.println("--------------------------------------");
                                    while (rs.next()) {
                                        System.out.print(rs.getString("id") + " | ");
                                        System.out.print(rs.getString("name") + " | $");
                                        System.out.println(rs.getString("price"));
                                    }
                                    rs.close();
                                    st.close();
                                    System.out.println("100 | Go Back");
                                    do {
                                        System.out.println("--------------------------------------");
                                        System.out.println();
                                        System.out.println("What would you like to order?");
                                        System.out.print("> ");
                                        int item_no = i.nextInt();
                                        if (item_no == 100) {
                                            break;
                                        } else if (item_no >= 28 && item_no <= 38) {
                                            PreparedStatement si = connection.prepareStatement("SELECT * FROM items WHERE id = ?");
                                            si.setInt(1, item_no);
                                            ResultSet is = si.executeQuery();
                                            while (is.next()) {
                                                StringBuilder notes = new StringBuilder();
                                                double price = Double.parseDouble(is.getString("price"));
                                                do {
                                                    System.out.println();
                                                    System.out.println("---" + is.getString("name") + "---");
                                                    System.out.println("1. Done");
                                                    System.out.println("2. Notes");
                                                    if (!notes.toString().contains("Combo: ")) {
                                                        System.out.println("3. Combo     + $2.50");
                                                    }
                                                    System.out.print("> ");
                                                    int user = i.nextInt();
                                                    if (user == 3 && !notes.toString().contains("Combo: ")) {
                                                        int combo_fries;
                                                        String fries = null;
                                                        int combo_drink;
                                                        do {
                                                            System.out.println();
                                                            System.out.println("What fries would you like?");
                                                            System.out.println("1. Regular Fries");
                                                            System.out.println("2. Sweet Potato Fries");
                                                            System.out.println("3. Quit");
                                                            System.out.print("> ");
                                                            combo_fries = i.nextInt();
                                                            if (combo_fries == 1) {
                                                                fries = "Fries";
                                                                break;
                                                            } else if (combo_fries == 2) {
                                                                fries = "Sweet Potato Fries";
                                                                break;
                                                            } else if (combo_fries == 3) {
                                                                break;
                                                            } else {
                                                                System.out.println("Error!! Invalid Action!!");
                                                            }
                                                        } while (true);
                                                        if (combo_fries != 3) {
                                                            boolean active2 = true;
                                                            do {
                                                                System.out.println();
                                                                System.out.println("What drink would you like?");
                                                                System.out.println("1. Water");
                                                                System.out.println("2. Sprite");
                                                                System.out.println("3. Coke");
                                                                System.out.println("4. Root Beer");
                                                                System.out.println("5. Lemonade");
                                                                System.out.println("6. Powerade");
                                                                System.out.println("7. Fanta Orange");
                                                                System.out.println("8. Dr Pepper");
                                                                System.out.println("9. Sweet Tea");
                                                                System.out.println("10. Unsweet Tea");
                                                                System.out.println("11. Quit");
                                                                System.out.print("> ");
                                                                combo_drink = i.nextInt();
                                                                switch (combo_drink) {
                                                                    case 1 -> {
                                                                        notes.append("Combo: ").append(fries).append("+Water; ");
                                                                        active2 = false;
                                                                        price += 2.50;
                                                                    }
                                                                    case 2 -> {
                                                                        notes.append("Combo: ").append(fries).append("+Sprite; ");
                                                                        active2 = false;
                                                                        price += 2.50;
                                                                    }
                                                                    case 3 -> {
                                                                        notes.append("Combo: ").append(fries).append("+Coke; ");
                                                                        active2 = false;
                                                                        price += 2.50;
                                                                    }
                                                                    case 4 -> {
                                                                        notes.append("Combo: ").append(fries).append("+Root Beer; ");
                                                                        active2 = false;
                                                                        price += 2.50;
                                                                    }
                                                                    case 5 -> {
                                                                        notes.append("Combo: ").append(fries).append("+Lemonade; ");
                                                                        active2 = false;
                                                                        price += 2.50;
                                                                    }
                                                                    case 6 -> {
                                                                        notes.append("Combo: ").append(fries).append("+Powerade; ");
                                                                        active2 = false;
                                                                        price += 2.50;
                                                                    }
                                                                    case 7 -> {
                                                                        notes.append("Combo: ").append(fries).append("+Fanta Orange; ");
                                                                        active2 = false;
                                                                        price += 2.50;
                                                                    }
                                                                    case 8 -> {
                                                                        notes.append("Combo: ").append(fries).append("+Dr Pepper; ");
                                                                        active2 = false;
                                                                        price += 2.50;
                                                                    }
                                                                    case 9 -> {
                                                                        notes.append("Combo: ").append(fries).append("+Sweet Tea; ");
                                                                        active2 = false;
                                                                        price += 2.50;
                                                                    }
                                                                    case 10 -> {
                                                                        notes.append("Combo: ").append(fries).append("+Unsweet Tea; ");
                                                                        active2 = false;
                                                                        price += 2.50;
                                                                    }
                                                                    case 11 -> active2 = false;
                                                                    default -> System.out.println("Error! Invalid Action!!");
                                                                }
                                                            } while (active2);
                                                        }
                                                    } else if (user == 2) {
                                                        System.out.println();
                                                        System.out.println("----Notes----");
                                                        System.out.print("> ");
                                                        notes.append(s.nextLine()).append("; ");
                                                    } else if (user == 1) {
                                                        break;
                                                    } else {
                                                        System.out.println("Error! Invalid Action!!");
                                                    }
                                                } while (true);
                                                if (!notes.isEmpty()) {
                                                    notes.delete(notes.length() - 2, notes.length());
                                                }
                                                ticket.add(is.getString("name") + " | $" + price + " | " + notes);
                                            }
                                            System.out.println();
                                            System.out.println("-------------------------------");
                                            System.out.println("| Your ticket has been updated |");
                                            System.out.println("-------------------------------");
                                            System.out.println();
                                            break;
                                        } else {
                                            System.out.println();
                                            System.out.println("-------------------------------");
                                            System.out.println("That item id does not exist!!");
                                            System.out.println("-------------------------------");
                                            System.out.println();
                                        }
                                    } while (true);
                                } catch (SQLException ex) {
                                    ex.printStackTrace();
                                    System.exit(1);
                                }
                                break;
                            case 6:
                                try {
                                    Connection connection = DriverManager.getConnection("jdbc:postgresql:slice");
                                    PreparedStatement st = connection.prepareStatement("SELECT * FROM items WHERE items.category = ?");
                                    st.setString(1, "Pasta");
                                    ResultSet rs = st.executeQuery();
                                    System.out.println();
                                    System.out.println("--------------------------------------");
                                    while (rs.next()) {
                                        System.out.print(rs.getString("id") + " | ");
                                        System.out.print(rs.getString("name") + " | $");
                                        System.out.println(rs.getString("price"));
                                    }
                                    rs.close();
                                    st.close();
                                    System.out.println("100 | Go Back");
                                    do {
                                        System.out.println("--------------------------------------");
                                        System.out.println();
                                        System.out.println("What would you like to order?");
                                        System.out.print("> ");
                                        int item_no = i.nextInt();
                                        if (item_no == 100) {
                                            break;
                                        } else if (item_no >= 21 && item_no <= 27) {
                                            PreparedStatement si = connection.prepareStatement("SELECT * FROM items WHERE id = ?");
                                            si.setInt(1, item_no);
                                            ResultSet is = si.executeQuery();
                                            while (is.next()) {
                                                StringBuilder notes = new StringBuilder();
                                                do {
                                                    System.out.println();
                                                    System.out.println("---" + is.getString("name") + "---");
                                                    System.out.println("1. Done");
                                                    System.out.println("2. Notes");
                                                    if (item_no == 27 && !notes.toString().contains("Type: ")) {
                                                        System.out.println("3. Type of Pasta");
                                                    }
                                                    System.out.print("> ");
                                                    int user = i.nextInt();
                                                    boolean active2 = true;
                                                    if (user == 3 && item_no == 27 && !notes.toString().contains("Type: ")) {
                                                        do {
                                                            System.out.println();
                                                            System.out.println("Which pasta would you like?");
                                                            System.out.println("1. Lasagna");
                                                            System.out.println("2. Chicken Alfredo");
                                                            System.out.println("3. Chicken Parmesan");
                                                            System.out.println("4. Rotel Chicken Spaghetti");
                                                            System.out.println("5. Spaghetti & Meat Sauce");
                                                            System.out.println("6. Spaghetti & Meatballs");
                                                            System.out.println("7. Quit");
                                                            System.out.print("> ");
                                                            int pasta = i.nextInt();
                                                            switch (pasta) {
                                                                case 1 -> {
                                                                    notes.append("Type: Lasagna; ");
                                                                    active2 = false;
                                                                }
                                                                case 2 -> {
                                                                    notes.append("Type: Chicken Alfredo; ");
                                                                    active2 = false;
                                                                }
                                                                case 3 -> {
                                                                    notes.append("Type: Chicken Parmesan; ");
                                                                    active2 = false;
                                                                }
                                                                case 4 -> {
                                                                    notes.append("Type: Rotel Chicken Spaghetti; ");
                                                                    active2 = false;
                                                                }
                                                                case 5 -> {
                                                                    notes.append("Type: Spaghetti & Meat Sauce; ");
                                                                    active2 = false;
                                                                }
                                                                case 6 -> {
                                                                    notes.append("Type: Spaghetti & Meatballs");
                                                                    active2 = false;
                                                                }
                                                                case 7 -> active2 = false;
                                                                default -> System.out.println("Error!! Invalid Action!!");
                                                            }
                                                        } while (active2);
                                                    } else if (user == 2) {
                                                        System.out.println();
                                                        System.out.println("----Notes----");
                                                        System.out.print("> ");
                                                        notes.append(s.nextLine()).append("; ");
                                                    } else if (user == 1) {
                                                        break;
                                                    } else {
                                                        System.out.println("Error! Invalid Action!!");
                                                    }
                                                } while (true);
                                                if (!notes.isEmpty()) {
                                                    notes.delete(notes.length() - 2, notes.length());
                                                }
                                                ticket.add(is.getString("name") + " | $" + is.getString("price") + " | " + notes);
                                            }
                                            System.out.println();
                                            System.out.println("-------------------------------");
                                            System.out.println("| Your ticket has been updated |");
                                            System.out.println("-------------------------------");
                                            System.out.println();
                                            break;
                                        } else {
                                            System.out.println();
                                            System.out.println("-------------------------------");
                                            System.out.println("That item id does not exist!!");
                                            System.out.println("-------------------------------");
                                            System.out.println();
                                        }
                                    } while (true);
                                } catch (SQLException ex) {
                                    ex.printStackTrace();
                                    System.exit(1);
                                }
                                break;
                            case 7:
                                try {
                                    Connection connection = DriverManager.getConnection("jdbc:postgresql:slice");
                                    PreparedStatement st = connection.prepareStatement("SELECT * FROM items WHERE items.category = ?");
                                    st.setString(1, "Kids Menu");
                                    ResultSet rs = st.executeQuery();
                                    System.out.println();
                                    System.out.println("--------------------------------------");
                                    while (rs.next()) {
                                        System.out.print(rs.getString("id") + " | ");
                                        System.out.print(rs.getString("name") + " | $");
                                        System.out.println(rs.getString("price"));
                                    }
                                    rs.close();
                                    st.close();
                                    System.out.println("100 | Go Back");
                                    do {
                                        System.out.println("--------------------------------------");
                                        System.out.println();
                                        System.out.println("What would you like to order?");
                                        System.out.print("> ");
                                        int item_no = i.nextInt();
                                        if (item_no == 100) {
                                            break;
                                        } else if (item_no >= 15 && item_no <= 20) {
                                            PreparedStatement si = connection.prepareStatement("SELECT * FROM items WHERE id = ?");
                                            si.setInt(1, item_no);
                                            ResultSet is = si.executeQuery();
                                            while (is.next()) {
                                                StringBuilder notes = new StringBuilder();
                                                do {
                                                    System.out.println();
                                                    System.out.println("---" + is.getString("name") + "---");
                                                    System.out.println("1. Done");
                                                    System.out.println("2. Notes");
                                                    System.out.print("> ");
                                                    int user = i.nextInt();
                                                    if (user == 2) {
                                                        System.out.println();
                                                        System.out.println("----Notes----");
                                                        System.out.print("> ");
                                                        notes.append(s.nextLine()).append("; ");
                                                    } else if (user == 1) {
                                                        break;
                                                    } else {
                                                        System.out.println("Error! Invalid Action!!");
                                                    }
                                                } while (true);
                                                if (!notes.isEmpty()) {
                                                    notes.delete(notes.length() - 2, notes.length());
                                                }
                                                ticket.add(is.getString("name") + " | $" + is.getString("price") + " | " + notes);
                                            }
                                            System.out.println();
                                            System.out.println("-------------------------------");
                                            System.out.println("| Your ticket has been updated |");
                                            System.out.println("-------------------------------");
                                            System.out.println();
                                            break;
                                        } else {
                                            System.out.println();
                                            System.out.println("-------------------------------");
                                            System.out.println("That item id does not exist!!");
                                            System.out.println("-------------------------------");
                                            System.out.println();
                                        }
                                    } while (true);
                                } catch (SQLException ex) {
                                    ex.printStackTrace();
                                    System.exit(1);
                                }
                                break;
                            case 8:
                                try {
                                    Connection connection = DriverManager.getConnection("jdbc:postgresql:slice");
                                    PreparedStatement st = connection.prepareStatement("SELECT * FROM items WHERE items.category = ?");
                                    st.setString(1, "Desserts");
                                    ResultSet rs = st.executeQuery();
                                    System.out.println();
                                    System.out.println("--------------------------------------");
                                    while (rs.next()) {
                                        System.out.print(rs.getString("id") + " | ");
                                        System.out.print(rs.getString("name") + " | $");
                                        System.out.println(rs.getString("price"));
                                    }
                                    rs.close();
                                    st.close();
                                    System.out.println("100 | Go Back");
                                    do {
                                        System.out.println("--------------------------------------");
                                        System.out.println();
                                        System.out.println("What would you like to order?");
                                        System.out.print("> ");
                                        int item_no = i.nextInt();
                                        if (item_no == 100) {
                                            break;
                                        } else if (item_no >= 6 && item_no <= 14) {
                                            PreparedStatement si = connection.prepareStatement("SELECT * FROM items WHERE id = ?");
                                            si.setInt(1, item_no);
                                            ResultSet is = si.executeQuery();
                                            while (is.next()) {
                                                StringBuilder notes = new StringBuilder();
                                                double price = Double.parseDouble(is.getString("price"));
                                                do {
                                                    System.out.println();
                                                    System.out.println("---" + is.getString("name") + "---");
                                                    System.out.println("1. Done");
                                                    System.out.println("2. Notes");
                                                    if (!notes.toString().contains("Size: ") &&(item_no == 6 || item_no == 8 || item_no == 9)) {
                                                        System.out.println("3. Size");
                                                    } else if (!notes.toString().contains("Fruit: ") && item_no == 7) {
                                                        System.out.println("3. Size");
                                                        System.out.println("4. Fruit");
                                                    }
                                                    System.out.print("> ");
                                                    int user = i.nextInt();
                                                    if (user == 2) {
                                                        System.out.println();
                                                        System.out.println("----Notes----");
                                                        System.out.print("> ");
                                                        notes.append(s.nextLine()).append("; ");
                                                    } else if (user == 1) {
                                                        break;
                                                    } else if (user == 3 && (item_no == 6 || item_no == 7)){
                                                        boolean active2 = true;
                                                        do {
                                                            System.out.println();
                                                            System.out.println("What size would you like?");
                                                            System.out.println("1. Small  -Current");
                                                            System.out.println("2. Large  +$4");
                                                            System.out.println("3. Quit");
                                                            System.out.print("> ");
                                                            int size = i.nextInt();
                                                            switch (size) {
                                                                case 1 -> {
                                                                    notes.append("Size: Small; ");
                                                                    active2 = false;
                                                                }
                                                                case 2 -> {
                                                                    notes.append("Size: Large; ");
                                                                    price += 4;
                                                                    active2 = false;
                                                                }
                                                                case 3 -> active2 = false;
                                                                default -> System.out.println("Error!! Invalid Action!!");
                                                            }
                                                        } while (active2);
                                                    } else if (user == 3 && (item_no == 8 || item_no == 9)){
                                                        boolean active2 = true;
                                                        do {
                                                            System.out.println();
                                                            System.out.println("What size would you like?");
                                                            System.out.println("1. Small  -Current");
                                                            System.out.println("2. Large  +$5");
                                                            System.out.println("3. Quit");
                                                            System.out.print("> ");
                                                            int size = i.nextInt();
                                                            switch (size) {
                                                                case 1 -> {
                                                                    notes.append("Size: Small; ");
                                                                    active2 = false;
                                                                }
                                                                case 2 -> {
                                                                    notes.append("Size: Large; ");
                                                                    price += 5;
                                                                    active2 = false;
                                                                }
                                                                case 3 -> active2 = false;
                                                                default -> System.out.println("Error!! Invalid Action!!");
                                                            }
                                                        } while (active2);
                                                    } else if (user == 4 && item_no == 7){
                                                        boolean active2 = true;
                                                        do {
                                                            System.out.println();
                                                            System.out.println("What fruit would you like? ");
                                                            System.out.println("1. Apple");
                                                            System.out.println("2. Cherry");
                                                            System.out.println("3. Blueberry");
                                                            System.out.println("4. Peach");
                                                            System.out.println("5. Strawberry");
                                                            System.out.println("6. Quit");
                                                            System.out.print("> ");
                                                            int fruit = i.nextInt();
                                                            switch (fruit) {
                                                                case 1 -> {
                                                                    notes.append("Fruit: Apple; ");
                                                                    active2 = false;
                                                                }
                                                                case 2 -> {
                                                                    notes.append("Fruit: Cherry; ");
                                                                    active2 = false;
                                                                }
                                                                case 3 -> {
                                                                    notes.append("Fruit: Blueberry; ");
                                                                    active2 = false;
                                                                }
                                                                case 4 -> {
                                                                    notes.append("Fruit: Peach; ");
                                                                    active2 = false;
                                                                }
                                                                case 5 -> {
                                                                    notes.append("Fruit: Strawberry; ");
                                                                    active2 = false;
                                                                }
                                                                case 6 -> active2 = false;
                                                                default -> System.out.println("Error!! Invalid Action!!");
                                                            }
                                                        } while (active2);
                                                    } else {
                                                        System.out.println("Error! Invalid Action!!");
                                                    }
                                                } while (true);
                                                if (!notes.isEmpty()) {
                                                    notes.delete(notes.length() - 2, notes.length());
                                                }
                                                ticket.add(is.getString("name") + " | $" + price + " | " + notes);
                                            }
                                            System.out.println();
                                            System.out.println("-------------------------------");
                                            System.out.println("| Your ticket has been updated |");
                                            System.out.println("-------------------------------");
                                            System.out.println();
                                            break;
                                        } else {
                                            System.out.println();
                                            System.out.println("-------------------------------");
                                            System.out.println("That item id does not exist!!");
                                            System.out.println("-------------------------------");
                                            System.out.println();
                                        }
                                    } while (true);
                                } catch (SQLException ex) {
                                    ex.printStackTrace();
                                    System.exit(1);
                                }
                                break;
                            case 9:
                                try {
                                    Connection connection = DriverManager.getConnection("jdbc:postgresql:slice");
                                    PreparedStatement st = connection.prepareStatement("SELECT * FROM items WHERE items.category = ?");
                                    st.setString(1, "Drinks");
                                    ResultSet rs = st.executeQuery();
                                    System.out.println();
                                    System.out.println("--------------------------------------");
                                    while (rs.next()) {
                                        System.out.print(rs.getString("id") + " | ");
                                        System.out.print(rs.getString("name") + " | $");
                                        System.out.println(rs.getString("price"));
                                    }
                                    rs.close();
                                    st.close();
                                    System.out.println("100 | Go Back");
                                    do {
                                        System.out.println("--------------------------------------");
                                        System.out.println();
                                        System.out.println("What would you like to order?");
                                        System.out.print("> ");
                                        int item_no = i.nextInt();
                                        if (item_no == 100) {
                                            break;
                                        } else if (item_no >= 1 && item_no <= 5) {
                                            PreparedStatement si = connection.prepareStatement("SELECT * FROM items WHERE id = ?");
                                            si.setInt(1, item_no);
                                            ResultSet is = si.executeQuery();
                                            while (is.next()) {
                                                StringBuilder notes = new StringBuilder();
                                                do {
                                                    System.out.println();
                                                    System.out.println("---" + is.getString("name") + "---");
                                                    System.out.println("1. Done");
                                                    System.out.println("2. Notes");
                                                    if (!notes.toString().contains("Type: ") && (item_no == 2 || item_no == 4 || item_no == 5)) {
                                                        System.out.println("3. Type of Drink");
                                                    }
                                                    System.out.print("> ");
                                                    int user = i.nextInt();
                                                    if (user == 2) {
                                                        System.out.println();
                                                        System.out.println("----Notes----");
                                                        System.out.print("> ");
                                                        notes.append(s.nextLine()).append("; ");
                                                    } else if (user == 1) {
                                                        break;
                                                    } else if (user == 3 && (item_no == 2 || item_no == 4) && !notes.toString().contains("Type: ")) {
                                                        boolean active2 = true;
                                                        do {
                                                            System.out.println();
                                                            System.out.println("What drink would you like? ");
                                                            System.out.println("1. Sprite");
                                                            System.out.println("2. Coke");
                                                            System.out.println("3. Root Beer");
                                                            System.out.println("4. Lemonade");
                                                            System.out.println("5. Powerade");
                                                            System.out.println("6. Fanta Orange");
                                                            System.out.println("7. Dr Pepper");
                                                            System.out.println("8. Sweet Tea");
                                                            System.out.println("9. Unsweet Tea");
                                                            System.out.println("10. Quit");
                                                            System.out.print("> ");
                                                            int drink = i.nextInt();
                                                            switch (drink) {
                                                                case 1 -> {
                                                                    notes.append("Type: Sprite; ");
                                                                    active2 = false;
                                                                }
                                                                case 2 -> {
                                                                    notes.append("Type: Coke; ");
                                                                    active2 = false;
                                                                }
                                                                case 3 -> {
                                                                    notes.append("Type: Root Beer; ");
                                                                    active2 = false;
                                                                }
                                                                case 4 -> {
                                                                    notes.append("Type: Lemonade; ");
                                                                    active2 = false;
                                                                }
                                                                case 5 -> {
                                                                    notes.append("Type: Powerade; ");
                                                                    active2 = false;
                                                                }
                                                                case 6 -> {
                                                                    notes.append("Type: Fanta Orange; ");
                                                                    active2 = false;
                                                                }
                                                                case 7 -> {
                                                                    notes.append("Type: Dr Pepper; ");
                                                                    active2 = false;
                                                                }
                                                                case 8 -> {
                                                                    notes.append("Type: Sweet Tea; ");
                                                                    active2 = false;
                                                                }
                                                                case 9 -> {
                                                                    notes.append("Type: Unsweet Tea; ");
                                                                    active2 = false;
                                                                }
                                                                case 10 -> active2 = false;
                                                                default -> System.out.println("Error!! Invalid Action!!");
                                                            }
                                                        } while (active2);
                                                    } else if (user == 3 && item_no == 5 && !notes.toString().contains("Type: ")) {
                                                        boolean active2 = true;
                                                        do {
                                                            System.out.println();
                                                            System.out.println("What drink would you like? ");
                                                            System.out.println("1. Sprite");
                                                            System.out.println("2. Coke");
                                                            System.out.println("3. Root Beer");
                                                            System.out.println("4. Lemonade");
                                                            System.out.println("5. Powerade");
                                                            System.out.println("6. Fanta Orange");
                                                            System.out.println("7. Dr Pepper");
                                                            System.out.println("8. Quit");
                                                            System.out.print("> ");
                                                            int drink = i.nextInt();
                                                            switch (drink) {
                                                                case 1 -> {
                                                                    notes.append("Type: Sprite; ");
                                                                    active2 = false;
                                                                }
                                                                case 2 -> {
                                                                    notes.append("Type: Coke; ");
                                                                    active2 = false;
                                                                }
                                                                case 3 -> {
                                                                    notes.append("Type: Root Beer; ");
                                                                    active2 = false;
                                                                }
                                                                case 4 -> {
                                                                    notes.append("Type: Lemonade; ");
                                                                    active2 = false;
                                                                }
                                                                case 5 -> {
                                                                    notes.append("Type: Powerade; ");
                                                                    active2 = false;
                                                                }
                                                                case 6 -> {
                                                                    notes.append("Type: Fanta Orange; ");
                                                                    active2 = false;
                                                                }
                                                                case 7 -> {
                                                                    notes.append("Type: Dr Pepper; ");
                                                                    active2 = false;
                                                                }
                                                                case 8 -> active2 = false;
                                                                default -> System.out.println("Error!! Invalid Action!!");
                                                            }
                                                        } while (active2);
                                                    } else {
                                                        System.out.println("Error! Invalid Action!!");
                                                    }
                                                } while (true);
                                                if (!notes.isEmpty()) {
                                                    notes.delete(notes.length() - 2, notes.length());
                                                }
                                                ticket.add(is.getString("name") + " | $" + is.getString("price") + " | " + notes);
                                            }
                                            System.out.println();
                                            System.out.println("-------------------------------");
                                            System.out.println("| Your ticket has been updated |");
                                            System.out.println("-------------------------------");
                                            System.out.println();
                                            break;
                                        } else {
                                            System.out.println();
                                            System.out.println("-------------------------------");
                                            System.out.println("That item id does not exist!!");
                                            System.out.println("-------------------------------");
                                            System.out.println();
                                        }
                                    } while (true);
                                } catch (SQLException ex) {
                                    ex.printStackTrace();
                                    System.exit(1);
                                }
                                break;
                            case 10:
                                active = false;
                                break;
                            case 0:
                                try {
                                    Connection connection = DriverManager.getConnection("jdbc:postgresql:slice");
                                    PreparedStatement st = connection.prepareStatement("SELECT * FROM items WHERE items.category = ?");
                                    st.setString(1, "Secret Menu");
                                    ResultSet rs = st.executeQuery();
                                    System.out.println();
                                    System.out.println("----------- SECRET MENU --------------");
                                    while (rs.next()) {
                                        System.out.print(rs.getString("id") + " | ");
                                        System.out.print(rs.getString("name") + " | $");
                                        System.out.println(rs.getString("price"));
                                    }
                                    rs.close();
                                    st.close();
                                    System.out.println("100 | Go Back");
                                    do {
                                        System.out.println("--------------------------------------");
                                        System.out.println();
                                        System.out.println("What would you like to order?");
                                        System.out.print("> ");
                                        int item_no = i.nextInt();
                                        if (item_no == 100) {
                                            break;
                                        } else if (item_no >= 77 && item_no <= 92) {
                                            PreparedStatement si = connection.prepareStatement("SELECT * FROM items WHERE id = ?");
                                            si.setInt(1, item_no);
                                            ResultSet is = si.executeQuery();
                                            while (is.next()) {
                                                StringBuilder notes = new StringBuilder();
                                                do {
                                                    System.out.println();
                                                    System.out.println("---" + is.getString("name") + "---");
                                                    System.out.println("1. Done");
                                                    System.out.println("2. Notes");
                                                    System.out.print("> ");
                                                    int user = i.nextInt();
                                                    if (user == 2) {
                                                        System.out.println();
                                                        System.out.println("----Notes----");
                                                        System.out.print("> ");
                                                        notes.append(s.nextLine()).append("; ");
                                                    } else if (user == 1) {
                                                        break;
                                                    } else {
                                                        System.out.println("Error! Invalid Action!!");
                                                    }
                                                } while (true);
                                                if (!notes.isEmpty()) {
                                                    notes.delete(notes.length() - 2, notes.length());
                                                }
                                                ticket.add(is.getString("name") + " | $" + is.getString("price") + " | " + notes);
                                            }
                                            System.out.println();
                                            System.out.println("-------------------------------");
                                            System.out.println("| Your ticket has been updated |");
                                            System.out.println("-------------------------------");
                                            System.out.println();
                                            break;
                                        } else {
                                            System.out.println();
                                            System.out.println("-------------------------------");
                                            System.out.println("That item id does not exist!!");
                                            System.out.println("-------------------------------");
                                            System.out.println();
                                        }
                                    } while (true);
                                } catch (SQLException ex) {
                                    ex.printStackTrace();
                                    System.exit(1);
                                }
                                break;
                        }
                    } while (active);
                }
                case 2 -> {
                    System.out.println();
                    if (ticket.isEmpty()) {
                        System.out.println("------------------------");
                        System.out.println("| Your ticket is empty! |");
                        System.out.println("------------------------");
                        System.out.println();
                    } else {
                        boolean active = true;
                        do {
                            System.out.println("----------------------");
                            System.out.println("Your Ticket : ");
                            Iterator<String> q = ticket.iterator();
                            float total = 0;
                            while (q.hasNext()) {
                                Object e = q.next();
                                System.out.println(e);
                                String a = e.toString();
                                total += Float.parseFloat(a.substring(a.indexOf("$") + 1, a.indexOf("$") + 6).trim());
                            }
                            System.out.println();
                            System.out.print("Total : $");
                            System.out.printf("%.2f", total);
                            System.out.println();
                            System.out.println("----------------------");
                            System.out.println();
                            System.out.println("1. Delete an Item");
                            System.out.println("2. Place Order");
                            System.out.println("3. Go Back");
                            System.out.println();
                            System.out.println("What would you like to do?");
                            System.out.print("> ");
                            int p = i.nextInt();
                            switch (p) {
                                case 1 -> {
                                    System.out.println();
                                    System.out.println("----------------------");
                                    System.out.println("Your Ticket : ");
                                    q = ticket.iterator();
                                    int x = 1;
                                    while (q.hasNext()) {
                                        Object e = q.next();
                                        System.out.println(x + ": " + e);
                                        x++;
                                        System.out.println("----------------------");
                                    }
                                    do {
                                        System.out.println();
                                        System.out.println("Which item would you like to delete? ");
                                        System.out.println("Input 0 to go back");
                                        System.out.print("> ");
                                        int delete_item = i.nextInt();
                                        if (delete_item == 0) {
                                            break;
                                        } else if (delete_item < 0 || delete_item > ticket.size()) {
                                            System.out.println();
                                            System.out.println("----------------------------------------");
                                            System.out.println("| Error!! That item id does not exist!! |");
                                            System.out.println("----------------------------------------");
                                            System.out.println();
                                        } else {
                                            System.out.println("Are you sure you want to delete this item? ");
                                            System.out.print("[Y/N] : ");
                                            String confirm = s.nextLine();
                                            if (confirm.equalsIgnoreCase("Y")) {
                                                ticket.remove(delete_item - 1);
                                                System.out.println();
                                                System.out.println("---------------------------------");
                                                System.out.println("| Your ticket has been updated! |");
                                                System.out.println("---------------------------------");
                                                System.out.println();
                                            }
                                            break;
                                        }
                                    } while (true);
                                }
                                case 2 -> {
                                    boolean active2 = true;
                                    String order_type;
                                    String address = null;
                                    System.out.println();
                                    do {
                                        System.out.println("Will your order be [carryout] or [delivery]?");
                                        order_type = s.nextLine();
                                        if (order_type.equals("carryout")) {
                                            active2 = false;
                                        } else if (order_type.equals("delivery")) {
                                            System.out.println();
                                            System.out.println("What address will this order be delivered to?");
                                            address = s.nextLine();
                                            active2 = false;
                                        } else {
                                            System.out.println();
                                            System.out.println("---------------------------");
                                            System.out.println("| Error! Invalid Action!! |");
                                            System.out.println("---------------------------");
                                            System.out.println();
                                        }
                                    } while (active2);
                                    System.out.println();
                                    System.out.println("Who is ordering? ");
                                    String customer_name = s.nextLine();
                                    System.out.println();
                                    String schedule;
                                    Date schedule_day = null;
                                    String schedule_time = null;
                                    String scheduled_day;
                                    do {
                                        System.out.println("Are you scheduling this order? ");
                                        System.out.print("[Y/N]: ");
                                        schedule = s.nextLine();
                                        if (schedule.equalsIgnoreCase("Y")) {
                                            do {
                                                System.out.println();
                                                System.out.println("What date is your order scheduled for?");
                                                System.out.println("Ex: MM/dd/yyyy");
                                                System.out.print("> ");
                                                scheduled_day = s.nextLine();
                                                try {
                                                    java.util.Date utilDate = new SimpleDateFormat("MM/dd/yyyy").parse(scheduled_day);
                                                    schedule_day = new Date(utilDate.getTime());
                                                    break;
                                                } catch (ParseException e) {
                                                    System.out.println("Error! Invalid Date!!");
                                                }
                                            } while (true);
                                            System.out.println();
                                            System.out.println("What time is your order scheduled for?");
                                            System.out.print("> ");
                                            schedule_time = s.nextLine();
                                            break;
                                        } else if (schedule.equalsIgnoreCase("N")) {
                                            break;
                                        } else {
                                            System.out.println("Error! Invalid Action!!");
                                        }
                                    } while (true);
                                    System.out.println();
                                    System.out.println("----------------------");
                                    System.out.println("Your Ticket : ");
                                    q = ticket.iterator();
                                    total = 0;
                                    while (q.hasNext()) {
                                        Object e = q.next();
                                        System.out.println(e);
                                        String a = e.toString();
                                        total += Float.parseFloat(a.substring(a.indexOf("$") + 1, a.indexOf("$") + 5));
                                    }
                                    if (order_type.equals("delivery")) {
                                        System.out.println("Deliver to " + customer_name + " at " + address);
                                    } else {
                                        System.out.println("Pickup by " + customer_name);
                                    }
                                    if (schedule.equalsIgnoreCase("Y")) {
                                        System.out.println();
                                        System.out.println("Scheduled for " + schedule_day + " at " + schedule_time);
                                    }
                                    System.out.println();
                                    System.out.print("Total: $");
                                    System.out.printf("%.2f", total);
                                    System.out.println();
                                    System.out.println("----------------------");
                                    System.out.println();
                                    System.out.println("Are you sure you want to place your order?");
                                    System.out.print("[Y/N] : ");
                                    String confirm = s.nextLine();
                                    if (confirm.equalsIgnoreCase("Y")) {
                                        try {
                                            Connection connection = DriverManager.getConnection("jdbc:postgresql:slice");
                                            PreparedStatement st = connection.prepareStatement("INSERT INTO ticket (customer, type, address, day, time, items) VALUES (?, ?, ?, ?, ?, ?)");
                                            Array new_ticket = connection.createArrayOf("text", ticket.toArray());
                                            st.setString(1, customer_name);
                                            st.setString(2, order_type);
                                            st.setString(3, address);
                                            st.setDate(4, schedule_day);
                                            st.setString(5, schedule_time);
                                            st.setArray(6, new_ticket);
                                            st.executeUpdate();
                                        } catch (SQLException ex) {
                                            ex.printStackTrace();
                                            System.exit(1);
                                        }
                                        ticket.clear();
                                        System.out.println();
                                        System.out.println("---------------------------------");
                                        System.out.println("|  Your order has been placed!  |");
                                        System.out.println("---------------------------------");
                                        active = false;
                                    }
                                }
                                case 3 -> active = false;
                                default -> System.out.println("Error! Invalid Action!!");
                            }
                        } while (active);
                    }
                }
                case 3 -> {
                    System.out.println();
                    System.out.println("Who's orders do you want to view? or [Quit]");
                    System.out.print("> ");
                    String orders = s.nextLine();
                    if (!orders.equalsIgnoreCase("Quit")) {
                        try {
                            Connection connection = DriverManager.getConnection("jdbc:postgresql:slice");
                            PreparedStatement st = connection.prepareStatement("SELECT * FROM ticket WHERE ticket.customer = ?");
                            st.setString(1, orders);
                            ResultSet rs = st.executeQuery();
                            System.out.println();
                            while (rs.next()) {
                                System.out.println("Type: " + rs.getString("type"));
                                if (rs.getString("type").equalsIgnoreCase("delivery")) {
                                    System.out.println("Address: " + rs.getString("address"));
                                }
                                if (rs.getString("day") != null) {
                                    System.out.println("Day: " + rs.getString("day"));
                                }
                                if (rs.getString("time") != null) {
                                    System.out.println("Time: " + rs.getString("time"));
                                }
                                System.out.println("Items: ");
                                for (int u = 0; u < rs.getString("items").split(",").length; u++) {
                                    System.out.println(rs.getString("items").split(",")[u]);
                                }
                                System.out.println("--------------------------------");
                            }
                        } catch (SQLException e) {
                            System.out.println("That person does not have any orders placed!");
                        }
                    }
                }
                case 4 -> {
                    System.out.println("Are you sure you want to quit?");
                    System.out.println("(Any items on your current ticket will be discarded.)");
                    System.out.print("[Y/N] : ");
                    String confirm = s.nextLine();
                    if (confirm.equalsIgnoreCase("Y")) {
                        System.out.print("Thank you for ordering with Wedge! We hope you come back soon!");
                        on = false;
                    }
                }
                default -> System.out.println("Error! Invalid Action!!");
            }
        } while (on);
    }
}