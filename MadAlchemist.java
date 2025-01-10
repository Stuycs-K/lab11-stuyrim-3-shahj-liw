public class MadAlchemist extends Adventurer{
  int toxicity, toxicityMax;

  public MadAlchemist(String name, int hp){
    super(name,hp); // 80 hp
    toxicityMax = 100;
    toxicity = 40;
  }

  public String getSpecialName(){
    return "Toxicity";
  }

  public int getSpecial(){
    return toxicity;
  }

  public void setSpecial(int n){
    if (n < 0){
      toxicity = 0;
    }
    else if (n > toxicityMax){
      toxicity = toxicityMax;
    }
    else{
      toxicity = n;
    }
  }

  public int getSpecialMax(){
    return toxicityMax;
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
