import java.util.ArrayList;

/**
 *
 * @author nanwang
 *
 */
public class Something {

	private static final int VALUE1 = 36;
	private static final int VALUE2 = 15;

	private static int method1(int n1, int n2) {
		if (n1 >= n2) {
			while (n1 >= n2) {
				n1 -= n2;
			}

			return n1;
		} else {
			while (n2 >= n1) {
				n2 -= n1;
			}

			return n2;
		}
	}

	private static int method2(int n1, int n2) {
		while (n1 != n2) {
			if (n1 > n2)
				n1 -= n2;
			else
				n2 -= n1;
		}
		return n2;
	}

	private static int method3(int n1, int n2) {
		return n1 * n2 / method2(n1, n2);
	}

	public static int someMethod(int n1, int n2, int n3, int n4) {
		int sum = 0;
		if (method2(n1, n2) == VALUE1) {
			if (method3(n1, n3) == method3(n2, n4)) {
				sum += n1 + n4;
			}
			sum += n1 + n2;
		}

		if (method1(n3, n4) == VALUE2) {
			sum += n3 + n4;
		}

		return sum;
	}
//
//	public static void main(String[] args) {
//		ArrayList<int[]> m1List = new ArrayList<>();
//		for (int i = 1; i <= 100; i++){
//			for (int j = 1; j <= 100; j++){
//				if (method1(i,j)==15){
//					int[] ints = new int[2];
//					ints[0] = i;
//					ints[1] = j;
//					m1List.add(ints);
//					System.out.println(i+" "+j);
//				}
//			}
//		}
//
//		System.out.println("-------------------------");
//		ArrayList<int[]> m2List = new ArrayList<>();
//		for (int i = 1; i <= 100; i++){
//			for (int j = 1; j <= 100; j++){
//				if (method2(i,j)==36){
//					int[] ints = new int[2];
//					ints[0] = i;
//					ints[1] = j;
//					m2List.add(ints);
//					System.out.println(i+" "+j);
//				}
//			}
//		}
//
//		System.out.println("-------------------------");
//		for (int[] n1n2:m2List){
//			for (int[] n3n4:m1List){
//				int n1 = n1n2[0];
//				int n2 = n1n2[1];
//				int n3 = n3n4[0];
//				int n4 = n3n4[1];
//				if (method3(n1,n3)==method3(n2,n4)){
//					System.out.println(n1+" "+n2+" "+n3+" "+n4);
//				}
//			}
//		}
//
//		System.out.println();
//		System.out.println(someMethod(36,36,30,45));
//
//		System.out.println();
//		System.out.println(method2(36,72));
//		System.out.println(method1(100,85));
//		System.out.println(method3(36,100));
//		System.out.println(method3(72,85));
//		System.out.println(someMethod(36,72,100,85));
//	}
}
