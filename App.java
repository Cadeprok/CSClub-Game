import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int count = 1;
        String[] Board = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };
        while (count <= 9) {
            if (count >= 5) {
                if (win(Board)) {
                    break;
                }
            }
            System.out.println(
                    "Enter your number (Ex. '1') to select the small board you would like to play in. Please only enter 1 through 9, including both 1 and 9!");

            Scanner inputNum = new Scanner(System.in);
            System.out.println("Player " + getPlayer(count) + " please enter your move (1-9)");
            System.out.println();
            System.out.println(printBoard(Board));
            String UM = inputNum.nextLine();
            int userMove = Integer.parseInt(UM); // userMove is small board that is being played in.
            if ((userMove < 1) || (userMove > 9)) {
                System.out.println("Please enter a valid board to play in!");
            } else if ((Board[userMove - 1] == "P1W") || (Board[userMove - 1] == "P2W")) {
                System.out.println("Please enter a board that has not been played in yet.");
            } else {
                int playerWhoWon = runSmallGame(count);
                if (playerWhoWon == 1) {
                    Board[userMove - 1] = "PW1";
                    count++;
                } else if (playerWhoWon == 2) {
                    Board[userMove - 1] = "PW2";
                    count += 1;
                } else {
                    System.out.println("Nobody won the round!");
                    count--;
                }

            }

        }
        if (win(Board)) {
            int UM = count - 1;
            System.out.println(
                    "Congratulations player " + getPlayer(count) + "on winning the game!");
            System.out.println(printBoard(Board));
            // return getPlayer(count - 1);
        } else {
            System.out.println("No one won the game!");
            // return 0;
        }
    }

    public static int runSmallGame(int count) {
        // int count = 1;
        String[] Board = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };
        System.out.println(
                "Enter your number (Ex. '1') to select which space you would like to obtain. Please only enter 1 through 9, including both 1 and 9!");
        while (count <= 9) {
            if (count >= 6) {
                if (win(Board)) {
                    break;
                }
            }

            Scanner inputNum = new Scanner(System.in);
            System.out.println("Player " + getPlayer(count) + " please enter your move (1-9)");
            System.out.println();
            System.out.println(printBoard(Board));
            String temp = inputNum.nextLine();
            int userMove = Integer.parseInt(temp);
            if (((userMove < 1) || (userMove > 9)) || ((Board[userMove - 1] == "X") || (Board[userMove - 1] == "O"))) {
                System.out.println("Please enter a valid move!");
            } else if (count % 2 != 0) {
                Board[userMove - 1] = "X";
                count++;
            } else {
                Board[userMove - 1] = "O";
                count++;
            }

        }
        if (win(Board)) {
            int temp = count - 1;
            System.out.println(
                    "Congratulations player " + getPlayer(count - 1) + " on winning the match in " + temp + " turns!");
            System.out.println(printBoard(Board));
            return getPlayer(count - 1);
        } else {
            System.out.println("No one won this round!");
            return 0;
        }
    }

    public static boolean win(String[] Arr) {
        return (checkCrossWin(Arr) || checkLRUDWin(Arr));
    }

    public static int getPlayer(int count) {
        if (count % 2 == 0) {
            return 2;
        }
        return 1;
    }

    public static boolean checkCrossWin(String[] Arr) {
        if (Arr[4] == "4") {
            return false;
        } else if ((Arr[0] == Arr[4]) && (Arr[4] == Arr[8])) {
            return true;
        } else if ((Arr[2] == Arr[4]) && (Arr[4] == Arr[6])) {
            return true;
        }
        return false;
    }

    public static boolean checkLRUDWin(String[] Arr) { /* CHECK LEFT RIGHT UP DOWN WIN */
        int x = 1;
        while (x == 1) {
            for (int i = 0; i < 9; i++) {
                if (i == 0) {
                    return (((Arr[i] == Arr[i + 1]) && (Arr[i + 1] == Arr[i + 2]))
                            || ((Arr[i] == Arr[i + 3]) && (Arr[i + 3] == Arr[i + 6])));
                } else {
                    if ((Arr[i] == Arr[i + 3]) && (Arr[i + 3] == Arr[i + 6])) {
                        return true;
                    } else if (i % 3 == 0) {
                        if ((Arr[i] == Arr[i + 1]) && (Arr[i + 1] == Arr[i + 2])) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static String printBoard(String[] Arr) {
        String returnValue = Arr[0] + " | " + Arr[1] + " | " + Arr[2] + "\n" + "----------" + "\n" + Arr[3] + " | "
                + Arr[4] + " | "
                + Arr[5] + "\n" + "----------" + "\n" + Arr[6] + " | " + Arr[7] + " | " + Arr[8] + "\n";

        return returnValue;
    }
}
