import java.util.*;
//위상 정렬  ( VOG , DAG )
//사이클은 싱크 , 소스가 있는지 확인하고 막음.
class Graph{
    char [] Name; // 노드 이름 (a,b,c,d... )
    char [] Result; // 위상 정렬 결과 담는 배열
    boolean [] Node; // 방문 노드 확인
    int [][] Edge; // 그래프 확인
    public Graph(){
        Result = new char[0];
        Node = new boolean[0];
        Edge = new int[0][0];
        Name = new char[0];
    }
    public Graph(int Size){
        Scanner scanner = new Scanner(System.in);
        Name = new char[Size];
        Result = new char[Size];
        Node = new boolean[Size];
        Edge = new int[Size][Size];
        for(int i=0;i<Size;i++) {
            for (int j=0; j < Size; j++) {
                if (i != j) {
                    System.out.print(i + "," + j + ": 행은 연결되어있습니까? : " + i  +" -> " + j + "방향 연결이면 1 / 아니면 0 : " );
                    Edge[i][j] = scanner.nextInt();
                }  else{
                    Edge[i][j] = 0;
                }
                Node[i] = false; // 전부 비방문 상태
            }
        }
        for(int i=0;i<Size;i++){
            char temp = 'a';
            Name[i] = (char)((int)temp + i);
        }
    }

    // 싱크인지 , 소스인지 판단하고 아니면 다시 .
    public boolean find(char start, char end){
        boolean findEdge = false;
        int sink = 0; // 싱크
        int source = 0; // 소스
        int sinkFind = 0; // 싱크를 할 노드 위치
        int sourceFind = 0; // 소스를 찾을 노드 위치
        for(int i=0;i<Name.length;i++){
            if(Name[i] == start){
                sinkFind = i;

            }
            if(Name[i] == end){
                sourceFind = i;
            }
        } // 위치 파악중 찾아보기

        for(int i=0;i<this.Node.length;i++){
                if((Edge[i][sinkFind] ==1) && (i!=sinkFind))  sink++;
        } // 싱크인지 파악

        for(int i=0;i<this.Node.length;i++){
            if((Edge[sourceFind][i] ==1)&& (i!=sourceFind))  source++;
        } // 소스인지 파악

        // Sink, Source인지 확인하고 Update
        if(sink == 0 && source == 0){
            findEdge = true;
        }else{
            findEdge = false;
        }
        return findEdge;
    }

    // 위상 정렬 함수
    public void topologcial_Sort(Graph graph,char start){
        int Temp = 0; // 싱크의 갯수
        int nodeFind = 0; // 노드 찾을 위치
        for(int i=0;i<Name.length;i++){
            if(Name[i] == start){
                nodeFind = i;
            }
        } // 위치 파악중 찾아보기

        Node[nodeFind] = true; // 방문했다고 확인
        Result[nodeFind] = start; // 해당 경로 삽입
        for(int i=0;i<this.Node.length;i++){
            Edge[nodeFind][i] = 0; // 간선을 다 끊는다
        }

        // 모두 들렀는지 확인 ( 모두 들렀다면 위상 정렬이 끝났으므로 종료 )
        for(int i=0;i<this.Node.length;i++)
        {
            if(Node[i] == false) Temp++;
        }
        if(Temp == 0) {
            for(int i=0;i<this.Node.length;i++)
                System.out.println("경로 " + (i+1) + ": " + Result[i]);
            return;
        }

        for(int i=0;i<this.Node.length;i++){
            int node_Temp = 0; // 싱크를 찾기 위한 임시 변수
            for(int j=0;j<this.Node.length;j++){
                if(Node[i]==false){
                    if(Edge[j][i] == 1) node_Temp++;  // 해당 경로에 가는 방향이 있는지 확인
                    // 싱크인것이 확인되었으므로 다시 위상정렬
                    if(j==this.Node.length-1 && node_Temp == 0){
                        graph.topologcial_Sort(graph,Name[i]); // 싱크인지 확인된다면 다시 함수 사용
                    }
                }
            }
        }
    }
}

public class Java_Graph {

    public static void main(String[] args) {
        Graph graph = new Graph();
        Scanner scanner = new Scanner(System.in);
       int size,cases;
       char start, end;
       boolean findEdge;
      while(true) {
          System.out.print("인접 행렬 설정 (1 - 경로 지정 / 2 - 경로 탐색 ) : ");
          cases = scanner.nextInt();
          switch(cases) {
              case 1:
                  System.out.print("그래프 사이즈를 지정해주세요 : ");
                  size = scanner.nextInt();
                  graph = new Graph(size);
              break;
              case 2:
                  scanner.nextLine();
                  System.out.print("시작점을 지정해주세요 : ");
                  start = scanner.next().charAt(0);
                  scanner.nextLine();
                  System.out.print("종료점을 지정해주세요 : ");
                  end =  scanner.next().charAt(0);
                  findEdge = graph.find(start,end);
                  if(findEdge == true)
                  graph.topologcial_Sort(graph,start);
                  else
                      System.out.println("Sink, Source가 아닙니다.");
              break;
          }
      }
     }
}