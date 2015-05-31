/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode dummyHead = new RandomListNode(0);
        RandomListNode p = dummyHead;
        RandomListNode q = head;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        while(q != null) {
            p.next = new RandomListNode(q.label);
            map.put(q, p.next);
            q = q.next;
            p = p.next;
        }
        p = dummyHead.next;
        q = head;
        while(q != null) {
            p.random = map.get(q.random);
            p = p.next;
            q = q.next;
        }
        return dummyHead.next;
    }
}
