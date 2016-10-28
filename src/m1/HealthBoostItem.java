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
public class HealthBoostItem extends Item
{
    
    public HealthBoostItem(String name, int damage, int healthBoost, boolean temporary) {
        super(name, damage, healthBoost, temporary);
    }
    
    public int use()
    {
        return this.getHealthBoost();
    }
    
}
