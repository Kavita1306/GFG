class Solution
{
    public:
char nonrepeatingCharacter(const std::string& S) {
    std::unordered_map<char, int> charFrequency;
    for (char c : S) {
        charFrequency[c]++;
    }
    for (char c : S) {
        if (charFrequency[c] == 1) {
            return c;
        }
    }

    // If no non-repeating character found, return '$'
    return '$';
}
};
