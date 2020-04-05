*
* @author hannah killian
*
*/

public class ReviewList {

 private Node head;

 static class Node {
       int data;
       Node next;
       Node(int d)
       {
           data = d;
           next = null;
       }
   }

 public static void main(String[] args) {

   // reviews: LinkedList<Reviews>
   ReviewList Reviews = new ReviewList();
   Reviews.head = new Node(1);


   // + print()
   System.out.print(Reviews);

 }

}
