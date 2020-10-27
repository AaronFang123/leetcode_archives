package leetcode.editor.cn.base;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode(int x ,TreeNode left, TreeNode right){
        val = x;
        this.left = left;
        this.right = right;
    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        // 创建队列
        Queue<TreeNode> queue = new LinkedList<>();
        // 根结点入队
        queue.offer(root);
        // 当队列非空时循环
        while(!queue.isEmpty()){
            // 创建本节点list
            List<Integer> thisLevel = new ArrayList<>();
            // 读队列长度
            int size = queue.size();
            for(int i = 0; i < size; ++i){
                TreeNode node = queue.poll();
                thisLevel.add(node.val);
                if (node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
            }
            result.add(thisLevel);
        }
        return result;
    }
}
