package com.linkedList;

import com.linkedList.Node;

public class addTwoNumbersLL {
    static Node addNumbers(Node first, Node second){
        Node head = null;
        Node prev = null;
        Node temp = null;
        int carry = 0, sum;

        while (first != null || second != null) {
            sum = carry + (first != null ? first.data : 0)
                    + (second != null ? second.data : 0);

            carry = (sum >= 10) ? 1 : 0;
            sum = sum % 10;
            temp = new Node(sum);
            if (head == null) {
                head = temp;
            } else {
                prev.next = temp;
            }
            prev = temp;
            if (first != null) {
                first = first.next;
            }
            if (second != null) {
                second = second.next;
            }
        }

        if (carry > 0) {
            temp.next = new Node(carry);
        }

        return head;
    }

    public static void main(String[] args) {

    }
}
