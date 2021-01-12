package com.linkedList;
import java.util.HashMap;
import java.util.Map;

public class cloneLinkedList {

    public Node CloneList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node tempHead = head;
        while (tempHead != null) {
            map.put(tempHead, new Node(tempHead.val));
            tempHead = tempHead.next;
        }
        tempHead = head;
        while (tempHead != null) {
            map.get(tempHead).next = map.get(tempHead.next);
            map.get(tempHead).random = map.get(tempHead.random);
            tempHead = tempHead.next;
        }
        return map.get(head);
    }
}
