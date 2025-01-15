public class OpenAIEmployee extends Adventurer{
  int paycheck, paycheckMax;

  /*the other constructors ultimately call the constructor
  *with all parameters.*/
  public OpenAIEmployee(String name, int hp){
    super(name,hp);
    paycheckMax =100;
    paycheck = 50;
  }

  /*The next 8 methods are all required because they are abstract:*/
  public String getSpecialName(){
    return "paycheck";
  }

  public int getSpecial(){
    return paycheck;
  }

  public void setSpecial(int n){
    if (n < 0){
      paycheck = 0;
    }
    else if (n > paycheckMax){
      paycheck = paycheckMax;
    }
    else{
      paycheck = n;
    }
  }

  public int getSpecialMax(){
    return paycheckMax;
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
