# **Java_Algorithm/DataStruct**

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

<hr>

## Data Structure

## List

Java 자체는 Pointer가 unsafe이며 사용자체를 하고 있지 않습니다. 

따라서 저는 기존의 배열보다 큰 동적 임시 배열을 만들어서,  기존 배열의 공간을 확장시킨 후 값을 넣습니다. 

```java
/* Insert Code 일부분 */
else if((Position == 1) && (Number>0)){
  String[] Temp = new String[this.Number]; // 기존의 배열 공간만큼 임시 배열을 만들어서,
  for (int i = 0; i < this.Number; i++)
      Temp[i] = this.Context[i]; // 기존의 값을 백업 시킨다.
      this.Number++; // 새로 넣을 배열 공간을 만든다.
      this.Context = new String[this.Number]; // 증가된 공간만큼 기존 배열을 새롭게 다시 만든다.
      this.Context[0] = Data; // 집어 넣어야 할 위치에 새로운 Data를 넣는다.
  for(int i=1;i<this.Number;i++) {
    this.Context[i] = "";  
    this.Context[i] = Temp[i - 1];
  } // 기존의 Data들을 다시 Context에 넣고 함수 결과를 끝낸다.

}

```

삭제시에는 기존 배열보다 작은 동적 임시 배열을 만들어서, 기존의 배열 공간을 축소시킨 후 처리했습니다.



```java
/* Delete Code 일부분 */      
else if((Position == 1) && (Number>1)){
  Number--; // 값을 삭제할 예정이므로 기존의 값보다 작게 만든다.
  String[] Temp = new String[this.Number]; // 임시로 값을 담을 배열을 하나 만든다.
    for (int i = 0; i < this.Number; i++)
      Temp[i] = this.Context[i+1]; // 삭제할 위치를 제외한 나머지 값을 임시 배열에 넣는다.
      this.Context = new String[Number];  // 삭제할 값을 제외한 공간만큼 다시 배열을 만듭니다.
  for(int i=0;i<this.Number;i++) {
      this.Context[i] = ""; 
      this.Context[i] = Temp[i];
    } // 임시로 백업해 두었던 값을 전부 원래 배열로 옮기고 함수 결과를 끝냅니다.

}
```



삭제, 삽입 , 검색 등의 기능을 While 문을 이용하여 확인합니다.



```java
 System.out.print("1 - 삽입 / 2 - 삭제 / 3 - 검색 / 4 - 길이 / 5 - 다시 생성 / 6 - 리스트 파괴 / 7 - 비어있는지 확인 / 8 - 모든 검색  ");
        Select = scanner.nextInt(); // 선택하여 기능을 선택.
        switch(Select){
            // 삽입 기능
            case 1:
                System.out.println("삽입 기능입니다.");
                System.out.print("해당 위치 :");
                Position = scanner.nextInt();
                scanner = new Scanner(System.in);
                System.out.print("해당 Data :");
                Data = scanner.nextLine();
                list.Insert(Position,Data);
            break;
            // 삭제 기능
            case 2:
                System.out.println("삭제 기능입니다.");
                scanner = new Scanner(System.in);
                System.out.print("삭제할 위치 :");
                Position = scanner.nextInt();
                list.Delete(Position);
            break;
            // 검색 기능
            case 3:
                scanner = new Scanner(System.in);
                System.out.print("검색할 위치 :");
                Position = scanner.nextInt();
                list.Retrieve(Position);
            break;
            // 길이 기능
            case 4:
                list.Length();
            break;
            case 5:
                list.Create();
            break;
            case 6:
                list.Destroy();
            break;
            case 7:
                list.Isempty();
            break;
            case 8:
                list.AllRetrieve();
            break;
        }

    }

```

[위로](#Java_Algorithm/DataStruct)



## Stack 

기존의 `List` 코드를 이용해서 `Stack`을 구현하였으며 , `LIFO` 이기 때문에 삭제 , 삽입 부분만 수정하였습니다.

```java
 /* 스택 전용 함수 */
   // 삽입
   public void Push(String Data){
        this.Insert(1,Data); // Last Data가 제일 먼저 나와야 하므로 1번째 위치에 넣습니다.
   }
   //삭제
   public void Pop(){
        this.Delete(1); // First Data를 삭제해야 하므로 위치로 첫번째를 지정합니다.
   }
   //검색
   public void GetTop(){
       this.Retrieve(1); // 맨 처음 Data를 검색하므로 Retrieve에서 첫번째를 지정합니다.
   }
   // 초기화 ( Stack 또한 새롭게 생성합니다. )
    public void Init(){
      this.Create();
    }
   // 파괴
    public void Stack_Destroy(){
        this.Destroy();
    }
// List와 대부분의 기능은 유사하며, 모든 검색이 궁금하실 분이 있으셔서 넣었습니다.
  public static void main(String[] args){
      Stack stack = new Stack();
    int Position;
    String Data;
    Scanner scanner = new Scanner(System.in);
    int Select;

    while(true){
        System.out.println("해당 기능을 선택해주세요  ");
        System.out.print("1 - 삽입 / 2 - 삭제 / 3 - 검색 / 4 - 길이 /
                         5 - 다시 생성 / 6 - 리스트 파괴 / 7 - 비어있는지 확인 / 8 - 모든 검색  ");
        Select = scanner.nextInt();
        switch(Select){
            // 삽입 기능
            case 1:
                System.out.println("삽입 기능입니다.");
                scanner = new Scanner(System.in);
                System.out.print("해당 Data :");
                Data = scanner.nextLine();
                stack.Push(Data);
            break;
            // 삭제 기능
            case 2:
                System.out.println("삭제 기능입니다.");
                stack.Pop();
            break;
            // 검색 기능
            case 3:
                scanner = new Scanner(System.in);
                System.out.print("검색 기능입니다.");
                stack.GetTop();
            break;
            // 길이 기능
            case 4:
                stack.Length();
            break;
            case 5:
                stack.Init();
            break;
            case 6:
                stack.Stack_Destroy();
            break;
            case 7:
                stack.Isempty();
            break;
            case 8:
                stack.AllRetrieve();
            break;
        }

    }

  }
```

[위로](#Java_Algorithm/DataStruct)



## Depth First Search - Tree Preorder

깊이 우선 탐색(`Depth First Search`)은 스택을 통해 구현하고 사용할 수 있으며, A->B->C->D등의 경로를 검색할때 A->D까지 가는 경로가 있는지? 를 파악하며 A->B를 먼저 탐색하여 A->B로 가는 길이 있다면 A->B , A->B->C등으로 파고 들어가며,  경로가 없을시 A->B->C에서 A->B, A->B->D 경로로 돌아가는데 A->B->C에서 A->B로 갔던 길로 돌아가는 것을 `BackTracking`이라고 하며 A,B,C등의 정점을 `Node`, 경로를 `Edge`라고 합니다.

```java
    // Depth First Search ( 배열의 크기는 10*10이며 수정 필요시 j를 수정하면 됩니다. )
   public void DFS(Stack stack,int i,int End){
        if(stack.Track[i] == false) {
            stack.Push(String.valueOf(stack.Route[i])); // Stack에 집어넣음
            stack.Track[i] = true; // 해당 Node에 방문을 했다고 표시
        }
        // 목적지와 일치했을 경우 탐색 종료
        if(Integer.parseInt(stack.GetTop())==End){
            find = 1;
        }

        // 경로가 목적지와 일치하지 않을 경우 경로를 탐색 합니다.
        if(find == 0) {
            for (int j = 0; j < 10; j++) {
                if (stack.Edge[i][j] == 1) {
                    if (stack.Track[j] == false) {
                        stack.DFS(stack, j, End); // ex) A-> G까지 가는 경로가 있다면
                    } // A->B->C 등으로 경로 이동을 하기 위해 재귀함수를 씁니다.
                }
                if(find == 1){
                    break;
                }
                if (j == 9) {
                        stack.Pop();
                       if(stack.Length() == 0) // 경로를 탐색해서 나오는 경로가 없을 경우 탐색 종료
                        { find = 1;}
                        if(find == 0) {
                            int Start = Integer.parseInt(stack.GetTop());
                            stack.DFS(stack, Start, End); // 경로가 아직 있다면 재귀함수
                        }
                }
            }
        }

     }

```

```java
 public static void main(String[] args){
    int Temp = 0;
    DFS stack;
    int Start=0, End=0;
    String Data_Start, Data_End;
    Scanner scanner = new Scanner(System.in);

    while(true){ // 사정상 10 *10 배열을 미리 지정해놓았으며, 삽입으로 넣기 위해서는 입력 함수를
      // 따로 만들어 주어야 합니다.
        stack = new Stack();
        System.out.println("해당 경로를 갈 수 있는지 탐색합니다.");
        System.out.print("시작점 : ");
        Data_Start = scanner.nextLine();
        System.out.print("종료점 : ");
        Data_End = scanner.nextLine();
        for(int i=0;i<10;i++){
            if(Data_Start.charAt(0)==stack.Code[i]){
               Start = i;
                break;
            }
        }
        for(int i=0;i<10;i++){
            if(Data_End.charAt(0)==stack.Code[i]){
                End = i;
                break;
            }
        }

        stack.DFS(stack,Start,End); // 깊이 우선 탐색 시작
        stack.find = 0;
        int length = stack.Length();
        if(length == 0){ // 찾는 경로가 없을 경우
            System.out.println("해당 경로가 없습니다.");
        }else { // 찾는 경로가 있는 경우
            for (int i = 0; i < length; i++) {
                System.out.println("경로" + (i + 1) + " : " + 
                                   stack.Code[Integer.parseInt(stack.GetTop())]);
                stack.Pop();
            }
        }
        stack.Stack_Destroy();
        System.out.println("종료입니다.");
    }

  }
```



[위로](#Java_Algorithm/DataStruct)



## Queue

기존의 `List` 코드를 이용해서 `Stack`을 구현하였으며 , `LIFO` 이기 때문에 삭제 , 삽입 부분만 수정하였습니다.

```java
  /* 큐 전용 함수 */
    //삽입
    public void Add(String Data){
        this.Insert((this.Number+1),Data); 
    } // 해당 Queue는 FIFO구조 이므로 뒤에 정보를 넣습니다.
    //삭제 (Queue는 First Out므로 첫번째 자료를 삭제합니다.)
    public void Remove(){this.Delete(1);}
    //초기화
    public void Queue_Init(){this.Create();}
    //파괴
    public void Queue_Destroy(){this.Destroy();}
    //큐 읽기
    public void GetFront(){
        this.Retrieve(1);
    }

// List와 대부분의 기능은 유사하며, 모든 검색이 궁금하실 분이 있으셔서 넣었습니다.
  public static void main(String[] args){
        Queue queue = new Queue();
        int Position;
        String Data;
        Scanner scanner = new Scanner(System.in);
        int Select;

        while(true){
            System.out.println("해당 기능을 선택해주세요  ");
            System.out.print("1 - 큐 삽입 / 2- 큐 삭제 / 3 - 큐 초기화 
                             / 4- 큐 파괴 / 5 - 맨 앞 확인 / 6- 전체 확인  ");
            Select = scanner.nextInt();
            switch(Select){
                // 삽입 기능
                case 1:
                    System.out.println("삽입 기능입니다.");
                    scanner = new Scanner(System.in);
                    System.out.print("해당 Data :");
                    Data = scanner.nextLine();
                    queue.Add(Data);
                    break;
                // 삭제 기능
                case 2:
                    System.out.println("삭제 기능입니다.");
                    queue.Remove();
                    break;
                // 검색 기능
                case 3:
                    scanner = new Scanner(System.in);
                    System.out.print("초기화 기능입니다.");
                    queue.Queue_Init();
                    break;
                // 길이 기능
                case 4:
                    queue.Queue_Destroy();
                    break;
                case 5:
                    queue.GetFront();
                    break;
                case 6:
                    queue.AllRetrieve();
                    break;

            }

        }

    }


```

[위로](#Java_Algorithm/DataStruct)

## Breadth First Search - Tree Level Traversal

너비 우선 탐색(`Breadth First Search`)은 큐를 통해 구현하고 사용할 수 있으며, A->B , A->C , A->D등의 경로등이 존재할때, A가 삭제되고 B,C,D 가 큐에 들어가며 B가 B->E, B->F, B->G등의 경로가 존재시 E,F,G가 큐에 들어가며 B는 빠져나오고, 해당되는 목적지를 찾으면 경로탐색을 종료합니다. A,B,C등의 정점을 `Node`, 경로를 `Edge`라고 합니다.

```java
//( 배열의 크기는 10*10이며 수정 필요시 j를 수정하면 됩니다. )
public void BFS(BFS bfs,int i,int End){
        // 방문했는지 확인하고 준비
        if(bfs.Track[i] == false){
            bfs.Add(String.valueOf(bfs.Route[i])); // Queue에 집어넣음
            bfs.Track[i] = true; // 해당 Node에 방문을 했다고 표시
        }

          // 목적지와 일치했을 경우 탐색 종료
        if(queue_route > 0) {
            if (Integer.parseInt(bfs.Retrieve(queue_route)) == End) {
                find = 1;
            }

        }

        // 일치하는것이 끝나지 않았을 경우
        if(find == 0) {
            // BFS는 노드가 가지고 있는 전체 경로를 다 넣어야 하므로,
            // 지나가는 경로가 있다면 집어넣습니다.
            for (int j = 0; j < 10; j++) {
                if (bfs.Edge[i][j] == 1) {
                    if (bfs.Track[j] == false) {
                       bfs.Add(String.valueOf(bfs.Route[j]));
                       bfs.Track[j] = true;
                    }
                }

            }
                    try {
                        queue_route++;
                        int route = Integer.parseInt(bfs.Retrieve(queue_route));
                        bfs.BFS(bfs, route, End);
                    }catch(NumberFormatException e){
                            find = 1;
                            bfs.Destroy();
                            bfs.Create();
                    }
            }
     }

```

```java
  public static void main(String[] args){
        BFS bfs = new BFS();
        int Position;
        String Data;
        Scanner scanner = new Scanner(System.in);
        int Select;
        int Start=0, End=0;
        String Data_Start, Data_End;

        while(true){// 사정상 10 *10 배열을 미리 지정해놓았으며, 삽입으로 넣기 위해서는 입력 함수를
      // 따로 만들어 주어야 합니다.
            bfs = new BFS();
            System.out.println("해당 경로를 갈 수 있는지 탐색합니다.");
            System.out.print("시작점 : ");
            Data_Start = scanner.nextLine();
            System.out.print("종료점 : ");
            Data_End = scanner.nextLine();
            for(int i=0;i<10;i++){
                if(Data_Start.charAt(0)==bfs.Code[i]){
                    Start = i;
                    break;
                }
            }
            for(int i=0;i<10;i++){
                if(Data_End.charAt(0)==bfs.Code[i]){
                    End = i;
                    break;
                }
            }

            bfs.BFS(bfs,Start,End); // 깊이 우선 탐색 시작

            int length = bfs.Length();
            if(length == 0){ // 찾는 경로가 없을 경우
                System.out.println("해당 경로가 없습니다.");
            }else { // 찾는 경로가 있는 경우
                for (int i = 0; i < bfs.queue_route; i++) {
                    System.out.println("경로" + (i + 1) + " : " +
                                       bfs.Code[Integer.parseInt(bfs.GetFront())]);
                    bfs.Pop();
                }
            }
            bfs.find = 0;
            bfs.queue_route = 0;
            bfs.Queue_Destroy();
            System.out.println("종료입니다.");
        }

    } 
```

[위로](#Java_Algorithm/DataStruct)
