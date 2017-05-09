package my.program;

/*
Matthew Dalton
Enhancement of my pet project
*/
public class MyProgram
{
    private String name, actionText, foodText, clothesText, cygnusText, perseusText, mitnakaText, centerText, leopardText;
    private int age, health, hunger, strength, money, food, medicine;
    private int leopardMedicine=3;
    private boolean milkyOne, milkyTwo, milkyThree, milkyFour, milkyFive, showGif;
    private boolean cygnusDead=false, dead=false, mitnakaConfuse=false, mitnakaDead=false, gameOver=false, neilDead=false, leopardDead=false;
    final private int maxStat=100, minStat=0;
    private int cygnusHealth=maxStat, mitnakaHealth=maxStat, neilHealth=maxStat, leopardHealth=maxStat;
    private boolean nixon=false, rolex=false, snapback=false, beanie=false, fedora=false, sketchers=false, yeezy=false, jordan=false, gucci=false, versace=false, diamond=false, gold=false, silver=false, coach=false, kors=false;
    
    public MyProgram()
    {
        name="Jerry";
        age=0;
        health=maxStat;
        hunger=minStat;
        strength=minStat;
        money=50;
        food=minStat;
        medicine=minStat;
        dead=false;
        milkyOne=true;
        milkyTwo=false;
        milkyThree=false;
        milkyFour=false;
        milkyFive=false;
    }
    public String tigerMove(boolean b)
    {
        if(b==true)
        {
            int i=(int)(Math.random()*10+1);
            if(i<4)
            {
                centerText="The leopard dodged "+name+"'s attack";
            }
            if(i>3&&i<7)
            {
                centerText=name+" pounced on the leopard";
                leopardHealth-=5;
            }
            if(i>6&&i<10)
            {
                centerText=name+" bit the leopard";
                leopardHealth-=10;
            }
            if(i==10)
            {
                centerText=name+" backflip-kicked the leopard";
                leopardHealth-=20;
            }
            leopardDeadCheck();
        }
        if(b==false)
        {
            if(medicine>0)
            {
                centerText="You gave "+name+" a pill";
                health+=25;
                medicine--;
            }
            if(medicine==0)
            {
                centerText="You are out of pills!";
            }
        }
        if(neilDead==true)
        {
            centerText=(centerText+"\n\n"+leopardMove());
        }
        deadCheck();
        return centerText;
    }
    public String neilMove(boolean b)
    {
        if(b==true)
        {
            int i=(int)(Math.random()*10+1);
            if(i<4)
            {
                centerText="The leopard dodged Neil's attack";
            }
            if(i>3&&i<7)
            {
                centerText="Neil roundhouse kicked the leopard";
                leopardHealth-=5;
            }
            if(i>6&&i<10)
            {
                centerText="Neil poked the leopard in the eyes";
                leopardHealth-=10;
            }
            if(i==10)
            {
                centerText="Neil stepped on the leopard";
                leopardHealth-=20;
            }
            leopardDeadCheck();
        }
        if(b==false)
        {
            if(medicine>0)
            {
                centerText="You gave neil a pill";
                neilHealth+=25;
                medicine--;
            }
            if(medicine==0)
            {
                centerText="You are out of pills!";
            }
        }
        centerText=(centerText+"\n\n"+leopardMove());
        deadCheck();
        neilDeadCheck();
        return centerText;
    }
    public String leopardMove()
    {
        if(leopardHealth<25&&leopardMedicine>0)
        {
            leopardText="The leopard popped a pill";
            leopardHealth=maxStat;
            leopardMedicine--;
        }
        else
        {
            int i=(int)(Math.random()*10+1);
            if(i<4)
            {
                if(dead==true)
                {
                    leopardText="The leopard clawed Neil";
                    neilHealth-=15;
                }
                if(neilDead==true)
                {
                    leopardText="The leopard clawed "+name;
                    health-=15;
                }
                if(dead==false&&neilDead==false)
                {
                    leopardText="The leopard clawed "+name+" and Neil at the same time!";
                    health-=15;
                    neilHealth-=15;
                }
            }
            if(i>3&&i<7)
            {
                if(dead==false)
                {
                    leopardText="The leopard bit "+name+"'s leg";
                    health-=20;
                }
                if(dead==true)
                {
                    leopardText="The leopard bit Neil's leg";
                    neilHealth-=20;
                }
            }
            if(i>6&&i<10)
            {
                if(neilDead==false)
                {
                    leopardText="The leopard jump-kicked Neil";
                    neilHealth-=20;
                }
                if(neilDead==true)
                {
                    leopardText="The leopard jump-kicked "+name;
                    health-=20;
                }
            }
            if(i==10)
            {
                leopardText="The leopard tried to bite "+name+" but missed";
            }
        }
        return leopardText;
    }
    public String mitnakaPuzzle()
    {
        mitnakaText="There is a lock on the Central Mitnaka Mine... it looks like some time of puzzle.\nFigure out the right pattern to unlock the door.";
        return mitnakaText;
    }
    public String fightMitnaka()
    {
        if(mitnakaDead==false)
        {
            int i=(int)(Math.random()*5+1);
            if(i==1)
            {
                mitnakaText=name+" clawed the guard in the face.";
                mitnakaHealth-=5;
            }
            if(i==2)
            {
                mitnakaText=name+" tackled the guard.";
                mitnakaHealth-=7;
            }
            if(i==3)
            {
                mitnakaText=name+" sunk his teeth into the guard!";
                mitnakaHealth-=12;
            }
            if(i==4)
            {
                mitnakaText=name+" mauled the guard!";
                mitnakaHealth-=10;
            }
            if(i==5)
            {
                mitnakaText=name+"'s attack missed.";
            }
            mitnakaDeadCheck();
            if(mitnakaDead==false)
            {
                mitnakaText=mitnakaText+"\n"+mitnakaFight();
            }
        }
        reset();
        return mitnakaText;
    }
    public String confuseMitnaka()
    {
        mitnakaConfuse=false;
        int i=(int)(Math.random()*5+1);
        if(i<4)
        {
            mitnakaText=name+" confused the guard.";
            mitnakaConfuse=true;
        }
        else
        {
            mitnakaText=name+" failed in his attempt to confuse the guard";
        }
        mitnakaText=mitnakaText+"\n"+mitnakaFight();
        mitnakaDeadCheck();
        reset();
        return mitnakaText;
    }
    public String mitnakaFight()
    {
        if(mitnakaConfuse==true)
        {
            int i=(int)(Math.random()*2+1);
            if(i==1)
            {
                mitnakaText="The guard hurt himself in confusion";
                mitnakaHealth-=10;
            }
            else
            {
                mitnakaText="The guard missed "+name+" in his confusion.";
            }
        }
        else
        {
            int i=(int)(Math.random()*5+1);
            if(i<3)
            {
                mitnakaText="The guard backhanded "+name;
                health-=3;
            }
            if(i>2&&i<5)
            {
                mitnakaText="The guard kicked "+name+" in the face";
                health-=5;
            }
            if(i==5)
            {
                mitnakaText="The guard slashed "+name+" with his diamond encrusted sword.";
                health-=20;
            }
        }
        mitnakaConfuse=false;
        reset();
        return mitnakaText;
    }
    public String perseusRiddleOne()
    {
        perseusText="What has three feet but cannot walk?";
        return perseusText;
    }
    public String perseusAnswerOne()
    {
        return "yard";
    }
    public String perseusRiddleTwo()
    {
        perseusText="What is a seven letter word containing thousands of\nletters?";
        return perseusText;
    }
    public String perseusAnswerTwo()
    {
        return "mailbox";
    }
    public String perseusRiddleThree()
    {
        perseusText="You can see me in water, but I never get wet. What am I?";
        return perseusText;
    }
    public String perseusAnswerThree()
    {
        return "reflection";
    }
    public String fightCygnus()
    {
        int i=(int)(Math.random()*10+1);
        if(i<3)
        {
            cygnusText=name+"'s attack missed.";
        }
        if(i>2&&i<6)
        {
            cygnusText=name+" tackled the alien leader.";
            cygnusHealth-=10;
        }
        if(i>5&&i<10)
        {
            cygnusText=name+" clawed at the alien leader.";
            cygnusHealth-=15;
        }
        if(i>9)
        {
            cygnusText=name+" pounced on the alien leader right in the sweet\nspot!";
            cygnusHealth-=20;
        }
        cygnusDeadCheck();
        if(cygnusDead==false)
        {
            cygnusText = cygnusText+"\n"+cygnusFight();
        }
        return cygnusText;
    }
    public String fleeCygnus()
    {
        int i=(int)(Math.random()*3+1);
        if(i<3)
        {
            cygnusText="You managed to get away safely.";
        }
        if(i>2)
        {
            cygnusText="You couldn't escape..";
            cygnusText = cygnusText+"\n"+cygnusFight();
        }
        return cygnusText;
    }
    public String cygnusFight()
    {
        int i=(int)(Math.random()*10+1);
        if(i<3)
        {
            cygnusText="The alien leader's attack missed.. but only just.";
        }
        if(i>2&&i<6)
        {
            cygnusText="The alien leader slashed "+name+" in the side";
            health-=5;
        }
        if(i>5&&i<10)
        {
            cygnusText="The alien leader tackled "+name;
            health-=10;
        }
        if(i>9)
        {
            cygnusText="The alien leader hit "+name+" with a laser!";
            health-=20;
        }
        reset();
        return cygnusText;
    }
    public String compete()
    {
        if((health<50||hunger>50)&&money<50)
        {
            actionText=name+" won some money on a street corner.";
            money+=5;
            age++;
            showGif=true;
        }
        if((health<50||hunger>50)&&money>=50)
        {
            actionText="You should try buying cookies to feed "+name+" or\nbuying pills to heal "+name;
            showGif=false;
        }
        if(!(health<50))
        {
            int i=(int)(Math.random()*20+1);
            actionText=name+" did pretty well in the local tiger race.";
            if(i<3)
            {
                money+=20;
                health-=15;
                hunger+=15;
            }
            if(i<5&&i>2)
            {
                health-=10;
                hunger+=10;
                money+=20;
            }
            if(i<7&&i>4)
            {
                health-=5;
                hunger+=15;
                money+=25;
            }
            if(i<9&&i>6)
            {
                actionText=name+" took 3rd in the annual Jing Bells tiger race.";
                health-=5;
                hunger+=5;
                money+=25;
            }
            if(i<11&&i>8)
            {
                actionText=name+" finished in 5th in the tiger half-marathon!";
                money+=50;
                health-=20;
                hunger+=30;
            }
            if(i<13&&i>10)
            {
                actionText=name+" placed 2nd in the local pie-eating contest";
                health-=5;
                hunger+=25;
                money+=30;
            }
            if(i<15&&i>12)
            {
                money+=30;
                health-=5;
                hunger+=10;
            }
            if(i<17&&i>14)
            {
                actionText="There weren't many competitions around, "+name+"\n won ten dollars in a cat-fight";
                money+=10;
            }
            if(i<19&&i>16)
            {
                actionText=name+" didn't do very well in the Kentucky beauty pagent";
                health-=10;
                hunger+=10;
            }
            if(i==19)
            {
                money-=100;
                actionText=name+" attacked the other contestants and was kicked\nout of the competition";
            }
            if(i==20)
            {
                money+=100;
                actionText="Jackpot! "+name+" beat Mike Tyson's tiger in a\nprize-fight!";
            }
            age++;
            showGif=true;
        }
        reset();
        return actionText;
    }
    public String nurse()
    {
        if(medicine==0)
        {
            actionText="You have no medicine to give "+name;
            showGif=false;
        }
        if(health==maxStat&&!(medicine==0))
        {
            actionText=name+" is completely healthy";
            showGif=false;
        }
        if(!(health==maxStat)&&!(medicine==0))
        {
            int i=(int)(Math.random()*10+1);
            actionText = "You nursed "+name;
            if(i<4)
                health+=10;
            if(i<7&&i>3)
                health+=5;
            if(i<10&&i>6)
                health+=15;
            if(i==10)
            {
                health-=20;
                actionText = "You gave "+name+" a bad pill.";
            }
            medicine--;
            age++;
            showGif=true;
        }
        reset();
        return actionText;
    }
    public String train()
    {
        if(hunger>75)
        {
            actionText=name+" is too hungry to train.";
            showGif=false;
        }
        if(health<25)
        {
            actionText=name+"'s health is too low to train.";
            showGif=false;
        }
        if(!(hunger>75)&&!(health<25))
        {
            int i=(int)(Math.random()*20+1);
            actionText="You trained "+name+" really hard";
            if(i<5)
            {
                actionText=actionText+" but\nhe was not really feeling it today";
                strength+=3;
                hunger+=5;
            }
            if(i<9&&i>4)
            {
                strength+=4;
                hunger+=10;
            }
            if(i<13&&i>8)
            {
                strength+=4;
                hunger+=15;
            }
            if(i<17&&i>12)
            {
                strength-=2;
                hunger+=15;
            }
            if(i==17)
            {
                strength+=5;
                hunger+=15;
            }
            if(i==18)
            {
                actionText=actionText+".\n"+name+" is getting a lot stronger";
                strength+=5;
                hunger+=25;
            }
            if(i==19)
            {
                actionText=actionText+".\n"+name+" is getting a lot stronger";
                strength+=7;
                hunger+=10;
            }
            if(i==20)
            {
                actionText=name+" wasn't really into the training today";
            }
            age++;
            showGif=true;
        }
        reset();
        return actionText;
    }
    public String buyCookies()
    {
        if(money<5)
        {
            foodText = "You have no money to buy cookies";
        }
        else
        {
            foodText = "You purchased a cookie from Jeremy.";
            money-=5;
            food++;
        }
        reset();
        return foodText;
    }
    public String buyMedicine()
    {
        if(money<5)
        {
            foodText = "You have no money to buy medicine";
        }
        else
        {
            foodText = "You purchased a pill from Julia.";
            money-=5;
            medicine++;
        }
        reset();
        return foodText;
    }
    public String feed()
    {
        if(food==0)
        {
            actionText = "You have no food to feed "+name;
            showGif=false;
        }
        if(hunger==minStat&&!(food==0))
        {
            actionText=name+" is full";
            showGif=false;
        }
        if(!(food==0)&&!(hunger==minStat))
        {
            int i=(int)(Math.random()*10+1);
            actionText = "You fed "+name;
            if(i<4)
                hunger-=10;
            if(i<7&&i>3)
                hunger-=5;
            if(i<10&&i>6)
                hunger-=15;
            if(i==10)
            {
                hunger+=20;
                actionText = name+" threw up";
            }
            food--;
            age++;
            showGif=true;
        }
        reset();
        return actionText;
    }
    public void reset()
    {
        if(age<minStat)
            age=minStat;
        if(age>(3*maxStat))
            age=(3*maxStat);
        if(health>maxStat)
            health=maxStat;
        if(health<minStat)
            health=minStat;
        if(hunger<minStat)
            hunger=minStat;
        if(hunger>maxStat)
            hunger=maxStat;
        if(strength<minStat)
            strength=minStat;
        if(strength>maxStat)
            strength=maxStat;
        if(money<minStat)
            money=minStat;
        if(food<minStat)
            food=minStat;
        if(medicine<minStat)
            medicine=minStat;
        if(cygnusHealth<minStat)
            cygnusHealth=minStat;
        if(mitnakaHealth<minStat)
            mitnakaHealth=minStat;
        if(neilHealth<minStat)
            neilHealth=minStat;
        if(neilHealth>maxStat)
            neilHealth=maxStat;
        if(leopardHealth<minStat)
            leopardHealth=minStat;
        deadCheck();
        gameOverCheck();
    }
    public void gameOverCheck()
    {
        if(age>=3*maxStat)
            gameOver=true;
    }
    public void deadCheck()
    {
        dead=false;
        if(health<=minStat)
            dead=true;
        cygnusDeadCheck();
    }
    public void cygnusDeadCheck()
    {
        if(cygnusHealth<=minStat)
        {
            cygnusDead=true;
        }
    }
    public void mitnakaDeadCheck()
    {
        if(mitnakaHealth<=minStat)
        {
            mitnakaDead=true;
        }
    }
    public void neilDeadCheck()
    {
        if(neilHealth<=minStat)
        {
            neilDead=true;
        }
    }
    public void leopardDeadCheck()
    {
        if(leopardHealth<=minStat)
        {
            leopardDead=true;
        }
    }
    public String nixon()
    {
        if(nixon==true)
        {
            clothesText="You already bought the Nixon watch for "+name;
        }
        if(nixon==false&&money<10)
        {
            clothesText="You do not have enough money to buy the Nixon watch for "+name;
        }
        if(!(nixon==true)&!(nixon==false&&money<10))
        {
            clothesText="You bought the Nixon watch for "+name+"!";
            money-=10;
            nixon=true;
        }
        return clothesText;
    }
    public String rolex()
    {
        if(rolex==true)
        {
            clothesText="You already bought the Rolex watch for "+name;
        }
        if(rolex==false&&money<50)
        {
            clothesText="You do not have enough money to buy the Rolex watch for "+name;
        }
        if(!(rolex==true)&!(rolex==false&&money<50))
        {
            clothesText="You bought the Rolex watch for "+name+"!";
            money-=50;
            rolex=true;
        }
        return clothesText;
    }
    public String snapback()
    {
        if(snapback==true)
        {
            clothesText="You already bought the snapback for "+name;
        }
        if(snapback==false&&money<5)
        {
            clothesText="You do not have enough money to buy the snapback for "+name;
        }
        if(!(snapback==true)&!(snapback==false&&money<5))
        {
            clothesText="You bought the snapback for "+name+"!";
            money-=5;
            snapback=true;
        }
        return clothesText;
    }
    public String beanie()
    {
        if(snapback==true)
        {
            clothesText="You already bought the beanie for "+name;
        }
        if(beanie==false&&money<5)
        {
            clothesText="You do not have enough money to buy the beanie for "+name;
        }
        if(!(beanie==true)&!(beanie==false&&money<5))
        {
            clothesText="You bought the beanie for "+name+"!";
            money-=5;
            beanie=true;
        }
        return clothesText;
    }
    public String fedora()
    {
        if(fedora==true)
        {
            clothesText="You already bought the fedora for "+name;
        }
        if(fedora==false&&money<15)
        {
            clothesText="You do not have enough money to buy the fedora for "+name;
        }
        if(!(fedora==true)&!(fedora==false&&money<15))
        {
            clothesText="You bought the fedora for "+name+"!";
            money-=15;
            fedora=true;
        }
        return clothesText;
    }
    public String sketchers()
    {
        if(sketchers==true)
        {
            clothesText="You already bought the sketchers for "+name;
        }
        if(sketchers==false&&money<5)
        {
            clothesText="You do not have enough money to buy the sketchers for "+name;
        }
        if(!(sketchers==true)&!(sketchers==false&&money<5))
        {
            clothesText="You bought the sketchers for "+name+"!";
            money-=5;
            sketchers=true;
        }
        return clothesText;
    }
    public String yeezy()
    {
        if(yeezy==true)
        {
            clothesText="You already bought the Yeezy's for "+name;
        }
        if(yeezy==false&&money<50)
        {
            clothesText="You do not have enough money to buy the Yeezy's for "+name;
        }
        if(!(yeezy==true)&!(yeezy==false&&money<50))
        {
            clothesText="You bought the Yeezy's for "+name+"!";
            money-=50;
            yeezy=true;
        }
        return clothesText;
    }
    public String jordan()
    {
        if(jordan==true)
        {
            clothesText="You already bought the Jordans for "+name;
        }
        if(jordan==false&&money<50)
        {
            clothesText="You do not have enough money to buy the Jordans for "+name;
        }
        if(!(jordan==true)&!(jordan==false&&money<50))
        {
            clothesText="You bought the Jordans for "+name+"!";
            money-=50;
            jordan=true;
        }
        return clothesText;
    }
    public String gucci()
    {
        if(gucci==true)
        {
            clothesText="You already bought the Gucci belt for "+name;
        }
        if(gucci==false&&money<40)
        {
            clothesText="You do not have enough money to buy the Gucci belt for "+name;
        }
        if(!(gucci==true)&!(gucci==false&&money<40))
        {
            clothesText="You bought the Gucci Belt for "+name+"!";
            money-=40;
            gucci=true;
        }
        return clothesText;
    }
    public String versace()
    {
        if(versace==true)
        {
            clothesText="You already bought the Versace belt for "+name;
        }
        if(versace==false&&money<60)
        {
            clothesText="You do not have enough money to buy the Versace belt for "+name;
        }
        if(!(versace==true)&!(versace==false&&money<60))
        {
            clothesText="You bought the Versace belt for "+name+"!";
            money-=60;
            versace=true;
        }
        return clothesText;
    }
    public String diamond()
    {
        if(diamond==true)
        {
            clothesText="You already bought the diamond ring for "+name;
        }
        if(diamond==false&&money<30)
        {
            clothesText="You do not have enough money to buy the diamond ring for "+name;
        }
        if(!(diamond==true)&!(diamond==false&&money<30))
        {
            clothesText="You bought the diamond ring for "+name+"!";
            money-=30;
            diamond=true;
        }
        return clothesText;
    }
    public String gold()
    {
        if(gold==true)
        {
            clothesText="You already bought the 24 karat gold ring for "+name;
        }
        if(gold==false&&money<25)
        {
            clothesText="You do not have enough money to buy the 24 karat gold ring for "+name;
        }
        if(!(gold==true)&!(gold==false&&money<25))
        {
            clothesText="You bought the 24 karat gold ring for "+name+"!";
            money-=25;
            gold=true;
        }
        return clothesText;
    }
    public String silver()
    {
        if(silver==true)
        {
            clothesText="You already bought the silver ring for "+name;
        }
        if(silver==false&&money<20)
        {
            clothesText="You do not have enough money to buy the silver ring for "+name;
        }
        if(!(silver==true)&!(silver==false&&money<20))
        {
            clothesText="You bought the silver ring for "+name+"!";
            money-=20;
            silver=true;
        }
        return clothesText;
    }
    public String coach()
    {
        if(coach==true)
        {
            clothesText="You already bought the Coach bag for "+name;
        }
        if(coach==false&&money<30)
        {
            clothesText="You do not have enough money to buy the Coach bag for "+name;
        }
        if(!(coach==true)&!(coach==false&&money<30))
        {
            clothesText="You bought the Coach bag for "+name+"!";
            money-=30;
            coach=true;
        }
        return clothesText;
    }
    public String kors()
    {
        if(kors==true)
        {
            clothesText="You already bought the Michael Kors bag for "+name;
        }
        if(kors==false&&money<30)
        {
            clothesText="You do not have enough money to buy the Micheal Kors bag for "+name;
        }
        if(!(kors==true)&!(kors==false&&money<30))
        {
            clothesText="You bought the Micheal Kors bag for "+name+"!";
            money-=30;
            kors=true;
        }
        return clothesText;
    }
    public void setName(String s)
    {
        name=s;
    }
    public void setMilkyOne(boolean b)
    {
        milkyOne=b; 
    }
    public void setMilkyTwo(boolean b)
    {
        milkyTwo=b;
    }
    public void setMilkyThree(boolean b)
    {
        milkyThree=b;
    }
    public void setMilkyFour(boolean b)
    {
        milkyFour=b;
    }
    public void setMilkyFive(boolean b)
    {
        milkyFive=b;
    }
    public void setCygnusHealth(int i)
    {
        cygnusHealth=i;
    }
    public void setCygnusDead(boolean b)
    {
        cygnusDead=b;
    }
    public void setMitnakaHealth(int i)
    {
        mitnakaHealth=i;
    }
    public void setMitnakaDead(boolean b)
    {
        mitnakaDead=b;
    }
    public void setHealth(int i)
    {
        health=i;
    }
    public void setMedicine(int i)
    {
        medicine=i;
    }
    public void setHunger(int i)
    {
        hunger=i;
    }
    public void setMoney(int i)
    {
        money=i;
    }
    public void setNeilHealth(int i)
    {
        neilHealth=i;
    }
    public void setLeopardHealth(int i)
    {
        leopardHealth=i;
    }
    public void setNeilDead(boolean b)
    {
        neilDead=b;
    }
    public void setLeopardDead(boolean b)
    {
        leopardDead=b;
    }
    public void setDead(boolean b)
    {
        dead=b;
    }
    public void setLeopardMedicine(int i)
    {
        leopardMedicine=i;
    }
    public String getName()
    {
        return name;
    }
    public int getAge()
    {
        return age;
    }
    public int getHealth()
    {
        return health;
    }
    public int getHunger()
    {
        return hunger;
    }
    public int getStrength()
    {
        return strength;
    }
    public int getMoney()
    {
        return money;
    }
    public int getFood()
    {
        return food;
    }
    public int getMedicine()
    {
        return medicine;
    }
    public int getCygnusHealth()
    {
        return cygnusHealth;
    }
    public boolean getCygnusDead()
    {
        return cygnusDead;
    }
    public int getMitnakaHealth()
    {
        return mitnakaHealth;
    }
    public boolean getMitnakaDead()
    {
        return mitnakaDead;
    }
    public boolean getDead()
    {
        return dead;
    }
    public boolean getMilkyOne()
    {
        return milkyOne;
    }
    public boolean getMilkyTwo()
    {
        return milkyTwo;
    }
    public boolean getMilkyThree()
    {
        return milkyThree;
    }
    public boolean getMilkyFour()
    {
        return milkyFour;
    }
    public boolean getMilkyFive()
    {
        return milkyFive;
    }
    public boolean getShowGif()
    {
        return showGif;
    }
    public boolean getGameOver()
    {
        return gameOver;
    }
    public int getHumanAge()
    {
        return (int)(age/8);
    }
    public int getNeilHealth()
    {
        return neilHealth;
    }
    public int getLeopardHealth()
    {
        return leopardHealth;
    }
    public boolean getNeilDead()
    {
        return neilDead;
    }
    public boolean getLeopardDead()
    {
        return leopardDead;
    }
}