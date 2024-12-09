package Fungames;
import java.util.Scanner;

public class snakeladders {
    static int player1 = 0;
    static int player2 = 0;
    public static int RollDice(){
        return (int)(Math.random()*6)+1;
    }
    static void printboard(){
        int[] board = new int[101];
        for (int i = 0; i < 101; i++) {
            board[i] = i;
        }
        int alt = 0;
        int iterLR = 90;
        int iterRL = 91;
        int value = 100;
        while (value-- > 0){
            if (alt == 0){
                iterLR++;
                if (iterLR == player1){
                    System.out.print("#P1    ");
                }
                else if (iterLR == player2){
                    System.out.print("#P2    ");
                }
                else{
                    System.out.print(board[iterLR]);
                    System.out.print("     ");
                }
                if (iterLR % 10 == 0){
                    System.out.print("\n\n");
                    alt = 1;
                    iterLR -= 30;
                }
            }
            else{
                iterRL--;
                if (iterRL == player1){
                    System.out.print("#P1    ");
                }
                else if (iterRL == player2){
                    System.out.print("#P2    ");
                }
                else{
                    System.out.print(board[iterRL]);
                    System.out.print("     ");
                    if (iterRL < 10){
                        System.out.print(" ");

                    }
                }
                if (iterRL % 10 == 1){
                    alt = 0;
                    System.out.print("\n\n");
                    iterRL -= 10;
                }
            }
        }
    }
static int movePlayer(int currestPos, int roll){
        int newpos = currestPos + roll;
        int[] SnakesAndLadders = new int[106];
        for (int i = 0; i < 106; i++){
            SnakesAndLadders[i] = 0;
        }
        SnakesAndLadders[6] = 40; 
        SnakesAndLadders[23] = -10; 
        SnakesAndLadders[45] = -7; 
        SnakesAndLadders[61] = -18; 
        SnakesAndLadders[65] = -8; 
        SnakesAndLadders[77] = 5; 
        SnakesAndLadders[98] = -10; 
        int newsquare = newpos + SnakesAndLadders[newpos];
        if (newsquare > 100){
            System.out.print("Oops try again\n");
            return currestPos;
        }
        return newsquare;
    
    }
    public static void main(String[] args) {
        int currentplayer = 1;
        boolean gg = false;
        Scanner scanner = new Scanner(System.in);
        while (!gg){
            System.out.printf("\nPlayer %d, press Enter to roll the die...\n", currentplayer);
            scanner.nextLine(); 
            int roll = RollDice(); 
            System.out.printf("You rolled a %d.\n", roll);
            if (currentplayer == 1){
                player1 = movePlayer(player1, roll);
                System.out.printf("Player %d is at position %d\n", currentplayer, player1);
                printboard();
                if (player1 == 100){
                    System.out.printf("Player %d wins!", currentplayer);
                    gg = true;
                }
            }
            if (currentplayer == 2){
                player2 = movePlayer(player2, roll);
                System.out.printf("Player %d is at position %d\n", currentplayer, player2);
                printboard();
                if (player2 == 100){
                    System.out.printf("Player %d wins!", currentplayer);
                    gg = true;
                }
            }
            currentplayer = (currentplayer == 1) ? 2 : 1;
            try {
                // Sleep for 100 milliseconds
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace(); // Handle the exception
            }    
        }
        scanner.close();

    }
}
