class MessageNotifier extends Thread {

    // write fields to store variables here
     String str = "Hello, Mary";
    int n = 0;
    public MessageNotifier(String msg, int repeats) {
        str = msg;
        n = repeats;
    }

    @Override
    public void run() {
       for(int i=0;i<n;i++){
           System.out.println(str);
       }
    }
}