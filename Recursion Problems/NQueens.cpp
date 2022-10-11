#include <bits/stdc++.h>

using namespace std;

const int size = 4;
int board[size][size] = {0};

void printBoard(){
    // Output the state of the board
    for (int i=0; i<size; i++){
        for (int j=0; j<size; j++){
            cout << board[i][j] << " ";
        }
        cout << "\n";
    }
}

bool CheckPossible(int col, int row){
    // Check if there is a queen in the same row
    for (int i=0; i<size; i++){
        if (board[row][i] == 1) {
            cout << "1" << endl;
            return false;
        }
    }

    // Check if there is a queen in the same column
    for (int i=0; i<size; i++){
        if (board[i][col] == 1) {
            cout << "2" << endl;
            return false;
        }
    }

    // Check if there is a queen in the upper right diagonal
    for (int i=row, j=col; i>=0 && j<size; i--, j++){
        if (board[i][j] == 1){
            cout << "3" << endl;
            return false;
        }
    }

    // Check if ther is a queen in the lower right diagonal
    for (int i=row, j=col; i<size && j>=0; i++, j--){
        if (board[i][j] == 1) {
            cout << "4" << endl;
            return false;
        }
    }

    // Check if there is a qeen in the upper left diagonal
    for (int i=row, j=col; i>=0 && j>=0; i--, j--){
        if (board[i][j] == 1)  {
            cout << "5" << endl;
            return false;
        }
    }

    // Check if there is a qeen in the lower left diagonal
    for (int i=row, j=col; i<size && j<size; i++, j++){
        if (board[i][j] == 1){ 
            cout << "6" << endl;
            return false;
        }
    }

    return true; // If there is no queen intersecting the placement of the current queen
}


bool NQueens(int col){
    if (col == size){
        return true;
    }
    // Travers through every row
    for (int i=0; i<size; i++){
        // Check if we can place the queen in the current square
        if (CheckPossible(col, i)){

            // Debugging
            printBoard();
            cout << endl;

            // If it is possible to place the queen place the queen
            board[i][col] = 1;
            printBoard();
            cout << endl;
            // Check we can place another queen in the next column
            if (NQueens(col+1)){
                return true;
            }
            // If not remove the current queen and continue backtracking
            else{
                board[i][col] = 0;
            }
        }
    }
    // If we couldn't find any place for a queen in the current column
    return false;
}



int main(){
    if (NQueens(0)){
        // If we find the solution we print the board
        printBoard();
    }
    else{
        // Otherwise
        cout << "There exists no solution" << endl;
    }
    return 0;
}