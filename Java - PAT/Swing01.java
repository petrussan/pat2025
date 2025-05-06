
class Swing01 {
    public static void main(String[] args) {
        Api02 test = new Api02();
        try {
            test.getREST();            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}