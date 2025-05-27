public  class testthread {
    public static void main(String[] args) {
        int n = 5;
        for (int i=0;i<n;i++) {
            Thread o = new Thread(new multithread01());
//            multithread01 o = new multithread01();
            o.start();
        }
    }
}
