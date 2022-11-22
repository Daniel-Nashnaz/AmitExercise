
public class TestReflectionClass {

    private int id;
    private String name;
    private int phone;

    public TestReflectionClass(int id, String name, int phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public TestReflectionClass() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Test{" + "id=" + id + ", name=" + name + ", phone=" + phone + '}';
    }
    public void printHi(){
        System.out.println("Hi welcome to Reflection");
    }

}
