import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Homework5{
    public static void main(String[] args) {
    System.out.println(isCorrectParentheses("()")); // true
    System.out.println(isCorrectParentheses("(")); // false
    System.out.println(isCorrectParentheses("())")); // false
    System.out.println(isCorrectParentheses("((()))")); // true
    System.out.println(isCorrectParentheses("()[]{}<>")); // true
    System.out.println(isCorrectParentheses("([)]")); // false
    System.out.println(isCorrectParentheses("][]")); // false
    System.out.println(isCorrectParentheses("[]{<()[]<>>}")); // true
}

/**
 * Дана последовательность скобочек. Проверить, что она является корректной.
 */
static boolean isCorrectParentheses(String parentheses) {
        // TODO: 07.04.2023 Вписать решение!
        // Нужно завести маппинг скобочек либо ( -> ), либо ) -> ( и так для каждой пары
        // Нужно использовать Deque.
        // Открывающуюся скобку вносим в Deque (insertFirst)
        // Если встретилась закрывающаяся скобка, то (Deque#pollFirst) и сравниваем ее с встретившейся
        if (parentheses.length()%2!=0) return false;
        Map <Character, Character> storage = CreateStorage();
        Deque <Character> deq = new ArrayDeque<>();
        for (int i=0; i<parentheses.length(); i++){
            if(storage.containsValue(parentheses.charAt(i))){
                deq.addFirst(parentheses.charAt(i));
            } else if(storage.containsKey(parentheses.charAt(i))){
                if(storage.get(parentheses.charAt(i))!=deq.pollFirst()) {
                    return false;
                }
            }
        }
        
        return true;
    }

static Map<Character, Character> CreateStorage(){
    Map <Character, Character> storage = new HashMap<>();
    storage.put(')', '(');
    storage.put(']', '[');
    storage.put('}', '{');
    storage.put('>', '<');
    return storage;

}
}