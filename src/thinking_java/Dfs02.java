package thinking_java;

public class Dfs02 {
    public static void main(String[] args){
        char grid[][]  = {{'1','1','0','0','0'},{'1','0','0','0','0'},{'0','1','1','1','0'},
                          {'0','0','0','0','1'}};
        Solution02 solution = new Solution02();
        System.out.println(solution.numIslands(grid));
    }
}
class Solution02{
    public  int numIslands(char[][] grid) {
        int count = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == '1') {
                    dfs(grid, row, col);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int row, int col) {
        if (row >= 0 && row < grid.length && col >= 0 && col < grid[row].length && grid[row][col] == '1') {
            grid[row][col] = '2';
            dfs(grid, row - 1, col);
            dfs(grid, row + 1, col);
            dfs(grid, row, col - 1);
            dfs(grid, row, col + 1);
        }
    }
}