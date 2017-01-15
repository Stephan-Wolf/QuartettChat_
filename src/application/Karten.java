package application;

public class Karten {
    public String Name;
    public int TopSpeed;
    public int Hubraum;
    public double TimeTo100;
    public int Zylinder;
    public int PS;
    public int RpM;

    public Karten(String name, int topspeed, int hubraum, double beschleunigung, int zylinder, int ps, int rpm) {
        // TODO Auto-generated constructor stub
        this.Name = name;
        this.TopSpeed = topspeed;
        this.Hubraum = hubraum;
        this.TimeTo100 = beschleunigung;
        this.Zylinder = zylinder;
        this.PS = ps;
        this.RpM = rpm;
    }
    
    public void printKarte(){
    	System.out.println(this.Name);
    }
    
}