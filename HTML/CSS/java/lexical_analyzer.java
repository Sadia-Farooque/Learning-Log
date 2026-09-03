package week_4_codes;

import java.util.*;
import java.util.regex.*;

public class task1 {

    static String datatypepattern = "\\b(int|float|double|char|boolean|String)\\b";
    static String identifierpattern = "\\b[a-zA-Z_][a-zA-Z0-9_]*\\b";
    static String romanpattern = "\\b(III|IV|II|I|XV|XX|X|V|L|C|D|M)\\b";
    static String operatorpattern = "\\+|\\-|\\*|\\/|\\%|\\=|\\<|\\>|\\!|\\&|\\||\\^";
    static String delimiterpattern = "\\(|\\)|\\{|\\}|\\[|\\]|\\;|\\,|\\.";

    public static void main(String[] args) {
        String input = "int x= XX;";

        List<String> tokens = tokenize(input);
        System.out.println("Tokens stream :  ");
        for (String token : tokens) {
            System.out.println(token);
        }
    }

    public static List<String> tokenize(String input) {

        List<String> tokens = new ArrayList<>();
        String regex = datatypepattern + "|" +
                romanpattern + "|" +
                identifierpattern + "|" +
                operatorpattern + "|" +
                delimiterpattern;

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String token = matcher.group();
            tokens.add(classifyToken(token));
        }
        return tokens;
    }

    public static String classifyToken(String token) {
        if (token.matches(datatypepattern))
            return "DATATYPE(" + token + ")";
        if (token.matches(romanpattern))
            return "ROMAN(" + token + ")";
        if (token.matches(identifierpattern))
            return "IDENTIFIER(" + token + ")";
        if (token.matches(operatorpattern))
            return "OPERATOR(" + token + ")";
        if (token.matches(delimiterpattern))
            return "DELIMITER(" + token + ")";
        return "UNKNOWN(" + token + ")";

    }

}
