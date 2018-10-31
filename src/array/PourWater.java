package array;

/**
  Solution:
 Check first left and then right to see if there are any lower levels, if yes then drop the water at this point. Else
 maintain the drop at the start position
 */
public class PourWater {

    /**
     * Main method
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
        int[] A = {2, 1, 1, 2, 1, 2, 2};
        int[] result = new PourWater().pourWater(A, 4, 3);
        for(int i : result){
            System.out.print(i + " ");
        }
    }

    public int[] pourWater(int[] heights, int V, int K) {
        while(V-- > 0){
            heights[K] += 1;
            int index = K;
            int min = heights[K];
            for(int i = K - 1; i >= 0; i--){
                if(heights[i] + 1 > min){
                    break;
                } else if(heights[i] + 1 < min){
                    min = heights[i] + 1;
                    index = i;
                }
            }
            if(index == K){
                for(int i = K + 1; i < heights.length; i++){
                    if(heights[i] + 1 > min){
                        break;
                    } else if(heights[i] + 1 < min){
                        min = heights[i] + 1;
                        index = i;
                    }
                }
            }
            if(index != K){
                heights[K]--;
                heights[index]++;
            }
        }
        return heights;
    }

}
