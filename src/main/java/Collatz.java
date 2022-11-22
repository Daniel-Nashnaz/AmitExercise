//התוכנית מתחילה עם קראיה לפונקצית הדפסה שמקבלת סכום של מערך מהפונקציה של סאריה
public class Collatz {

    public static int oneStep(int num) {
        //בודק את התנאים של קולץ
        if (num == 1) {
            return 1;
        }
        if (num % 2 == 0) {
            num = num / 2;
        } else {
            num = (num* 3) + 1;
        }
        //מחזיר את הערך 
        return num;
    }

    public static int[] calcSeria(int n) {
        //הפונקציה מקבלת ערך שהגדרנו מראש
        int[] arr = new int[100];

        for (int i = 0; i < arr.length; i++) {
        //בודק את הערך שקיבלנו מהפונקציה למעלה
            if (oneStep(n) >= 1) {
                arr[i] = oneStep(n);
            }
            //לשמור על הערך ולשלוח מחדש לפונקציה למעלה בהמשך
            n = oneStep(n);
            if (n == 1) {
                break;
            }
        }
        //מחזיר לנו את המערך 
        return arr;

    }
    //הפונקציה הנל מקבלת את המערך של הפונקציה השנייה ומדפיסה אותו 
    public static void Printarray(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                System.out.println(arr[i]);
            }
        }

    }
    public static void main(String[] args) {
        
        
        Printarray(calcSeria(11));
        
        
    }
 
}
