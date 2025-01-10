public class TechPriest extends Adventurer{
  int faith, faithMax;
  String machine_god;

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

  public String attack(Adventurer other){

  }


  public String specialAttack(Adventurer other){

  }

  public String support(Adventurer other){

  }

  public String support(){

  }    
}