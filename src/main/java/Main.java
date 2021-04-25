import com.beust.jcommander.Parameter;
import picocli.CommandLine.Command;

import java.util.Scanner;

public class Main {

//    @Command(name = "search")
//    public void search() {
//
//    }

    @Parameter(names={"--length", "-l"})
    int length;

    @Parameter(names={"--pattern", "-p"})
    int pattern;

    public static void search() {
        Scanner input = new Scanner(System.in);
        System.out.print("Select 1) Users or 2) Tickets or 3) Organizations: ");
        int type = input.nextInt();
        System.out.print("Enter search term: ");
        String term = input.next().toString();
        System.out.print("Enter search value: ");
        String value = input.next().toString();
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }
}
