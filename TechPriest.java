public class TechPriest extends Adventurer{
  int faith, faithMax;

  public TechPriest(String name, int hp, String machine){
    super(name,hp); // 60 hp
    faithMax = 100;
    faith = 20;
  }

  public String getSpecialName(){
    return "Faith";
  }

  public int getSpecial(){
    return faith;
  }

  public void setSpecial(int n){
    if (n < 0){
      faith = 0;
    }
    else if (n > faithMax){
      faith = faithMax;
    }
    else{
      faith = n;
    }
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
