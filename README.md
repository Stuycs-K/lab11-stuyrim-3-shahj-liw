[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/KprAwj1n)
# APCS - Stuyrim

## Features

Make a clear list of features that work/dont work

:white_check_mark: This feature works.

:question: This feature works partially.

:ballot_box_with_check: This extra (beyond the things that the lab was supposed to do) feature works.

:x: This required feature does not work.

:beetle: This is a bug that affects the game.

# Subclasses

## Mad Alchemist
- **HP**: **80 HP**
- **Attack**: *Acid Throw*: Deals 20 damage to an enemy and restores 10 toxicity 
- **Support**: *Healthy Brew*: Throws healing potions at its team, healing each member for 10 hp.
- **Ultimate**: *Elder Dragon’s Acid (Requires 50 toxicity)*: Deals 50 damage to each enemy, also dealing 20 damage to itself. Can die while performing this special attack.
- **Special Resource**: **Toxicity**


## Tech Priest
- **HP**: **60 HP**
- **Attack**: *Guided Bolt*: Deals 10 damage to the enemy and increases faith by 10
- **Support (Self)**: *Artificial Augmentation*: Self converts half of current faith to HP, adds that number to HP, and then sets self faith to zero
- **Support (Ally)**: *Security in Metal*: Heal lowest HP Ally for 25 HP and give him 10 of respective Special resource, but self loses 30 faith
- **Ultimate**: *Deus Ex Machina (Requires 25 Faith)*: Deals 30 damage to the enemy, self loses 25 faith
- **Special Resource**: **Faith**
