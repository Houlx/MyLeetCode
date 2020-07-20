import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 *
 * https://leetcode.com/problems/lru-cache/description/
 *
 * algorithms
 * Medium (32.63%)
 * Likes:    5964
 * Dislikes: 261
 * Total Accepted:    562.9K
 * Total Submissions: 1.7M
 * Testcase Example:  '["LRUCache","put","put","get","put","get","put","get","get","get"]\n' +
  '[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]'
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and put.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present.
 * When the cache reached its capacity, it should invalidate the least recently
 * used item before inserting a new item.
 * 
 * The cache is initialized with a positive capacity.
 * 
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * 
 * Example:
 * 
 * 
//  * LRUCache cache = new LRUCache( 2 /* capacity */
//  * 
//  * cache.put(1, 1);
//  * cache.put(2, 2);
//  * cache.get(1);       // returns 1
//  * cache.put(3, 3);    // evicts key 2
//  * cache.get(2);       // returns -1 (not found)
//  * cache.put(4, 4);    // evicts key 1
//  * cache.get(1);       // returns -1 (not found)
//  * cache.get(3);       // returns 3
//  * cache.get(4);       // returns 4
//  * 
//  * 
//  * 
//  * 
//  */

// @lc code=start
class LRUCache {

    class Node {
        int key, val;
        Node next;
        Node pre;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public void insert(Node node) {
        node.next = fakeHead.next;
        node.pre = fakeHead;
        fakeHead.next = node;
        node.next.pre = node;
    }

    public void remove(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    Node fakeHead = new Node(0, 0);
    Node fakeTail = new Node(0, 0);
    Map<Integer, Node> cache = new HashMap<>();
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        fakeHead.next = fakeTail;
        fakeTail.pre = fakeHead;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            insert(node);
            return node.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node old = cache.get(key);
            Node newNode = new Node(key, value);
            cache.remove(key);
            cache.put(key, newNode);
            remove(old);
            insert(newNode);
            return;
        }
        if (cache.size() == this.capacity) {
            Node leastUsed = this.fakeTail.pre;
            cache.remove(leastUsed.key);
            remove(leastUsed);
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            insert(newNode);
        } else {
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            insert(newNode);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */
// @lc code=end
