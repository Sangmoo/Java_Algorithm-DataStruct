import java.util.*;

public class Java_Stack {

  private int Number; // 항의 갯수
  private boolean EmptyNumber; // 비어있는지 확인
  private String[] Context; // 확인 내용

  public Java_Stack(){
      this.Number = 0;
      this.EmptyNumber = false;
      this.Context = new String[0];
  }

  // 삽입 함수
  public void Insert(int Position, String Data){
        // 삽입 불가능한 위치에 삽입
       if((Position>(this.Number + 2)) || (Position<1)){
            System.out.println("입력할 수 없습니다.");
        }
        // 맨 처음에 추가할 경우
        // 아무것도 존재하지 않는 경우
        else if(Position == 1 && Number ==0){
           this.EmptyNumber = true;
            this.Number++;
            this.Context = new String[this.Number];
            this.Context[0] = Data;
        }
        // 맨 처음 위치에 있지만, 이미 존재하고 있는 값이 있는 경우
        else if((Position == 1) && (Number>0)){
            String[] Temp = new String[this.Number];
            for (int i = 0; i < this.Number; i++)
                Temp[i] = this.Context[i];
            this.Number++;
            this.Context = new String[this.Number];
            this.Context[0] = Data;
            for(int i=1;i<this.Number;i++) {
                this.Context[i] = "";
                this.Context[i] = Temp[i - 1];
            }

        }
        // 맨뒤에 Data를 넣을 경우
        else if(Position == this.Number+1){
            this.Number++;
            String[] Temp = new String[this.Number];
            for(int i=0;i<(this.Number)-1;i++)
                Temp[i] = this.Context[i];
                Temp[Number-1] = Data;
            this.Context = new String[this.Number];
            for(int i=0;i<this.Number;i++) {
                this.Context[i] = "";
                this.Context[i] = Temp[i];
            }
        }
        else{ // 중간에 넣는 경우
            // 포인터가 없기 떄문에 동적 배열을 사용한다.
            String[] left = new String[Position];
            String[] right = new String[this.Number - (Position-1)];
            for(int i=0;i<Position-1;i++){
                left[i] = this.Context[i];
            }
            left[Position-1] = Data;
            for(int i=Position-1;i<this.Number;i++){
                right[i-(Position-1)] = this.Context[i];
            }
            this.Number++;
            this.Context = new String[this.Number];
            for(int i=0;i<this.Number;i++){
                if(i<Position){
                    this.Context[i] = "";
                    this.Context[i] = left[i];
                }else {
                    this.Context[i] = "";
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
          this.Context = new String[0];
      }
      // 맨 처음 위치에 있지만, 이미 존재하고 있는 값이 있는 경우
      else if((Position == 1) && (Number>1)){
          Number--;
          String[] Temp = new String[this.Number];
          for (int i = 0; i < this.Number; i++)
              Temp[i] = this.Context[i+1];
          this.Context = new String[Number];
          for(int i=0;i<this.Number;i++) {
              this.Context[i] = "";
              this.Context[i] = Temp[i];
          }

      }
      // 맨 마지막 삭제
      else if(Position == this.Number+1) {
            this.Number--;
            String[] Temp = new String[this.Number];
            for(int i=0;i<Number;i++){
                Temp[i] = this.Context[i];
            }
            this.Context = new String[this.Number];
            for(int i=0;i<Number;i++){
                this.Context[i] = Temp[i];
            }

      } // 중간에 삭제하는 경우
      else{

          // 포인터가 없기 떄문에 동적 배열을 사용한다.
          String[] left = new String[(Position-1)];
          String[] right = new String[this.Number - (Position-1)];
          for(int i=0;i<Position-1;i++){
              left[i] = this.Context[i];
          }
          for(int i=Position-1;i<this.Number;i++){
              right[i-(Position-1)] = this.Context[i];
          }
          this.Number--;
          this.Context = new String[this.Number];
          for(int i=0;i<this.Number;i++){
              if(i<(Position-1)){
                  this.Context[i] = "";
                  this.Context[i] = left[i];
              }else {
                  this.Context[i] = "";
                  this.Context[i] = right[i-(Position-1)];
              }
          }
      }
      for(int i=0;i<this.Number;i++)
          System.out.println(this.Context[i]);

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
      this.Context = new String[0];
  }
  // 리스트 자체를 삭제
  public void Destroy(){
     this.Number = 0;
     this.EmptyNumber = false;
     this.Context = new String[0];
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
   public void Push(String Data){
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
   // 초기화\
    public void Init(){
      this.Create();
    }
   // 파괴
    public void Java_Stack_Destroy(){
        this.Destroy();
    }

  public static void main(String[] args){
      Java_Stack Java_Stack = new Java_Stack();
    int Position;
    String Data;
    Scanner scanner = new Scanner(System.in);
    int Select;

    while(true){
        System.out.println("해당 기능을 선택해주세요  ");
        System.out.print("1 - 삽입 / 2 - 삭제 / 3 - 검색 / 4 - 길이 / 5 - 다시 생성 / 6 - 리스트 파괴 / 7 - 비어있는지 확인 / 8 - 모든 검색  ");
        Select = scanner.nextInt();
        switch(Select){
            // 삽입 기능
            case 1:
                System.out.println("삽입 기능입니다.");
                scanner = new Scanner(System.in);
                System.out.print("해당 Data :");
                Data = scanner.nextLine();
                Java_Stack.Push(Data);
            break;
            // 삭제 기능
            case 2:
                System.out.println("삭제 기능입니다.");
                Java_Stack.Pop();
            break;
            // 검색 기능
            case 3:
                scanner = new Scanner(System.in);
                System.out.print("검색 기능입니다.");
                Java_Stack.GetTop();
            break;
            // 길이 기능
            case 4:
                Java_Stack.Length();
            break;
            case 5:
                Java_Stack.Init();
            break;
            case 6:
                Java_Stack.Java_Stack_Destroy();
            break;
            case 7:
                Java_Stack.Isempty();
            break;
            case 8:
                Java_Stack.AllRetrieve();
            break;
        }

    }

  }
}