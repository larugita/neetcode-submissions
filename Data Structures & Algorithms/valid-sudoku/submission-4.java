class Solution {
    public boolean isValidSudoku(char[][] board) {

        for(int i = 0; i < 9; i++){
            HashSet<Character> set = new HashSet<>();
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.') continue;
                if(set.contains(board[i][j])) return false;
                set.add(board[i][j]);
            }
        }

        for(int i = 0; i < 9; i++){
            HashSet<Character> set = new HashSet<>();
            for(int j = 0; j < 9; j++){
                if(board[j][i] == '.') continue;
                if(set.contains(board[j][i])) return false;
                set.add(board[j][i]);
            }
        }

        for(int boxrow = 0; boxrow < 9; boxrow += 3){
            for(int boxcol = 0; boxcol < 9; boxcol += 3){
                HashSet<Character> set = new HashSet<>();
                for(int i = 0; i < 3; i++){
                    for(int j = 0; j < 3; j++){
                        char c = board[boxrow + i][boxcol + j];
                        if(c == '.') continue;
                        if(set.contains(c)) return false;
                        set.add(c);
                    }
                }
            }
        }

        return true;
        
    }
}
