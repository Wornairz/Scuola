package javaapplication1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;
import static java.awt.event.KeyEvent.VK_ENTER;
import static java.awt.event.KeyEvent.VK_ESCAPE;
import static java.awt.event.KeyEvent.VK_LEFT;
import static java.awt.event.KeyEvent.VK_RIGHT;
import javax.swing.*;

/**
 *
 * @author admin
 */
public class Mappa extends JPanel implements ActionListener, KeyListener{
    //0 spazi vuoti - 1 mattoncini - 2 spuntoni - 3 frammenti
    private final int alt, larg, spost=5,hei=700,wid=600;
    private Image immagini[]=new Image[5];
    private int posizione=0, i=0;
    Dimension schermo;
    Suono cambpag,sottofondoini,sottosto;
    private boolean up=false,down=false,left=false,right=false,scendi=true,iniziale=true,menù=false,enter=true,dr=false,dl=false;
    private Personaggio pg;
    private final Image mattoncino, spuntup, spuntdown, spuntleft, spuntright, foglio, torcia, sfondo, logo;
    private String dir="", codice2;
    private final int m[][] = new int[][]{
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,4,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},
        {1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,3,1,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,4,0,0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0},
        {0,0,4,0,0,0,0,0,0,0,0,0,0,0,22,1,0,0,0,0,0,0,4,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,22,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {3,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {1,1,0,1,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,22,1,0,0,0,0},
        {1,222,0,22,1,0,0,0,0,1,0,0,0,0,0,0,0,0,1,222,0,0,0,0,22,1,0,0,0,0},
        {1,222,0,22,1,2,2,2,2,1,0,0,0,4,0,0,0,0,1,0,0,0,0,0,22,1,0,0,0,0},
        {1,222,0,22,1,1,1,1,1,1,0,0,0,0,0,1,1,1,1,0,0,0,1,1,1,1,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,4,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,2,1,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,1,1,0,0,0,0,4,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,1,0,0,0,0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {3,2,2,2,0,0,1,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,3,0,0,0,0,0},
        {1,1,1,1,1,1,1,0,0,0,0,0,0,0,1,1,0,1,1,0,0,0,0,1,1,1,1,1,1,1},
    };     
    private final Timer timer;

    public Mappa(Dimension schermo) {
        this.schermo=schermo;
        larg = 45;
        alt=32;
        timer = new Timer(30, this);
        cambpag=new Suono(".\\Suoni\\colpo.mp3");
        sottofondoini=new Suono(".\\Suoni\\MarciaImperiale.mp3");
        sottosto=new Suono(".\\Suoni\\KyloRenTheme.mp3"); 
       immagini[0]=new ImageIcon(".\\Immagini\\Fogliperg1.png").getImage().getScaledInstance(wid, hei, WIDTH);
       immagini[1]=new ImageIcon(".\\Immagini\\Fogliperg2.png").getImage().getScaledInstance(wid, hei, WIDTH);
       immagini[2]=new ImageIcon(".\\Immagini\\Fogliperg3.png").getImage().getScaledInstance(wid, hei, WIDTH);
       immagini[3]=new ImageIcon(".\\Immagini\\Fogliperg4.png").getImage().getScaledInstance(wid, hei, WIDTH);
       immagini[4]=new ImageIcon(".\\Immagini\\Fogliperg5.png").getImage().getScaledInstance(wid, hei, WIDTH);
        logo= new ImageIcon(".\\Immagini\\logo.jpg").getImage().getScaledInstance(schermo.width,schermo.height, WIDTH); // logo iniziale 
        mattoncino = new ImageIcon(".\\Immagini\\mattone2.png").getImage().getScaledInstance(larg, alt, WIDTH);
        spuntup = new ImageIcon(".\\Immagini\\spuntoni.png").getImage().getScaledInstance(larg, alt, WIDTH);
        spuntdown = new ImageIcon(".\\Immagini\\spuntonisotto.png").getImage().getScaledInstance(larg, alt, WIDTH);
        spuntright = new ImageIcon(".\\Immagini\\spuntonidestra.png").getImage().getScaledInstance(larg, alt, WIDTH);
        spuntleft = new ImageIcon(".\\Immagini\\spuntonisinistra.png").getImage().getScaledInstance(larg, alt, WIDTH);
        foglio = new ImageIcon(".\\Immagini\\fogligif.gif").getImage().getScaledInstance(larg, alt, WIDTH);
        torcia=new ImageIcon(".\\Immagini\\torcia.gif").getImage().getScaledInstance(larg,larg,WIDTH);
        sfondo=new ImageIcon(".\\Immagini\\Sfondo.jpg").getImage().getScaledInstance(1366,768,WIDTH);
        pg = new Personaggio(3*alt, larg);
        timer.start();
        setPreferredSize(schermo);
        setFocusable(true);
        addKeyListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(!menù)
        {
            /*sottofondoini.setMediaTimer();
            sottofondoini.Start();*/
        }
        if(dr && i<immagini.length)
        {
            i++;            
            /*cambpag.setMediaTimer();
            cambpag.Start();*/
            dr=false;
        }
        if(dl && i>0)  
        {
            i--;
            /*cambpag.setMediaTimer();
            cambpag.Start();*/
            dl=false;
        }       
        if(i==immagini.length-1)
        {    menù=false;
            iniziale=false;
           //sottosto.Stop();
        g.drawImage(sfondo, 0, 0, this);
        Disegna_Mappa(g); 
        Controlla_personaggio();
        }     
        if(menù)
               Menù(g);
        else
       if(iniziale)
           try {
                Stampainiz(g);
            } catch (InterruptedException ex) {} 
    }
    private void Disegna_Mappa(Graphics g){
        int i, j;
        //0 spazi vuoti - 1 mattoncini - 2 spuntoni - 3 frammenti 
        //i=riga    j=colonna
        codice2="sotto";
        for(i=0;i<24;i++){
            for(j=0;j<30;j++){   
                switch (m[i][j]){
                    case 1:
                        g.setColor(Color.BLUE);
                        g.drawImage(mattoncino, j*larg, i*alt, this);
                        Collisioni(i,j);
                        break;
                    case 4:
                        g.drawImage(torcia, j*larg, i*alt, this);
                        break;
                    case 2:
                        g.drawImage(spuntup, j*larg, i*alt, this);
                        Controllo_Morte(i,j);
                        break;
                    case 22:
                        g.drawImage(spuntleft, j*larg, i*alt, this);
                        Controllo_Morte(i,j);
                        break;
                    case 222:
                        g.drawImage(spuntright, j*larg, i*alt, this);
                        Controllo_Morte(i,j);
                        break;
                    case 2222:
                        g.drawImage(spuntdown, j*larg, i*alt, this);
                        Controllo_Morte(i,j);
                        break;
                    case 0:
                        break;
                    case 3:
                        g.setColor(Color.YELLOW);
                        g.drawImage(foglio, j*larg, i*alt, this);
                        break;
                    default:
                        break;
                }
            }
        }
        if(!left && !right) pg.dis_pg(g, dir, true);
        else { 
                if(up) dir="sopra";
                else if(right) dir="destra";
                else if(left) dir="sinistra";
                pg.dis_pg(g, dir, false);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==VK_LEFT)
            if(menù)
              dl=true;  
        if(e.getKeyCode()==VK_RIGHT)
            if(menù)
              dr=true;  
        if(e.getKeyCode()==VK_ENTER){
            if(enter){ 
            /*sottofondoini.Stop();
            sottosto.setMediaTimer();
            sottosto.Start();*/
                enter=false;
                menù=true;
                timer.start();
            }
        }
        if(e.getKeyCode()==VK_ESCAPE)
            System.exit(0);
        if(e.getKeyCode()==KeyEvent.VK_W && !up)
        {  
            up=true;
        }
        if(e.getKeyCode()==KeyEvent.VK_A) left=true;
        if(e.getKeyCode()==KeyEvent.VK_D) right=true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //if(e.getKeyCode()==KeyEvent.VK_W) 
        if(e.getKeyCode()==KeyEvent.VK_A) left=false;
        if(e.getKeyCode()==KeyEvent.VK_D) right=false;
        if(e.getKeyCode()==VK_LEFT)
              dl=false;  
        if(e.getKeyCode()==VK_RIGHT)
              dr=false; 
    }  
    
    private void Controlla_personaggio()
    {
        if(pg.getX()%larg==0 && pg.getY()%alt==0)
        {
            if(m[(pg.getY()+alt)/alt][pg.getX()/larg]==3)
            {
                m[(pg.getY()+alt)/alt][pg.getX()/larg]=0;
            }
        } 
        if(up)
        {
            if(!scendi)            
              pg.setY(pg.getY()-spost*2);
            
        }
        if(pg.getY()<=posizione-150){
                    scendi=true;  
                    up=false;
                    
        }
        
        if(left)  if(pg.getX()>0) pg.setX(pg.getX()-spost); 
        if(right) pg.setX(pg.getX()+spost);
        
        if(codice2.equals("sotto"))
        { 
            pg.setY(pg.getY()+spost);
            if(pg.getY()+pg.getAltezza()>24*alt){
                pg.setX(3*alt);
                pg.setY(larg);
            }
            
        } 
    }
    private void Collisioni(int i, int j)
    {
        if(left && j!=0)
        {
            if((pg.getX()>=j*larg && pg.getX()<=j*larg+larg && pg.getY()+(pg.getAltezza()/4)>=i*alt && pg.getY()+(pg.getAltezza()/4)<=i*alt+alt) ){
                left=false;
                Collisioni(i,j);
            }
            else if((pg.getX()>=j*larg && pg.getX()<=j*larg+larg && pg.getY()+(pg.getAltezza()/4)*3>=i*alt && pg.getY()+(pg.getAltezza()/4)*3<=i*alt+alt) ){
                left=false;
                Collisioni(i,j);
            }
        }
        else if(right)
        {
            if(pg.getX()+larg>=j*larg && pg.getX()+larg<=j*larg+larg && pg.getY()+(pg.getAltezza()/4)>=i*alt && pg.getY()+(pg.getAltezza()/4)<=i*alt+alt){
                right=false;
                Collisioni(i,j);
            }
            else if(pg.getX()+larg>=j*larg && pg.getX()+larg<=j*larg+larg && pg.getY()+(pg.getAltezza()/4)*3>=i*alt && pg.getY()+(pg.getAltezza()/4)*3<=i*alt+alt){
                right=false;
                Collisioni(i,j);
            }
        }
        else if(up  && pg.getY()<=i*alt+alt && pg.getY()>=i*alt && pg.getX()+pg.getLarghezza()/2>=j*larg && pg.getX()+pg.getLarghezza()/2<j*larg+larg)
        {
            scendi=true;
            up=false;
            Collisioni(i,j);
        }
        if(codice2.equals("sotto")  && pg.getY()+pg.getAltezza()<=i*alt+alt && pg.getY()+pg.getAltezza()>=i*alt && pg.getX()+pg.getLarghezza()/2>=j*larg && pg.getX()+pg.getLarghezza()/2<j*larg+larg)
        {
            codice2="";
            scendi=false;
            posizione=pg.getY();
            Collisioni(i,j);
        }
    }
    
    private void Stampainiz(Graphics g) throws InterruptedException{
            g.drawImage(logo,0,0,this);
            g.setColor(Color.red);
            g.setFont(new Font("TimesRoman",Font.BOLD,42));
            g.drawString("Press ENTER to get into the menù", schermo.width-(g.getFontMetrics().stringWidth("Press ENTER to get into the menù"))-schermo.width/100*2, schermo.height-schermo.height/100*2);
            g.drawString("Press ESC to exit the game", 0+schermo.width/100*2, schermo.height-schermo.height/100*2);
            timer.stop();
    }    
                                                                                                                                                                                                               
    private void Menù(Graphics g){
           g.drawImage(immagini[i],(schermo.width-wid)/2,(schermo.height-hei)/2, this);
           g.setColor(Color.red);
           g.setFont(new Font("TimesRoman",Font.BOLD,40));
           g.drawString("Press ESC to exit the game",0,schermo.height-10);
           g.drawString("Press -> or <- to move into the book",schermo.width-g.getFontMetrics().stringWidth("Press -> or <- to move into the book"),schermo.height-10);
    }
    private void Controllo_Morte(int i,int j){
        /*switch (m[i][j]) {
            case 2:
                if(pg.getX()){
                    
                }
                break;
            case 22:
                break;
            case 222:
                break;
            default:
                break;
        }*/
    }
}
