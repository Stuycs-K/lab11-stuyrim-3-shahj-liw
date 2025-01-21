public class TechPriest extends Adventurer{
  int faith, faithMax;

  public TechPriest(String name, int hp){
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

  /*Deal 5 damage to opponent, restores 10 faith*/
  public String attack(Adventurer other){
    int damage = 5;
    other.applyDamage(damage);
    restoreSpecial(10);
    return this + " summons a Guided Bolt to attack "+ other + " and deals "+ damage +
    " points of damage. While attacking, " + this + " restores 10 faith.";
  }


  /*Heals team to max hp if enough faith
  */
  public String specialAttack(Adventurer other){
    if(getSpecial() >= 60){
      setSpecial(getSpecial()-60);
      other.setHP(other.getmaxHP());
      return this + " prays to The Original Programmer to heal " + other + " to max HP!";
    }else{
      return "The Original Programmer doesn't respond to the prayer. Nothing happens...";
    }

  }

  /*Restores 20 health to ally and restore 10 of their special resource*/
  public String support(Adventurer other){
    other.setHP(other.getHP() + 20);
    other.restoreSpecial(10);
    return this + " uses Security in Metal to restore 20 health and 10 " + other.getSpecialName()
    + " to " + other;
  }

  /*Converts half of current faith to hp */
  public String support(){
    int amount = getSpecial()/2;
    setHP(getHP() + amount);
    setSpecial(amount);
    return this + " converts half of gathered faith to " + amount
    + " health.";
  }
}
