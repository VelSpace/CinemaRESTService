class Starter {

    public static void startRunnables(Runnable[] runnables) {
       for(Runnable r : runnables){
           Thread t = new Thread(r);
           t.start();
       }
    }
}