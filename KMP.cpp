void GetNext(char * p, int next[]) {  
    int pLen = strlen(p);  
    next[0] = -1;  
    int k = -1, j = 0;  
    while (j < pLen - 1) {  
        //p[k]表示前缀，p[j]表示后缀  
        if (k == -1 || p[j] == p[k]) {  
            ++k;  
            ++j;  
            next[j] = k;  
        } else {  
            k = next[k];  
        }  
    }  
}

int KmpSearch(char * s, char * p, int next[]) {  
    int i = 0, j = 0;  
    int sLen = strlen(s), pLen = strlen(p);  
    while (i < sLen && j < pLen) {  
        //1.如果j = -1，或者当前字符匹配成功（即S[i] == P[j]），都令i++，j++      
        if (j == -1 || s[i] == p[j]) {  
            i++;  
            j++;  
        } else {  
            //2.如果j != -1，且当前字符匹配失败（即S[i] != P[j]），则令 i 不变，j = next[j]      
            //next[j]即为 j 所对应的next值        
            j = next[j];  
        }  
    }  
    if (j == pLen) {
        return i - j;  
    } else {
        return -1;  
    }  
}  
