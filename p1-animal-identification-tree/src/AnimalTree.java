import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class AnimalTree {

    private Node root;

    public AnimalTree() {
        root = null;
    }

    public Node getRoot() {
        return this.root;
    }

    // load the tree.txt tree from the file
    public void loadFromFile(String filePath) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;

        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",", 2);
            if (parts.length < 2) continue;
            int id = Integer.parseInt(parts[0].trim());
            String text = parts[1].trim();
            insert(id, text);
        }
        br.close();
    }

    public void insert(int id, String text) {
        Node newNode = new Node(id);
        newNode.setText(text);

        if (root == null)
            root = newNode;
        else {
            Node current = root;

            while (true) {
                if (current.getValue() == newNode.getValue()) {
                    System.out.println("No duplicates allowed");
                    break;
                } else if (newNode.getValue() < current.getValue()) {
                    if (current.getLeft() == null) {
                        current.setLeft(newNode);
                        current.getLeft().setParent(current);
                        break;
                    } else
                        current = current.getLeft();
                } else {
                    if (current.getRight() == null) {
                        current.setRight(newNode);
                        current.getRight().setParent(current);
                        break;
                    } else
                        current = current.getRight();
                }
            }
        }
    }

    public void bfs() {

        if (root == null) {
            System.out.println("Tree is empty!!");
            return;
        }

        Queue<Node> queue = new ArrayDeque<Node>();
        queue.add(root);

        while(!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.println(current.getText());

            if (current.getLeft() != null) queue.add(current.getLeft());
            if (current.getRight() != null) queue.add(current.getRight());
        }

    }

    public void identify(Scanner scanner) {
        Node current = root;

        while (current.getLeft() != null || current.getRight() != null) {
            System.out.println("Is this animal " + current.getText() + "? (Y/N) > ");
            String answer = scanner.nextLine().trim().toLowerCase();

            if (answer.equals("y")) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }

        System.out.println("Hmmm... I think I know.");
        System.out.println("Is it " + current.getText() + "?");
        String finalAnswer = scanner.nextLine().trim().toLowerCase();

        if (finalAnswer.equals("y")) {
            System.out.println("Good! All done");
        }
    }








}
