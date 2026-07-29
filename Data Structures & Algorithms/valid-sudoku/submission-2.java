class Solution {
    public boolean isValidSudoku(char[][] board) {

        for(int i = 0; i < 9; i++){
            HashSet<Character> seen = new HashSet<>();
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.') continue;
                if(seen.contains(board[i][j])) return false;
                seen.add(board[i][j]);
            }
        }

        for(int i = 0; i < 9; i++){
            HashSet<Character> seen = new HashSet<>();
            for(int j = 0; j < 9; j++){
                if(board[j][i] == '.') continue;
                if(seen.contains(board[j][i])) return false;
                seen.add(board[j][i]);
            }
        }

        for(int boxrow = 0; boxrow <= 6; boxrow+=3){
            for(int boxcol = 0; boxcol <=6; boxcol+=3){
                HashSet<Character> box = new HashSet<>();
                for(int i = 0; i < 3; i++){
                    for(int j = 0; j < 3; j++){
                        char val = board[boxrow + i][boxcol + j];
                        if(val == '.') continue;
                        if(box.contains(val)) return false;
                        box.add(val);
                    }
                }
            }
        }

        return true;
        
    }
}
