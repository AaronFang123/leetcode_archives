//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。 
//
// 
// push(x) —— 将元素 x 推入栈中。 
// pop() —— 删除栈顶的元素。 
// top() —— 获取栈顶元素。 
// getMin() —— 检索栈中的最小元素。 
// 
//
// 
//
// 示例: 
//
// 输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// pop、top 和 getMin 操作总是在 非空栈 上调用。 
// 
// Related Topics 栈 设计 
// 👍 691 👎 0


package leetcode.editor.cn;

//最小栈
//提交时间 2020-10-13 16:41:51
class P155_MinStack{
	 public static void main(String[] args) {
	 	 //测试代码
         MinStack solution = new P155_MinStack().new MinStack();
         solution.push(-2);
         solution.push(0);
         solution.push(-3);
         System.out.println(solution.getMin());
         solution.pop();
         solution.push(0);

         System.out.println(solution.getMin());
     }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class MinStack {
    int[] stack ;
    int currTop;
    int min;
    int min_before;
    int min_index;
    int min_before_index;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new int[1000];
        currTop = 0;
        min = 0;
        min_index = 0;
        min_before = 0;
        min_before_index = 0;
    }

    public void push(int x) {
        if(currTop == 0) min = x;
        stack[currTop] = x;
        if(min > x){
            min_before = min;
            min = x;
            min_before_index = min_index;
            min_index = currTop;
        }
        currTop++;
    }

    public void pop() {
        if(stack[currTop - 1] == min && currTop - 1== min_index) {
            min = min_before;
            min_index = min_before_index;
        }
        stack[currTop] = 0;
        if(currTop > 0) currTop--;
    }

    public int top() {
        return stack[currTop - 1];
    }

    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

}