package LinkList.Medium;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x){ val = x;};

   public static void main(String[] args){
       ListNode l = new ListNode(1);
       l = new ListNode(2);
       l=l.next;
       l=new ListNode(1);
       AddTwoNumbers ad = new AddTwoNumbers();
       ad.print(l);


   }
}
