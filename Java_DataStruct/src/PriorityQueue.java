import java.util.*;

public class PriorityQueue {

        private int Number; // 항의 갯수
        private boolean EmptyNumber; // 비어있는지 확인
        private int[] Context; // 확인 내용

        public PriorityQueue(){
            this.Number = 0;
            this.EmptyNumber = false;
            this.Context = new int[0];
        }

        // 삽입 함수
        public void Insert(int Position, int Data){
            // 삽입 불가능한 위치에 삽입
            if((Position>(this.Number + 2)) || (Position<1)){
                System.out.println("입력할 수 없습니다.");
            }
            // 맨 처음에 추가할 경우
            // 아무것도 존재하지 않는 경우
            else if(Position == 1 && Number ==0){
                this.EmptyNumber = true;
                this.Number++;
                this.Context = new int[this.Number];
                this.Context[0] = Data;
            }
            // 맨 처음 위치에 있지만, 이미 존재하고 있는 값이 있는 경우
            else if((Position == 1) && (Number>0)){
                int[] Temp = new int[this.Number];
                for (int i = 0; i < this.Number; i++)
                    Temp[i] = this.Context[i];
                this.Number++;
                this.Context = new int[this.Number];
                this.Context[0] = Data;
                for(int i=1;i<this.Number;i++) {
                    this.Context[i] = 0;
                    this.Context[i] = Temp[i - 1];
                }

            }
            // 맨뒤에 Data를 넣을 경우
            else if(Position == this.Number+1){
                this.Number++;
                int[] Temp = new int[this.Number];
                for(int i=0;i<(this.Number)-1;i++)
                    Temp[i] = this.Context[i];
                Temp[Number-1] = Data;
                this.Context = new int[this.Number];
                for(int i=0;i<this.Number;i++) {
                    this.Context[i] = 0;
                    this.Context[i] = Temp[i];
                }
            }
            else{ // 중간에 넣는 경우
                // 포인터가 없기 떄문에 동적 배열을 사용한다.
                int[] left = new int[Position];
                int[] right = new int[this.Number - (Position-1)];
                for(int i=0;i<Position-1;i++){
                    left[i] = this.Context[i];
                }
                left[Position-1] = Data;
                for(int i=Position-1;i<this.Number;i++){
                    right[i-(Position-1)] = this.Context[i];
                }
                this.Number++;
                this.Context = new int[this.Number];
                for(int i=0;i<this.Number;i++){
                    if(i<Position){
                        this.Context[i] = 0;
                        this.Context[i] = left[i];
                    }else {
                        this.Context[i] = 0;
                        this.Context[i] = right[i-Position];
                    }
                }

            }

        }
        // 삭제하는 함수
        public void Delete(int Position){
            // 삭제 불가능한 위치에 삽입
            if(this.Number == 0){
                System.out.println("삭제할 것이 없습니다.");
            }
            else if((Position>(this.Number + 2)) || (Position<1)){
                System.out.println("삭제할 수 없습니다.");
            }
            // 맨 처음 삭제
            else if(Position == 1 && Number ==1){
                this.Number = 0;
                this.EmptyNumber = false;
                this.Context = new int[0];
            }
            // 맨 처음 위치에 있지만, 이미 존재하고 있는 값이 있는 경우
            else if((Position == 1) && (Number>1)){
                Number--;
                int[] Temp = new int[this.Number];
                for (int i = 0; i < this.Number; i++)
                    Temp[i] = this.Context[i+1];
                this.Context = new int[Number];
                for(int i=0;i<this.Number;i++) {
                    this.Context[i] = 0;
                    this.Context[i] = Temp[i];
                }

            }
            // 맨 마지막 삭제
            else if(Position == this.Number+1) {
                this.Number--;
                int[] Temp = new int[this.Number];
                for(int i=0;i<Number;i++){
                    Temp[i] = this.Context[i];
                }
                this.Context = new int[this.Number];
                for(int i=0;i<Number;i++){
                    this.Context[i] = Temp[i];
                }

            } // 중간에 삭제하는 경우
            else{

                // 포인터가 없기 떄문에 동적 배열을 사용한다.
                int[] left = new int[(Position-1)];
                int[] right = new int[this.Number - (Position-1)];
                for(int i=0;i<Position-1;i++){
                    left[i] = this.Context[i];
                }
                for(int i=Position-1;i<this.Number;i++){
                    right[i-(Position-1)] = this.Context[i];
                }
                this.Number--;
                this.Context = new int[this.Number];
                for(int i=0;i<this.Number;i++){
                    if(i<(Position-1)){
                        this.Context[i] = 0;
                        this.Context[i] = left[i];
                    }else {
                        this.Context[i] = 0;
                        this.Context[i] = right[i-(Position-1)];
                    }
                }
            }


        }
        // 해당 위치를 탐색하는 함수
        public void Retrieve(int Position){
            if(this.Number == 0){
                System.out.println("데이터가 없습니다.");
            }
            if(Position > this.Number)
                System.out.println("해당 위치에 Data가 없다.");
            else {
                System.out.println(Position + ": " + this.Context[Position-1]);
            }
        }
        // 다시 생성
        public void Create(){
            this.Number = 0;
            this.EmptyNumber = false;
            this.Context = new int[0];
        }
        // 리스트 자체를 삭제
        public void Destroy(){
            this.Number = 0;
            this.EmptyNumber = false;
            this.Context = new int[0];
        }
        // 비어있는지 확인
        public void Isempty(){
            if(this.EmptyNumber == false){
                System.out.println("리스트가 비어있습니다.");
            }else{
                System.out.println("리스트가 비어있지 않습니다.");
            }
        }
        // 리스트의 길이
        public void Length(){
            System.out.println("길이 :" +  this.Number);

        }
        // 모든 항 확인
        public void AllRetrieve(){
            for(int i=0;i<this.Number;i++)
                System.out.println((i+1)+":" + this.Context[i]);
        }


        /* 스택 전용 함수 */
        // 삽입
        public void Push(int Data){
            this.Insert(1,Data);
        }
        //삭제
        public void Pop(){
            this.Delete(1);
        }
        //검색
        public void GetTop(){
            this.Retrieve(1);
        }
        //초기화
        public void Init(){
            this.Create();
        }
        //파괴
        public void Stack_Destroy(){
            this.Destroy();
        }


        /* 큐 전용 함수 */
        //삽입
        public void Add(int Data){
            this.Insert((this.Number+1),Data);
        }
        //삭제
        public void Remove(){this.Delete(1);}
        //초기화
        public void Queue_Init(){this.Create();}
        //파괴
        public void Queue_Destroy(){this.Destroy();}
        //큐 읽기
        public void GetFront(){
            this.Retrieve(1);
        }


        // 우선순위 큐 삽입 함수
        public void priority_Add(int Data){
            // 맨 처음에 추가할 경우
            // 아무것도 존재하지 않는 경우
             if(Number==0){
                this.EmptyNumber = true;
                this.Number++;
                this.Context = new int[this.Number];
                this.Context[0] = Data;
            }
            // 맨 처음에 삽입하나 이미 값이 있을 경우
           else{
                // 새로운 값을 삽입 ( Pointer가 없기 때문에 배열로 처리 )
                int[] Temp = new int[this.Number];
                for (int i = 0; i < this.Number; i++)
                    Temp[i] = this.Context[i];
                this.Number++;
                this.Context = new int[this.Number];
                this.Context[0] = Data;
                for(int i=0;i<this.Number-1;i++){
                    this.Context[i+1] = Temp[i];
                }
                // 정렬을 통해 우선순위를 파악한다. ( 버블 정렬 )
                for(int i=0;i<this.Number-1;i++){
                    int swap = 0;
                    if(this.Context[i]>this.Context[i+1]){
                        // 우선순위가 낮은것을 제일 앞으로 둔다. ( 기준을 거꾸로 하고 싶으면 반대로 해도 좋습니다. )
                        // Swap 처리
                        swap = this.Context[i];
                        this.Context[i] = this.Context[i+1];
                        this.Context[i+1] = swap;
                    }
                }
            }

        }


        public static void main(String[] args){
            PriorityQueue queue = new PriorityQueue();
            int Position;
            int Data;
            Scanner scanner = new Scanner(System.in);
            int Select;

            while(true){
                System.out.println("해당 기능을 선택해주세요  ");
                System.out.print("1 - 큐 삽입 / 2- 큐 삭제 / 3 - 큐 초기화 / 4- 큐 파괴 / 5 - 맨 앞 확인 / 6- 전체 확인  ");
                Select = scanner.nextInt();
                switch(Select){
                    // 삽입 기능
                    case 1:
                        System.out.println("삽입 기능입니다.");
                        scanner = new Scanner(System.in);
                        System.out.print("해당 Data :");
                        Data = scanner.nextInt();
                        queue.priority_Add(Data);
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
}