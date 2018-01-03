# Java_Algorithm

<hr>

* Sort

## Sort

`Sort`은 자료를 오름차순 또는 내림차순으로 정렬하는 것으로서 , Sort의 기준은 Record(Data)입니다. 이중 정렬의 기준이 되는 것은 key field 로서, key field에 따라 오름차순 ex)2,3,5 또는 내림차순 ex) 5,3,2 으로 나누는 것입니다.

### Selection Sort

`Selection Sort`( 선택 정렬 )이란, 가장 마지막 것과 가장 큰것을 Swap 하면서 Record를 정렬하는 것입니다.

시간 복잡도는 O(n<sup>2</sup>) 입니다.

```java
import java.util.*;

// 삽입 정렬
public class Solution {
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

```



### Bubble Sort

`Bubble Sort`는 큰 수를 거품처럼 한칸씩 가장 큰 인덱스로 정렬하는 것입니다.

시간 복잡도는 O(n<sup>2</sup>) 입니다.

```java

import java.util.*;

// 버블 정렬
public class Solution {
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

```



### Merge Sort

`Merge Sort(합병 정렬)`이란 , 두 그룹의 데이터를 나누어서 처리를 합니다.

다만 두 영역 각자의 내부는 정렬이 끝나있어야 합니다. 시간 복잡도는 O(NlogN)입니다.

```java

import java.util.*;

// 합병 정렬
public class Solution {
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

```



### Quick Sort

`Quick Sort(쾌속 정렬)`이란 , 피벗이라는 기준점을 두어서 피벗보다 큰 Data는 오른쪽 인덱스, 

작은 Data는 왼쪽 인덱스로 둡니다. 시간 복잡도는 O(NlogN)입니다.



```java
// 쾌속 정렬
public class Solution {
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

        Solution solution = new Solution();
        solution.put(size);
        solution.QuickSort(solution.keyData,0,size-1);


        for(int i=0;i<size;i++)
            System.out.print(solution.keyData[i]  + " ");
    }
}

```
