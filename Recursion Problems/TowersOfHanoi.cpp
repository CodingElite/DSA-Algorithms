#include <bits/stdc++.h>

using namespace std;

void TowersOfHanoi(int Stand_from, int Stand_mid, int Stand_to, int diskNum){
    // Base case: Only one disk
    if (diskNum == 1){
        cout << "Move disk " << diskNum << " from stand " << Stand_from << " to stand " << Stand_to << endl;
        return;
    }
    // Move the current disk to the spare stand
    TowersOfHanoi(Stand_from, Stand_to, Stand_mid, diskNum-1);

    cout << "Move disk "  << diskNum << " from stand " << Stand_from << " to stand " << Stand_to << endl;
    // Move the disk from the spare stand to the required stand
    TowersOfHanoi(Stand_mid, Stand_from, Stand_to, diskNum-1);
}


int main(){
    TowersOfHanoi(1, 2, 3, 3);
    return 0;
}