import java.io.*;
import java.util.*;


// Node 처리
class Node{
    public int[] key;
    public String[] value;
    public Node(){
        key = new int[0];
        value = new String[0];
    }
    public Node(int size){
        key = new int[size];
        value = new String[size];
        for(int i=0;i<size;i++){
            value[i] = "";
            key[i] = -1;
        }
    }

    public String get(int location){
        String returnValue = this.value[(location-1)%key.length];
        return returnValue;
    }

    public void set(int key,String value){
        this.key[(key-1)%this.key.length] = key;
        this.value[(key-1)%this.key.length] = value;
    }
}

public class Java_Hash {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int cases , sizes;
        String value;
        Node Node = new Node();
        while(true){
            System.out.print(" 1 : 사이즈 조절 , 2: 입력 , 3 : 출력 : ");
            cases = scanner.nextInt();
            switch(cases){
                case 1:
                    System.out.print("사이즈를 정해주세요 : ");
                    sizes = scanner.nextInt();
                    Node = new Node(sizes);
                break;
                case 2:
                    System.out.print("넣을 위치를 정해주세요 : ");
                    sizes = scanner.nextInt();
                    System.out.print("넣을 값을 정해주세요 : ");
                    Scanner scanner1 = new Scanner(System.in);
                    value = scanner1.nextLine();
                    Node.set(sizes,value);
                break;
                case 3:
                    System.out.print("찾을 위치를 정해주세요 : ");
                    sizes = scanner.nextInt();
                    value = Node.get(sizes);
                    System.out.println("사이즈 : " + sizes + " 값 : " + value);
                break;
            }

        }
    }
}