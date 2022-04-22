import java.util.Arrays;

import org.graalvm.compiler.nodes.cfg.HIRLoop;

public class cipher5 {
    public static String ciph = "HDTRSTHWNCERBYELATAARTBCYIOEPDOCUUMORODSSETSLOLTHILOTHBDTHPSAODSIHOLNPCSORNTNISOYVEANIESCEBCMAWATNIDPNSSAECTEHRLDEOSIEEUNHIINTEKCNBNIMJHWUSHCEONGFHTOSPDSHUEHEDOEEKEIAPEEOHMPLOAGIAIYFVDFERLEISTRNMBEIRESSESDTTHPNAHKLEHEDKMHELNRIOSNTHENAFEGAUOUDEHEMSNHENDCNOMSSYEATARHESHSTTNNMSRDETOAFFWTFPEGENNCEBFOGOGTEIIANOEHYKGDREERSLWOIIDEMYAHMEWNCANWWEOIERLIRNVAOEATSRCSNTEEGSORCPOITBTLIHERTBEEIAERSEUABEOIMSIEEEVTBNCTRLFTSFERPIEORHBOGFUCAFOGISIEIHEEOLEDUHOTHHOTILISLITOTAGERRAOAIASDGSREATICSLOOCRCBUIOCVTSEATAPTHGCNTIIFFRSSKNCDEBRRYESILIGRDAFOOIAIFCCYHYCAWEALTDTNOMTDCTADTKASNWAWEHIETHTAAWCOGARODWWEENOHSONOFIOHNTNELDLESTSELOEHKTROTOARTNODDATESKNLNETTIDATWMRDIWMOERAMTTHEOALLTLTTIAOITNNOAISEIALDNOSASRSVATAALDRMKOLEMJOPANETASTEASTDTAASHTBISESEGNNARETGIEIRNAERELENAEHHENNIIRDRINNEGUHAAIISSHIELTAEEHEGHNMOITPYAFHATIDIDEOONTLTONOANNTTLOREHWQRTMOSHFYLNNMMH";

    public static void main(String[] args) { 
        decrypt(ciph, 5);
    }

/*
*THE KEY WAS DETERMINED BY TRIAL AND ERROR
*this decrypt function works by two for loops, one for columns and the other for rows, where each loops through the cipher text
* as if it were broken into rows and columns of the key length. The code essentially takes each row of, in this case, 5 character (the key length) and goes through the nth index column of each row and adds the cipher text
in order of the string to those indexes.For example HDTRS gets put into H_____D_____T_____R_____S where the blank spaces will be later populated by other characters to form HEWINDOWINTHEFORMOFAS
FIRST 30 CHARACTERS = HEWINDOWINTHEFORMOFASPIRITLESS
*/
    public static void decrypt(String ciph, int key){
        String plaintext = "";
        for(int col = 0; col < ciph.length()/key; col++){
            for(int row = col; row < ciph.length(); row+=ciph.length()/key){
               plaintext += ciph.charAt(row);
            }
        }
        System.out.println(plaintext);
    }
}
