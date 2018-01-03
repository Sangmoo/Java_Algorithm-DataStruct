// 쾌속 정렬
import java.util.*;

public class Quick_Sort {
    public int[] keyData;

    void put(int size){
        Scanner scanner = new Scanner(System.in);
        keyData = new int[size];
        for(int i=0;i<size;i++){
            System.out.print((i+1) + "번째 숫자를 입력해주세요 : ");
            keyData[i] = scanner.nextInt();
        } // 값을 입력받는다.

    }

    int partition(int arr[], int left, int right)
    {
        int i = left, j = right;
        int tmp;
        int pivot = arr[(left + right) / 2]; // 중간쯤을 피벗으로 둔다
        while (i <= j) { // 크로스 오버가 나기 전까지 계속 비교한다
            while (arr[i] < pivot)
                i++;
            while (arr[j] > pivot)
                j--;
            if (i <= j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        };

        return i;
    }

    void QuickSort(int arr[], int left, int right) {
        int index = partition(arr, left, right);
        if (left < index - 1)
            QuickSort(arr, left, index - 1);
        if (index < right)
            QuickSort(arr, index, right);
    }

    public static void main(String[] args) {
        int size = 0; // size 크기 조절
        Scanner scanner = new Scanner(System.in);

        System.out.print("사이즈를 조절합니다 :");
        size = scanner.nextInt();

        Quick_Sort solution = new Quick_Sort();
        solution.put(size);
        solution.QuickSort(solution.keyData,0,size-1);


        for(int i=0;i<size;i++)
            System.out.print(solution.keyData[i]  + " ");
    }
}