import java.util.*;
//인접 행렬을 이용한 경로 탐색
class Graph {

    char [] Name;
    boolean [] Node;
    int [][] Edge;
    public Graph(){
        Node = new boolean[0];
        Edge = new int[0][0];
        Name = new char[0];
    }
    public Graph(int Size){
        Scanner scanner = new Scanner(System.in);
        Name = new char[Size];
        Node = new boolean[Size];
        Edge = new int[Size][Size];
        for(int i=0;i<Size;i++) {
            for (int j = i; j < Size; j++) {
                if (i != j) {
                    System.out.print(i + "," + j + ":" + j + "," + i + "행은 인접합니까? : 인접 1 / 비인접 0 : ");
                    Edge[i][j] = scanner.nextInt();
                } else { // 같은 부분은 어차피 인접행렬이 아니다다.
                    Edge[i][j] = 0;
                }
                Node[i] = false; // 전부 비방문 상태
            }
        }
        for(int k=0;k<Size;k++) {
            for (int j = Size - 1; j > k; j--) {
                if (k != j) {
                    Edge[j][k] = Edge[k][j];
                } else { // 같은 부분은 어차피 인접행렬이 아니다다.
                    Edge[k][j] = 0;
                }
            }
        }
        for(int i=0;i<Size;i++){
            char temp = 'a';
            Name[i] = (char)((int)temp + i);
        }

    }

    public void findPath(char start, char end)
    {
        int find = 0;
        char find_Path = '0';
        for(int i=0;i<Name.length;i++)
        	{
            if(Name[i] == start)
            	{
	                find = i;
	                Node[i] = true;
	                find_Path = Name[i];
            	}
            }

        if(find_Path == end) 
        {
            System.out.println("경로가 있습니다.");
            return;
        }

        for(int i=0;i<this.Node.length;i++)
        {
            // 목적지를 찾았을 경우
            // 가는 경로가 존재시 ( 방문하지 않은 행 )
            if((Edge[find][i] == 1)&& (Node[i] == false))
            {
                 findPath(Name[i],end);
            }
            if(i==this.Node.length-1)
            {
                System.out.println("해당 경로는 없습니다.");
            }
        }
    }
}

public class Java_Graph_Adjacency {

    public static void main(String[] args) {
        Graph graph = new Graph();
        Scanner scanner = new Scanner(System.in);
       int size,cases;
       char start, end;
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
                  graph.findPath(start,end);
              break;
          }

      }
     }
}