package org.LG1000.DSA.LinkedList;

import java.util.HashMap;

//138. Copy List with Random Pointer
//https://leetcode.com/problems/copy-list-with-random-pointer/description/
public class CopyListwithRandomPointer {

    //Approach1
    class Approach1{

        public Node copyRandomList(Node head) {
            HashMap<Node,Node> map=new HashMap<>();
            Node dummy=new Node(-1);
            Node p=dummy;

            while(head!=null){
                int val=head.val;
                if(!map.containsKey(head)){
                    map.put(head,new Node(val));
                }
                p.next=map.get(head);
                p=p.next;
                Node random=head.random;
                if(random!=null){
                    val=random.val;
                    if(!map.containsKey(random)){
                        map.put(random,new Node(val));
                    }
                    p.random=map.get(random);
                }

                head=head.next;
            }


            return dummy.next;
        }

    }

    //Approach2
    class Approach2{
        public Node copyRandomList(Node head) {
            Node p=head;
            Node deepCopy=null;
            Node d=deepCopy;
            HashMap<Node,Node> map=new HashMap<>();
            while(head!=null){
                Node newNode=new Node(head.val);
                if(deepCopy==null){
                    deepCopy=newNode;
                    d=deepCopy;
                }
                else{
                    deepCopy.next=newNode;
                    deepCopy=deepCopy.next;
                }
                map.put(head,deepCopy);
                head=head.next;

            }
            Node res=d;
            while(p!=null){
                if(p.random!=null){
                    d.random=map.get(p.random);
                }
                p=p.next;
                d=d.next;
            }
            return res;
        }
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }


}


