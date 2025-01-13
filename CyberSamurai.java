public class CyberSamurai extends Adventurer{
  int focus, focusMax;

  /*the other constructors ultimately call the constructor
  *with all parameters.*/
  public CyberSamurai(String name, int hp){
    super(name,hp);
    focusMax =100;
    focus = 50;
  }

  /*The next 8 methods are all required because they are abstract:*/
  public String getSpecialName(){
    return "Focus";
  }

  public int getSpecial(){
    return focus;
  }

  public void setSpecial(int n){
    if (n < 0){
      focus = 0;
    }
    else if (n > focusMax){
      focus = focusMax;
    }
    else{
      focus = n;
    }
  }

  public int getSpecialMax(){
    return focusMax;
  }

  /*Deal 20-25 damage to opponent, restores 10 focus*/
  public String attack(Adventurer other){
    int damage = (int)(Math.random()*6)+20;
    other.applyDamage(damage);
    restoreSpecial(10);
    return this + " cyber sliced "+ other + " and dealt "+ damage +
    " points of damage. While attacking, " + this + " gathers 10 focus.";
  }

  /*Deal 50-75 damage to opponent, only if focus is high enough.
  *Reduces focus by 50.
  */
  public String specialAttack(Adventurer other){
    if(getSpecial() >= 50){
      setSpecial(getSpecial()-50);
      int damage = (int)(Math.random()*26)+50;
      other.applyDamage(damage);
      return this + " gathers 50 focus to perform Rampage and deals "+ damage
      + " to each enemy!";
    }else{
      return "Not enough focus to Rampage. Instead, "+ attack(other);
    }
  }

  /*Restores 10-15 of allies special*/
  public String support(Adventurer other){
    int amount = (int)(Math.random()*6) + 10;
    return this + " meditates with " + other + ", restoring 10 " + other.getSpecialName()
    + " to " + other.restoreSpecial(amount);
  }

  /*Restores 10-15 focus to self.*/
  public String support(){
    int amount = (int)(Math.random()*6) + 10;
    restoreSpecial(amount);
    return this + " meditates in the midst of battle and restores " + amount
    + " focus.";
  }
}
