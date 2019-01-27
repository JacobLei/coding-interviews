package chap2;

import java.util.LinkedList;

/**
 * 两个栈实现一个队列
 */
public class TwoStackImpQueue {

    private LinkedList<Integer> input = new LinkedList<>();
    private LinkedList<Integer> output = new LinkedList<>();

    /**
     * 入队列
     */
    public void enqueue(int node){
        input.push(node);
    }

    /**
     * 出队列
     */
    public int dequeue(){
        if(input.isEmpty() && output.isEmpty()){
            throw new RuntimeException("队列为空");
        }

        if(output.isEmpty()){
            while (!input.isEmpty()){
                output.push(input.pop());
            }
        }

        return output.pop();
    }

}
