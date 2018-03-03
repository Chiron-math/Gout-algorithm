package LinkList.Medium;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummyHead = new ListNode(0);
        ListNode p=l1,q=l2,curr=dummyHead;
        int carry=0;//进位
        while(p!=null || q!=null){
            int x=(p!=null)?p.val:0;
            int y=(q!=null)?q.val:0;
            int sum=x+y+carry;
            carry=sum/10;
            curr.next=new ListNode(sum%10);
            curr=curr.next;
            if(p!=null) p=p.next;
            if(q!=null) q=q.next;
        }
        if(carry>0){
            curr.next=new ListNode(carry);
        }

        return dummyHead.next;

    }

    public void print(ListNode ret) {
        System.out.print("[");
        while(ret!=null){
            System.out.print("\t"+ret.val);
            ret=ret.next;
        }
        System.out.print("]\n");

    }


        public static void main(String[] args){
        AddTwoNumbers adn = new AddTwoNumbers();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        adn.print(l1);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        adn.print(l2);


        ListNode l3 = adn.addTwoNumbers(l1,l2);
        adn.print(l3);


    }
}
