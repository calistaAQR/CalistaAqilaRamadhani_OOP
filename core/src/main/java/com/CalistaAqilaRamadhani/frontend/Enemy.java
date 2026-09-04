package com.calista.frontend;

public class Test {
    String name;
    int hp;
    int maxHP;
   
    public void takeDamage(int damage) {
       hp = hp - damage;
    
    if (hp < 0) {
        hp = 0;
    }
    
    System.out.println(name+ " took " + damage + " damage! HP: "+ hp + "/" + maxHP);
    
    if (hp == 0) {
        System.out.println(name + "Was defeated !");
    }    
}
    public void attack(Player player, int damage) {
    System.out.println(name + "unleashes bullet barrage on " + player.name + "!");
    
    player.takeDamage(damage);
}

    public boolean isAlive (){
    return hp > 0;
}

    
}
