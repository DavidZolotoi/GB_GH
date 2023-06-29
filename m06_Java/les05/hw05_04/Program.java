/*
 * На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.
 */
package q01m09_Java.les05.hw05_04;
public class Program
{
    static int[] chessboard = {0,0,0,0,0,0,0,0};
    static int index = 0;
    static int version = 0;

    public static void main(String[] args){

        do {
            if (checking()){
                if (index == 7) {
                    System.out.println
                    (
                        "(x, y)" + "v" + version++ + ":  " + 
                        "(" + chessboard[0] + ", 0); " + 
                        "(" + chessboard[1] + ", 1); " + 
                        "(" + chessboard[2] + ", 2); " + 
                        "(" + chessboard[3] + ", 3); " + 
                        "(" + chessboard[4] + ", 4); " + 
                        "(" + chessboard[5] + ", 5); " + 
                        "(" + chessboard[6] + ", 6); " + 
                        "(" + chessboard[7] + ", 7); "
                    );
                    chessboard[index]++;
                }
                else {
                    index++;
                }
            }
            else {
                chessboard[index]++;
            }
        } while (chessboard[0]<8);
    }

    static boolean checking() {
        int i;

        if (index == 0) {
            return true;
        }

        if (chessboard[index]>7){
            chessboard[index] = 0;
            index--;
            return false;
        }

        for (i=0;i<index;i++){
            if ((chessboard[index] == chessboard[i])|((Math.abs(chessboard[index] - chessboard[i])) == (index-i))){
                return false;
            }
        }

        return true;
   }
}
