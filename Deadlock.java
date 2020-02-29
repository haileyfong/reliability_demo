public class DeadLock {
    static class Fork {
    }

    static class Philosopher extends Thread {

        final Fork left;
        final Fork right;

        public Philosopher(Fork left, Fork right) {
            this.left = left;
            this.right = right;
            //start();
        }

        @Override
        public void run() {
            // think!
            synchronized (left) {
                synchronized (right) {
                    // eat!
                }
            }
        }
    }


    public static void main(String[] args) {
        Fork myLock = new Fork();
        Fork yourLock = new Fork();
        Philosopher me = new Philosopher(myLock, yourLock);
        Philosopher you = new Philosopher(yourLock, myLock);
        me.start();
        you.start();
        //Verify.endAtomic();
    }
}
