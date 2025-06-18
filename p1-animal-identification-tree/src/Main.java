import java.io.IOException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {

        AnimalTree animalTree = new AnimalTree();
        animalTree.loadFromFile("src/tree.txt");
//        animalTree.bfs();

        Scanner scanner = new Scanner(System.in);

        boolean keepGoing = true;

        while (keepGoing) {
            animalTree.identify(scanner);

            System.out.print("Do you have another animal to identify? (Y/N) > ");
            String answer = scanner.nextLine().trim().toLowerCase();

            if (!answer.equals("y")) {
                keepGoing = false;
            }
        }

        scanner.close();

    }
}