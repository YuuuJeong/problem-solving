import java.io.*;
import java.util.*;

public class BOJ5397 {
	public static class Node {
        String value;
        Node next;
        Node prev;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String input = br.readLine();


            Node head = new Node();
            Node curNode = head;
            List<Node> list = new ArrayList<>();
            list.add(head);
            
            for (char c : input.toCharArray()) {
                if (c == '<') {
                    if (curNode.prev != null) {
                        curNode = curNode.prev;
                    }
                } else if (c == '>') {
                    if (curNode.next != null) {
                        curNode = curNode.next;
                    }
                } else if (c == '-') {
                    if (curNode != head) {
                        Node toDelete = curNode;
                        curNode = curNode.prev;
                        if (toDelete.next != null) {
                            toDelete.next.prev = curNode;
                        }
                        curNode.next = toDelete.next;
                    }
                } else {
                    Node newNode = new Node();
                    newNode.value = String.valueOf(c);
                    newNode.prev = curNode;
                    newNode.next = curNode.next;
                    if (curNode.next != null) {
                        curNode.next.prev = newNode;
                    }
                    curNode.next = newNode;
                    curNode = newNode;
                    list.add(newNode);
                }
            }


            StringBuilder sb = new StringBuilder();
            Node node = head.next; 
            while (node != null) {
                sb.append(node.value);
                node = node.next;
            }
            
            System.out.println(sb.toString());
        }
    }
}

