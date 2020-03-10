#include <vector>
#include <iostream>

int removeDuplicates(std::vector<int> &nums)
{
    if (nums.empty())
    {
        return 0;
    }
    int length = nums.size();
    int i = 0;
    int currentNum = INT_MIN;
    while (nums[i] != nums.back())
    {
        if (currentNum != nums[i])
        {
            currentNum = nums[i];
            i++;
        }
        else
        {
            nums.erase(nums.begin() + i);
        }
    }
    return i + 1;
}

int main()
{
    int test1[] = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
    std::vector<int> vec1(test1, test1 + sizeof(test1) / sizeof(int));
    int newSize = removeDuplicates(vec1);
    std::cout << "length of array after removal: " << newSize << "\n";
    std::cout << "[";
    for (int i = 0; i < newSize; i++)
    {
        i != newSize-1 ? std::cout << vec1[i] << ", " : std::cout << vec1[i];
    }
    std::cout << "]\n";
}