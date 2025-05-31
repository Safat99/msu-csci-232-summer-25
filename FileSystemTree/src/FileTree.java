import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class FileTree {

    private Node root;
    private Node current;

    public FileTree() {
        this.root = new Node("~");
        this.current = root;
    }

    public boolean insert(String directory) {

        if(directory == null || directory.equals(" ") || directory.equals("~")) {
            return false;
        }
        else {
            Node newNode = new Node(directory);
            newNode.setParent(current);
            current.addChild(newNode);
            return true;
        }
    }

    public boolean moveDown(String directory) {
        //TODO: Allow for a directory path for an argument
        // cd School/CSCI232/Programs
        String[] parts = directory.split("/");
        Node temp = current;

        boolean found = false;
        for (String part : parts) {
            found = false;
            for (Node child : temp.getChildren()) {
                //move down
                if (child.getName().equals(part)) {
                    temp = child;
                    found = true;
                    break;
                }
            }
        }
        if (!found)
            return false;

        current = temp;
        return true;
    }

    public void moveUp() {
        if (current != root) {
            current = current.getParent();
        }
    }

    public void goHome() {
        current = root;
    }

    public String getCurrentLocation() {
        return current.getName();
    }

    public String getChildren() {
        String files = "";
        LinkedList<Node> children = current.getChildren();
        for(Node c: children) {
            files += c.getName() + " ";
        }
        return files;
    }

    public boolean remove(String directory) {
        //TODO: Lab 2
        LinkedList<Node> children = current.getChildren();
        for (Node child : children) {
            if (child.getName().equals(directory)) {
                children.remove(child);
                return true;
            }
        }
        return false;
    }


    public String getPath() {
        //TODO: Lab 2
        StringBuilder path = new StringBuilder(root.getName());
        Stack<String> nodes = new Stack<>();
        Node temp = current;
        while(temp != root) {
            nodes.push(temp.getName());
            temp = temp.getParent();
        }
        while (!nodes.isEmpty()) {
            path.append("/").append(nodes.pop());
        }
        return path.toString();
    }




}