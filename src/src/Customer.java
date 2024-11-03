package src;

import java.util.*;

public class Customer {
    private final String email;
    private final String name;
    private final String password;

    private final Map<Food, Integer> cart = new HashMap<>();


    public Customer(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    private static void printDashes(){
        System.out.println("-------------------------------------------------------");
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void displayGUI(){
        System.out.println("Press\n1.To Browse Menu\n");
        System.out.println("2.To View/Modify Cart\n");
    }

    public void browseMenu(ArrayList<Food> Menu){
        Scanner scanner = new Scanner(System.in);

        ArrayList<Food> menu = new ArrayList<>(Menu);

        while (true){
            printDashes();

            System.out.println("Press\n1.To View All Items\n2.To search By Name\n3.To Filter by category\n4.Sort By Price\n5.Go Back");
            int choice2 = scanner.nextInt();
            scanner.nextLine();

            if(choice2==1){
                printDashes();
                for(Food f : menu){
                    System.out.print(f.getID()+".");
                    System.out.println(f);
                }
            }else if(choice2==2){
                printDashes();

                System.out.println("Name:");
                String name = scanner.nextLine();

                boolean found = false;

                for(Food f : menu){
                    if(f.getName().contains(name)){
                        System.out.println(f.getID()+"."+ f);
                        found = true;
                    }
                }

                if(!found){
                    System.out.println("No such Item");
                }

            }else if(choice2==3){
                printDashes();

                System.out.println("Category:");
                String category = scanner.nextLine();

                boolean found = false;

                for(Food f : menu){
                    if(f.getCategory().equals(category)){
                        System.out.println(f.getID()+"."+ f);
                        found = true;
                    }
                }

                if(!found){
                    System.out.println("No such Category");
                }
            } else if (choice2 == 4) {
                printDashes();

                while (true){
                    System.out.println("Press\n1.To Sort In Ascending Order\n2.To Sort In Descending order\n");
                    int choice3 = scanner.nextInt();
                    scanner.nextLine();

                    if(choice3==1){
                        menu.sort(Comparator.comparing(Food::getPrice));
                    }
                    else if(choice3==2){
                        menu.sort(Comparator.comparing(Food::getPrice).reversed());
                    }
                    else{
                        System.out.println("Invalid Choice");
                        continue;
                    }

                    for(Food f : menu){
                        System.out.println(f.getID()+"."+ f);
                    }

                    break;
                }

            }else if(choice2 == 5){
                break;
            }else{
                System.out.println("Please enter a valid choice");
            }
        }
    }

    public void cart(ArrayList<Food> menu){
        Scanner scanner = new Scanner(System.in);

        while (true){
            printDashes();

            System.out.println("Press\n1.To Add Items\n2.To Modify Quantities");
            int choice2 = scanner.nextInt();
            scanner.nextLine();

            if(choice2==1){
                printDashes();

                System.out.println("Select Food to add to cart By ID\n");
                for(Food f : menu){
                    if(f.isAvailable()){
                        System.out.println(f.getID()+"."+ f);
                    }
                }

                System.out.println("ID:");
                int id = scanner.nextInt();
                scanner.nextLine();

                Food food = null;
                for(Food f : menu){
                    if(f.getID() == id && f.isAvailable()){
                        food = f;
                    }
                }

                if(food==null){
                    System.out.println("No such ID");
                    continue;
                }

                System.out.println("Enter Quantity:");
                int quantity = scanner.nextInt();
                scanner.nextLine();

                cart.put(food,cart.getOrDefault(food,0)+quantity);
                System.out.println("Added Item!");
            }
            else if(choice2==2){
                printDashes();


            }
        }
    }

}
