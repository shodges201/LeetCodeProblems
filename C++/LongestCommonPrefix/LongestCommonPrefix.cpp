#include <string>
#include <vector>
#include <iostream>
using namespace std;

string longestCommonPrefix(vector<string>& strs) {
        int minLength = INT_MAX;
        int numItems = strs.size();
        if(numItems == 0){
            return "";
        }
        else if(numItems == 1){
            return strs[0];
        }
        for(int i = 0; i < numItems; i++){
            if(strs[i].size() < minLength){
                minLength = strs[i].size();
            }
        }
        
        string s = "";
        bool noEqual = false;
        int i = 0;
        while(i < minLength && !noEqual){
            char c = strs[0][i];
            for(int j = 1; j < numItems; j++){
                if(strs[j][i] != c){
                    noEqual = true;
                    break;
                }
            }
            if(!noEqual){
                s += c;
            }
            i++;
        }
        return s;
    }

int main(){
    vector<string> v;
    v.push_back("flower");
    v.push_back("flow");
    v.push_back("flight");
    cout << longestCommonPrefix(v) << "\n";
}