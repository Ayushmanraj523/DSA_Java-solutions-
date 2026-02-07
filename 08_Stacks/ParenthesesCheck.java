import java.util.Stack;

public class ParenthesesCheck {
    public static void main(String[] args) {
        String[] tests = {"{([])}", "({})[]", "{[}]", "((())", ")("};
        
        for (String expr : tests) {
            System.out.println("Expression: " + expr);
            System.out.println("Is balanced? " + isBalanced(expr));
            System.out.println();
        }
    }
    
    static boolean isBalanced(String expr) {
        Stack<Character> stack = new Stack<>();
        
        for (char ch : expr.toCharArray()) {
    
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            
            else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) return false;
                
                char top = stack.pop();
                
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
}
