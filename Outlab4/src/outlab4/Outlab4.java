/*
    This program takes in an input file of numbers to run an election game of IDs. It uses a circular, doubly linked list to organize the data
    and runs an algorithm to "elect" officials using clock and counterclock-wise counters to select officials. It then writes the output to a file.
 */
package outlab4;

import java.io.PrintWriter;


/**
 *
 * @author risau
 */
public class Outlab4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedListControl list = new LinkedListControl();
        PrintWriter writer = null;
        
        try {
            writer = new PrintWriter("LinkedListProgram.txt", "UTF-8");
            writer.println("Program 4");
            writer.println("----------\n");

            while (true) {

                list.addFromFile();

                if (list.n == 0) { //If n is zero, then we hit the end our program. 0 0 0
                    break;
                }

                list.election(writer);

            }

            writer.println("End of Program 4");

        } catch (Exception e) {
        } finally {
            if (writer != null) {
                System.out.println("Closing PrintWriter");
                writer.close(); //Close the file for editing
            } else {
                System.out.println("PrintWriter not open");
            }

        }

    }

}
