// task 2 : user-defined operators and precedence

import java.util.Stack;
import java.util.Scanner;
import java.util.HashMap;

public class precedence_of_operators {
    public static void main(String [] args ){

        Scanner sc = new Scanner (System.in);

        HashMap<Character, Integer> precedenceMap = new HashMap<>();

        System.out.println("Number of operators : ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0;i<n;i++){
            System.out.println("Operator : ");
            char op = sc.nextLine().charAt(0);
            System.out.println("Precedence : ");
            int prec = Integer.parseInt(sc.nextLine());
            precedenceMap.put(op, prec);
        }

        System.out.println("User-defined precedence table : ");
        System.out.println(precedenceMap);

        System.out.println("Enter the infix expression : ");
        String exp = sc.nextLine();

        // System.out.println(exp);
        StringBuilder output = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0;i<exp.length();i++){
            char c = exp.charAt(i);
            // System.out.println(c); 
            if (Character.isLetterOrDigit(c)){
                output.append(c);
            }
            else if (c=='('){
                stack.push(c);
            }
            else if (c==')'){
                while (!stack.isEmpty() && stack.peek()!='('){
                    output.append(stack.pop());
                }
                stack.pop();
            }
            else {
                while (!stack.isEmpty() && stack.peek()!='(' && precedence(c, precedenceMap)<=precedence(stack.peek(), precedenceMap)){
                    output.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()){
            output.append(stack.pop());
        }

        System.out.println("Infix   : " + exp);
        System.out.println("Postfix : " + output);

    }

    static int precedence(char op, HashMap<Character, Integer> precedenceMap){
        return precedenceMap.getOrDefault(op, -1);
    }
    
}