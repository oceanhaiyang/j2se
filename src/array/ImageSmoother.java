package array;

/**
     题目给了我们一个2d M array，让我们平滑处理图片。对于每一个cell，把它更新为 以自身为中心 3x3 的平均值。
 就用常规方法做，新设一个 res[][] array，遍历M，对于每一个cell， 遍历以它为中心的3x3的cells，得到平均值，存入res。
 需要注意的就是，3x3的边界问题。
 */

public class ImageSmoother {

    public static void main(String[] args) throws Exception {
        int[][] M = {{1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        int[] [] N = new ImageSmoother().imageSmoother(M);
        for (int i = 0; i < N.length; i++) {
            for (int j = 0; j < N[0].length; j++) {
                System.out.print(N[i][j]+" ");
            }
        }
    }

    public int[][] imageSmoother(int[][] M)
    {
        int rows = M.length;
        int cols = M[0].length;
        int[][] res = new int[rows][cols];

        for(int i=0; i<rows; i++)
        {
            for(int j=0; j<cols; j++)
            {
                int sum = 0;
                int count = 0;

                for(int x=Math.max(0,i-1); x<=Math.min(rows-1, i+1); x++)
                {
                    for(int y=Math.max(0, j-1); y<=Math.min(cols-1, j+1); y++)
                    {
                        sum += M[x][y];
                        count++;
                    }
                }

                res[i][j] = sum / count;
            }
        }

        return res;
    }

    }