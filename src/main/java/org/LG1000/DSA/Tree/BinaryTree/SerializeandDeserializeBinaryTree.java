package org.LG1000.DSA.Tree.BinaryTree;
import org.LG1000.DSA.Tree.TreeNode;
import java.util.*;

//297. Serialize and Deserialize Binary Tree
//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
public class SerializeandDeserializeBinaryTree {
    public String serialize(TreeNode root) {
        if(root==null) return "";
        StringBuilder sb=new StringBuilder();
        Queue<TreeNode> q=new LinkedList<>();
        sb.append(String.valueOf(root.val));
        sb.append("#");
        q.add(root);
        while(!q.isEmpty()){
            int t=q.size();
            while(t-- >0){
                TreeNode p=q.poll();
                if(p.left!=null){
                    q.add(p.left);
                    sb.append(String.valueOf(p.left.val));
                    sb.append(",");
                }
                else{
                    sb.append("a");
                    sb.append(",");
                }
                if(p.right!=null){
                    q.add(p.right);
                    sb.append(String.valueOf(p.right.val));
                    sb.append(",");
                }
                else{
                    sb.append("a");
                    sb.append(",");
                }
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("#");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0) return null;
        String[] arr=data.split("#");
        Queue<TreeNode> q=new LinkedList<>();
        TreeNode root=new TreeNode(Integer.parseInt(arr[0]));
        q.add(root);
        int lvl=1;
        while(!q.isEmpty()){
            if(lvl==arr.length) break;
            String[] s=arr[lvl].split(",");
            int t=q.size();
            int i=0;
            while(t-- >0){
                TreeNode p=q.poll();
                if(p==null){
                    continue;
                }
                if(!s[i].equals("a")){
                    TreeNode left=new TreeNode(Integer.parseInt(s[i]));
                    p.left=left;
                    q.add(left);
                }
                else{
                    q.add(null);
                }
                i++;
                if(!s[i].equals("a")){
                    TreeNode right=new TreeNode(Integer.parseInt(s[i]));
                    p.right=right;
                    q.add(right);
                }
                else{
                    q.add(null);
                }
                i++;
            }
            lvl++;
        }


        return root;
    }
}
