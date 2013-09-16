/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mostuseword;

import java.io.IOException;

/**
 *
 * @author Daniil
 */
public class Main {

    public static void main(String[] args) throws IOException {


        WordInputOutput n = new WordInputOutput();
        n.setAlphabet();
        n.read();
        System.out.println("root frequncy is: " + n.root.frequency);

        n.MostUseWord(n.root);
        System.out.println("Word, must word: " + n.mostUseWord);



//        n.allChar(n.root.nodes[0]);
//        System.out.println(""+n.getFrequency(n.root));
    }
}
