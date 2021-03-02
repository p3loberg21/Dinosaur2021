
/**
 * Write a description of class DINO here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class DINO
{
    // instance variables - replace the example below with your own
    private String type;
    private int age;
    private String gender;
    private int health;
    private int wins;
    private double battlecount;
    private static int population;
    //final int ghsyic; //Constant, cannot change

    /**
     * default Constructor for objects of class DINO
     */
    public DINO()
    {
        this.type = "dino";
        this.age = 0;
        this.wins = 0;
        this.battlecount = 0;
        
        int x = (int)(Math.random())*2;
        if(x==1)
            this.gender = "male";
        if(x==0)
            this.gender = "female";
        this.health = 1;
        
    }
    //Explicit constructor for the DINO class
    public DINO(String t)
    {
        this.type =t;
        this.age = 0;
        this.health = 1;
        int x = (int)((Math.random())*2);
        if(x==1)
            this.gender = "male";
        if(x==0)
            this.gender = "female";
    }
    
    /***********    Getters *************/
    //getter return the private instance data.
    public String getType()
    {
        return this.type;
    }
    public int getHealth()
    {
        return this.health;
    }
    public int getAge()
    {
        return this.age;
    }
    public String getGender()
    {
        return this.gender;
    }
    public int getWins()
    {
        return this.wins;
    }
    public double getBattleCount()
    {
        return this.battlecount;
    }
    public static int getPopulation()
    {
        return DINO.population;
    }
    
    /***********    Setters *************/
    public void setType(String t)
    {
        this.type = t;
    }
    public void setGender(String g)
    {
        this.gender = g;
    }
    public void setAge(int a)
    {
        this.age = a;
    }
    public void setHealth(int h)
    {
        this.health = h;
    }
    public void setWins(int w)
    {
        this.wins = w;
    }
    public void setBattleCount(double b)
    {
        this.battlecount = b;
    }
    public static void setPopulation(int p)
    {
        DINO.population = p;
    }
    
    /***********************************/
    
    public boolean Equals(DINO d)
    {
        if((d.getType()).equals(this.type))
            return true;
        else
            return false;
    }
    
    public void ageUp()
    {
        if(this.health>0) //le dino be livin
        {
            if(this.age<21)
                this.health +=10;
            if(this.age>25 && this.age<31)
                this.health -=5;
            if(this.age>30)
                this.health -=10;
            this.age++;
        }
    }
    
    public double getBattleFactor(DINO d)
    {
        double relativeXP =( ( (double)(this.getBattleCount()) ) / ( (double)(d.getBattleCount()) ) );
        double healthPercentage = ( ( (double)this.getHealth() ) / ( (double)(200) ) );
        double battleFactor = ( ((healthPercentage * 2 ) /3) + (relativeXP / 3) );
        return battleFactor; 
    }
    
    public abstract void update(DINO loser);
    
    public abstract boolean attack(DINO other);
    
    public String toString()
    {
        String answer = this.type +" "+ this.age +" "+ this.health +" "+ this.gender;
        return answer;
    }
}
