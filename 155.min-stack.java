/*
 * @lc app=leetcode id=155 lang=java
 *
 * [155] Min Stack
 *
 * https://leetcode.com/problems/min-stack/description/
 *
 * algorithms
 * Easy (44.07%)
 * Likes:    3414
 * Dislikes: 334
 * Total Accepted:    556.7K
 * Total Submissions: 1.3M
 * Testcase Example:  '["MinStack","push","push","push","getMin","pop","top","getMin"]\n' +
  '[[],[-2],[0],[-3],[],[],[],[]]'
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 * 
 * 
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * 
 * Output
 * [null,null,null,null,-3,null,0,-2]
 * 
 * Explanation
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin(); // return -3
 * minStack.pop();
 * minStack.top();    // return 0
 * minStack.getMin(); // return -2
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * Methods pop, top and getMin operations will always be called on non-empty
 * stacks.
 * 
 * 
 */

// @lc code=start
class MinStack {

    int[] stack;
    int t;
    int min;

    /** initialize your data structure here. */
    public MinStack() {
        this.stack = new int[10000];
        t = 0;
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        this.stack[this.t] = x;
        this.min = x < this.min ? x : this.min;
        this.t++;
    }

    public void pop() {
        if (t == 0)
            return;
        this.t--;
        if (this.stack[this.t] == min) {
            min = Integer.MAX_VALUE;
            for (int i = 0; i < this.t; i++) {
                min = this.stack[i] < min ? this.stack[i] : min;
            }
        }
        this.stack[this.t] = 0;
    }

    public int top() {
        if (t == 0)
            return 0;
        return this.stack[this.t - 1];
    }

    public int getMin() {
        return this.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4
 * = obj.getMin();
 */
// @lc code=end
