package lab6.generics;

import tasks.Task;

public class StackTester implements Task {

    @Override
    public void run() {
        final int TO = 10;
        Stack<Integer> stack = new Stack<>();
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        for (int i = 0; i < TO; ++i) {
            stack.push(i);
            arrayStack.push(i);
        }
        for (int i = 0; i < TO; ++i) {
            System.out.println(stack.top() + " <-> " + arrayStack.top());
            stack.pop();
            arrayStack.pop();
        }
        System.out.println(stack.isEmpty() + " <-> " + arrayStack.isEmpty());
    }
}