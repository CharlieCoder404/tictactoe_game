import java.util.Random;
import java.util.Scanner;

public class ticTacToeGame {
    public static void main(String[] args) {
        while(true) {

            // Heading
            System.out.println("Welcome to the game of TIC-TAC-TOE !!!");
            System.out.println("Starting the game......");

            // Showing positions
            System.out.println("Select positions as shown below : ");
            System.out.print("  "+1+"  ");
            System.out.print("  "+2+"  ");
            System.out.print("  "+3+"  \n");
            System.out.print("  "+4+"  ");
            System.out.print("  "+5+"  ");
            System.out.print("  "+6+"  \n");
            System.out.print("  "+7+"  ");
            System.out.print("  "+8+"  ");
            System.out.print("  "+9+"  \n");
            System.out.println();

            // The modes :
            System.out.println("Select the mode you want to play : ");
            System.out.println("1.Single Player");
            System.out.println("2.Multi Player");
            System.out.println();

            // Selecting the mode :
            Scanner modeInput = new Scanner(System.in);
            System.out.print("Enter the option no. : ");
            int mode = modeInput.nextInt();
            System.out.println("\n");

            // Pre-defined values
            boolean flag = true;
            int[] temp = {2, 2, 2};
            int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2,};
            int[][] winPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
                    {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
                    {0, 4, 8}, {2, 4, 6}};
            int player = 1;
            String status = "X's Turn";


            // Stating the game
            if(mode==1){
                while (flag) {
                    if(player==1) {
                        // Showing the grid
                        for (int a = 0; a <= 8; a++) {
                            if (gameState[a] == 0) {
                                System.out.print("  o  ");
                            } else if (gameState[a] == 1) {
                                System.out.print("  x  ");
                            } else if (gameState[a] == 2) {
                                System.out.print("  -  ");
                            }
                            if (a == 2 || a == 5) {
                                System.out.println();
                            }
                        }
                        System.out.println("\n");
                    }

                    // Selecting position for user input
                    if(player==1) {
                        System.out.println(status);
                        System.out.print("Select a position : ");
                        Scanner input = new Scanner(System.in);
                        int inputPos = input.nextInt();
                        System.out.println();

                        if (gameState[inputPos-1] == 2) {
                            gameState[inputPos-1] = 1;
                            player = 0;
                            status = "O's Turn";
                        }
                    }
                    // Selecting position for bot input
                    else if (player==0) {
                        Random com = new Random();
                        int bot = com.nextInt(8);
                        if (gameState[bot] == 2) {
                            System.out.println("Place selected by bot is : "+bot);
                            gameState[bot] = 0;
                            player = 1;
                            status = "X's Turn";

                            // Showing the grid
                            for (int a = 0; a <= 8; a++) {
                                if (gameState[a] == 0) {
                                    System.out.print("  o  ");
                                } else if (gameState[a] == 1) {
                                    System.out.print("  x  ");
                                } else if (gameState[a] == 2) {
                                    System.out.print("  -  ");
                                }
                                if (a == 2 || a == 5) {
                                    System.out.println();
                                }
                            }
                            System.out.println("\n");
                        } else {
                            player=0;
                        }
                    }
                        // getting the values of gameState
                    for (int i = 0; i <= 7; i++) {
                        for (int j = 0; j <= 2; j++) {
                            temp[j] = gameState[winPositions[i][j]];
                        }

                        // Winning check
                        if (temp[0] == temp[1] && temp[1] == temp[2] && temp[2] != 2) {
                            if (player == 0) {
                                // Showing the grid
                                for (int a = 0; a <= 8; a++) {
                                    if (gameState[a] == 0) {
                                        System.out.print("  o  ");
                                    } else if (gameState[a] == 1) {
                                        System.out.print("  x  ");
                                    } else if (gameState[a] == 2) {
                                        System.out.print("  -  ");
                                    }
                                    if (a == 2 || a == 5) {
                                        System.out.println();
                                    }
                                }
                                System.out.println();

                                System.out.println("Player won.");
                                System.out.println();
                                for (int k = 0; k <= 7; k++) {
                                    gameState[k] = 2;
                                }
                            } else if (player == 1) {
                                // Showing the grid
                                for (int a = 0; a <= 8; a++) {
                                    if (gameState[a] == 0) {
                                        System.out.print("  o  ");
                                    } else if (gameState[a] == 1) {
                                        System.out.print("  x  ");
                                    } else if (gameState[a] == 2) {
                                        System.out.print("  -  ");
                                    }
                                    if (a == 2 || a == 5) {
                                        System.out.println();
                                    }
                                }
                                System.out.println();

                                System.out.println("Bot won.");
                                System.out.println();
                                for (int k = 0; k <= 7; k++) {
                                    gameState[k] = 2;
                                }
                            }
                            flag = false;
                        }
                    }

                    // checking if the match have been a draw
                    int t1 = 0;
                    for (int b = 0; b <= 8; b++) {
                        if (gameState[b] == 2) {
                            t1 = 1;
                        }
                    }
                    if (t1 != 1) {
                        // Showing the grid
                        for (int a = 0; a <= 8; a++) {
                            if (gameState[a] == 0) {
                                System.out.print("  o  ");
                            } else if (gameState[a] == 1) {
                                System.out.print("  x  ");
                            } else if (gameState[a] == 2) {
                                System.out.print("  -  ");
                            }
                            if (a == 2 || a == 5) {
                                System.out.println();
                            }
                        }
                        System.out.println();
                        System.out.println("Match has been a draw.\n");
                        flag = false;
                    }
                }
            }
            else if(mode==2){
                while (flag) {

                    // Showing the grid
                    for (int a = 0; a <= 8; a++) {
                        if (gameState[a] == 0) {
                            System.out.print("  o  ");
                        } else if (gameState[a] == 1) {
                            System.out.print("  x  ");
                        } else if (gameState[a] == 2) {
                            System.out.print("  -  ");
                        }
                        if (a == 2 || a == 5) {
                            System.out.println();
                        }
                    }
                    System.out.println("\n");


                    // Selecting position for inputs
                    System.out.println(status);
                    System.out.print("Select a position : ");
                    Scanner input = new Scanner(System.in);
                    int inputPos = input.nextInt();
                    System.out.println();


                    // Taking Different inputs
                    if (gameState[inputPos-1] == 2) {
                        if (player == 1) {
                            gameState[inputPos-1] = 1;
                            player = 0;
                            status = "O's Turn";
                        } else {
                            gameState[inputPos-1] = 0;
                            player = 1;
                            status = "X's Turn";
                        }
                    }


                    // getting the values of gameState
                    for (int i = 0; i <= 7; i++) {
                        for (int j = 0; j <= 2; j++) {
                            temp[j] = gameState[winPositions[i][j]];
                        }

                        // Winning check
                        if (temp[0] == temp[1] && temp[1] == temp[2] && temp[2] != 2) {
                            if (player == 0) {
                                // Showing the grid
                                for (int a = 0; a <= 8; a++) {
                                    if (gameState[a] == 0) {
                                        System.out.print("  o  ");
                                    } else if (gameState[a] == 1) {
                                        System.out.print("  x  ");
                                    } else if (gameState[a] == 2) {
                                        System.out.print("  -  ");
                                    }
                                    if (a == 2 || a == 5) {
                                        System.out.println();
                                    }
                                }
                                System.out.println();

                                System.out.println("X won.");
                                for (int k = 0; k <= 7; k++) {
                                    gameState[k] = 2;
                                }
                            } else if (player == 1) {
                                // Showing the grid
                                for (int a = 0; a <= 8; a++) {
                                    if (gameState[a] == 0) {
                                        System.out.print("  o  ");
                                    } else if (gameState[a] == 1) {
                                        System.out.print("  x  ");
                                    } else if (gameState[a] == 2) {
                                        System.out.print("  -  ");
                                    }
                                    if (a == 2 || a == 5) {
                                        System.out.println();
                                    }
                                }
                                System.out.println();

                                System.out.println("O won.");
                                for (int k = 0; k <= 7; k++) {
                                    gameState[k] = 2;
                                }
                            }
                            flag = false;
                        }
                    }

                    // checking if the match have been a draw
                    int t1 = 0;
                    for (int b = 0; b <= 8; b++) {
                        if (gameState[b] == 2) {
                            t1 = 1;
                        }
                    }
                    if (t1 != 1) {
                        // Showing the grid
                        for (int a = 0; a <= 8; a++) {
                            if (gameState[a] == 0) {
                                System.out.print("  o  ");
                            } else if (gameState[a] == 1) {
                                System.out.print("  x  ");
                            } else if (gameState[a] == 2) {
                                System.out.print("  -  ");
                            }
                            if (a == 2 || a == 5) {
                                System.out.println();
                            }
                        }
                        System.out.println();
                        System.out.println("Match has been a draw.\n");
                        flag = false;
                    }
                }
            }
            else{
                System.out.println("Choose option correctly.");
                System.out.println("\n");
            }
        }
    }
}
