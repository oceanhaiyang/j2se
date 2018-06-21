package thinking_java;

public class jiugongge{
    public static void main(String[]args){
        int k = 3;
        int arr[][] =new int [k][k];
        int a =2,b=k/2;
        for (int i=1;i<=k*k;i++){
            arr[a++][b++]=i;
            if(i%k == 0){
                a=a-2;
                b=b-1;
            }else{
                a=a%k;
                b=b%k;
            }
        }
        System.out.println("输出九宫格：");
        for(int i=0;i<k;i++){
            for (int j=0;j<k;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}