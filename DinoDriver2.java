import java.util.ArrayList;
/**
 * Write a description of class DinoDriver2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DinoDriver2
{
    public static void main(String[] args)
    {
        
        //DINO[] pop = new DINO[10];
        //DINO.setPopulation(pop.length);
        
        ArrayList<DINO> Dinopop = new ArrayList<DINO>();
        
        for(int i=0; i<25; i++)
        {
            int x = (int)(Math.random()*3);
            int a = ((int)(Math.random()*40))+1;
            if(x == 0)
               {
                 Dinopop.add(new Trex());
                 for(int j=0 ; j< a; j++)
                        Dinopop.get(i).ageUp();
                 Dinopop.get(i).setBattleCount(Dinopop.get(i).getAge());
                }
            if(x == 1)
               {
                 Dinopop.add(new Tri());
                 for(int j=0 ; j< a; j++)
                        Dinopop.get(i).ageUp();
                 Dinopop.get(i).setBattleCount((int)Dinopop.get(i).getAge() * .5);
               }
            if(x == 2)
                {
                 Dinopop.add(new Pter()); 
                 for(int j=0 ; j< a; j++)
                        Dinopop.get(i).ageUp();
                 Dinopop.get(i).setBattleCount((int)(Dinopop.get(i).getAge()*.33));
                }
            System.out.println(Dinopop.get(i).toString());
        }
        DinoDriver2.battleRound(Dinopop);
    }
    //DINO[] p
    private static void battleRound(ArrayList<DINO> p)
    {
        int rounds = 20;
        int attacks;
         for(int i=0;i<rounds;i++)
        {
          if(p.size() ==1)
             {
                 System.out.println("\t\t\tWE HAVE THE KING!!!!");
                 break;
              }
          System.out.println("****************** Round: " + (i + 1)+" ******************");
          attacks = (int)(Math.random()*p.size());
          System.out.println("Attacks this round: " + attacks);
          for(int j=0;j<attacks;j++)
          {
             int rand = (int)(Math.random()*p.size());
             int r2 = (int)(Math.random()*p.size());
             //DINO rd = rd.DINOValue(rand);
             while((r2 == rand)||(p.get(rand).getHealth() < 1)||(p.get(r2).getHealth() < 1))
             {                    
                 rand = (int)(Math.random()*p.size());
                 r2 = (int)(Math.random()*p.size());
              }
             //System.out.println(rand +"  "+r2);
             if(p.get(rand).attack(p.get(r2)))
                 p.get(r2).update(p.get(rand));
             else
                 p.get(rand).update(p.get(r2));
             for( int o=0;o<p.size() ; o++)
             {
                while(p.get(o).getHealth()<1)
                   {
                      p.remove(o);
                      if(o==p.size())
                          break;
                   }

                // System.out.println(p.get(o));
             }
          }
           for(DINO d:p)
              System.out.println("\t" + d);
          System.out.println("Population remaining: "+p.size());
       }
    }
    
    
}

