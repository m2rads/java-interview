package bby.data.structures;

public class Tree<T> {

    public void breadthFirstTraversal(TreeNode<T> root) {
        Queue<TreeNode<T>> queue = new Queue<>();
        queue.enqueue(root);

        while (queue.size > 0) {
            TreeNode<T> current = queue.dequeue();
            System.out.println(current.data);
            if (current.left != null) {
                queue.enqueue(current.left);
            }
            if (current.right != null) {
                queue.enqueue(current.right);
            }
        }
    }

    public void depthFirstTraversal(TreeNode<T> root ) {
        Stack<TreeNode<T>> stack = new Stack<>();
        stack.push(root);

        while (stack.size > 0) {
            TreeNode<T> current = stack.pop();
            System.out.println(current.data);
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
    }

    // Root -> Right -> Left
    public void preOrderTraversal(TreeNode<T> root) {
         if (root == null) {
             return;
         }
         System.out.println(root.data);
         preOrderTraversal(root.right);
         preOrderTraversal(root.left);
    }

    // Right -> Left -> Root
    public void postOrderTraversal(TreeNode<T> root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.right);
        postOrderTraversal(root.left);
        System.out.println(root.data);
    }

    // Right -> Root -> Left
    public void inOrderTraversal(TreeNode<T> root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.right);
        System.out.println(root.data);
        inOrderTraversal(root.left);
    }

}


















