class Solution {
    public boolean isValidSudoku(char[][] board) {

        for(int i = 0; i < 9; i++){
            HashSet<Character> set = new HashSet<>();
            for(int j = 0; j < 9; j++){
                char val = board[i][j];
                if(val == '.') continue;
                if(set.contains(val)) return false;
                set.add(val);
            }
        }

        for(int i = 0; i < 9; i++){
            HashSet<Character> set = new HashSet<>();
            for(int j = 0; j < 9; j++){
                char val = board[j][i];
                if(val == '.') continue;
                if(set.contains(val)) return false;
                set.add(val);
            }
        }

        for (int boxRow = 0; boxRow < 9; boxRow += 3) {        // 0, 3, 6
            for (int boxCol = 0; boxCol < 9; boxCol += 3) {    // 0, 3, 6
                HashSet<Character> set = new HashSet<>();
                // now visit the 3x3 cells starting at (boxRow, boxCol)
                for (int r = 0; r < 3; r++) {
                    for (int c = 0; c < 3; c++) {
                        char val = board[boxRow + r][boxCol + c];
                        if(val == '.') continue;
                        if(set.contains(val)) return false;
                        set.add(val);
                    }
                }
            }
        }

        return true;
             
    }
}
