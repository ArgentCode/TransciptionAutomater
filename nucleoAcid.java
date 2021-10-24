import java.util.HashMap;
import java.util.Scanner;
public class nucleoAcid{

    public static String acids(String input){
        String output = "";
        String end = "";
        if (input.charAt(0) == '5'){
            output = "3' ";
            end = " 5'";
        } else if (input.charAt(0) == '3'){
            output = "5' ";
            end = " 3'";
        } else {
            return "Error";
        }
        input = input.substring(3, input.length() - 3);
        input = input.toLowerCase();
        String mid = "";
        for (int i=0;i<input.length();i++) {
            char next = transcriptionSwtich(input.charAt(i));
            if (next != 'n'){
                mid += next;
            }
        }
        mid = mid.toUpperCase();
        output += mid;
        output += end;
        System.out.println("RNA sequence: " + output);
        return output;
    }

    public static char transcriptionSwtich(char DNA){
        char RNA = 'n';
        switch(DNA) {
            case 'a': RNA = 'u'; break;
            case 't': RNA = 'a'; break;
            case 'g': RNA = 'c'; break;
            case 'c': RNA = 'g'; break;
        }
        return RNA;
    }

    public static String reverse(String RNA){
        String nstr = "";
        for (int i=0; i<RNA.length(); i++) {
            char ch = RNA.charAt(i); //extracts each character
            nstr= ch+nstr; //adds each character in front of the existing string
        }
        return nstr;
    }
    public static HashMap aminoAcids(){
        
        HashMap<String, String> aminoAcids = new HashMap<String, String>();
        aminoAcids.put("UUU", "PHE"); aminoAcids.put("UCU", "SER"); aminoAcids.put("UAU", "TYR"); aminoAcids.put("UGU", "CYS");
        aminoAcids.put("UUC", "PHE"); aminoAcids.put("UCC", "SER"); aminoAcids.put("UAC", "TYR"); aminoAcids.put("UGC", "CYS");
        aminoAcids.put("UUA", "LEU"); aminoAcids.put("UCA", "SER"); aminoAcids.put("UAA", "STOP"); aminoAcids.put("UGA", "STOP");
        aminoAcids.put("UUG", "LEU"); aminoAcids.put("UCG", "SER"); aminoAcids.put("UAG", "STOP"); aminoAcids.put("UGG", "TRP");

        aminoAcids.put("CUU", "LEU"); aminoAcids.put("CCU", "PRO"); aminoAcids.put("CAU", "HIS"); aminoAcids.put("CGU", "ARG");
        aminoAcids.put("CUC", "LEU"); aminoAcids.put("CCC", "PRO"); aminoAcids.put("CAC", "HIS"); aminoAcids.put("CGC", "ARG");
        aminoAcids.put("CUG", "LEU"); aminoAcids.put("CCA", "PRO"); aminoAcids.put("CAA", "GIN"); aminoAcids.put("CGA", "ARG");
        aminoAcids.put("CUA", "LEU"); aminoAcids.put("CCG", "PRO"); aminoAcids.put("CAG", "GIN"); aminoAcids.put("CGG", "ARG");

        aminoAcids.put("AUU", "ILE"); aminoAcids.put("ACU", "THR"); aminoAcids.put("AAU", "ASN"); aminoAcids.put("AGU", "SER");
        aminoAcids.put("AUC", "ILE"); aminoAcids.put("ACC", "THR"); aminoAcids.put("AAC", "ASN"); aminoAcids.put("AGC", "SER");
        aminoAcids.put("AUA", "ILE"); aminoAcids.put("ACA", "THR"); aminoAcids.put("AAA", "LYS"); aminoAcids.put("AGA", "ARG");
        aminoAcids.put("AUG", "MET"); aminoAcids.put("ACG", "THR"); aminoAcids.put("AAG", "LYS"); aminoAcids.put("AGG", "ARG");
        
        aminoAcids.put("GUU", "VAL"); aminoAcids.put("GCU", "ALA"); aminoAcids.put("GAU", "ASP"); aminoAcids.put("GGU", "GLY");
        aminoAcids.put("GUC", "VAL"); aminoAcids.put("GCC", "ALA"); aminoAcids.put("GAC", "ASP"); aminoAcids.put("GGC", "GLY");
        aminoAcids.put("GUA", "VAL"); aminoAcids.put("GCA", "ALA"); aminoAcids.put("GAA", "GLU"); aminoAcids.put("GGA", "GLY");
        aminoAcids.put("GUG", "VAL"); aminoAcids.put("GCG", "ALA"); aminoAcids.put("GAG", "GLU"); aminoAcids.put("GGG", "GLY");

        return aminoAcids;
    }

    public static String translation(String RNA){

        HashMap aminoAcidTable = aminoAcids();
        if (RNA.charAt(0) == '5'){
            RNA = reverse(RNA);
        }
        RNA = RNA.substring(3, RNA.length() - 3);
        RNA = RNA.toLowerCase();
        int i = 0;
        String output = "";
        while (i+3<RNA.length()){
            String codon = RNA.substring(i, i+3);
            i+= 3;
            Object acid = aminoAcidTable.get(codon.toUpperCase());
            output += acid+" ";
        }
        output = "3' "+output+" 5'";
        return output;
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        String RNA = acids(input);
        System.out.println(RNA);
        System.out.println("----------");
        String aminoAcids = translation(RNA);
        System.out.println(aminoAcids);

    }
}