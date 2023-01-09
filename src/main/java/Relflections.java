
import java.lang.reflect.*;

public class Relflections {

    public static void main(String[] args) throws Exception {
        TestReflectionClass t1 = new TestReflectionClass(1, "daniel", 545896578);
        TestReflectionClass t2 = new TestReflectionClass(-1, "dan", 65);
        try {
            //printDeclares(t1);
            // printMethods(t1);
            // printMethod(t1);
            //isEquals(t1, t2);
            int i = 0;
            long srart = System.currentTimeMillis();
            while(i<10000){
            fill(t1, t2);
            i++;
            }
        System.out.println((System.currentTimeMillis() - srart) / 1000.0);
           // System.out.println(t2);
        } catch (SecurityException e) {
            System.err.println(e);
        }

    }

    public static void fill(Object src, Object dest) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field[] fieldsSrc = src.getClass().getDeclaredFields();
        Field[] fieldsDest = dest.getClass().getDeclaredFields();
        for (int i = 0; i < fieldsSrc.length; i++) {
            if (fieldsSrc[i].getName().equals(fieldsDest[i].getName())) {
                fieldsSrc[i].setAccessible(true);
                fieldsDest[i].setAccessible(true);
                fieldsDest[i].set(dest, fieldsSrc[i].get(src));
            }
        }
    }

    public static boolean isEquals(Object src, Object dest) throws IllegalArgumentException, IllegalAccessException {
        Field[] fieldsSrc = src.getClass().getDeclaredFields();
        Field[] fieldsDest = dest.getClass().getDeclaredFields();
        for (int i = 0; i < fieldsSrc.length; i++) {
            if (fieldsSrc[i].getName().equals(fieldsDest[i].getName())) {
                fieldsSrc[i].setAccessible(true);
                fieldsDest[i].setAccessible(true);
                if (fieldsSrc[i].get(src) != fieldsDest[i].get(dest)) {
                    return false;
                } else {
                    System.out.println("Equal " + fieldsSrc[i].getName() + " To " + fieldsDest[i].getName());
                }
            }
        }
        return true;
    }

    public static void printDeclares(Object object) {
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            System.out.println("Name properties : " + field.getName());
        }
    }

    public static void printMethods(Object object) {
        Method methods[] = object.getClass().getDeclaredMethods();
        for (Method m : methods) {
            // get names of methods
            System.out.println("Method Name: " + m.getName());
            // get the access modifier of methods
            int modifier = m.getModifiers();
            System.out.println("Modifier: " + Modifier.toString(modifier));
            // get the return types of method
            System.out.println("Return Types: " + m.getReturnType());
            System.out.println(" ");
        }
    }

    public static void printMethod(Object object) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method methods[] = object.getClass().getDeclaredMethods();
        for (Method m : methods) {
            System.out.println(m.getName());
            if (m.getName().equals("printHi")) {
                m.setAccessible(true);
                m.invoke(object);
            }
        }

    }
}


/*Class c = triangle1.getClass();
            // access and set the type fieldfield1.setAccessible(true);
            Field field = c.getField("name");
            Field field1 = c.getDeclaredField("sideA");
            Field field2 = c.getDeclaredField("sideB");
            Field field3 = c.getDeclaredField("sideC");
            field1.setAccessible(true);
            field2.setAccessible(true);
            field3.setAccessible(true);
            field.set(triangle2, triangle1.name);
            field1.set(triangle2, triangle1.getSideA());
            field2.set(triangle2, triangle1.getSideB());
            field3.set(triangle2, triangle1.getSideC());
            // get the value of the field type
            double typeValue1 = (double) field1.get(triangle2);
            System.out.println("Value: " + typeValue1);
            double typeValue2 = (double) field2.get(triangle2);
            System.out.println("Value: " + typeValue2);
            double typeValue3 = (double) field3.get(triangle2);
            System.out.println("Value: " + typeValue3);
            System.out.println("After: " + triangle2.toString());
 */
