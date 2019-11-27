/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackapp;

/**
 *
 * @author 174134K
 */
public class StackApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        StackArray s = new StackArray(6);
        s.push(7);
        s.push(8);
        s.push(3);
        s.push(5);
        s.push(-1);
        s.dispalyStack();//this function works from top to bottom
        try {
            s.pop();//handle exception here...otherwisw clash in the program...
            s.dispalyStack();
            s.pop();
            s.dispalyStack();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}

class StackArray {

    private int maxSize;
    private int[] stackData;
    private int top;

    public StackArray(int s) {

        //s means the maximum size of the array
        this.stackData = new int[s];
        this.maxSize = s;
        this.top = -1;

    } //constructor 

    public boolean isEmpty() {
        return (this.top == -1);
    } //true if stack is empty

    public boolean isFull() {
        return (this.top == this.maxSize - 1);
    }

    public void push(int j) {

        if (isFull()) {
            System.out.println("Stack is already full, cannot push");
            return;//instead of return statement here, we can write remaining part of the code inside the else block...
        }

        this.stackData[++top] = j;//first increment the current top by one and put the user input to that top loacation...
        //top++;

    } //put item on top of the stack

    public int pop() throws Exception {//plural exception..."throws"

        if (isEmpty()) {
            throw new Exception("Stack is empty, cannot pop");//this is a custom exception: name of the exception=>Stack is empty, cannot pop
            //System.out.println("No item in the stack to remove");
            // return -1;//item cannot be returned as this retunrning value can eve be an element in the stack, therefore manually own exception, thereby handle it, in that case either throw it or handle it in a try catch block
        }

        this.top--;
        return stackData[top + 1];//here pre decrement of top is not matching with the requirement...instead  return stackData[top--] in one line;

    } //take item from top of the stack

    public int peek() throws Exception {

        if (isEmpty()) {
            throw new Exception("Stack is empty, cannot get the peek");

        }

        return stackData[top];

    } //peek at top of the stack

    public void dispalyStack() {//normally there is no display function for the stack

        if (isEmpty()) {
            System.out.println("Stack is empty, nothing to print");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.print(stackData[i] + " ");
        }
        System.out.println();

    }

}
