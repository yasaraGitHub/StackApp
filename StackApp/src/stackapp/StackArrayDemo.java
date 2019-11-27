/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackapp;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yasara
 */
class Main {

    public static void main(String args[]){

        StackArrayDemo s=new StackArrayDemo(8);
        try {
            s.decimalConvertToBinary(10);
        } catch (Exception ex) {
            System.out.println(ex);
            //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

public class StackArrayDemo {

    private int maxSize;
    private int stackArray[];
    private int top;

    public StackArrayDemo(int s) {

        this.maxSize = s;
        this.stackArray = new int[s];
        this.top = -1;

    }

    public boolean isEmpty() {
        return (this.top == -1);
    } //true if stack is empty

    public boolean isFull() {
        return (this.top == this.maxSize - 1);
    }

    public void push(int j) {

        if (isFull()) {
            System.out.println("Stack is already full, cannot push");
            return;
        }

        this.stackArray[++top] = j;

    }

    public int pop() throws Exception {

        if (isEmpty()) {
            throw new Exception("Stack is empty, cannot pop");
        }

        this.top--;
        return stackArray[top + 1];

    }

    public void decimalConvertToBinary(int decimal) throws Exception {

        int quotient = decimal;
        int remainder = 0;
        while (quotient!= 1) {

            System.out.println(quotient);
            
            remainder = quotient % 2;
            System.out.println(remainder);
            
            quotient = quotient / 2;
            System.out.println(quotient);
            
            System.out.println("");
            push(remainder);
            

        }
        System.out.println(quotient);
        System.out.println("");
        push(quotient);
        
        for (int i = top; i >= 0; i--) {
            System.out.print(pop());}
            System.out.println();
        
    }
}
