
/**
 * Write a description of class Triceratops here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tri extends DINO
{
    // instance variables - replace the example below with your own
    private int packSize;

    /**
     * Constructor for objects of class Triceratops
     */
    public Tri()
    {
        super("Tri");
        packSize = (int)(Math.random()*5);
    }

    public boolean attack(DINO other)
    {
        if((other.getType()).equals("Trex"))
        {
            double x = (Math.random() * 50) +30 + (this.packSize*5);
            double y = (Math.random() * 50) +50;
            int diff = (int)((x*this.getBattleFactor(other)) - (y*other.getBattleFactor(this)));
            if(diff>0)
                return true;
            else
                return false;
        }
        else if((other.getType()).equals("Pter"))
        {
            double x = (Math.random() * 50) +55 + (this.packSize*5);
            double y = (Math.random() * 50) +25;
            int diff = (int)((x*this.getBattleFactor(other)) - (y*other.getBattleFactor(this)));
            if(diff>0)
                return true;
            else
                return false;
        }
        else if((other.getType()).equals("Tri"))
        {
            double x = (Math.random() * 50) +55 + (this.packSize*5);
            double y = (Math.random() * 50) +50;
            int diff = (int)((x*this.getBattleFactor(other)) - (y*other.getBattleFactor(this)));
            if(diff>0)
                return true;
            else
                return false;
        }
        else
            return true;
        
    }
    
    public void update(DINO loser)
    {
        if(Math.random() < .5 || loser.getHealth() == 1)
             loser.setHealth(0);
        else
        {
            loser.setHealth((int)(loser.getHealth()*.2));
            if(loser.getHealth()==0)
               loser.setHealth(1);
        }
        this.setHealth((int)(this.getHealth()*.8));
        if(this.getHealth() == 0)
           this.setHealth(1);
        this.setWins(this.getWins()+1);
        this.setBattleCount(this.getBattleCount()+1);
        loser.setBattleCount(loser.getBattleCount()+1);
    }
    
    public String toString()
    {
        if(this.getAge() ==0)
            return super.toString();  //super. calls the method of the parent class
        else
            return this.getType() + " Wins: " + this.getWins() + " Battles: " + this.getBattleCount()+ "   Health: " +this.getHealth() + "   Pack: " +this.packSize;
    }
}
