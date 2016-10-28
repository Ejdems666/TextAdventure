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
public class Weapon extends Item
{
    
    public Weapon(String name, int damage, int healthBoost, boolean temporary) {
        super(name, damage, healthBoost, temporary);
    }
    
    public int Use()
    {
        return this.getDamage();
    }
    
}
