// task 1 : infix to postfix 

import java.util.Stack;
import java.util.Scanner;
public class infix_to_postfix {
    public static void main(String [] args ){

        Scanner sc = new Scanner (System.in);

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
            else if (c==')'){
                while (!stack.isEmpty() && stack.peek()!='('){
                    output.append(stack.pop());
                }
                stack.pop();//how ? what it is doing 
            }
            else if (c=='('){
                stack.push(c);
            }
            else {
                while (!stack.isEmpty() && stack.peek()!='(' && priority(c)<=priority(stack.peek())){
                    output.append(stack.pop());
                }
                stack.push(c);
            }
        }
        // System.out.println(output);
        while (!stack.isEmpty()){
            output.append(stack.pop());
        }

        System.out.println("Oriinal exp : "+exp);
        System.out.println("Postfix : "+output);


    }

      static int priority(char op){
        switch(op){
            case '+':
            case '-': return 1;
            case '*':
            case '/': return 2;
            case '^': return 3;
            default: return -1;
        }
    }

    
}

