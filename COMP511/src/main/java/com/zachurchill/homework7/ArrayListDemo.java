import java.util.*;
/**
 * Write a description of class ArrayListDemo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ArrayListDemo {
    
    public static void main(String[] args) {
        // put your code here
        ArrayList<Integer> al = new ArrayList();
        for (int i = 0; i < 10; i++) {
            al.add(i);
        }
        
        Iterator iter = al.iterator();
        while (iter.hasNext()) {
            System.out.printf("%d, ", iter.next());
        }
        System.out.println("\n+++++++++++++++++++++");
        
        ListIterator li = al.listIterator();
        while (li.hasNext()) {
            System.out.printf("%d, ", li.next());
        }
        System.out.println("\n+++++++++++++++++++++");
        
        while (li.hasPrevious()) {
            System.out.printf("%d, ", li.previous());
        }
        System.out.println("\n+++++++++++++++++++++");
    }
}
