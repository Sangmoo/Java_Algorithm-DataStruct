import java.util.*;

// 삽입 정렬
public class Select_Sort {
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

        for(int N=size-1;N>=1;N--){ // 가장 큰수부터 마지막까지 비교
            int Largest = 0; // 가장 큰 배열
            for(int i=1;i<=N;i++){ // 해당되는 순서까지 비교
                if(keyData[Largest] < keyData[i]){
                    Largest = i; // 더 큰 수의 인덱스로 교체
                }
            }
            int temp =  keyData[Largest];
            keyData[Largest] = keyData[N];
            keyData[N] = temp;
        }

        for(int i=0;i<size;i++)
            System.out.print(keyData[i] + " ");
    }
}