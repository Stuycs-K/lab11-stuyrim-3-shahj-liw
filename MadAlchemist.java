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

  /*Deal 15-20 damage to opponent, restores 10 toxicity*/
  public String attack(Adventurer other){
    int damage = (int)(Math.random()*6)+15;
    other.applyDamage(damage);
    restoreSpecial(10);
    return this + " throws an acid potion at "+ other + " and deals "+ damage +
    " points of damage. While attacking, " + this + " gathers 10 toxicity from potion residue.";
  }

  /*Deal 80 damage to opponent, only if toxicity is high enough.
  *Reduces toxicity by 50 and health by 20.
  */
  public String specialAttack(Adventurer other){
    if(getSpecial() >= 50){
      setSpecial(getSpecial()-50);
      int damage = 80;
      other.applyDamage(damage);
      setHP(getHP() - 20);
      return this + " inhales 50 toxicity to release the Elder Dragon's Acid and deals "+ damage 
      + " to " + other + this + " also feels the poison and loses 20 health.";
    }else{
      return "Not enough toxicity to release the Elder Dragon's Acid. Instead, "+ attack(other);
    }

  }

  /*Restores 20 health to ally*/
  public String support(Adventurer other){
    int amount = 20;
    other.setHP(other.getHP() + amount);
    return this + " throws a healing potion at " + other + 
    ", restoring 20 of their health ";
  }

  /*Restores 5-10 toxicity */
  public String support(){
    int amount = (int)(Math.random()*6) + 5;
    restoreSpecial(amount);
    return this + " spends a round mixing potions and gathers " + amount
    + " toxicity.";
  }
}
