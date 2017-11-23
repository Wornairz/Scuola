package pacman;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static java.awt.event.KeyEvent.*;
import java.util.Random;


public class Mappa extends JPanel implements KeyListener, ActionListener{
    private Timer timer;
    private Pacman pacman;
    private Fantasma f1, f2, f3 ,f4;
    private final Suono waka_waka,inizio,sirena,frutto, morte;
    private final Image fragola,granata,ciliegia,mela,chiave,campana,astronave,arancia, mattoncino;
    private int i=0,j=0,r=6,spost=8,codice_tasto=0, punteggio=0,c=18, spostFant=5;
    private boolean up=false,down=false,left=true,right=false;
    private String codice2="left", dir_fant_r="up",dir_fant_b="down",dir_fant_p="down",dir_fant_o="up",temp="";
    private Random rand;
    private int m[][] = new int[][]{
        {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},//1
        {2,0,0,0,0,0,0,8,0,1,0,0,0,0,0,0,9,0,2},//2
        {2,0,1,1,0,1,1,1,0,1,0,1,1,1,0,1,1,0,2},//3
        {2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2},//4
        {2,0,1,1,0,1,0,1,1,1,1,1,0,1,0,1,1,0,2},//5
        {2,0,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,2},//6
        {2,2,2,2,0,1,1,1,6,1,6,1,1,1,0,2,2,2,2},//7
        {3,3,3,2,0,1,6,6,6,6,6,6,6,1,0,2,3,3,3},//8
        {2,2,2,2,0,1,6,1,1,5,1,1,6,1,0,2,2,2,2},//9
        {6,10,6,6,0,6,6,1,6,6,6,1,6,6,0,6,6,11,6},//10
        {2,2,2,2,0,1,6,1,1,1,1,1,6,1,0,2,2,2,2},//11
        {3,3,3,2,0,1,6,6,6,6,6,6,6,1,0,2,3,3,3},//12
        {2,2,2,2,0,1,1,1,6,1,6,1,1,1,0,2,2,2,2},//13
        {2,0,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,2},//14
        {2,0,1,1,0,1,0,1,1,1,1,1,0,1,0,1,1,0,2},//15
        {2,0,0,0,0,0,0,0,0,7,0,0,0,0,0,0,0,0,2},//16
        {2,0,1,1,0,1,1,1,1,1,1,1,1,1,0,1,1,0,2},//17
        {2,0,12,0,0,0,0,0,0,0,0,0,0,0,0,0,13,0,2},//18
        {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},//19
        {6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6}, //20
    };
    public Mappa()
    {
        pacman=new Pacman();
        f1=new Fantasma("red");
        f2=new Fantasma("orange");
        f3=new Fantasma("pink");
        f4=new Fantasma("blue");
        timer=new Timer(30, this);
        sirena=new Suono(".\\Suoni\\Pacman_Siren.wav");
        waka_waka=new Suono(".\\Suoni\\Pacman_Waka_Waka.wav");
        inizio=new Suono(".\\Suoni\\Pacman_Opening_Song.wav");
        frutto=new Suono(".\\Suoni\\Pacman_Eating_Cherry.wav");
        morte=new Suono(".\\Suoni\\Pacman_Dies.wav");
        mela=new ImageIcon(".\\Immagini\\mela.png").getImage().getScaledInstance(40, 40, 0);
        arancia=new ImageIcon(".\\Immagini\\arancia.png").getImage().getScaledInstance(40, 40, 0);
        fragola=new ImageIcon(".\\Immagini\\fragola.png").getImage().getScaledInstance(40, 40, 0);
        granata=new ImageIcon(".\\Immagini\\granata.png").getImage().getScaledInstance(40, 40, 0);
        campana=new ImageIcon(".\\Immagini\\campana.png").getImage().getScaledInstance(40, 40, 0);
        ciliegia=new ImageIcon(".\\Immagini\\ciliegia.png").getImage().getScaledInstance(40, 40, 0);
        chiave=new ImageIcon(".\\Immagini\\chiave.png").getImage().getScaledInstance(40, 40, 0);
        mattoncino=new ImageIcon(".\\Immagini\\mattoncino.jpg").getImage().getScaledInstance(40, 40, 0);
        inizio.StartClip();
        timer.start();
        rand=new Random();
        addKeyListener(this);
        setFocusable(true);
        setPreferredSize(new Dimension(760, 800));
        setBackground(Color.BLACK);
        astronave=null;
    }

    @Override
    public void keyTyped(KeyEvent e){}

    @Override
    public void keyPressed(KeyEvent e)
    {
        codice_tasto=e.getKeyCode();
    }
    
    @Override
    public void keyReleased(KeyEvent e){} 

    @Override
    public void actionPerformed(ActionEvent e) 
    {   
        if(!inizio.isRunning() && !morte.isRunning()) repaint();
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        controllo_Tasto(codice_tasto);
        Disegna_Mappa(g);
        Controlli_Fantasmi(g);
        Controlli_Pacman(g);
        Controllo_Morte(g);
        g.setColor(Color.white);
        g.setFont(new Font(null, 0, 32));
        g.drawString(("Punteggio: " + punteggio), 0, 20*40-8);
        if(punteggio==8960)
        {
            g.setFont(new Font(null, 0, 60));
            g.drawString("WINS!",290,400);
            waka_waka.StopClip();
            sirena.StopClip();
            timer.stop();
        }
        if(inizio.isRunning())
        {
            g.drawString("GET READY!",290,450);
        }
    }
    private void controllo_Tasto(int codice_tasto)
    {
        if((pacman.getX())%40==0 && (pacman.getY())%40==0)
        {
            if(codice_tasto==VK_UP)
            {
                down=false;
                left=false;
                right=false;
                up=true;
            }
            else if(codice_tasto==VK_DOWN)
            {
                up=false;
                left=false;
                right=false;
                down=true; 
            }
            else if(codice_tasto==VK_LEFT)
            {

                up=false;
                down=false;
                right=false;
                left=true;
            }
            else if(codice_tasto==VK_RIGHT)
            {
                up=false;
                down=false;
                left=false;
                right=true;  
            }  
        }
    }
    private void Collisioni(int i, int j)
    {
        if(j!=0 && left && (m[i][j-1]==1 || m[i][j-1]==2))
        {
            left=false;
            if(codice2.equals("up"))   up=true;
            else if(codice2.equals("down")) down=true;
            else if(codice2.equals("right")) right=true;
            Collisioni(i,j);
        }
        else if(j!=18 && right && (m[i][j+1]==1 || m[i][j+1]==2))
        {
            right=false;
            if(codice2.equals("up"))   up=true;
            else if(codice2.equals("down")) down=true;
            else if(codice2.equals("left")) left=true;
            Collisioni(i,j);
        }
        else if(up && (m[i-1][j]==1 || m[i-1][j]==2))
        {
            up=false;
            if(codice2.equals("left"))   left=true;
            else if(codice2.equals("down")) down=true;
            else if(codice2.equals("right")) right=true;
            Collisioni(i,j);
        }
        else if(down && (m[i+1][j]==1 || m[i+1][j]==2))
        {
            down=false;
            if(codice2.equals("up"))   up=true;
            else if(codice2.equals("left")) left=true;
            else if(codice2.equals("right")) right=true;
            Collisioni(i,j);
        }
    }
    private void CollisioniFant(Fantasma f, String dir_fant){
        if(f.getX()%40==0 && f.getY()%40==0){
            if(f.getX()/40!=0 && dir_fant.equals("left")  && (m[f.getY()/40][f.getX()/40-1]==1 || m[f.getY()/40][f.getX()/40-1]==2)){ //left
                int r=rand.nextInt(3);
                if(r==0) temp="down";
                else if(r==1) temp="up";
                else if(r==2) temp="right";
                CollisioniFant(f,temp);
            }
            else if(f.getX()/40!=18 && dir_fant.equals("right") &&  (m[f.getY()/40][f.getX()/40+1]==1 || m[f.getY()/40][f.getX()/40+1]==2)){ //right
                int r=rand.nextInt(3);
                if(r==0) temp="down";
                else if(r==1) temp="left";
                else if(r==2) temp="up";
                CollisioniFant(f,temp);
            }
            else if(dir_fant.equals("up") && (m[f.getY()/40-1][f.getX()/40]==1 || m[f.getY()/40-1][f.getX()/40]==2)){ //up
                int r=rand.nextInt(3);
                if(r==0) temp="down";
                else if(r==1) temp="left";
                else if(r==2) temp="right";
                CollisioniFant(f,temp);
            }
            else if(dir_fant.equals("down") && (m[f.getY()/40+1][f.getX()/40]==1 || m[f.getY()/40+1][f.getX()/40]==2)){ //down
                int r=rand.nextInt(3);
                if(r==0) temp="up";
                else if(r==1) temp="left";
                else if(r==2) temp="right";
                CollisioniFant(f,temp);
            }
        }
    }
    private String DirezioniFant(Fantasma f, String dir_fant){
            if(f.getX()%40==0 && f.getY()%40==0){
                if(dir_fant.equals("left") || dir_fant.equals("right"))
                {
                    if(m[f.getY()/40-1][f.getX()/40]==0 || m[f.getY()/40-1][f.getX()/40]==7|| m[f.getY()/40-1][f.getX()/40]==6 || m[f.getY()/40-1][f.getX()/40]==5){ //up
                        int r=rand.nextInt(5);
                        if(r==0 || r==1) return "up";

                    }
                    else if(m[f.getY()/40+1][f.getX()/40]==0 || m[f.getY()/40+1][f.getX()/40]==7|| m[f.getY()/40+1][f.getX()/40]==6 || m[f.getY()/40+1][f.getX()/40]==5){ //down
                        int r=rand.nextInt(5);
                        if(r==0 || r==1) return "down";   
                    }
                }
                else if(dir_fant.equals("up") || dir_fant.equals("down"))
                {
                    if(m[f.getY()/40][f.getX()/40-1]==0 || m[f.getY()/40][f.getX()/40-1]==7 || m[f.getY()/40][f.getX()/40-1]==6|| m[f.getY()/40][f.getX()/40-1]==5){ //up
                    int r=rand.nextInt(5);
                    if(r==0 || r==1) return "left";

                   }

                    else if((m[f.getY()/40][f.getX()/40+1]==0 || m[f.getY()/40][f.getX()/40+1]==7 || m[f.getY()/40][f.getX()/40+1]==6 || m[f.getY()/40][f.getX()/40+1]==5 )){ //down
                       int r=rand.nextInt(5);
                        if(r==0 || r==1) return "right";  
                    }
                }
        }
        return dir_fant;
    }
    private void ControlloDir(Fantasma f, String dir_fant){  
    if(dir_fant.equals("up")){
                f.setY(f.getY()-spostFant);
            }
            else if(dir_fant.equals("down")){
                f.setY(f.getY()+spostFant);
            }
            else if(dir_fant.equals("right")){
                f.setX(f.getX()+spostFant);
                if(f.getX()>=760) f.setX(0);
            }
            else if(dir_fant.equals("left")){    
                f.setX(f.getX()-spostFant);
                if(f.getX()<0) f.setX(720);
            }
    }
    private void Disegna_Mappa(Graphics g){
        //i=riga    j=colonna 
        for(i=0;i<20;i++)
        {
            for(j=0;j<19;j++)
            {    
                if(m[i][j]!=0 && m[i][j]!=1 && m[i][j]!=2 && pacman.getX()==j*40 && pacman.getY()==i*40 && !inizio.isRunning())
                {
                    waka_waka.StopClip();
                    waka_waka.setFrame(0);
                    if(!frutto.isRunning()) frutto.setFrame(0);
                    if(!morte.isRunning() && !inizio.isRunning()) sirena.LoopClip(1); 
                }
                if(m[i][j]==1)
                {
                   g.setColor(Color.BLUE);
                   g.fillRect(j*40, i*40, 40, 40);
                }
                else if(m[i][j]==5)
                {
                   g.setColor(Color.WHITE);
                   g.fillRect(j*40, i*40+10, 40, 5);
                }
                else if(m[i][j]==2) 
                {
                    g.setColor(Color.BLUE);
                    //g.drawRect(j*40, i*40, 40, 40);
                    g.drawImage(mattoncino, j*40, i*40, this);
                }
                else if(m[i][j]==0)
                {
                    g.setColor(Color.WHITE);
                    g.fillOval(j*40+(40-r)/2, i*40+(40-r)/2, r, r);
                    if(pacman.getX()==j*40 && pacman.getY()==i*40){
                        m[i][j]=7;
                        punteggio+=10; 
                        sirena.StopClip();
                        sirena.setFrame(0);
                        if(!frutto.isRunning()) frutto.setFrame(0);
                        if(!morte.isRunning() && !inizio.isRunning()) waka_waka.LoopClip(1);
                    }
                }
                else if(m[i][j]>=8 && m[i][j]<=14)
                {
                    if(m[i][j]==8)       g.drawImage(mela, 40*j, 40*i, this);
                    else if(m[i][j]==9)  g.drawImage(arancia, 40*j, 40*i, this); 
                    else if(m[i][j]==10) g.drawImage(fragola, 40*j, 40*i, this);
                    else if(m[i][j]==11) g.drawImage(ciliegia, 40*j, 40*i, this);
                    else if(m[i][j]==12) g.drawImage(granata, 40*j, 40*i, this);    
                    else if(m[i][j]==13) g.drawImage(campana, 40*j, 40*i, this);
                    else if(m[i][j]==14) g.drawImage(chiave, 40*j, 40*i, this); 
                    if(pacman.getX()==j*40 && pacman.getY()==i*40)
                    {
                        punteggio+=m[i][j]*100;
                        m[19][c--]=m[i][j];
                        m[i][j]=7;
                        waka_waka.StopClip();
                        waka_waka.setFrame(0);
                        frutto.StopClip();
                        frutto.setFrame(0);
                        frutto.StartClip();
                    }
                }
                
                if(j*40==pacman.getX() && i*40==pacman.getY()) Collisioni(i,j); 
            }
        }
    }
    private void Controlli_Fantasmi(Graphics g){
            if(!inizio.isRunning() && !morte.isRunning()){
            temp=dir_fant_r;
            CollisioniFant(f1,temp); 
            dir_fant_r=temp;
            dir_fant_r=DirezioniFant(f1,dir_fant_r);

            temp=dir_fant_b;
            CollisioniFant(f2,temp); 
            dir_fant_b=temp;
            dir_fant_b=DirezioniFant(f2,dir_fant_b);

            temp=dir_fant_o;
            CollisioniFant(f3,temp); 
            dir_fant_o=temp;
            dir_fant_o=DirezioniFant(f3,dir_fant_o);

            temp=dir_fant_p;
            CollisioniFant(f4,temp); 
            dir_fant_p=temp;
            dir_fant_p=DirezioniFant(f4,dir_fant_p);
        }
        if(!inizio.isRunning() && !morte.isRunning())
        {
            ControlloDir(f1,dir_fant_r);
            ControlloDir(f2,dir_fant_b);
            ControlloDir(f3,dir_fant_o);
            ControlloDir(f4,dir_fant_p);
        }
        f1.dis_fantasma(g,dir_fant_r);
        f2.dis_fantasma(g,dir_fant_b);
        f3.dis_fantasma(g,dir_fant_o);
        f4.dis_fantasma(g,dir_fant_p);
    }
    private void Controllo_Morte(Graphics g){
        if(pacman.getX()>=f1.getX() && pacman.getX()<=f1.getX()+f1.getR() && pacman.getY()>=f1.getY() && pacman.getY()<=f1.getY()+f1.getR()){
            pacman.setX(360);
            pacman.setY(600);
            f1.setX(360);
            f1.setY(280);
            f2.setX(320);
            f2.setY(360);
            f3.setX(360);
            f3.setY(360);
            f4.setX(400);
            f4.setY(360);
            waka_waka.StopClip();
            waka_waka.setFrame(0);
            sirena.StopClip();
            sirena.setFrame(0);
            morte.setFrame(0);
            morte.StartClip();
        }
        
        else if(pacman.getX()>=f2.getX() && pacman.getX()<=f2.getX()+f2.getR() && pacman.getY()>=f2.getY() && pacman.getY()<=f2.getY()+f2.getR()){
            pacman.setX(360);
            pacman.setY(600);
            f1.setX(360);
            f1.setY(280);
            f2.setX(320);
            f2.setY(360);
            f3.setX(360);
            f3.setY(360);
            f4.setX(400);
            f4.setY(360);
            waka_waka.StopClip();
            waka_waka.setFrame(0);
            sirena.StopClip();
            sirena.setFrame(0);
            morte.setFrame(0);
            morte.StartClip();
        }
        
        else if(pacman.getX()>=f3.getX() && pacman.getX()<=f3.getX()+f3.getR() && pacman.getY()>=f3.getY() && pacman.getY()<=f3.getY()+f3.getR()){
            pacman.setX(360);
            pacman.setY(600);
            f1.setX(360);
            f1.setY(280);
            f2.setX(320);
            f2.setY(360);
            f3.setX(360);
            f3.setY(360);
            f4.setX(400);
            f4.setY(360);
            waka_waka.StopClip();
            waka_waka.setFrame(0);
            sirena.StopClip();
            sirena.setFrame(0);
            morte.setFrame(0);
            morte.StartClip();
        }
        
        else if(pacman.getX()>=f4.getX() && pacman.getX()<=f4.getX()+f4.getR() && pacman.getY()>=f4.getY() && pacman.getY()<=f4.getY()+f4.getR()){
            pacman.setX(360);
            pacman.setY(600);
            f1.setX(360);
            f1.setY(280);
            f2.setX(320);
            f2.setY(360);
            f3.setX(360);
            f3.setY(360);
            f4.setX(400);
            f4.setY(360);
            waka_waka.StopClip();
            waka_waka.setFrame(0);
            sirena.StopClip();
            sirena.setFrame(0);
            morte.setFrame(0);
            morte.StartClip();
        }
        if(morte.getPuntoEsecuzione()==morte.getLunghezzaBrano()){
            morte.setFrame(0);
            morte.StopClip();
            sirena.StopClip();
            sirena.setFrame(0);
            waka_waka.StopClip();
            waka_waka.setFrame(0);
            inizio.setFrame(0);
            inizio.StartClip();
        }
    }
    private void Controlli_Pacman(Graphics g){
        if(!left && !right && !up && !down) pacman.dis_pac(g, codice2, true);
        else pacman.dis_pac(g, codice2, false);
        if(up) 
        {
           pacman.setY(pacman.getY()-spost);
           codice2="up";
        }
        else if(down) 
        {
            pacman.setY(pacman.getY()+spost);
            codice2="down";
        }
        else if(right)
        {
            pacman.setX(pacman.getX()+spost);
            if(pacman.getX()>760) pacman.setX(0);
            codice2="right";
        }
        else if(left && !inizio.isRunning() && !morte.isRunning())
        {
            pacman.setX(pacman.getX()-spost);
            if(pacman.getX()<0) pacman.setX(720); //760-39
            codice2="left";
        } 
    }
}

