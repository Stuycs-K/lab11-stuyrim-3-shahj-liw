public class Boss extends Adventurer{
  int agi, agiMax;

  /*the other constructors ultimately call the constructor
  *with all parameters.*/
  public Boss(String name, int hp){
    super(name,hp);
    agiMax =100;
    agi = 50;
  }

  /*The next 8 methods are all required because they are abstract:*/
  public String getSpecialName(){
    return "Focus";
  }

  public int getSpecial(){
    return agi;
  }

  public void setSpecial(int n){
    if (n < 0){
      agi = 0;
    }
    else if (n > agiMax){
      agi = agiMax;
    }
    else{
      agi = n;
    }
  }

  public int getSpecialMax(){
    return agiMax;
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
