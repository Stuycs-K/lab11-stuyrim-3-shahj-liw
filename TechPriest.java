public class TechPriest extends Adventurer{
  int faith, faithMax;
  String machine_god;

  /*the other constructors ultimately call the constructor
  *with all parameters.*/
  public TechPriest(String name, int hp, String machine){
    super(name,hp);
    faithMax = 100;
    faith = faithMax/2;
    machine_god=machine;
  }

  public TechPriest(String name, int hp){
    this(name,hp,"Horus");
  }

  public TechPriest(String name){
    this(name,24);
  }

  public TechPriest(){
    this("OP-1");
  }

  /*The next 8 methods are all required because they are abstract:*/
  public String getSpecialName(){
    return "faith";
  }

  public int getSpecial(){
    return faith;
  }

  public void setSpecial(int n){
    faith = n;
  }

  public int getSpecialMax(){
    return faithMax;
  }

  /*Deal 2-7 damage to opponent, restores 2 caffeine*/
  public String attack(Adventurer other){

  }

  /*Deal 3-12 damage to opponent, only if caffeine is high enough.
  *Reduces caffeine by 8.
  */
  public String specialAttack(Adventurer other){

  }
  /*Restores 5 special to other*/
  public String support(Adventurer other){

  }
  /*Restores 6 special and 1 hp to self.*/
  public String support(){

  }    
}