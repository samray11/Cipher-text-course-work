import java.util.Random;

public class cipher2 {
    public static void main(String[] args){
        char[] alphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O',
        'P','Q','R','S','T','U','V','W','X','Y','Z'};

        String ciph = "YELJOIXZQDHRUJZILTYKLAELSXTUOI";
        String key ="TESSOFTHEDURBERVILLES";
        String keyext =  "TESSOFTHEDURBERVILLESTESSOFTHE";//extended the key to match the text
        String d = decrpyt(keyext.toCharArray(), ciph.toCharArray(), alphabet);
        System.out.println(d);
        
    }
/*
* the decrypted text is determined by extending the key to match the cipher
* looping through the cipher and performing a calculation on the char value where
* value of the char is substracted from its position in the key modulos the key length + 26 modulos 26 ( int z = (ciph[i] - key[i % key.length]+ 26)%26;)
* int z corresponds to a character in the alphabet list
* PLAIN TEXT  = FATRADESMANATFINDINGTHATAJOBHE
*/
    
    public static String decrpyt(char[] key, char[] ciph, char[] alphabet){
        String plainText = "";
        for(int i = 0; i < ciph.length; i++){
            int z = (ciph[i] - key[i % key.length]+ 26)%26;
            plainText += alphabet[z];
        }
        return plainText;
    }


            
}
