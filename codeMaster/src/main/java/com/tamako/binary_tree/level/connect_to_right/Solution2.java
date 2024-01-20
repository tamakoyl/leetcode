package com.tamako.binary_tree.level.connect_to_right;

import com.tamako.utils.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author:Tamako
 * @Date:2023/12/29 10:40
 * @Description:117. 填充每个节点的下一个右侧节点指针 II
 */
public class Solution2 {
    //逻辑是一样的
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if(root!=null)queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Node front = queue.poll();
                //将每层的最后一个节点的next置为null
                if(i == size - 1){
                    front.next = null;
                }else{
                    front.next = queue.peek();
                }
                if(front.left!=null)queue.offer(front.left);
                if(front.right!=null)queue.offer(front.right);
            }
        }
        return root;
    }
}
