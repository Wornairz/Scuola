package punto_retta;

import static java.lang.Math.*;

public class Punto {
    public float x,y;
    Punto(){
        x=0;
        y=0;
    }
    public void setXY(float x, float y){
        this.x=x;
        this.y=y;
    }
    public float distanza(float x, float y){
        return (float) sqrt((pow(x-this.x,2)+pow(y-this.y,2)));
    }
}
