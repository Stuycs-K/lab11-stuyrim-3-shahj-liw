import java.util.*;

import javax.swing.text.DefaultStyledDocument.ElementSpec;
public class Game{
  private static final int WIDTH = 80;
  private static final int HEIGHT = 30;
  private static final int BORDER_COLOR = Text.BLUE;
  private static final int BORDER_BACKGROUND = Text.BLACK + Text.BACKGROUND;

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
          String output = "" + text.charAt(place);
          System.out.print(Text.colorize(output, Text.WHITE));
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
        return new CyberSamurai("Vanna", 100);
      }
      else if (selection == 1){
        return new MadAlchemist("Jai", 80);
      }
      else {
        return new TechPriest("William", 60);
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

      int spacing = 30;
      // names
      for (int i = 0; i < party.size(); i++){
        Text.go(startRow, spacing * i + 3);
        System.out.print(party.get(i).getName());
      }

      // health
      for (int i = 0; i < party.size(); i++){
        Text.go(startRow + 1, spacing * i + 3);
        System.out.print("HP: " + colorByPercent(party.get(i).getHP(), party.get(i).getmaxHP()));
      }

      // special
      for (int i = 0; i < party.size(); i++){
        Text.go(startRow + 2, spacing * i + 3);
        System.out.print(party.get(i).getSpecialName() + ": " + party.get(i).getSpecial() + "/" + party.get(i).getSpecialMax());
      }

      /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

      Text.go(32, 1);
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



  public static Adventurer p1=createRandomAdventurer();
  public static Adventurer p2=createRandomAdventurer();
  public static Adventurer p3=createRandomAdventurer();
  public static Adventurer p1e= new OpenAIEmployee("OpenAI Employee 0", 75);
  public static Adventurer p2e= new ChatGPT("AM", 140);
  public static Adventurer p3e= new OpenAIEmployee("OpenAI Employee 2", 75);
  //Display the party and enemies
  //Do not write over the blank areas where text will appear.
  //Place the cursor at the place where the user will by typing their input at the end of this method.
  public static void drawScreen(){

    drawBackground();

    //draw player party
    ArrayList<Adventurer> party = new ArrayList<Adventurer>();
    party.add(p1);
    party.add(p2);
    party.add(p3);

    drawParty(party, 2);

    //draw enemy party

    ArrayList<Adventurer> enemies= new ArrayList<Adventurer>();
    enemies.add(p1e);
    enemies.add(p2e);
    enemies.add(p3e);
    drawParty(enemies, 25);
  }

  public static String userInput(Scanner in){
      //Move cursor to prompt location
      Text.go(15, 3);
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
    enemies.add(p1e);
    enemies.add(p2e);
    enemies.add(p3e);
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

    //Adventurers you control:
    //Make an ArrayList of Adventurers and add 2-4 Adventurers to it.
    ArrayList<Adventurer> party = new ArrayList<>();
  
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    party.add(p1);
    party.add(p2);
    party.add(p3);
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
    System.out.println("Controls:");
    System.out.println("End game: q/quit");
    System.out.println("Attack: a/attack");
    System.out.println("Special: sp/special");
    System.out.println("Ally support: asu/allysupport");
    System.out.println("Self support: ssu/selfsupport");

    //Main loop

    //display this prompt at the start of the game.
    String preprompt = "Enter command for "+party.get(whichPlayer)+": attack/special/quit";

    while(! (input.equalsIgnoreCase("q") || input.equalsIgnoreCase("quit"))){
      //Read user input
      input = userInput(in);

      //example debug statment
      TextBox(9,3,50,1,"input: "+input+" partyTurn:"+partyTurn+ " whichPlayer="+whichPlayer+ " whichOpp="+whichOpponent );

      //display event based on last turn's input
      if(partyTurn){

        //Process user input for the last Adventurer:
        if(input.equals("attack") || input.equals("a")){
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          TextBox(10,3,50,1, "Which enemy? Type in 0-2, based on positioning" );
          try{
            int hit = Integer.parseInt(userInput(in));
            if (hit >= 0 && hit < enemies.size()){
              String text = party.get(whichPlayer).attack(enemies.get(hit));
              drawScreen();
              TextBox(16,3,75,2,text);
            }
            else{
              TextBox(16,3,75,1, "No valid enemy selected");
            }
          } catch (IllegalArgumentException e){
            TextBox(16,3,75,1, "Input a valid number");
          }
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        }
        else if(input.equals("special") || input.equals("sp")){
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          TextBox(10,3,50,1, "Which enemy? Type in 0-2, based on positioning" );
          try{
            int hit = Integer.parseInt(userInput(in));
            if (hit >= 0 && hit < enemies.size()){
              String text = party.get(whichPlayer).specialAttack(enemies.get(hit));
              drawScreen();
              TextBox(16,3,75,2,text);
            }
            else{
              TextBox(16,3,75,1,"No valid enemy selected");
            }
          } catch (IllegalArgumentException e){
            TextBox(16,3,75,1,"Input a valid number");
          }
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        }
        else if(input.startsWith("asu") || input.startsWith("allysupport")){
          //"support 0" or "su 0" or "su 2" etc.
          //assume the value that follows su  is an integer.
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          TextBox(10,3,50,1, "Which ally? Type in 0-2, based on positioning" );
          try{
            int help = Integer.parseInt(userInput(in));
            if (help >= 0 && help < party.size()){
              String text = party.get(whichPlayer).support(party.get(help));
              drawScreen();
              TextBox(16,3,75,2,text);
            }
            else{
              TextBox(16,3,75,1,"No valid ally selected");
            }
          } catch (IllegalArgumentException e){
            TextBox(16,3,75,1,"Input a valid number");
          }
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        }
        else if(input.startsWith("ssu") || input.startsWith("selfsupport")){

          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
            String text = party.get(whichPlayer).support();
            drawScreen();
            TextBox(16,3,75,2,text);
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        }

        if(party.get(whichPlayer).getHP()<=0){
          TextBox(16,3,75,2,party.get(whichPlayer).getName()+" is dead. RIP.")
          party.remove(whichPlayer);
          if(whichPlayer>=party.size()){
            whichPlayer=0;
          }
        }

        //You should decide when you want to re-ask for user input
        //If no errors:
        whichPlayer++;
        if(party.isEmpty()){
          TextBox(16,3,75,2,"Everyone is dead. You have no mouth and you must scream. Game Over.");
          break; //How do we do it without break?
        }

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
        Random rand=new Random();
        int ActionNumber=rand.nextInt(3);
        if(ActionNumber==0){
            int hit = rand.nextInt(party.size());
            String text = enemies.get(whichOpponent).attack(party.get(hit));
            drawScreen();
            TextBox(16,3,75,2,text);
        }
        else if (ActionNumber==1){
            int special = rand.nextInt(party.size());
            String text = enemies.get(whichOpponent).specialAttack(party.get(special));
            drawScreen();
            TextBox(16,3,75,2,text);
        }
        else if(ActionNumber==2){
            int heal = rand.nextInt(enemies.size());
            String text = enemies.get(whichOpponent).support(enemies.get(heal));
            drawScreen();
            TextBox(16,3,75,2,text);
        }
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
      //drawScreen();


    }//end of main game loop


    //After quit reset things:
    quit();
  }
}
