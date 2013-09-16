package mostuseword;

// @author Daniil TrieTryNode
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.*;

public class Node {

    int frequency = 0;
    char charNode;
    Node nodes[];


    public Node() {
        this.charNode = '*';
        this.nodes = new Node[40];
    }

    public Node(char cn) {
        this.charNode = cn;
        nodes = new Node[40];
        this.frequency = 1;
    }

    public Node(char cn, Node node[]) {
        this.charNode = cn;
        this.nodes = node;
        this.frequency = 1;
    }

    public Node(char cn, String alphabet) {
        this.charNode = cn;
        this.nodes = new Node[alphabet.length() + 3];
        for (int i = 0; i < alphabet.length(); i++) {
            nodes[i] = new Node(alphabet.charAt(i));
        }
    }

    
    Node getNode(Node n, StringBuffer s) {
        return n.getNode(n, s.charAt(0));
    }

    Node getNode(Node n, char c) {
//        System.out.println("getNode(c) c = |"+c+"|");
        if (n.nodes != null) {
            return n.nodes[norm(c)];
        } else {
            return null;
        }
    }

    private Node[] getNodes(Node n, StringBuffer s) {
        return getNode(n, s).nodes;
    }

    private int norm(int a) {
        if ((a - 1072) > 40 || (a - 1072) < 0) {
//            System.out.println("Not exist simvol!");
            return 34;
        }
        return (a - 1072);
    }

    int norm(char a) {
        return norm((int) a);
    }

    char getChar(Node n) {
        if (n != null) {
            return n.charNode;
        }
        return 'ё';
    }

    int getFrequency(Node n) {
        if (n != null) {
            return n.frequency;
        }
        return -1;
    }
}
