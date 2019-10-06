package LeetCode.Common.Easy;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode
 * Problem : https://leetcode.com/problems/maximum-depth-of-n-ary-tree
 **/
public class MaximumDepthOfNaryTree {

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public int maxDepth(Node root) {
        if (root == null) return 0;

        Queue<DecoratedNode> queue = new LinkedList<>();
        queue.add(new DecoratedNode(1, root));
        int maxLevel = 0;

        while (!queue.isEmpty()) {
            DecoratedNode decoratedNode = queue.poll();
            maxLevel = Math.max(maxLevel, decoratedNode.level);

            for (Node n : decoratedNode.node.children)
                queue.add(new DecoratedNode(decoratedNode.level + 1, n));
        }

        return maxLevel;
    }

    static class DecoratedNode {
        public int level;
        public Node node;

        public DecoratedNode(int level, Node node) {
            this.level = level;
            this.node = node;
        }
    }
}
