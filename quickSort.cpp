public class Main {
    public static void main(String[] args) {
        int[] arr = new int[] {4, 8, 1, 3, 5};
        int len = arr.length;
        quickSort(arr, 0, len-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            Random r = new Random();
            swap(arr, start,start + r.nextInt(end - start + 1));
            int x = arr[start], i = start, j = end;
            while (i < j) {
                while (i < j && arr[j] >= x) {
                    j--;
                }
                if (i < j) {
                    arr[i] = arr[j];
                    i++;
                }
                while (i < j && arr[i] < x) {
                    i++;
                }
                if(i < j) {
                    arr[j] = arr[i];
                    j--;
                }
            }
            arr[i] = x;
            quickSort(arr, start, i-1);
            quickSort(arr, i+1, end);
        }
    }
    public static void swap(int[] arr, int i , int j) {
        if (i == j) return;
        arr[i] = arr[i] - arr[j];
        arr[j] = arr[i] + arr[j];
        arr[i] = arr[j] - arr[i];
    }
}