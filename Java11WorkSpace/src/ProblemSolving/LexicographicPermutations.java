package ProblemSolving;

/**
 * Input: -
 * set[] = {'a', 'b'}, n = 3
 *
 * Output:
 * aaa
 * aab
 * aba
 * abb
 * baa
 * bab
 * bba
 * bbb
 */
public class SequenceFinder {
    public static void main(String[] args) {
        char a[] = {'a','b'};
        for(int i=0;i<a.length;i++){
            for(int j=1;j<a.length;j++){
                if(a[j] + a[i] == 5){
                    System.out.println(a[i] + ", "+ a[j]);
                }
            }
        }
    }
}
