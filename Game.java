import java.util.*;
public class Game{
  private static final int WIDTH = 80;
  private static final int HEIGHT = 30;
  private static final int BORDER_COLOR = Text.BLUE;
  private static final int BORDER_BACKGROUND = Text.WHITE + Text.BACKGROUND;

  public static void main(String[] args) {
    run();
  }

  //Display the borders of your screen that will not change.
  //Do not write over the blank areas where text will appear or parties will appear.
  public static void drawBackground(){
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    //YOUR CODE HERE
    for (int i = 1; i <= HEIGHT; i ++){
        for (int j = 1; j <= WIDTH; j++){
            Text.go(i,j);
            if (i == 1 || i == 30 || j == 1 || j == 80){
              System.out.println(Text.colorize(" ", BORDER_COLOR + Text.BACKGROUND));
            }
            else if (i == 7 || i == 24){
              System.out.println(Text.colorize(" ", BORDER_COLOR + Text.BACKGROUND));
            }
            else{
              System.out.println(Text.colorize(" ", BORDER_BACKGROUND));
            }
        }
    }

    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
  }

  //Display a line of text starting at
  //(columns and rows start at 1 (not zero) in the terminal)
  //use this method in your other text drawing methods to make things simpler.
  public static void drawText(String s,int startRow, int startCol){
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    Text.go(startRow, startCol);
    System.out.println(s);
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
  }

  /*Use this method to place text on the screen at a particular location.
  *When the length of the text exceeds width, continue on the next line
  *for up to height lines.
  *All remaining locations in the text box should be written with spaces to
  *clear previously written text.
  *@param row the row to start the top left corner of the text box.
  *@param col the column to start the top left corner of the text box.
  *@param width the number of characters per row
  *@param height the number of rows
  */
  public static void TextBox(int row, int col, int width, int height, String text){
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    //YOUR CODE HERE
    Text.go(row,col);
    int place = 0;
    for (int i = 0; i < height; i++){
      Text.go(row + i, col); // goes to the current row based off i
      for (int j = 0; j < width; j++){ // starts writing
        if (place < text.length()){ // makes sure it doesnt go out of bounds
          System.out.print(text.charAt(place));
          place++; // go to next character in the text string
        }
        else{
          System.out.print(" "); // padding
        }
      }
      System.out.println(""); //moves to next line
    }
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
  }




    //return a random adventurer (choose between all available subclasses)
    //feel free to overload this method to allow specific names/stats.
    public static Adventurer createRandomAdventurer(){
      int selection = (int) (Math.random()*3);
      if (selection == 0){
        return new CyberSamurai("Bob", 100);
      }
      else if (selection == 1){
        return new MadAlchemist("Bobby", 80);
      }
      else {
        return new TechPriest("Bobbete", 60);
      }
    }

    /*Display a List of 2-4 adventurers on the rows row through row+3 (4 rows max)
    *Should include Name HP and Special on 3 separate lines.
    *Note there is one blank row reserved for your use if you choose.
    *Format:
    *Bob          Amy        Jun
    *HP: 10       HP: 15     HP:19
    *Caffeine: 20 Mana: 10   Snark: 1
    * ***THIS ROW INTENTIONALLY LEFT BLANK***
    */
    public static void drawParty(ArrayList<Adventurer> party,int startRow){

      /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
      //YOUR CODE HERE

      int spacing = 30/party.size();
      // names
      for (int i = 0; i < party.size(); i++){
        Text.go(startRow, spacing * i + 1);
        System.out.print(party.get(i).getName());
      }

      // health
      for (int i = 0; i < party.size(); i++){
        Text.go(startRow + 1, spacing * i + 1);
        System.out.print("HP: " + party.get(i).getHP());
      }

      // special
      for (int i = 0; i < party.size(); i++){
        Text.go(startRow + 2, spacing * i + 1);
        System.out.print(party.get(i).getSpecialName() + ": " + party.get(i).getSpecial());
      }

      // blank
      Text.go(startRow + 3, 1);
      System.out.print("LEFT BLANK");

      /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
    }


  //Use this to create a colorized number string based on the % compared to the max value.
  public static String colorByPercent(int hp, int maxHP){
    String output = String.format("%2s", hp+"")+"/"+String.format("%2s", maxHP+"");
    //COLORIZE THE OUTPUT IF HIGH/LOW:
    if(maxHP*0.25>hp){
      System.out.print(Text.colorize(output, Text.RED));
    }
    else if(maxHP*0.75>hp){
      System.out.print(Text.colorize(output,Text.YELLOW));
    }
    else{
      System.out.print(Text.colorize(output,Text.WHITE));
    }
    // under 25% : red
    // under 75% : yellow
    // otherwise : white
    return output;
  }





  //Display the party and enemies
  //Do not write over the blank areas where text will appear.
  //Place the cursor at the place where the user will by typing their input at the end of this method.
  public static void drawScreen(){

    drawBackground();

    //draw player party

    //draw enemy party

  }

  public static String userInput(Scanner in){
      //Move cursor to prompt location

      //show cursor

      String input = in.nextLine();

      //clear the text that was written

      return input;
  }

  public static void quit(){
    Text.reset();
    Text.showCursor();
    Text.go(32,1);
  }

  public static void run(){
    //Clear and initialize
    Text.hideCursor();
    Text.clear();


    //Things to attack:
    //Make an ArrayList of Adventurers and add 1-3 enemies to it.
    //If only 1 enemy is added it should be the boss class.
    //start with 1 boss and modify the code to allow 2-3 adventurers later.
    ArrayList<Adventurer>enemies = new ArrayList<Adventurer>();
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    //YOUR CODE HERE
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

    //Adventurers you control:
    //Make an ArrayList of Adventurers and add 2-4 Adventurers to it.
    ArrayList<Adventurer> party = new ArrayList<>();
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    //YOUR CODE HERE
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

    boolean partyTurn = true;
    int whichPlayer = 0;
    int whichOpponent = 0;
    int turn = 0;
    String input = "";//blank to get into the main loop.
    Scanner in = new Scanner(System.in);
    //Draw the window border

    //You can add parameters to draw screen!
    drawScreen();//initial state.

    //Main loop

    //display this prompt at the start of the game.
    String preprompt = "Enter command for "+party.get(whichPlayer)+": attack/special/quit";

    while(! (input.equalsIgnoreCase("q") || input.equalsIgnoreCase("quit"))){
      //Read user input
      input = userInput(in);

      //example debug statment
      TextBox(24,2,1,78,"input: "+input+" partyTurn:"+partyTurn+ " whichPlayer="+whichPlayer+ " whichOpp="+whichOpponent );

      //display event based on last turn's input
      if(partyTurn){

        //Process user input for the last Adventurer:
        if(input.equals("attack") || input.equals("a")){
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          //String attacked=userInput();
          //input.attack(attacked);//Fix, not quite right I think but should be a placeholder
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        }
        else if(input.equals("special") || input.equals("sp")){
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          //String specialed=userInput();
          //input.special(specialed);//Fix, not quite right I think but should be a placeholder
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        }
        else if(input.startsWith("su ") || input.startsWith("support ")){
          //"support 0" or "su 0" or "su 2" etc.
          //assume the value that follows su  is an integer.
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          //String supported=userInput();
          //input.support(supported);//Fix, not quite right I think but should be a placeholder
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        }

        //You should decide when you want to re-ask for user input
        //If no errors:
        whichPlayer++;


        if(whichPlayer < party.size()){
          //This is a player turn.
          //Decide where to draw the following prompt:
          String prompt = "Enter command for "+party.get(whichPlayer)+": attack/special/quit";


        }else{
          //This is after the player's turn, and allows the user to see the enemy turn
          //Decide where to draw the following prompt:
          String prompt = "press enter to see monster's turn";

          partyTurn = false;
          whichOpponent = 0;
        }
        //done with one party member
      }else{
        //not the party turn!


        //enemy attacks a randomly chosen person with a randomly chosen attack.z`
        //Enemy action choices go here!
        /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
        //YOUR CODE HERE
        /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/


        //Decide where to draw the following prompt:
        String prompt = "press enter to see next turn";

        whichOpponent++;

      }//end of one enemy.

      //modify this if statement.
      if(!partyTurn && whichOpponent >= enemies.size()){
        //THIS BLOCK IS TO END THE ENEMY TURN
        //It only triggers after the last enemy goes.
        whichPlayer = 0;
        turn++;
        partyTurn=true;
        //display this prompt before player's turn
        String prompt = "Enter command for "+party.get(whichPlayer)+": attack/special/quit";
      }

      //display the updated screen after input has been processed.
      drawScreen();


    }//end of main game loop


    //After quit reset things:
    quit();
  }
}
