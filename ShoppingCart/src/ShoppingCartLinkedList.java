
import java.util.LinkedList;

public class ShoppingCartLinkedList {

    private LinkedList<Item> cart;
    private int num_of_items;

    public ShoppingCartLinkedList() {
        this.cart = new LinkedList<Item>();
        this.num_of_items = 0;
    }

    public void addItem(String name, double price, int quantity) {
        Item item = new Item(name, price, quantity);
        cart.add(item);
        num_of_items++;
    }

    public void printCart() {
        System.out.println("Shopping Cart");
        System.out.println("---------------------");
        for(Item i: cart) {
            System.out.println(i.getName() + " " + i.getPrice() + " " + i.getQuantity());
        }
    }

    public void searchForItem(String name) {
        boolean found = false;
        for(Item i: cart) {
            if (i.getName().contains(name)) {
                System.out.println(i.getName() + " " + i.getPrice() + " " + i.getQuantity());
                found = true;
            }
        }
        if (!found) {
            System.out.println(name + " is not in the shopping cart.");
        }
    }


    public void removeItem(String name) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getName().equals(name)) {
                cart.remove(i);
            }
        }
    }


}