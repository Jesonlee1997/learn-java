package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @author lijs
 * @date 17-11-12.
 */
public class AddTwoNumbers {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            List<Integer> list = new ArrayList<>();
            list.add(val);
            ListNode node = next;
            while (node != null) {
                list.add(node.val);
                node = node.next;
            }
            return Arrays.toString(list.toArray());
        }

        static ListNode toNode(long num) {
            ListNode h = new ListNode((int) (num % 10));
            ListNode p = h;

            num = num / 10;
            while (num != 0) {
                p.next = new ListNode((int) (num % 10));
                p = p.next;
                num = num / 10;
            }
            return h;
        }
    }

    private static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            long num1 = getNum(l1);
            long num2 = getNum(l2);
            long res = num1 + num2;
            return ListNode.toNode(res);
        }

        long getNum(ListNode listNode) {
            if (listNode == null) {
                return 0;
            }
            long num = 0;
            long radio = 1;
            while (listNode != null) {
                num += listNode.val * radio;
                radio *= 10;
                listNode = listNode.next;
            }
            return num;
        }



        public static void main(String[] args) {
            Solution solution = new Solution();

            System.out.println(solution.addTwoNumbers(ListNode.toNode(9), ListNode.toNode(9999999991L)));

        }
    }

    private static class Solution2 {
        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int up;
            int val = l1.val + l2.val;
            up = val / 10;
            val = val % 10;
            l1 = l1.next;
            l2 = l2.next;
            ListNode h = new ListNode(val);
            ListNode p = h;
            while (l1 != null || l2 != null) {
                if (l1 == null) {
                    val = l2.val + up;
                    up = val / 10;
                    val = val % 10;
                    p.next = new ListNode(val);
                    l2 = l2.next;
                } else if (l2 == null) {
                    val = l1.val + up;
                    up = val / 10;
                    val = val % 10;
                    p.next = new ListNode(val);
                    l1 = l1.next;
                } else {
                    val = l1.val + l2.val;
                    up = val / 10;
                    val = val % 10;
                    p.next = new ListNode(val);
                    l2 = l2.next;
                    l1 = l1.next;
                }
                p = p.next;
            }
            if (up != 0) {
                p.next = new ListNode(1);
            }
            return h;
        }

        public static void main(String[] args) {
            System.out.println(addTwoNumbers(ListNode.toNode(111111111111111L), ListNode.toNode(111111111111111L)));
        }
    }
}
