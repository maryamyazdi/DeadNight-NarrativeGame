package game;
import java.util.*;
import java.io.*;
interface base
{
    void print();
    void prOptions();
}
class LoseException extends Exception
{ }
class Start implements Runnable,base
{
    //@Override
    public void print ()
    {
        System.out.println("\nDRIVING TOWARD OUT OF THE CITY ON A RAINY MIDNIGHT...");
        try {
            Thread.sleep(5000);
        } catch (Exception e){ }
        System.out.println("THE CAR DOESN'T MOVE CORRECTLY...");
        System.out.println((char)27 + "[31m" +"       OUT OF FUEL!");
        System.out.println((char)27+"[30m"+"HAVE TO STOP AND ASK FOR HELP.");
        try
        {
            Thread.sleep(5000);
        } catch (Exception e){ }
        System.out.println("THERE IS AN OLD HOME THERE BESIDE THE ROAD...");
        try {
            Thread.sleep(4000);
        } catch (Exception e) {
        }
    }
    //@Override
    public void prOptions()
    { }
    @Override
    public void run(){ }
}
class EnterHome implements base
{
    @Override
    public void print()
    {
        System.out.println("\nWANT TO KNOCK THE OLD WOODEN FRONT DOOR,BUT IT HAS BEEN OPEN!");
        System.out.println("THERE IS NO LIGHT AT THIS HOME.\nSEEMS SCARING...");
        System.out.println("LET'S TAKE A LOOK AROUND THE HOME TO FIND A HELP.");
        System.out.println("\nTHERE IS A STAIRS AND A DOOR IN FRONT OF ME:");
    }
    public void prOptions()
    {
        System.out.println("1. MOVE TOWARD THE STAIRS");
        System.out.println("2. MOVE TOWARD THE DOOR AND OPEN IT");
    }
}
class LockCase implements Runnable,base
{
    @Override
    public void print()
    {
        System.out.println("THERE IS A STRANGE PICTURE HANGED ON THE STAIRS WALL; SEEMS NOT STAND FIRMLY.");
        try {
            Thread.sleep(3000);
        } catch (Exception e){ }
        System.out.println("WTH!!  THERE IS SOMETHING LIKE A LOCKBOX PLACED BEHIND THE PICTURE.");
        try {
            Thread.sleep(4000);
        } catch (Exception e){ }
        System.out.println((char)27+"[35m"+"THE LOCK BOX HAS BEEN LOCKED WITH A BOARD GAME.");
    }
    @Override
    public void prOptions()
    {
        System.out.println((char)27+"[30m"+"1. TAKE A CHANCE TO OPEN THE LOCKBOX");
        System.out.println("2. GO TO THE UPSTAIRS ROOM WITHOUT OPENING THE LOCKBOX");
    }
    @Override
    public void run(){ }
}
class BoardGame
{
    int g[][] = new int[3][3];
    int x, y, s=1;
    boolean cheat=false;
    public void game()
    {
        int counter = 0;
        int i , j;
        Random r = new Random();
        Scanner S = new Scanner(System.in);
        for (i = 0; i < 3; i++)
        {
            for (j = 0; j < 3; j++)
            {
                g[i][j]=0;
            }
        }
        while(s<=8)
        {
            i=r.nextInt(3);
            j=r.nextInt(3);
            if(i==2&&j==2) continue;
            if(g[i][j]==0)
            {
                g[i][j]=s;
                s++;
            }
            else
            {
            }
        }
        i=2;j=2;
        g[i][j] = 0;
        printboard();
        while (counter < 50)
        {
            String d = S.next();
            if(d.equals("masterpiece"))
            {
                cheat=true;
                return;
            }
            if (d.equals("a")) {
                if (i == 0)
                {
                    System.out.println("INVALID ARGUMENT\n  TRY AGAIN!");
                } else
                {
                    g[i][j] = g[i - 1][j];
                    g[i - 1][j] = 0;
                    i=i-1;
                    counter++;
                    printboard();
                }
            }
            if (d.equals("d")) {
                if (i == 2) {
                    System.out.println("INVALID ARGUMENT\n  TRY AGAIN!");
                } else {
                    g[i][j] = g[i + 1][j];
                    g[i + 1][j] = 0;
                    i=i+1;
                    counter++;
                    printboard();
                }
            }
            if (d.equals("w")) {
                if (j == 0) {
                    System.out.println("INVALID ARGUMENT\n  TRY AGAIN!");
                } else {
                    g[i][j] = g[i][j - 1];
                    g[i][j - 1] = 0;
                    j=j-1;
                    counter++;
                    printboard();
                }
            }
            if (d.equals("s")) {
                if (j == 2) {
                    System.out.println("INVALID ARGUMENT\n  TRY AGAIN!");
                } else {
                    g[i][j] = g[i][j + 1];
                    g[i][j + 1] = 0;
                    j=j+1;
                    counter++;
                    printboard();
                }
            }
            //else System.out.println("INVALID ARGUMENT\n  TRY AGAIN!");
        }
    }
    public void printboard()
    {
        int m = 0;
        System.out.print(" ___ ___ ___");
        System.out.println();
        for (int n = 0; n < 3; n++) {
            System.out.print("|");
            for (m = 0; m < 3; m++)
            {
                if (g[m][n] == 0) {
                    System.out.print("_ _");
                    System.out.print("|");
                }
                else {
                    System.out.print("_"+ g[m][n]);
                    System.out.print("_");
                    System.out.print("|");
                }
            }
            System.out.println();
        }
        System.out.println("\n~Enter ^ w ^ to go up");
        System.out.println("~Enter ^ s ^ to go down");
        System.out.println("~Enter ^ d ^ to go right");
        System.out.println("~Enter ^ a ^ to go left");
        System.out.println("\n ENTER YOUR ARGUMENT:");
    }
}
class UpRoom implements base
{
    @Override
    public void print()
    {
        System.out.println("I'M IN THE UPSTAIRS ROOM.");
        try {
        Thread.sleep(3000);
    } catch (Exception e){ }
        System.out.println("THERE IS A STRANGE NECKLACE NEAR MY FEET ON THE WOODEN FLOOR.");
        System.out.println("THERE IS ALSO A BIG GLASS DOOR TO OUTSIDE BALCONY.");
    }
    @Override
    public void prOptions()
    {
        System.out.println("1. LOOK AT THE NECKLACE");
        System.out.println("2. MOVE TOWARD THE GLASS DOOR(OUTSIDE)");
    }
}
class Balcone implements base
{
    public void Lose() throws Exception
    {
        System.out.println("THE FLOOR OF BALCONY IS LOOSE!!");
        System.out.print((char) 27 + "[37m");
        System.out.println((char)27+"[41m"+"OH GOD!!!!!! I'M GONNA FALL...");
        throw new LoseException();
    }
    @Override
    public void print(){ }
    public void prOptions(){ }
}
class DownRoom implements Runnable,base
{
    @Override
    public void print()
    {
        System.out.println("THERE IS A LARGE BLACK OVERCOAT WITH A HAT HANGED ON CLOTHHANGER ON THE CORNER OF THE ROOM.");
        try {
            Thread.sleep(6000);
        } catch (Exception e){ }
        System.out.println("THERE IS ALSO A DOOR THERE. MAYBE TO OUTSIDE...");
    }
    @Override
    public void prOptions()
    {
        System.out.println("1. MOVE TOWARD THE DOOR AND OPEN IT");
        System.out.println("2. TAKE A LOOK AT THE COAT");
    }
    @Override
    public void run(){ }
}
class BackYard implements Runnable,base
{
    @Override
    public void print() {}
    @Override
    public void prOptions() {}
    @Override
    public void run()
    {
        System.out.println("I'M IN BACK YARD.");
        try { Thread.sleep(3000); }
        catch (Exception e){}
        System.out.println("IT SEEMS LIKE A GARAGE OVER THERE,NOT SURE.");
        try { Thread.sleep(3000); }
        catch (Exception e){}
        System.out.println("GETTING CLOSER...");
        try { Thread.sleep(4000); }
        catch (Exception e){}
        System.out.print((char)27+"[41m");
        System.out.println((char)27+"[30m"+"OH! THERE IS A FRIGHTENING SNAKE NEAR MY LEFT FOOT!");
        System.out.println((char)27+"[31m"+"IN LESS THAN 3 SECONDS ENTER <<0>> TO ESCAPE INSIDE THE GARAGE" +
            " OR BITE BY THE SNAKE AND DIE...");
        System.out.print((char)27+"[30m");
    }
}
class Garage implements Runnable,base
{
    public void NoLightMood()
    {
        try {
            Thread.sleep(5000);
        } catch (Exception e){}
        System.out.print((char)27+"[40m");
        System.out.println((char)27+"[37m"+"IT SEEMS LIKE A LIGHT KEY ON THE WALL.");
        System.out.print((char)27+"[40m");
        System.out.println((char)27+"[37m"+"ENTER <<1>> TO PRESS THE LIGHT KEY.");
    }
    public void HavingLightMood()
    {
        System.out.println("CAN'T FIND THE LIGHT KEY.");
        try {
        Thread.sleep(4000);
        } catch (Exception e){}
        System.out.println("BETTER TO USE THE LIGHT FOUND IN THAT COAT'S POCKET.");
        System.out.print((char)27+"[40m");
        System.out.println((char)27+"[37m"+"ENTER <<1>> TO USE THE LIGHT.");
    }
    @Override
    public void print(){}
    @Override
    public void prOptions(){}
    @Override
    public void run(){}
    public void LightOn()
    {
        System.out.println("SEE SOME CONTAINERS. GETTING CLOSER...");
        try {
            Thread.sleep(3000);
        } catch (Exception e){}
        System.out.println("THEY ARE FUEL CONTAINERS.PROBABLY I CAN FIND GASOLINE HERE...");
        System.out.println("SEARCHING...");
        try {
            Thread.sleep(3000);
        }
        catch (Exception e){}
        System.out.println(".");
        try {
            Thread.sleep(3000);
        }
        catch (Exception e){}
        System.out.println(".");
        try {
            Thread.sleep(2000);
        }
        catch (Exception e){}
        System.out.println(".");
        System.out.println("YES! IT IS A GASOLINE CONTAINER HERE.\nI'LL USE IT TO MAKE MY CAR RUNNING AGAIN...");
        try {
            Thread.sleep(4000);
        }
        catch (Exception e){}
        System.out.println("AND GET OUT OF THIS STRANGE HOME AS SOON AS POSSIBLE!");
        try {
            Thread.sleep(6000);
        }
        catch (Exception e){}
    }
}
class ScenarioHistory<T extends base>
{
    private ArrayList<T> history=new ArrayList<>();
    int LastIndex;
    public void add(T s)
    {
       history.add(s);
       LastIndex=history.indexOf(s);
    }
    public T undo()
    {
        T tr=history.get(LastIndex);
        history.remove(LastIndex);
        LastIndex--;
        return tr;
    }
    public void levels()
    {
        for (int i=0;i<history.size();i++)      System.out.print(history.get(i)+" -> ");
    }
}
class Necklace implements Runnable,base
{
    @Override
    public void print()
    {
        System.out.println("THE PATTERN OF A CONSTELLATION HAS BEEN RUBBED ON THE NECKLACE: << FOR TRAVELLING BACK IN TIME >>");
        try{
            Thread.sleep(5000);
        } catch (Exception E) { }
        System.out.println("THE CENTRAL STAR OF THAT IS OUTSTANDING, SEEMS LIKE A SMALL BUTTON.");
        try{
            Thread.sleep(4000);
        } catch (Exception E) { }
        System.out.println("WHAT DOES THIS BUTTON DO?");
    }
    @Override
    public void prOptions()
    {
        System.out.println("1. PRESS THE BUTTON ON THE NECKLACE AND RISK TRAVELLING BACK IN TIME");
        System.out.println("2. MOVE TOWARD THE GLASS DOOR(OUTSIDE)");
    }
    public void run() { }
}
class HighScoreManager
{
    String filePath = HighScoreManager.class.getResource(".").getFile();
    File f = new File(filePath + "ScoreBoard.txt");
    ArrayList ScoreBoard=new ArrayList<>();
    int time;   int flag=-1;
    public int CompareTo(Object o)
    {
        if(time>(int)o)     return 1;
        if(time==(int)o)        return 0;
        if(time<(int)o)      return -1;
        return 100;
    }
    public void add(int a)
    {
        for(int i=0;i<ScoreBoard.size();i++)
        {
            if(CompareTo(ScoreBoard.get(i))==1||CompareTo(ScoreBoard.get(i))==0)
            {
                if(i==0)    ScoreBoard.add(0,a);
                else {
                    ScoreBoard.add(i - 1, a);
                    flag = 1;
                }
                break;
            }
        }
        if(flag==-1)    ScoreBoard.add(a);
        try{
            Formatter fr=new Formatter(new FileWriter(f,true));
            fr.format("%s ","finish");}
        catch(IOException e){   e.printStackTrace();}
    }
}
class Time implements Runnable
{
    ScenarioHistory ScenHis=new ScenarioHistory<>();
    long t1,t2,counter;
    volatile boolean timer=true;
    boolean input;
    public Time(long t1)
    {
        this.t1=t1;
    }
    @Override
    public void run()
    {
        do {
            t2=System.currentTimeMillis();
            counter=t2-t1;
        }
        while(counter<=14000 && !input);
        timer=false;
        if(!input)
        {
            System.out.print((char)27+"[45m");
            System.out.println((char)27+"\n              GAME OVER\n");
            System.out.println((char)27+"[30m"+"THE SCENARIOS YOU'VE PASSED ARE: ");
            ScenHis.levels();
            System.exit(0);
        }
    }
}
class Enter extends Thread
{
    public static int y=-1;
    Scanner s;
    public Enter(Scanner s)
    {
        this.s=s;
    }
    @Override
    public void run()
    {
        try{
            y = s.nextInt();
        }catch (Exception e){}
    }
}
