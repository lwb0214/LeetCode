//1.取出一个字符串的所有子串
void getAllSubstring(string s, vector<string>& res) {
	int len = s.size();
	for (int i = 0; i < len; i++) {
		for (int j = 1; j <= len - i; j++) {
			res.emplace_back(s.substr(i, j));	//substr(i,j) 从i开始，长度为j
		}
	}
}

//2.最长无重复子串/列出字符串所有的无重复子串
int lenOfLongestSubstr(string s, vector<string>& res) {
	unordered_map<char, int> m;
	int len = s.size();

	//初始化，便于迭代的进行
	for (int i = 0; i < len; ++i)
		m[s[i]] = -1;	
	int Max = 0, pre = -1;

	for (int i = 0; i < len; ++i)
	{	//上一次起点的前一位（初始为-1） 与 这一次的字符上一次出现的位置（如果是第一次出现，则m[s[i]]=-1）
		//如果不是第一次出现，则将pre移动到这个字符上一次出现的位置
		pre = max(pre, m[s[i]]);
		//Max记录目前的最长子串的长度，i-pre为当前无重复子串长度
		Max = max(i - pre, Max);
		//将无重复子串（起点下标为pre+1，长度为i-pre）存入向量res
		res.emplace_back(s.substr(pre + 1, i - pre));
		//更新本次字符的值（键值对：key为字符，值为其下标）,以便以后的循环更新pre的值
		m[s[i]] = i;
	}
	return Max;
}

//3.最长重复（出现）子串（做法与1类似）
string longestRepSubstr(const string& str)
{
	string maxstr,subs;
	int len = str.size();
	int front,back;
	for (int i = 0; i < len; ++i)
		for (int j = 1; j <= len - i; j++)
		{
			subs = str.substr(i, j);
			front = str.find(subs);
			back = str.rfind(subs);
			if (front != back && subs.size() > maxstr.size())
				maxstr = subs;
		}
	return maxstr;
}

//4.寻找子串（连续、无顺序） 暴力+哈希
vector<int> findSubstr(string s, vector<string>& words)
{
    vector<int> res;
    if (s.empty() || words.empty())
        return res;
    int wordNum=words.size(),wordLen = words[0].size(),sLen=s.size();
    if (sLen < wordNum * wordLen)
        return res;

    //用need存储向量容器words中各字符串出现的次数
    unordered_map<string, int> need;    
    for (string t : words)
        need[t]++;
    //遍历字符串，用window存储所期待的字符串出现的次数
    for (int i = 0; i <= sLen - wordNum * wordLen; ++i) {
        int cnt = 0;
        int begin = i;
        int match = 0;  //
        unordered_map<string, int> window;
        while (cnt < wordNum) {
            string str = s.substr(begin, wordLen);
            cnt++;
            begin += wordLen;
            if (need.count(str)) {
                window[str]++;
                if (window[str] == need[str])
                    match++;
                else if (window[str] > need[str]) {
                    match--;
                    break;
                }
            }
            else
                break;
        }
        if (match == need.size())   //match==need.size()说明words中的每个字符串都匹配成功
            res.emplace_back(i);
    }
    return res;
}
//解法2 滑动窗口
vector<int> findSubstr(string s, vector<string>& words)
{
    unordered_map<string, int> need;
    vector<int> ret;
    if (s.empty() || words.empty()) return ret;
    int wordNum = words.size(), wordLen = words[0].size();
    int allLen = wordNum * wordLen;
    if (allLen > s.size()) return ret;
    // 统计word次数
    for (string s : words)
        need[s] ++;

    //用一个变长的window（左下标为left，右下标为right）遍历所有可能的组合
    //因为每次移动一个wordLen的长度，所以外循环只需从0到WordLen-1
    for (int i = 0; i < wordLen; ++i) {
        int cnt = 0;
        int left = i, right = i;
        unordered_map<string, int> window;
        while (right + wordLen <= s.size()) {
            string lastWord = s.substr(right, wordLen);
            right += wordLen;
            window[lastWord] ++;
            cnt++;
            while (window[lastWord] > need[lastWord]) { //滑动窗向右移动
                string firstWord = s.substr(left, wordLen);
                left += wordLen;
                window[firstWord] --;
                cnt--;
            }
            if (cnt == wordNum)
                ret.emplace_back(left);
        }
    }
    return ret;
}

//5.判断字符是否唯一
 bool isUnique(string astr) {
        int asLen=astr.size();
        unordered_map<char,int> m;

        for(int i=0;i<asLen;i++){
            m[astr[i]]++;
            if(m[astr[i]]>1)    return false;
        }

        return true;
    }
	