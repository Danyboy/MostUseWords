package mostuseword;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;
import java.util.Collection;

/**
 * @author Daniil
 */
public class WordInputOutput extends TryTree {

    public void read() throws IOException {
        setAlphabet();
        FileReader fr = new FileReader("sveta.txt");
        BufferedReader br = new BufferedReader(fr);
        String s;
        while ((s = br.readLine()) != null) {
//            System.out.println(s);
            stringToWords(s);
        }
        fr.close();

    }

    public void stringToWords(String s) {
        s = s.toLowerCase();
        Pattern pat;
        Matcher mat;
//         + "[0-9]+" + "[();:]"
        pat = Pattern.compile("[a-z]*[0-9]*");
        mat = pat.matcher(s);
        s = mat.replaceAll("");
        pat = Pattern.compile("[|—_]*-*");
        mat = pat.matcher(s);
        s = mat.replaceAll("");
        pat = Pattern.compile("[ ,?!]");
        mat = pat.matcher(s);
        String str[] = pat.split(s);
        for (int i = 0; i < str.length; i++) {
            add(str[i]);
//            System.out.print(str[i]+", ");
        }
    }
    int freq = 0;

    public int getWordFrequency(Node n, StringBuffer s) {
        Node a;
        if (s.length() != 0) {
            if (getNode(n, s) != null) {
                a = getNode(n, s);
                freq = a.frequency;
                s.deleteCharAt(0);
                return getWordFrequency(a, s);
            } else {
                return 0;
            }
        }
        return freq;
    }
    String mostUseWord = "";

    public String MostUseWord(Node myNode) {
        int freq = 0;
        char chr = 's';
        if (myNode != null && myNode.nodes != null) {
            Collection<Node> coll = myNode.nodes.values();
            for (Node node : coll) {
                if (node.frequency > freq) {
                    freq = node.frequency;
                    chr = node.charNode;
                }
            }
            if (chr != 's') {
//                System.out.println(""+chr);
                mostUseWord += chr;
                return mostUseWord + MostUseWord(myNode.getNode(myNode, chr));
            }
        }
        return "";
    }

    public String useWord(Node myNode) { //test metod
        int freq = 0;
        char chr = 's';
        if (myNode != null && myNode.nodes != null) {
            Collection<Node> coll = myNode.nodes.values();
            for (Node node : coll) {
                if (node.frequency > freq) {
                    freq = node.frequency;
                    chr = node.charNode;
                }
                System.out.println("Character: " + node.charNode + ", frequncy: " + node.frequency);
            }
            if (chr != 's') {
//                System.out.println(""+chr);
                mostUseWord += chr;
                return mostUseWord + MostUseWord(myNode.getNode(myNode, chr));
            }
        }
        return "";
    }
}


