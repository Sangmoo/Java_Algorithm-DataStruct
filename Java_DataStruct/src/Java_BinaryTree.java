// 이진 탐색트리 구현
public class Java_BinaryTree {

    Integer Data;
    Java_BinaryTree left; // 좌측 서브트리
    Java_BinaryTree right; // 우측 서브트리

    public Java_BinaryTree(){ // 생성자
        this.Data = null;
        this.left = null;
        this.right = null;
    }
    // 탐색 트리 구현
    public void search(Java_BinaryTree tree, int Data){
        // Data가 없을 때
        if(tree.Data == null){
            System.out.println("데이터가 없습니다.");
        } // 해당 되는 경로가 있을 때
        else if(tree.Data == Data){
            System.out.println(tree.Data + "가 경로에 있습니다.");
        } // 찾으려는 경로보다 작은 경우
        else if(tree.Data < Data){
            tree.search(tree.right,Data);
        } // 찾으려는 경로보다 큰 경우
        else {
            tree.search(tree.left,Data);
        }
    }// 탐색 트리 삽입
    public void Insert(Java_BinaryTree tree, int treevalue){
        if(tree.Data == null){ // 해당트리에 데이터가 없으면 삽입 ( rootData)
           tree.Data = treevalue;
        }
        else if(treevalue == tree.Data){
            System.out.println("이미 데이터가 있습니다.");
        } // Data가 삽입하려는 위치보다 클때
        else if(treevalue > tree.Data){
            // tree가 존재안할 경우
            if(tree.right == null){
                tree.right = new Java_BinaryTree();
                tree.right.Data = treevalue;
            }
            // 이미 트리가 존재할 경우
            else{
                tree.right.Insert(tree.right,treevalue);
            }
        } // Data가 삽입하려는 위치보다 작을때
        else{
            // 해당 트리가 존재 하지 않을 경우
            if(tree.left == null){
                tree.left = new Java_BinaryTree();
                tree.left.Data = treevalue;
            }// 이미 트리가 존재하는 경우
            else{
                tree.left.Insert(tree.left,treevalue);
            }
        }
    }
    // 탐색 트리 삭제
    public void Delete(Java_BinaryTree tree,int treevalue){
       // 삭제할 자료가 없을 때
        if(tree.Data == null){
           System.out.println("삭제할 자료가 없습니다.");
       }else if(tree.Data > treevalue){ // 값이 작은 경우
            tree.Delete(tree.left,treevalue);
       }else if(tree.Data < treevalue){ // 값이 큰 경우
            tree.Delete(tree.right,treevalue);
       }else{ // 삭제할 값을 찾았을 때
            if(tree.left == null && tree.right == null){
                tree = null;
            } // 자식 노드가 없는 경우
            //자식 노드 하나인 경우
            else if(tree.left == null){
                tree = tree.right;
            }else if(tree.right == null){
                tree = tree.left;
            }else{

                tree.Double_Delete(tree,tree.right,treevalue);
            }
       }
    }
    public void Double_Delete(Java_BinaryTree pretree,Java_BinaryTree tree,int treevalue){
       /* 추가 구축 예정 */
       if(tree.right== null){
       }else{
           pretree = tree.right;
       }
    }
    public static void main(String[] args){
        Java_BinaryTree Binary = new Java_BinaryTree();
        while(true) {
            java.util.Scanner scanner = new java.util.Scanner(System.in);
            int Choice;
            System.out.print("트리 기능 ( 1 - 탐색 ) / ( 2 - 삽입 ) / ( 3 - 삭제 ) :");
            Choice = scanner.nextInt();
            int Data;
            switch(Choice){
                case 1:
                    System.out.print("탐색 할 값을 넣어주세요 : ");
                    Data = scanner.nextInt();
                    Binary.search(Binary,Data);
                    break;
                case 2:
                    System.out.print("삽입 할 값을 넣어주세요 : ");
                    Data = scanner.nextInt();
                    Binary.Insert(Binary,Data);
                    break;
                case 3:
                    System.out.print("삭제 할 값을 넣어주세요 : ");
                    Data = scanner.nextInt();
                    Binary.Delete(Binary,Data);
                    break;
            }
        }
    }
}