package test.test.list_test;

import java.util.LinkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        stackImplByLinkedList();
        queueImplByLinkedList();
    }

    // 使用linkedList实现栈
    public static void stackImplByLinkedList(){
        // 我们要明白，栈是先进后出 后进先出
        // 使用linkedList的原因是 该数据结构底层为双向列表 对于头和尾的增加删除操作是极快的 为了实现模拟栈，所以使用first的方法，模拟栈中的栈顶
        LinkedList<String> stack = new LinkedList<>();
        stack.addFirst("1");
        stack.addFirst("2");
        stack.addFirst("3");
        stack.addFirst("4");
        System.out.println(stack);
        stack.removeFirst();
        stack.removeFirst();
        System.out.println(stack);
        stack.removeFirst();
        stack.removeFirst();
        System.out.println(stack);
    }
    // 使用linkedList实现队列
    public static void queueImplByLinkedList(){
        // 这里的入队我们要这么理解，平时我们排队时入队都是排到最后边入队，所以使用last方法进行入队，离开时最前边的离开，所以使用first方法离开
        LinkedList<String> queue = new LinkedList<>();
        queue.addLast("1");
        queue.addLast("2");
        queue.addLast("3");
        queue.addLast("4");
        System.out.println(queue);

        queue.removeFirst();
        queue.removeFirst();
        System.out.println(queue);
        queue.removeFirst();
        queue.removeFirst();
        System.out.println(queue);
    }
}
