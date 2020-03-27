package que2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * main class
 * @author Ayush
 *
 */
public class Main
{
    public static void main(String args[]) throws NumberFormatException,IOException
    {
        boolean flag = true;
        int capacity;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter Queue Size : ");
        capacity = Integer.parseInt(br.readLine());

        Queue queue = new Queue(capacity);
        do 
        {
            System.out
                    .print("\nOperations :\n1) Add item\n2) Delete item\n3) show Queue\n"
                            + "Select your operation : ");
            switch (Integer.parseInt(br.readLine()))
            {
            case 1:
                System.out.print("\nEnter Data : ");
                queue.add(Integer.parseInt(br.readLine()));
                break;
            case 2:
                queue.delete();
                break;
            case 3:
                queue.show();
                break;
            case 4:
                flag = false;
                break;
            default:
                System.out.println("Wrong Input try again");
            
            }
        } while (flag);
    }
}
