import java.util.Arrays;

public class Main {

    public Main(){
        breakCipher("esbzops qjh qfo");
    }
    
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Main main = new Main();
    }

    private void breakCipher(String code){
        // Base alphabet list - used to compare rank and clear modified lists
        final char[] ALPHABET = createCharArray("abcdefghijklmnopqrstuvwxyz");

        // Alphabet list to be manipulated
        char[] cipher;

        // Code phrase to be cracked - in char array format
        char[] codeChars;

        // This for-loop takes the alphabet list and runs through each rank 0-25
        for(int i = 0; i < ALPHABET.length; i++){


            // Manipulating the standard alphabet liest 
            cipher = shiftLetters(ALPHABET, i);
            codeChars = createCharArray(code);
            // Retrieve the normal rank of each character in the alphabet, and have it replaced with the corresponding rank
            // in the manipulated alphabet list 
            for(int j = 0; j < codeChars.length; j++){

                // ensure that the current character is not a space ##TODO: change this to ensure that the character is a letter
                if(codeChars[j] != ' '){
                    codeChars[j] = cipher[compareChars(codeChars[j], ALPHABET)];
                }

                System.out.print(codeChars[j]);
            }
            System.out.println("");




         }
         
    }

    private char[] shiftLetters(char[] letters, int shift){
        char[] newLetters = new char[letters.length];
        int p;
        for(int i = 0; i < letters.length; i++){
            p = i + shift;
            if(p >= letters.length){
                p = p - letters.length;
            }
            newLetters[i] = letters[p];
        }

        return newLetters;
    }

    private char[] createCharArray(String toChars){
        char[] ch = new char[toChars.length()]; 

        for (int i = 0; i < toChars.length(); i++) { 
            ch[i] = toChars.charAt(i); 
        }

        return ch;
    }

    private int compareChars(char a, char[] charList){
        for(int i = 0; i < charList.length; i++){
            if(a == charList[i]){
                return i;
            }
        }
        System.out.println("Error: compareChars method has failed to compare the character");
        return -1;
    }
}
