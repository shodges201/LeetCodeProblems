#include<map>
#include<iostream>
#include<string>

using namespace std;

int romanToInt(string s){
    map<char, int> map;
    map.insert(pair<char, int>('I', 1));
    map.insert(pair<char, int>('V', 5));
    map.insert(pair<char, int>('X', 10));
    map.insert(pair<char, int>('L', 50));
    map.insert(pair<char, int>('C', 100));
    map.insert(pair<char, int>('D', 500));
    map.insert(pair<char, int>('M', 1000));

    int total = 0;

    for (int i = 0; i < s.length(); i++)
    {
        char c = s[i];
        int value = map.find(c)->second;
        int nextValue = map.find(s[i + 1])->second;
        if (nextValue > value)
        {
            total += nextValue - value;
            ++i;
        }
        else
        {
            total += value;
        }
    }
    return total;
}

int main(){
    string x = "MCMXCIV";
    string y = "LVIII";
    cout << "the integer equivalent of " << x << " is: " << romanToInt(x) << "\n";
    cout << "the integer equivalent of " << y << " is: " << romanToInt(y) << "\n";
}