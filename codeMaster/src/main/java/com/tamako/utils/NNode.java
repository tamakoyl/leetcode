package com.tamako.utils;

import java.util.List;

/**
 * @Author:Tamako
 * @Date:2023/12/23 13:09
 * @Description:N叉树的结点
 */
public class NNode {
    public int val;
    public List<NNode> children;

    public NNode() {}

    public NNode(int _val) {
        val = _val;
    }

    public NNode(int _val, List<NNode> _children) {
        val = _val;
        children = _children;
    }
}
