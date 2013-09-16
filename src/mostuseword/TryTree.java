package mostuseword;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TryTree extends Node {

    Node root;
    String alphabet = "абвгдежзийклмнопрстуфхцчшщъыьэюя";

    void setAlphabet() {
        root = new Node('*', alphabet);
    }

    public void add(String s) {
        root.frequency++;
        add(root, new StringBuffer(s));
    }

    public void add(Node n, StringBuffer s) {
        Node a;
        if (s.length() != 0) {
            if (getNode(n, s) != null) {
                a = getNode(n, s);
                n.frequency++;
            } else {
                n.nodes.put(s.charAt(0), new Node(s.charAt(0)));
                a = getNode(n, s);
            }
            s.deleteCharAt(0);
            add(a, s);
        }
        return;
    }

    

    public void allChar(Node n) {
        for (int i = 0; i < 34; i++) {
//            System.out.println(getFrequency(n.nodes[i]) + " " + getChar(n.nodes[i]));
        }
    }
    /*а - 1072 б - 1073 в - 1074 г - 1075 д - 1076 е - 1077 ё - 1105 ж - 1078
    з - 1079 и - 1080 й - 1081 к - 1082 л - 1083 м - 1084 н - 1085 о - 1086
    п - 1087 р - 1088 с - 1089 т - 1090 у - 1091 ф - 1092 х - 1093 ц - 1094
    ч - 1095 ш - 1096 щ - 1097 ъ - 1098 ы - 1099 ь - 1100 э - 1101 ю - 1102
    я - 1103*/
//
}
