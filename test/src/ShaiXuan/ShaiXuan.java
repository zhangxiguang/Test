package ShaiXuan;

import java.util.Arrays;
import java.util.Scanner;

public class ShaiXuan {
	public static void main(String[] args) {
		System.out.println("请输入一串数字，输入0后停止输入");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] number = new int[100];
		int[] number2 = new int[100];
		int[] number3 = new int[100];
		int scount = 0;
		int scount2 = 0;
		int scount3 = 0;
		while (num != 0) { // 输入数据
			number[scount] = num;
			scount++;
			num = sc.nextInt();
		}
		for (int i = 0; i < scount; i++) { // 第一次筛选，选出出现两次的数据，录入第二个数组
			for (int j = 0; j < scount; j++) {
				if (number[i] == number[j] && i != j) {
					number2[scount2] = number[i];
//					System.out.println(number2[scount2]);
					scount2++;
					number[i] = 0;
				}
			}
		}
		for (int i = 0; i < scount2; i++) {
//			System.out.println(number2[i]);
		}

		for (int i = 0; i < scount2; i++) { // 第二次筛选，再次选出出现两次的数据，录入第三个数组
			for (int j = 0; j < scount2; j++) {
				if (number2[i] == number2[j] && i != j && number2[i] != 0) {
					number3[scount3] = number2[i];
//					System.out.println(number3[scount3]);
					scount3++;
					number2[i] = 0;
//					System.out.println(number3[scount3-1]);
				}
			}
		}

		Arrays.sort(number3);
		for (int i = 0; i < number3.length; i++) {
			if (number3[i] != 0) {
				System.out.println(number3[i]);
			}
		}
	}
}
