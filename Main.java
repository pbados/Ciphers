/**
 * Created by Patryk on 26-04-2017.
 */
public class Main {
    public static String vigenere(String stringToCipher, String cipheringString){
        char[] podTab = new char[26];
        int z=65;
        for(int i=0; i<podTab.length;i++){
            podTab[i] = (char)z++;
        }
        int t=0;
        int[] arrCipheringString = new int[cipheringString.length()];
        for(int i=0; i<arrCipheringString.length;i++){
            arrCipheringString[i] = (int)(cipheringString.charAt(t++))-65;
        }

        int y=0;
        int[] arrStringToCipher = new int[stringToCipher.length()];
        for(int i=0; i<arrStringToCipher.length;i++){
            arrStringToCipher[i] = (int)(stringToCipher.charAt(y++))-65;
        }

        int[] sumOfTwoString = new int[arrStringToCipher.length];
        int j=0;
        for(int i=0; i<sumOfTwoString.length;i++){
            if(arrStringToCipher[i]==-33){
                sumOfTwoString[i]=-33;
            }else{
                sumOfTwoString[i] = (arrStringToCipher[i]+arrCipheringString[j++]);
            }
            if(j==cipheringString.length()){
                j=0;
            }
        }

        String[] finalString = new String[sumOfTwoString.length];
        String nF="";
        for(int i=0; i<finalString.length;i++){
            if((char)(sumOfTwoString[i]+65)>90){
                nF += (char)((sumOfTwoString[i]+65)-26);
            }else{
                nF += (char)(sumOfTwoString[i]+65);
            }
        }

        return nF;
    }

    public static String caesar(int number, String string){

        String[] alphabet = new String[] {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

        String[] cipher = new String[alphabet.length];

        int range =alphabet.length-number;

        for(int i=0; i<range;i++){
            cipher[i] = alphabet[i+number];
        }

        int a=0;
        for(int i=range; i<cipher.length;i++){
            cipher[i] = alphabet[a++];
        }

        String[] napTab = string.split("");

        String cipherFinal="";
        for(int i=0; i<napTab.length;i++){
            for(int j=0; j<alphabet.length;j++){
                if(napTab[i].equals(alphabet[j])){
                    cipherFinal+=cipher[j];
                }
            }
        }

        return cipherFinal;
    }

    public static String caesarDecipher(int number, String string){
        String[] alphabet = new String[] {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

        String[] cipher = new String[alphabet.length];

        int range =alphabet.length-number;

        for(int i=0; i<range;i++){
            cipher[i] = alphabet[i+number];
        }

        int a=0;
        for(int i=range; i<cipher.length;i++){
            cipher[i] = alphabet[a++];
        }

        String[] napTab = string.split("");

        String decipherFinal="";
        for(int i=0; i<napTab.length;i++){
            for(int j=0; j<cipher.length;j++){
                if(napTab[i].equals(cipher[j])){
                    decipherFinal+=alphabet[j];
                }
            }
        }

        return decipherFinal;
    }

    public static void main(String[] args) {

        System.out.println("=====PROGRAM THAT MAKES VIGENERE CIPHERING AND CAESAR CIPHERING AND DECIPHERING=====");
        System.out.println("===VIGENER CIPHER===");
        String stringToCipher = "MAKE IT HAPPEN";
        String cipheringString = "MATH";
        System.out.println("String -> Cipher: "+stringToCipher);
        System.out.println("Ciphering string: "+cipheringString);
        System.out.println("String "+stringToCipher+" after ciphering by "+cipheringString+": "+vigenere(stringToCipher, cipheringString));
        System.out.println("===CAESAR CIPHER===");
        System.out.println("=CIPHERING=");
        String stringToCaesar = "JAVA";
        int number = 3;
        System.out.println("String -> Cipher: "+stringToCaesar);
        System.out.println("Shift: "+number);
        System.out.println("String "+stringToCaesar+" after ciphering by "+number+" shift: "+caesar(number, stringToCaesar));
        System.out.println("=DECIPHERING=");
        String caesarToString = "GHYHORSHU";
        System.out.println("Cipher -> String: "+caesarToString);
        System.out.println("Shift: "+number);
        System.out.println("Cipher "+caesarToString+" after ciphering by "+number+" shift: "+caesarDecipher(number, caesarToString));



    }
}
