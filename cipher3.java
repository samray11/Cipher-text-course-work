import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import javax.print.DocFlavor.CHAR_ARRAY;

import jdk.jfr.Frequency;

public class cipher3 {
    /*
    The decrypt function is the same as the one I used in the cipher2.java
    The difference with this cipher breaker is that this one determines the key first, as one is not given.
    It can determine a key in a given range, in this case I chose 4-6 as this is what is required for questions 3 and 4.
    Both ciphers are given, one is commented out to prevent conflict of a variable.
    The key is determined by frequenct analysis where given a cipher it will generate a key given the best match of the length.
    */
    public static void main(String[] args) {
        int maxkeysize = 6;
        int minkeysize = 4;
        char[] alphabet = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
                'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
        double freqencyTable[] = { 0.08167, 0.01492, 0.02782, 0.04253, 0.12702, 0.02228, 0.02015, 0.06094, 0.06966, 0.00153, 0.00772, 0.04025, 0.02406, 0.06749, 0.07507, 0.01929, 0.00095, 0.05987, 0.06327, 0.09056,0.02758, 0.00978, 0.02360, 0.00150, 0.01974, 0.00074 }; // distribution of letters used in the english alpha bet, src wikipedia 
        // exercise 3 String ciph = "NUSXSGMGMMBILECIICTIKIFTHORMLEEXHMBREUEECBETVIGVRKZBSCOAFPTDRNHUHDBKZEOGEZGIHIHKMMUPTOUMCUTKMUSPNZMWHWITFUCGEZGIBIHKOZSUAIDBCIHKZNTXRSZBWKEGMLWIWGRTWITRDMBDUMGNCGHOLVCITUJVCLTNZBWCTNDUOCNKQWTIHKOZSHETSVSVAZHDSIHKQMZPYGFZSPTKWKSETONVHDTNDLOALEHVUHOLBWMCEYRBVPTYGMVPDGKZSPDEOMFBIZSMRWISSWAPKKKWJTTUGMFWEXDIRPSGMIRSIZHWBPLGRAIGATBMBDTLTTZNTXNEWCGZGIHXNZGMTXERCAOCDVZAHJRKRBCHIMGOFPTORQGQYTNUSPNYCMSBEJVIGIERNDSBAQHVUQEOMOVTRKLWFTOLSMBPCIDXHTDOMKCCSOCMFPTKKGOCDLNZWISUVVGLEKSAOZEZGIBXNZGMQPRQHVUPNDHWIHHULMGDFZGMOBBOSQCJSCGMFTAMHZZHCXZDWCGLNZOCEYSIPAIYGUSCTVZZOAYFDAVTRNDIZIHESPCJGNSWTPPGRAWDNGRIBTNJSMGHWNXLWSYUTAONNUHVGJCNZXCHIZHDSLAEGMOHKKCPSGITSPSROAQASDFGEMKSAERAVTSZZZHTDJNVHPSQLMWIORCGCJWNXXOGTRXQOBNUSOCDDKMWIVHTNBKDRZGGSCOAFPVDWTNBTXNKKIRNETNCUWYKRACBEZGQBVLOJMHWAZLCFBUXDLGWEENCFURODVRHWUTTRHCUQVATITCMSSYUTUWHTGJMHWESLGTPTNDZOCDSNBVT";
        String ciph = "WXTJYWHIYCVWFDSQYIUWAWFBFGPFTXJFWUCQFUXVJFOTFFJNKIEZSUUOMZJVKXUXVYJOJCWRBDRZTSIVTFDAYWIJTELHBBCKFJTKWXTXVKUPAVLTNUZFUBIJASHMYGBBIKZJHUELQFCRFFTAVVYIUDGYIUIQTVHYMXCQEVSPXVDQOUMWWOUMWWDEDWFOINWWFTKWXTYEKYPDPZTQUCWXTDVKXUXVFBIENSXJJFZDPKEWJEDKSXLOFMAFIVWSIYDTJGEIWFOTJGMBLVAFIMYSYEYUZJTQPKFJTAGFOSLJNPKJDDJMZDQUUCDDPKNZJOMVSWFIVLYMUUASPKIDTEWZFLBJBASHISWWFJFETSHFOJWUIQBPHUAYXQJFTUXVJMVISSSEIYWMBTJSNEOVLFDEEKHJELKSFIJLMBJZFFQXPKNDQCKJOIVLMJIDSSBBFFJXQJZJSXLKGBDUKJFCVVYPMVALIEEZJSCFJJBDUETSUCANEKIASHJYWXNQCDMPKIKTGJYWSFNKETSDZFLXXZDJJJNSXTJZDQEQICIXUCDJSIEWFSJYWMJWYOFZINWWFSFFXDYFMXPVRVNTJLJGBDTWTGJYWNSDZYMUIIWXURPJZNRCASHDFAXFIZFYFHDAYUUELQZSFFYJDLASHJZDQEQPDNHXKFTJIVKFTSVJYBYELTSUTMWJDKZNTFRJYJSLDFSVZJXUMVWPPVKZJNEELMBIKZJWEZUJPVKZJDKTCTPYELMFJYAWEMVWPPVKZJTQDWYIUPOJSUKZJQHVDNNYESWJUJGKUXVYJOUISQSUDGABBKZJQQJKNOWFXYIUVEUUONSLHEEKFOTK";
        int character;
        //this for loop populates an int array that stores the int values of char's from the cipher string.
        for (int j = minkeysize; j <= maxkeysize; j++){// tests the possible key sizes which is 4 to 6
            char [] key = new char[j]; // a new char array of the key size being attempted is made
            for (int y = 0; y < key.length; y++) {
                double [] msgDouble = new double[ciph.length()/j];
                for (int z = y; z < ciph.length(); z+= j){// for each iteration, increase the iterator value by the key length being tried.
                     //puts the ciph[char] value in a double array for comparison to the frequency table
                    msgDouble[ciph.charAt(z) - 'A']++;
                }
                character = match(msgDouble,freqencyTable);//determines the best character to use given the frequency analysis
                key[y] = alphabet[character];// puts that character into the key[y]
            }
            System.out.println("Attempting to decrypt with: key"+Arrays.toString(key)+" Key length"+" "+j );
            decrpyt(key, ciph.toCharArray(), alphabet); // attempts to decrypt the code with the given key
        }
    }
    // same decrypt method as used in cipher2.java
    public static void decrpyt(char[] key, char[] ciph, char[] alphabet) {
        String plainText = "";
        for (int i = 0; i < ciph.length; i++) {
            int z = (ciph[i] - key[i % key.length] + 26) % 26;
            plainText += alphabet[z];
        }
        System.out.println(plainText);
        System.out.println();
    }
    // this method returns an int value that points to an alphabetical character
    public static int match(double[] msg, double[] freq){
        double fitness;
        double idealFit = Double.MAX_VALUE;
        int bestmatch = 0;
        for (int i = 0; i < msg.length; i++) {//loops for each letter in the alphabet
            fitness = 0;
            for (int j = 0; j < freq.length; j++){//loops through each character of the frequency table
                fitness += msg[(j+i)%26] / freq[j];//determines the accumulated fitness value for the character value and frequency given
            }
            if (fitness < idealFit){//compares the accumulated fitness with the ideal fitness value, we want a lower fitness
                idealFit = fitness;
                bestmatch = i;//the best match character is set
            }//if the fitness isnt less than fitter then the solution isnt an improvment, this is a greedy way of doing it as it converges on the local optima
        }
        System.out.println(bestmatch);
        return bestmatch;
    }
    
}
