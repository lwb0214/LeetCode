public int romanToInt(String s) {
    if(s == null || s.length()==0){
        return 0;
    }

    int result=0;
    if(s.indexOf("CM")!=-1) result-=200;
    if(s.indexOf("CD")!=-1) result-=200;
    if(s.indexOf("XC")!=-1) result-=20;
    if(s.indexOf("XL")!=-1) result-=20;
    if(s.indexOf("IX")!=-1) result-=2;
    if(s.indexOf("IV")!=-1) result-=2;

    for(char c:s.toCharArray()){
        if(c=='M') result+=1000;
        else if(c=='D') result+=500;
        else if(c=='C') result+=100;
        else if(c=='L') result+=50;
        else if(c=='X') result+=10;
        else if(c=='V') result+=5;
        else if(c=='I') result+=1;
    }

    return result;
}