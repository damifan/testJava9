package com.damifan.test;

import java.util.Stack;

/**
 * TODO
 *
 * @Author : WangLei
 * @Date : 2019/5/7
 * 实现一个最小栈，一步一步优化，从额外空间O(N) 到O(1) 。面试官看重代码逻辑。push,pop,top,getMin都是O(1)时间。
 */
public class stack {

    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minValue = new Stack<Integer>();

    public void push(Integer i) {
        stack.push(i);
        if (minValue.isEmpty() || minValue.peek() <= i) {
            minValue.push(i);
        }
    }

    public void pop() {
        int value = stack.pop();
        if (value == minValue.pop()) {
            minValue.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minValue.peek();
    }

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<Integer>();
        Stack<Integer> minValue = new Stack<Integer>();

        stack.push(131);
        stack.push(1111);

        System.out.println(stack.peek());
        System.out.println(stack.pop());
//        stack.forEach(st->{
//            System.out.println(st);
//        });
    }
}
