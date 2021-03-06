package algorithm;//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
//
//
// 示例 1：
//
//
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
//
//
// 示例 2：
//
//
//输入：l1 = [0], l2 = [0]
//输出：[0]
//
//
// 示例 3：
//
//
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
//
//
//
//
// 提示：
//
//
// 每个链表中的节点数在范围 [1, 100] 内
// 0 <= Node.val <= 9
// 题目数据保证列表表示的数字不含前导零
//
// Related Topics 递归 链表 数学
// 👍 5731 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {
    }
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


 class TwoSum {

     public static void main(String[] args) {
         ListNode node1 = new ListNode();
         node1.val = 9;

         ListNode node2 = new ListNode();
         node2.val = 1;

         ListNode node3 = new ListNode();
         node3.val = 9;

         ListNode node4 = new ListNode();
         node4.val = 9;

         ListNode node5 = new ListNode();
         node5.val = 9;

         ListNode node6 = new ListNode();
         node6.val = 9;
         ListNode node7 = new ListNode();
         node7.val = 9;
         ListNode node8 = new ListNode();
         node8.val = 9;
         ListNode node9 = new ListNode();
         node9.val = 9;
         ListNode node10 = new ListNode();
         node10.val = 9;
         ListNode node11 = new ListNode();
         node11.val = 9;

         node2.next = node3;
         node3.next = node4;
         node4.next = node5;
         node5.next = node6;
         node6.next = node7;
         node7.next = node8;
         node8.next = node9;
         node9.next = node10;
         node10.next = node11;
         ListNode node = addTwoNumbers(node1, node2);
         System.out.println(node);
     }

     public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         ListNode head = null;
         ListNode tail = null;
         int carry = 0;

         while(l1 != null ||l2 != null || carry != 0){
             ListNode node = new ListNode();
             int l1Val = l1 == null ? 0 : l1.val;
             int l2Val = l2 == null ? 0 : l2.val;
             int sum = l1Val + l2Val + carry;
             if(sum < 10){
                 node.val = sum;
                 carry = 0;
             }else {
                 node.val = sum%10;
                 carry = 1;
             }
             if(head == null){
                 head = node;
                 tail = node;
             }else {
                 tail.next = node;
                 tail = node;
             }
             l1 = l1 == null ? null : l1.next;
             l2 = l2 == null ? null : l2.next;
         }
         return head;
     }

//
//
//    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        int l1Sum = getSum(l1, 0);
//        int l2Sum = getSum(l2, 0);
//        int sumResult = l1Sum + l2Sum;
//        return getListNode(sumResult);
//    }
//
//
//    public static int getSum(ListNode node, int i) {
//        if (node == null) {
//            return 0;
//        }
//        return (int) (node.val * Math.pow(10, i) + getSum(node.next, i + 1));
//    }
//
//     /**
//      * 递归将数字转为ListNode
//      * @param val
//      * @return
//      */
//    public static ListNode getListNode(int val) {
//        ListNode node = new ListNode();
//        if (val < 10) {
//            node.val = val;
//            return node;
//        }
//        int value = val % 10;
//        node.val = value;
//        node.next = getListNode(val / 10);
//        return node;
//    }

}
//leetcode submit region end(Prohibit modification and deletion)
