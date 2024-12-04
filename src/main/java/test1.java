import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int[] a = new int[n];
        String s = scan.nextLine();
        String[] parts = s.split(" ");
        for (int i = 0; i < parts.length; i++) {
            try {
                int num = Integer.parseInt(parts[i]);
                a[i] = num;
            } catch (NumberFormatException e) {
                // 若不能转换为整数，忽略（可根据需求做更详细处理）
            }
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (!dx(a[j],a[j+1])) {
//                if (getmax(a[j]) > getmax(a[j + 1])) {
//                if (a[j] < a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        for (int i : a) {
            System.out.print(i);
        }
        scan.close();
    }
    public static boolean dx(int a,int b){
        if (getmax(a) > getmax(b)){
            return true;
        }else if (getmax(a) == getmax(b)){
            return dx(getmax2(a),getmax2(b));
        }else {
            return false;
        }
    }
    public static int getmax2(int a){
        if (a>10 && a<100){
            getmax(a/10);
        }
        return a;
    }

    public static int getmax(int a){
        if (a>10){
            getmax(a/10);
        }
        return a;
    }
}

