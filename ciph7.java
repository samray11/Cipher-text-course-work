import java.util.HashMap;

import javax.xml.stream.events.Characters;

import java.util.*;
public class ciph7 {
    static String ciph ="IJHKVXDJIYNBHFVZIJV|NIDIPNVLIHMIUNZDJIVLIDIFHMZIJHDUISOVXOIZWQLNYIZONINYKNIHMINPNQGZOVLKIZODZIDZZNUBZNYIZHIZQDPNQFNIVZIVZIODYIAJHX|NYIOVFIDXXNBZDLXNIHMIZONIXOWQXOIVZIAJHX|NYIOVFIDXXNBZDLXNIHMIZNFFIUHQNHPNQIOVFIDMMNXZVHLIVZFNJMISDFIJNFFIMVQNIZODLIQDYVDLXNIDLYISVZOIQNKDQYIZHIZONIHZONQIFNCISONLIONIXNDFNYIZHIANJVNPNIONIXNDFNYIZHIMHJJHSIXHLZQDFZVLKIVLIZOVFISVZOIUDLGIVUBQNFFVHLDAJNILDZWQNFISOHIQNUDVLIFNLFWHWFJGIVLMDZWDZNYISVZOISODZIZONGIVLZNJJNXZWDJJGIYNFBVFNIONISDVZNYIZVJJIONQIFHAAVLKIXNDFNYIVISVFOIODJMIZONISHUNLIVLINLKJDLYISNQNIDFIQNFBNXZDAJNIDFIGHWIONIFDVYIVLIDLINAWJJVZVHLIHMIAVZZNQLNFFIDKDVLFZISHUDL|VLYIVLIKNLNQDJIVZIVFLZIDITWNFZVHLIHMIQNFBNXZDAVJVZGIAWZIHLNIHMIBQVLXVBJNIONIFBH|NIFWXOIZOVLKFIDFIZONFNIDLYIUHQNIHMIDI|VLYQNYIFHQZIZHIONQIANVLKIFZVJJIFSDGNYIAGIZONIDLZVBDZONZVXISDPNISOVXOISDQBFIYVQNXZIFHWJFISVZOIFWXOIBNQFVFZNLXNISONLIHL";
    static char[] alphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','|'};
    static char[] newAlph =  {'V','B','C','Y','N','M','K','O','_','J','K','S','M','N','H','P','R','R','N','Z','W','P','U','X','Y','Z','|'};
    public static void main(String[] args) { 
        freq(ciph,alphabet);
        String plain = ciph.replaceAll("I", " ");//the most commonly occuring letter is probably a space
        /*
        * The replace functions were to assist in helping me determine characters, and start finding small words.
        plain = plain.replaceAll("N", "E");
        plain = plain.replaceAll("V", "A");
        plain = plain.replaceAll("Z", "T");
        plain = plain.replaceAll("S", "N");
        plain = plain.replaceAll("L", "S");
        plain = plain.replaceAll("O", "H");
        plain = plain.replaceAll("H", "O");
        plain = plain.replaceAll("G", "Y");
        plain = plain.replaceAll("D", "A");
        plain = plain.replaceAll("Y", "D");
        plain = plain.replaceAll("K", "G");
        plain = plain.replaceAll("M", "F");
        plain = plain.replaceAll("P", "V");
        plain = plain.replaceAll("Q", "R");
        plain = plain.replaceAll("W", "U");
        */
        System.out.println(plain);
        
        String output =decrpyt(ciph);
    }
    /*
    {A=13, B=14, C=1, D=54, F=52, G=9, H=41, I=146, J=31, K=11, L=47, M=16, N=95, O=43, P=6, Q=30, S=20, T=1, U=10, V=61, W=14, X=28, Y=24, Z=67, |=6} these are all the character requenecies and the order according to an alphabet frequancy table
    I = SPACE
    N = E   
    Z = T
    V = A
    D = O
    S = N
    L = S
    D = O
    F = I
    O = N   
    L = S
    H = R
    J = H
    
    */
// a selection of if statments to check each character in the string and replace it accordingly
    public static String decrpyt(String ciph){
        String plain = "";
        for (int i = 0; i < ciph.length(); i++) {
            if(ciph.charAt(i) == 'I'){
                plain += " ";
            }else if(ciph.charAt(i) == 'N'){
                plain += "E";
            }else if(ciph.charAt(i) == 'Z'){
                plain += "T";
            }else if(ciph.charAt(i) == 'V'){
                plain += "I";
            }else if(ciph.charAt(i) == 'H'){
                plain += "O";
            }else if(ciph.charAt(i) == 'S'){
                plain += "W";
            }else if(ciph.charAt(i) == 'L'){
                plain += "N";
            }else if(ciph.charAt(i) == 'W'){
                plain += "U";
            }else if(ciph.charAt(i) == 'M'){
                plain += "F";
            }else if(ciph.charAt(i) == 'G'){
                plain += "Y";
            }else if(ciph.charAt(i) == 'K'){
                plain += "G";
            }else if(ciph.charAt(i) == 'O'){
                plain += "H";
            }else if(ciph.charAt(i) == 'Y'){
                plain += "D";
            }else if(ciph.charAt(i) == 'P'){
                plain += "V";
            }else if(ciph.charAt(i) == '|'){
                plain += "K";
            }else if(ciph.charAt(i) == 'Q'){
                plain += "R";
            }else if(ciph.charAt(i) == 'D'){
                plain += "A";
            }else if(ciph.charAt(i) == 'F'){
                plain += "S";
            }else if(ciph.charAt(i) == 'X'){
                plain += "C";
            }else if(ciph.charAt(i) == 'B'){
                plain += "P";
            }else if(ciph.charAt(i) == 'A'){
                plain += "B";
            }else if(ciph.charAt(i) == 'J'){
                plain += "L";
            }else if(ciph.charAt(i) == 'U'){
                plain += "M";
            }else if(ciph.charAt(i) == 'C'){
                plain += "X";
            }else if(ciph.charAt(i) == 'T'){
                plain += "Q";
            }else{
                plain += "======CHARACTER HAS NOT BEEN DECIPHERED HERE===";
            }
        }
        System.out.println(plain);
        return plain;
    }

//generate a hashmap of frequencies for each character in the ciphertext.
    public static HashMap<Character,Integer> freq(String ciph, char[] alphabet){
        HashMap<Character,Integer> freq = new HashMap<>();
        for (int i = 0; i < alphabet.length; i++) {
            for (int j = 0; j < ciph.length(); j++) {
                if(alphabet[i] == ciph.charAt(j)){
                    if(freq.containsKey(alphabet[i])){
                        freq.put(alphabet[i],freq.get(alphabet[i])+1);
                    }else{
                        freq.put(alphabet[i], +1);
                    }
                }
            }
        }
        System.out.println(freq);
        return freq;
    }
}