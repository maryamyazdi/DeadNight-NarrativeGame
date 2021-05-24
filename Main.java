package game;
import java.util.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.*;
import java.io.IOException;
public class Main implements Runnable
{
    enum Light{on,off};
    /*public static void playSound()
    {
        try{
            AudioInputStream audioInputStream= AudioSystem.getAudioInputStream(new File("E://older.wav")
                    .getAbsoluteFile());
            Clip clip=AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
        catch (Exception e)
        {
            System.out.println("error");
            e.printStackTrace();
        }
    }*/
    public static void main(String[] args)
    {
        long StartTime = System.currentTimeMillis();
        Scanner S = new Scanner(System.in);
        int d = 0;
        boolean light=false;
        ScenarioHistory ScenHis=new ScenarioHistory<>();
        System.out.println("PLEASE ENTER YOUR NAME :");
        String name=S.next();
        //playSound();
        Start a = new Start();
        a.print();
        a.prOptions();
        EnterHome t = new EnterHome();
        t.print();
        t.prOptions();
        ScenHis.add(t);
        int flag=0,mark=-1;
        boolean GoOn=true,repeat=true,here=true;
        boolean O_o=true;
        int dump=0;
        while(GoOn)
        {
            d = S.nextInt();
            if (d == 1)
            {
                GoOn=false;
                LockCase g = new LockCase();
                g.print();  g.prOptions();
                ScenHis.add(g);
                while(repeat)
                {
                    d=S.nextInt();
                    if(d==1)
                    {
                        repeat=false;
                        System.out.println("HERE IS THE BOARD GAME:\nSET THE CORRECT SORT FOR NUMBERS IN LESS THEN" +
                                " 50 MOVES.");
                        BoardGame b = new BoardGame();
                        b.game();
                        if (b.cheat)
                        {
                            System.out.println((char) 27 + "[36m" + "THERE IS A GUN AND SOME MONEY INSIDE OF THE" +
                                    " LOCKBOX.\n" +
                                    (char) 27 + "[30m" + "PROBABLY NOT USEFUL FOR ME.");
                            try{
                                Thread.sleep(5000);
                            }catch (Exception E) { }
                            System.out.println("\nGOING TO THE ROOM ON THE FIRST FLOOR...\n");
                            try{
                                Thread.sleep(4000);
                            } catch (Exception E) { }
                            mark=0;
                        }
                    }
                    if(d==2||mark==0)
                    {
                        repeat=false;
                        UpRoom ur = new UpRoom();
                        ur.print();    ur.prOptions();
                        ScenHis.add(ur);
                        while(O_o)
                        {
                            d=S.nextInt();
                            if (d == 1)
                            {
                                O_o=false;
                                Necklace nk=new Necklace();
                                nk.print();     nk.prOptions();
                                d=S.nextInt();
                                while(here)
                                {
                                    if(d==1)
                                    {
                                        here=false;
                                        ScenHis.undo();
                                    }
                                    if(d==2)
                                    {
                                        flag=6;
                                        here=false;
                                    }
                                    else if(d!=1&&d!=2) System.out.println("INVALID ARGUMENT.\n  ENTER 1 OR 2");
                                }
                            }
                            if (d == 2|| flag==6)
                            {
                                O_o=false;
                                Balcone bl = new Balcone();
                                ScenHis.add(bl);
                                try{
                                    bl.Lose();
                                    }
                                catch (Exception e)
                                {
                                    System.out.println((char)27+"[45m");
                                    System.out.println("         GAME OVER\n");
                                    System.out.println((char)27+"[30m"+"THE SCENARIOS YOU'VE PASSED ARE: ");
                                    ScenHis.levels();
                                    return;
                                }
                            }
                            else if(d!=1&&d!=2)     System.out.println("INVALID ARGUMENT.\n  ENTER 1 OR 2");
                        }
                    }
                    else if(d!=1 && d!=2)     System.out.println("INVALID ARGUMENT.\n  ENTER 1 OR 2");
                }
            }
            if (d == 2)
            {
                GoOn=false;
                DownRoom dr = new DownRoom();
                dr.print();     dr.prOptions();
                ScenHis.add(dr);
                repeat=true;
                while(repeat)
                {
                    d = S.nextInt();
                    if(d==2)
                    {
                        repeat=false;
                        /*try
                        {
                            FileReader foo=new FileReader("E:\\Project\\Pocket.txt");
                            Scanner scan=new Scanner(foo);
                            while (true)
                            {
                                String string=scan.nextLine();
                                if(string.equals("end"))  break;
                                System.out.println(string);
                            }
                            scan.close();
                            Thread.sleep(6000);
                        }
                        catch (Exception e){}*/
                        System.out.println("FINDING A WAY TO OUTSIDE, GOING TOWARD THE DOOR.");
                        try{
                            Thread.sleep(3000);
                        } catch (Exception e){}
                        flag=2;
                    }
                    if(d==1||flag==2)
                    {
                        repeat=false;
                        ScenHis.add(new BackYard());
                        Thread t1=new Thread(new BackYard());
                        t1.start();
                        Enter entering=new Enter(S);
                        long NowTime=System.currentTimeMillis();
                        Time tt=new Time(NowTime);
                        (new Thread(tt)).start();
                        entering.start();
                        while (tt.timer)
                        {
                            int snake = S.nextInt();
                            tt.input = true;
                            if(snake==0)
                            {
                                Garage gr=new Garage();
                                ScenHis.add(gr);
                                System.out.print((char)27+"[40m");
                                System.out.println((char)27+"[37m"+"I'M IN THE GARAGE.");
                                System.out.print((char)27+"[40m");
                                System.out.println((char)27+"[37m"+"IT'S REALLY DARK HERE.");
                                if(light)
                                {
                                    gr.HavingLightMood();
                                }
                                else if(!light)
                                {
                                    gr.NoLightMood();
                                }
                                d=0;
                                while(d!=1)
                                {
                                    d=S.nextInt();
                                    if(d==1)
                                    {
                                        Light lg=Light.on;
                                        System.out.print((char)27+"[30m");
                                        gr.LightOn();
                                        System.out.println((char)27+"[45m");
                                        System.out.println((char)27+"[46m");
                                        System.out.println((char)27+"[42m");
                                        System.out.println((char)27+"[33m"+"                                 *  *  *"
                                                +"" +
                                                (char)27+"[30m"+"      WINNING"+(char)27+
                                                "[33m"+"      *  *  *");
                                        System.out.println((char)27+"[42m");
                                        System.out.println((char)27+"[46m");
                                        System.out.println((char)27+"[45m");
                                        System.out.println((char)27+"[30m"+"THE SCENARIOS YOU'VE PASSED ARE: ");
                                        ScenHis.levels();
                                        // for showing scoreboard when the player wins
                                        long FinishTime=System.currentTimeMillis();
                                        long score=FinishTime-StartTime;
                                        HighScoreManager Scoreboard=new HighScoreManager();
                                        Scoreboard.time=(int)score;
                                        Scoreboard.add((int)score);
                                        try
                                        {
                                            Formatter fr=new Formatter(new FileWriter(Scoreboard.f,true));
                                            fr.format("\n%s  ",name);
                                            fr.flush();
                                            fr.format("%s: %d","SCORE",(int)score);
                                            fr.flush();
                                            fr.close();
                                            Scanner scan=new Scanner(new FileReader(Scoreboard.f));
                                            while (true)
                                            {
                                                String string=scan.next();
                                                if(string.equals("finish"))  break;
                                                System.out.println(string);
                                            }
                                            scan.close();
                                        }
                                        catch (IOException err){    err.printStackTrace();}
                                        return;
                                    }
                                    System.out.println("WE CAN'T GO ON IN DARKNESS. LIGHT UP THE GARAGE.");
                                }
                            }
                            else if(snake!=0)
                            {
                                System.out.print((char)27+"[45m");
                                System.out.println((char)27+"\n              GAME OVER\n");
                                System.out.println((char)27+"[30m"+"THE SCENARIOS YOU'VE PASSED ARE: ");
                                ScenHis.levels();
                                System.exit(0);
                            }
                        }
                    }
                    else if(d!=1&&d!=2)     System.out.println("INVALID ARGUMENT.\n  ENTER 1 OR 2");
                }
            }
            else if(d!=1&&d!=2) System.out.println("INVALID ARGUMENT.\n  ENTER 1 OR 2");
        }
    }
    public void run(){ }
}
