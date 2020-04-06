//十进制转换为x（x<10）进制
void tenToX(int n, int x)
{
	if (n == 0)
		cout << 0;
	int y;
	stack<int> ans;
	while (n != 0)
	{
		y = n % x;
		n /= x;
		ans.push(y);
	}
	int size = ans.size();
	for (int i = 0; i < size; i++)
	{
		cout << ans.top();
		ans.pop();
	}
}