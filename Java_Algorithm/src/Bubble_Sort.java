import java.util.*;

// 버블 정렬
public class Bubble_Sort {
    public static void main(String[] args) {
        int size = 0; // size 크기 조절
        Scanner scanner = new Scanner(System.in);

        System.out.print("사이즈를 조절합니다 :");
        size = scanner.nextInt();

        int[] keyData = new int[size];
        for(int i=0;i<size;i++){
            System.out.print((i+1) + "번째 숫자를 입력해주세요 : ");
            keyData[i] = scanner.nextInt();
        } // 값을 입력받는다.

        boolean sort = false; // 정렬이 잘 되었는지 확인합니다.
        for(int i=1;(i<size)&& !(sort);i++){
            sort = true; // 정렬이 완료되면 빠져나옵니다
            for(int N=0;N<size-i;N++){ // 버블 정렬을 통해 숫자를 비교하면서 구합니다.
                if(keyData[N] > keyData[N+1]){
                    int temp = keyData[N];
                    keyData[N] = keyData[N+1];
                    keyData[N+1] = temp;
                    sort = false;
                }
            }
        }


        for(int i=0;i<size;i++)
            System.out.print(keyData[i] + " ");
    }
}