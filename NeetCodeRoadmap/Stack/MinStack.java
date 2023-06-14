package NeetCodeRoadmap.Stack;

import java.util.Stack;

class MinStack {

    Stack<Integer> mainStack;
    Stack<Integer> minStack;

    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    /**
     * Pushing both to mainStack and minStack
     * If new val is bigger than current minimum in stack, Push minimum value again. otherwise push new val to minStack.
     * @param val
     */
    public void push(int val) {
        mainStack.push(val);

        if(minStack.isEmpty()) minStack.push(val);
        else if(minStack.peek() < val) minStack.push(minStack.peek());
        else minStack.push(val);

    }

    public void pop() {
        mainStack.pop();
        minStack.pop();
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }


    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(5);
        obj.push(4);
        obj.push(3);
        obj.push(-2);
        obj.push(-3);
        obj.push(7);
        obj.push(9);
        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.getMin();
        System.out.println("Top -> " + param_3); //Expected 7
        System.out.println("Min -> " + param_4); //Expected -3
    }
}
