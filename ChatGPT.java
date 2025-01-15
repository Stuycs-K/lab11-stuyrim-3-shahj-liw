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

  // remove free image upload: deals 35 damage and restores 10 serverDownPercentage
  public String attack(Adventurer other){
    int damage = 35;
    other.applyDamage(damage);
    restoreSpecial(10);
    return this + " removed free image upload permissions for "+ other + ", dealing "+ damage +
    " points of damage. While attacking, " + this + "'s serverDownPercentage increases by 10'.";
  }

  // Crash before finals: deals 99 damage using 100 serverDownPercentage
  public String specialAttack(Adventurer other){
    if(getSpecial() >= 100){
      setSpecial(getSpecial()-100);
      int damage = 99;
      other.applyDamage(damage);
      return this + "'s serverDownPercentage has reached its maximum and Crashes before Finals to deal "+ damage
      + " to " + other + "!";
    }else{
      return "Not enough serverDownPercentage to Crash before Finals. Instead, "+ attack(other);
    }
  }

  
  public String support(Adventurer other){
    int amount = 10;
    restoreSpecial(amount);
    return this + " tries to restore 10 special to an ally, but realizes it has none! ChatGPT gains 10 serverDownPercentage instead.";
  }

  public String support(){
    int amount =  15;
    restoreSpecial(amount);
    return this + " sabotages its servers during battle and restores " + amount
    + " serverDownPercentage.";
  }
}
