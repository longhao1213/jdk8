package com.jdk;


/**
 * Copyright (C), 2006-2010, ChengDu ybya info. Co., Ltd.
 * FileName: MyHashMap.java
 *
 * @author lh
 * @version 1.0.0
 * @Date 2020/05/18 14:44
 */
public class MyHashMap<K,V> {
    // 默认长度
    private final static int DEFAULT_SIZE = 1 << 4;
    // hashMap存放数据的数组
    private Entry<K,V>[] data;
    // 表示现在的hashmap中存放了多少个数
    private int size = 0;
    // 初始化的空间
    private int cap;


    public MyHashMap() {
        this(DEFAULT_SIZE);
    }

    /**
     * 表示初始化HashMap的空间，记得用2的整数次幂
     * @param cap
     */
    public MyHashMap(int cap) {
        if (cap > 0) {
            data = new Entry[cap];
            size = 0;
            this.cap = cap;
        }
    }

    private int hash(K key){
        int h = 0;
//        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
        if (key == null) {
            h = 0;
        } else {
            h = key.hashCode() ^ (h >>> 16);
        }
        return  h % cap;
    }

    /**
     * 数据结构
     * @param <K>
     * @param <V>
     */
    private class Entry<K,V>{
        K key;
        V value;
        Entry<K,V> next;
        // 表示个数
        int cap;
        public Entry(K key,V value,Entry<K,V> next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public void put(K key, V value) {
        // key和value都可以为null
        // 计算hash
        int hash = hash(key);
        // 创建一个新的
        Entry<K, V> newEntry = new Entry<>(key, value, null);
        // hash值就是数据的下标，现在用hash值在数组获取对应的数据
        Entry<K, V> hashM = data[hash];
        /**
         * 如果链表的长度大于8，那么就要转换成红黑树
         */
        // 如果这个hashM有值，那么循环去找到对应的值
        while (hashM != null) {
            // 判断这个key是否已经存过值了，如果存过，就直接覆盖
            if (hashM.key.equals(key)) {
                hashM.value = value;
                return;
            }
            // 如果没有存过,那么就遍历这个链表，循环查找这个key是否存在，如果都没有，那么最后一个next一定为null，就会跳出循环
            hashM = hashM.next;
        }
        // 如果hashM没有值，那么就是一个新的插入
//        newEntry.next = null;
        // 直接把这个新的entry插入到这个位置
        data[hash] = newEntry;
        // 总长度加一
        size++;
        /**
         * 如果size>= 负载因子*空间数， 就需要扩容
         * resize
         */
    }

    public V get(K key) {
        int hash = hash(key);
        Entry<K,V> entry = data[hash];
        while (entry != null) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
            entry = entry.next;
        }
        // 数组没有对应的hash下标
        return null;
    }

    public static void main(String[] args){
        MyHashMap<String, String> map = new MyHashMap<>();
        map.put("1", "a");
        map.put("2", "b");
        map.put("1", "aa");
        System.out.println(map.get("1"));
        System.out.println(map.get("2"));
        System.out.println(map.get("3"));
    }

}