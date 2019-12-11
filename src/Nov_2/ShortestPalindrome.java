package Nov_2;


public class MakePalindromeOptimized {

    public static void main(String arg[]) {
        MakePalindromeOptimized opt = new MakePalindromeOptimized();
        String word = "aacecaaa";
        String newWord = word + opt.reverse(word);
        System.out.println(newWord);
        int start = newWord.lastIndexOf(word);
        System.out.println(opt.makePalindrome(newWord, start, start + word.length()));
    }

    private String reverse(String word) {
        String newStr = "";
        int length = word.length();

        for( int i = length - 1; i >= 0; i--) {
            newStr += word.charAt(i);
        }
        return newStr;
    }

    private String makePalindrome(String word, int start, int end) {

        if (word.length() == 0 || word.length() == 2 || start == 0) {
            return word;
        }

        if (isPalindrome(word.substring(start, end))) {
            return word.substring(start, end);
        } else
            return makePalindrome(word, start - 1, end);
    }

    private boolean isPalindrome(String word) {

        if(word.length() == 1 || word.length() == 0)
            return true;

        if(word.charAt(0) == word.charAt(word.length() -1))
            return isPalindrome(word.substring(1, word.length()-1));
        else
            return false;
    }
}
