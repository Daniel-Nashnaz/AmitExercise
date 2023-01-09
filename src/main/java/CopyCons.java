
public class CopyCons {

    public static void main(String[] args) {
        TestReflectionClass test1 = new TestReflectionClass(1, "daniel", 6104377);
        TestReflectionClass test2 = new TestReflectionClass();
        int i = 0;
        long srart = System.currentTimeMillis();
        while (i < 10000) {
            test2.setId(test1.getId());
            test2.setName(test1.getName());
            test2.setPhone(test1.getPhone());
            i++;
        }
        System.out.println((System.currentTimeMillis() - srart) / 1000.0);
    }

}
