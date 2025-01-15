public class ChatGPT extends Adventurer{
  int serverDownPercentage, serverDownPercentageMax;

  /*the other constructors ultimately call the constructor
  *with all parameters.*/
  public ChatGPT(String name, int hp){
    super(name,hp);
    serverDownPercentageMax =100;
    serverDownPercentage = 50;
  }

  /*The next 8 methods are all required because they are abstract:*/
  public String getSpecialName(){
    return "serverDownPercentage";
  }

  public int getSpecial(){
    return serverDownPercentage;
  }

  public void setSpecial(int n){
    if (n < 0){
      serverDownPercentage = 0;
    }
    else if (n > serverDownPercentageMax){
      serverDownPercentage = serverDownPercentageMax;
    }
    else{
      serverDownPercentage = n;
    }
  }

  public int getSpecialMax(){
    return serverDownPercentageMax;
  }

  public String attack(Adventurer other){

  }

  public String specialAttack(Adventurer other){

  }

  public String support(Adventurer other){

  }

  public String support(){

  }
}
