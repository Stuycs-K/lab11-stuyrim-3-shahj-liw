  public class OpenAIEmployee extends Adventurer{
  int paycheck, paycheckMax;

  /*the other constructors ultimately call the constructor
  *with all parameters.*/
  public OpenAIEmployee(String name, int hp){
    super(name,hp);
    paycheckMax =100;
    paycheck = 20;
  }

  /*The next 8 methods are all required because they are abstract:*/
  public String getSpecialName(){
    return "Paycheck";
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

//  deal 15-20 damage to opponent, restores 10 paycheck
  public String attack(Adventurer other){
    int damage = (int)(Math.random()*6) + 15;
    other.applyDamage(damage);
    restoreSpecial(10);
    return this + " throws a stone at " + other + " and dealt " + damage +
    " points of damage. While attacking, their boss pays them 10 paycheck.";
  }

  public String specialAttack(Adventurer other){
    if (getSpecial() >= 40){
      setSpecial(getSpecial() - 40);
      int damage = (int)(Math.random() * 50);
      other.applyDamage(damage);
      if (damage > 20){
        return this + " saves up all their paychecks to buy a baseball bat and bashes " +
        other + " on the head, dealing " + damage + " damage.";
      }
      else{
        return this + " saves up all their paychecks to buy a baseball bat and tries to bash " +
        other + " on the head, but slightly misses, dealing " + damage + " damage";
      }
    }
    else{
      return "Not enough paychecks to buy a baseball bat. Instead, " + attack(other);
    }
  }

  public String support(Adventurer other){
    int amount = (int)(Math.random()*6) + 10;
    other.restoreSpecial(amount);
    return this + " magically fabricates paychecks and gives them to " + other +
    " to evade the IRS, restoring " + amount + " paychecks to " + other;
  }

  public String support(){
    int amount = (int)(Math.random()*6) + 10;
    restoreSpecial(amount);
    return this + " picks up a few pennies, restoring " + amount + " paychecks";
  }
}
