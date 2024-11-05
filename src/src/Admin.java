package src;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Admin {

    private final String email;
    private final String password;

    public Admin(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    private static void printDashes(){
        System.out.println("-------------------------------------------------------");
    }

    public void displayGUI(){
        System.out.println("Press\n1.To Manage Menu");
        System.out.println("2.To Manage Orders");
        System.out.println("3.To Generate Report");
        System.out.println("4.To Exit");
    }

    public void manageMenu(ArrayList<Food> menu,ArrayList<Order> orders){
        printDashes();
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("\n1.To Add Item\n2.To Update An Item\n3.To Delete An Item\n4.To Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if(choice == 1){
                printDashes();

                System.out.println("Enter Item Name: ");
                String name = scanner.nextLine();

                System.out.println("Enter Item Price: ");
                int price = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Enter Item ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                boolean found = false;
                for(Food food : menu){
                    if(food.getID()==id){
                        found = true;
                        break;
                    }
                }

                if(found){
                    System.out.println("An Item with given ID already exists!");
                    continue;
                }

                System.out.println("Enter Item Category: ");
                String category = scanner.nextLine();

                Food newItem = new Food(name,price,id,category,true);

                menu.add(newItem);

                System.out.println("Item added successfully!");
            }
            else if(choice == 2){
                printDashes();

                System.out.println("Items:");
                for(Food item : menu){
                    System.out.println(item.getID()+"."+item);
                }

                System.out.println("Enter ID of the item that needs to be updated: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                Food updatedItem = null;
                for(Food item : menu){
                    if(item.getID()==id){
                        updatedItem = item;
                    }
                }

                if(updatedItem==null){
                    System.out.println("An Item with given ID does not exist!");
                    continue;
                }

                System.out.println("Enter Updated Name:");
                String name = scanner.nextLine();
                System.out.println("Enter Updated Price:");
                int price = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter Updated Category:");
                String category = scanner.nextLine();

                System.out.println("Enter Updated Availability [Type 1 for available and 0 for not]:");
                int availability = scanner.nextInt();
                scanner.nextLine();

                updatedItem.setName(name);
                updatedItem.setPrice(price);
                updatedItem.setCategory(category);
                updatedItem.setAvailable(availability);

                System.out.println("Item updated successfully!");
            }
            else if(choice == 3){
                printDashes();

                System.out.println("Items:");
                for(Food item : menu){
                    System.out.println(item.getID()+"."+item);
                }

                System.out.println("Enter ID of the item that needs to be deleted: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                Food deletedItem = null;
                for(Food item : menu){
                    if(item.getID()==id){
                        deletedItem = item;
                    }
                }

                if(deletedItem==null){
                    System.out.println("An Item with given ID does not exist!");
                    continue;
                }

                menu.remove(deletedItem);
                System.out.println("Item deleted successfully!");

                for(Order o:orders){
                    for(Map.Entry<Food, Integer> entry : o.getCart().entrySet()){
                        if(entry.getKey().getID()==id){
                            o.setStatus("denied");
                        }
                    }
                }
            }
            else if(choice == 4){
                break;
            }
            else {
                printDashes();
                System.out.println("Invalid choice!");
            }
        }
    }

    public void manageOrders(ArrayList<Order> orders){
        printDashes();
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("1.To View Pending Orders\n2.To Update Order status\n3.To Process refunds\n4.To Handle special requests");
        }
    }

}
