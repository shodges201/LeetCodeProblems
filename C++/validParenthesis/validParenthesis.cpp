#include<stack>
#include<map>
#include<string>
#include<iostream>

bool isOpen(char c)
{
    if (c == '(' || c == '[' || c == '{')
    {
        return true;
    }
    return false;
}

bool isValid(std::string s)
{
    int length = s.length();

    if (length == 0)
    {
        return true;
    }
    if (length % 2 != 0)
    {
        return false;
    }

    std::stack<char> stack;
    std::map<char, char> map;

    map.insert(std::pair<char, char>('(', ')'));
    map.insert(std::pair<char, char>('[', ']'));
    map.insert(std::pair<char, char>('{', '}'));

    for (int i = 0; i < length; i++)
    {
        char c = s[i];
        if (isOpen(c))
        {
            stack.push(c);
        }
        else
        {
            if (stack.empty())
            {
                return false;
            }
            else if (map.find(stack.top())->second != c)
            {
                return false;
            }
            else
            {
                stack.pop();
            }
        }
    }
    if (stack.empty())
    {
        return true;
    }
    return false;
}

int main(){
    std::string test1 = "(((((())))))";
    std::string test2 = "(((((((()";
    std::cout << "test 1 with string " << test1 << " returned a result of " << (isValid(test1) == 1 ? "true" : "false") << "\n";
    std::cout << "test 2 with string " << test2 << " returned a result of " << (isValid(test2) == 1 ? "true" : "false") << "\n";
}