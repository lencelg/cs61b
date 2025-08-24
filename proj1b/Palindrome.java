public class Palindrome {

    public Deque<Character> wordToDeque(String word){
        Deque<Character> res = new ArrayDeque<>();
        for (int i = 0; i < word.length() ; i++){
           res.addLast(word.charAt(i));
        }
        return res;
    }

    public boolean isPalindrome(String word){
        Deque<Character> cur = wordToDeque(word);
        return recursiveisPalindrome(cur);
    }

    private boolean recursiveisPalindrome(Deque<Character> queue){
        if (queue.size()<2){
            return true;
        } else{
            if (queue.removeFirst() != queue.removeLast()){
                return false;
            }
            return recursiveisPalindrome(queue);
        }
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        Deque<Character> cur = wordToDeque(word);
        while(cur.size() > 1){
            if (!cc.equalChars(cur.removeFirst(),cur.removeLast())){
                return false;
            }
        }
        return true;
    }
}