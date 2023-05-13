class NumbersThread extends Thread {

    int s ;
    int e;
    public NumbersThread(int from, int to) {
        this.s = from;
        this.e = to;
    }
    
    public void run(){
        for(int i=s;i<=e;i++){
            System.out.println(i);
        }
    }
}