package com.spring.graphq.formulaBuilder;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class FormulaBuilderService {

    public static Map<String,String> map=new HashMap<>();
    public static Map<String, Double> dataMap=new LinkedHashMap<>();


    static {
        map.put("Field 1","field1");
        map.put("Field 2","field2");
        map.put("Field 3","field3");
        map.put("Field 4","field4");
        map.put("Field 5","field5");

        dataMap.put("field1",10.0);
        dataMap.put("field2",50.0);
        dataMap.put("field3",6.30);
        dataMap.put("field4",8.20);
        dataMap.put("field5",9.10);
    }

    public Double result(String str){
        List<String> replaceString =getAllFieldsForReplace(str);
        for(String s : replaceString){
            str=str.replace("<"+s+">",dataMap.get(map.get(s)).toString());
        }
        Double finalRes=caluculation(str);
        System.out.println();
        return finalRes;
    }


    public List<String> getAllFieldsForReplace(String str){
        List<String> fieldNames = new ArrayList<>();
        Pattern pattern = Pattern.compile("<([^>]+)>");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            fieldNames.add(matcher.group(1));
        }
        return fieldNames;
    }

    public Double caluculation(String expression){
        expression = expression.replaceAll("\\s+", "");
        return evaluateExpression(expression);
    }

    public static double evaluateExpression(String expression) {
        String[] tokens = expression.split("\\s+");
        Stack<Double> values = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (String token : tokens) {
            if (token.isEmpty()) {
                continue;
            } else if (token.equals("(")) {
                operators.push('(');
            } else if (token.equals(")")) {
                while (operators.peek() != '(') {
                    values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
                }
                operators.pop();
            } else if (isOperator(token.charAt(0))) {
                char op = token.charAt(0);
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(op)) {
                    values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
                }
                operators.push(op);
            } else {
                values.push(Double.parseDouble(token));
            }
        }

        while (!operators.isEmpty()) {
            values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
        }

        return values.pop();
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private static int precedence(char op) {
        if (op == '+' || op == '-') {
            return 1;
        } else if (op == '*' || op == '/') {
            return 2;
        } else {
            return 0;
        }
    }

    private static double applyOperator(char op, double b, double a) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) throw new ArithmeticException("Division by zero");
                return a / b;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }


}
