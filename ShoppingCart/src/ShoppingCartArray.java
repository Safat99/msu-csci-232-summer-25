public class ShoppingCartArray {

    private Item[] cart;
    private int num_of_items;

    public ShoppingCartArray() {
        this.cart = new Item[0];
        this.num_of_items = 0;
    }

    public void addItem(String name, double price, int quantity) {
        Item item = new Item(name, price, quantity);

        Item[] tempArray = new Item[cart.length+1];

        for(int i = 0; i < cart.length; i++) {
            tempArray[i] = cart[i];
        }

        tempArray[cart.length] = item;
        cart = tempArray;
        num_of_items++;

    }

    public void printCart() {
        System.out.println("Shopping Cart");
        System.out.println("---------------------");
        for(Item i: cart) {
            if (i != null) {
                System.out.println(i.getName() + " " + i.getPrice() + " " + i.getQuantity());
            }
        }
    }

    public void searchForItem(String name) {
        for (int i=0; i<this.num_of_items; i++) {
            if (name.equals(cart[i].getName())) {
                System.out.println(cart[i].getName() + " " + cart[i].getPrice() + " " + cart[i].getQuantity());
                return;
            }
        }
        System.out.printf("%s is not in the shopping cart.\n", name);

    }

    public void removeItem(String name) {
        for (int i=0; i<num_of_items; i++) {
            if (name.equals(cart[i].getName())) {
                for (int j=i; j<cart.length-1; j++) {
                    cart[j] = cart[j+1];
                }
                cart[cart.length-1] = null;
                num_of_items--;
                return;
            }
        }
    }

}