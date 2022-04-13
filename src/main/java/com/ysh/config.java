package com.ysh;

public class config {


    public static void main(String[] args) {
        SynContainer container=new SynContainer();
        new productor(container).start();
        new coutorm(container).start();
    }
}

//生产者
class productor extends Thread{
    SynContainer container;

    public productor(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("第"+i+"鸡");
            container.push(new Chicken(i));
        }
    }
}
class coutorm extends Thread{
    SynContainer container;

    public coutorm(SynContainer container) {
        this.container = container;
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(container.pop().id+"------");
        }
    }

}
//产品
class Chicken{
    int id;
    public Chicken(int id){
        this.id=id;
    }
}

//缓冲区
class SynContainer{
    Chicken[] chickens=new Chicken[10];
    int count=0;
    public synchronized void push(Chicken chicken) {
        while (count == chickens.length) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        chickens[count] = chicken;
        count++;
        this.notifyAll();
    }

    public synchronized Chicken  pop() {
        while (count == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        Chicken chicken = chickens[count];
        this.notifyAll();
        return chicken;
    }
}