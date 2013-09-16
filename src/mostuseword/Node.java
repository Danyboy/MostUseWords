package mostuseword;

import java.util.HashMap;
import java.util.Map;

public class Node {

        int frequency = 0;
        char charNode;
        Map<Character, Node> nodes = new HashMap<Character, Node>();

        public Node() {
            charNode = '*';
//        nodes = new Map();
        }

        public Node(char cn) {
            charNode = cn;
//        nodes = new Node[40];
            frequency = 1;
        }

        public Node(char cn, Map node) {
            charNode = cn;
            nodes = node;
            frequency = 1;
        }

        public Node(char cn, String alphabet) {
            charNode = cn;
            for (int i = 0; i < alphabet.length(); i++) {
                nodes.put(alphabet.charAt(i), new Node(alphabet.charAt(i)));
            }
        }

        Node getNode(Node n, StringBuffer s) {
            return n.getNode(n, s.charAt(0));
        }

        Node getNode(Node n, char c) {
            if (n.nodes != null) {
                return n.nodes.get(c);
            } else {
                return null;
            }
        }

        private Map<Character, Node> getNodes(Node n, StringBuffer s) {
            return getNode(n, s).nodes;
        }

        char getChar(Node n) {
            if (n != null) {
                return n.charNode;
            }
            return 'ё'; // = null
        }

        int getFrequency(Node n) {
            if (n != null) {
                return n.frequency;
            }
            return -1;
        }
}
