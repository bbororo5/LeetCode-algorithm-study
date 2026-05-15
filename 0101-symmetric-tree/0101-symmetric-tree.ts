/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     val: number
 *     left: TreeNode | null
 *     right: TreeNode | null
 *     constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.left = (left===undefined ? null : left)
 *         this.right = (right===undefined ? null : right)
 *     }
 * }
 */

function isSymmetric(root: TreeNode | null): boolean {
    const deque: (TreeNode | null)[] = [root.left, root.right];

    while (deque.length > 0)  {
        const t1 = deque.shift();
        const t2 = deque.shift();

        if (!t1 && !t2) continue;
        if (!t1 || !t2 || t1.val !== t2.val) return false;

        deque.push(t1.left);
        deque.push(t2.right);
        
        deque.push(t1.right);
        deque.push(t2.left);

    }
        
    return true;
};