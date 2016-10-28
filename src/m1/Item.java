/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m1;

/**
 *
 * @author thomasthimothee
 */
public class Item {
    private String name;
    private int damage;
    private int healthBoost;
    private boolean temporary;

    public Item(String name, int damage, int healthBoost, boolean temporary) {
        this.name = name;
        this.damage = damage;
        this.healthBoost = healthBoost;
        this.temporary = temporary;
    }

    Item() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealthBoost() {
        return healthBoost;
    }

    public void setHealthBoost(int healthBoost) {
        this.healthBoost = healthBoost;
    }

    public boolean isTemporary() {
        return temporary;
    }

    public void setTemporary(boolean temporary) {
        this.temporary = temporary;
    }
    
    
    
    
    
}
