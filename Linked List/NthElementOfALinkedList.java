public class Nth {
    public static void main(String[] args) {
        // NOTE: The following input values will be used for testing your solution.
        Node current = new Node(1, null);
        for (int i = 2; i < 8; i++) {
            current = new Node(i, current);
        }
        Node head = current;
        // head = 7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1 -> (null)

        Node current2 = new Node(4, null);
        for (int i = 3; i > 0; i--) {
            current2 = new Node(i, current2);
        }
        Node head2 = current2;
        // head2 = 1 -> 2 -> 3 -> 4 -> (null)

        // nthFromLast(head, 1) should return 1.
        // nthFromLast(head, 5) should return 5.
        // nthFromLast(head2, 2) should return 3.
        // nthFromLast(head2, 4) should return 1.
        // nthFromLast(head2, 5) should return null.
        // nthFromLast(null, 1) should return null.
    }


    // Implement your function below.
    public static Node nthFromLast(Node head, int n) {
        if(head == null) {
            return null;
        }
        Node temp = head;
        int count = 1;
        while(temp.child != null) {
            temp = temp.child;
            count++;
        }
        if(n > count) {
            return null;
        }
        temp = head;
        int tracker = 0;
        while(temp != null) {
            if(tracker == count-n) {
                return temp;
            }
            tracker++;
            temp = temp.child;
        }
        return null;
    }


    //  NOTE: Feel free to use the following function for testing.
    //  It converts the given linked list into an easy-to-read string format.
    //  Example: 7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1 -> (null)
    public static String linkedListToString(Node head) {
        Node current = head;
        StringBuilder sb = new StringBuilder();
        while (current != null) {
            sb.append(String.valueOf(current.value));
            sb.append(" -> ");
            current = current.child;
        }
        sb.append("(null)");
        return sb.toString();
    }
 }
