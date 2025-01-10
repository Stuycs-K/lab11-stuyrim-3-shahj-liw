public class MadAlchemist extends Adventurer{
  int toxicity, toxicityMax;
  String chemistry;

  public MadAlchemist(String name, int hp, String machine){
    super(name,hp);
    toxicityMax = 100;
    toxicity = toxicityMax/2;
    chemistry=machine;
  }

  public MadAlchemist(String name, int hp){
    this(name,hp,"Organic Chemistry");
  }

  public MadAlchemist(String name){
    this(name,24);
  }

  public MadAlchemist(){
    this("Louis Pasteur");
  }

  public String getSpecialName(){
    return "toxicity";
  }

  public int getSpecial(){
    return toxicity;
  }

  public void setSpecial(int n){
    toxicity = n;
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