package LinkList.Medium;


public class DeleteNode {

    //TODO 现在无法删除第一节点，其它都是可以的
    public void deleteNode(ListNode node){
        int delNum =2;
        while(node!=null){
            if (node.next.val==delNum){
                node.next = node.next.next;
                break;
            }else if(node.val == delNum){
                node = null;
                break;
            }
            node =node.next;
        }
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
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);


        DeleteNode dn = new DeleteNode();
        dn.print(node);

        dn.deleteNode(node);
        dn.print(node);
    }

}
