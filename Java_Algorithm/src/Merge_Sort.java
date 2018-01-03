import java.util.*;

// 합병 정렬
public class Merge_Sort {
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

        
        int mid = keyData.length/2;  // 중간에 분할할 영역을 선택한다.
        // 범위에 따라 변수를 지정한다
        int first1 = 0; int last1 = mid-1;
        int first2 = mid; int last2 = keyData.length-1;
        int [] Temp = new int[size];
        int index = first1;
        for(;(first1<=last1)&&(first2<=last2);index++){ 
            // 두개의 분할 영역 중 하나가 다 비워질때까지 비교한다
            if(keyData[first1]<keyData[first2]){
                Temp[index] = keyData[first1];
                first1++;
            }
            else{
                Temp[index] = keyData[first2];
                first2++;
            }
        }

        // 남은 한쪽의 Data를 집어넣는다.
        for(;first1<=last1;first1++, index++) {
             Temp[index] = keyData[first1];
         }

        for(;first2<=last2;first2++, index++) {
            Temp[index] = keyData[first2];
        }

        for(int i=0;i<size;i++) {
            keyData[i] = Temp[i];
        }
        for(int i=0;i<size;i++)
            System.out.print(keyData[i]  + " ");
    }
}