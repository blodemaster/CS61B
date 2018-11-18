public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        Deque<Character> wordDeque = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            Character currentChar = word.charAt(i);
            wordDeque.addLast(currentChar);
        }

        return wordDeque;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> wordDeque = wordToDeque(word);

        int fullLen = wordDeque.size();
        for (int i = 0; i < fullLen / 2; i++) {
            if (!wordDeque.removeFirst().equals(wordDeque.removeLast())) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> wordDeque = wordToDeque(word);

        int fullLen = wordDeque.size();
        for (int i = 0; i < fullLen / 2; i++) {
            if (!cc.equalChars(wordDeque.removeFirst(), wordDeque.removeLast())) {
                return false;
            }
        }
        return true;

    }
}
