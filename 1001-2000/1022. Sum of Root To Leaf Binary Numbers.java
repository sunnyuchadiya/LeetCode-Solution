class Solution {
    int ans=0;
    public int sumRootToLeaf(TreeNode root) {
        dfs(root,0);
        return ans;
        
    }
    public void dfs(TreeNode rt, int val){
        if (rt==null){
            return;
        }
        val = val * 2 + rt.val;

        if (rt.left==null && rt.right==null){
            ans+=val;

        }
        dfs(rt.left,val);
        dfs(rt.right,val);
    }
 
}