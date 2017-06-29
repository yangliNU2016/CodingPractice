/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *  push(x) --- Push element x onto stack
 *  pop() --- Remove the element on top of the stack
 *  top() --- Get the top element
 *  getMin() --- Retrieve the minimum element in the stack
 * Example:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin(); --> Return -3
 * minStack.pop();
 * minStack.top(); ---> Return 0
 * minStack.getMin(); ---> Return -2
 **/
 public class MinStack {
    private int minPtr = 0;
    private ArrayList<Integer> al;
    
    /** initialize your data structure here. */
    public MinStack() {
        al = new ArrayList<Integer>();
    }
    
    public void push(int x) {
        al.add(x);
        findIdxMin();
    }
    
    public void pop() {
        if (al.size() != 0) {
            al.remove(al.size() - 1);
            findIdxMin();
        }
    }
    
    public int top() {
        if (al.size() == 0) return -1;
        return al.get(al.size() - 1);
    }
    
    public int getMin() {
        if (al.size() == 0) return -1;
        return al.get(minPtr);
    }
    
    public void findIdxMin() {
        minPtr = 0;
        for (int i = 1; i < al.size(); i++) {
            if (al.get(i) < al.get(minPtr)) minPtr = i;
        }
    }
}
