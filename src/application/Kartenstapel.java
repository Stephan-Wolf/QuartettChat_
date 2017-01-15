package application;
import java.util.ArrayList;
import java.util.List;

 public class Kartenstapel {
	
	 private int anzahlKarten;
	 
	List<Karten> Karten = new ArrayList<Karten>(); // hier vom typ der Karten-Klasse
	
	public Kartenstapel(){
		
	}
	
	//  public Karten(String name, int topspeed, int hubraum, double beschleunigung, int zylinder, int ps, int rpm)
	
	public Kartenstapel(int a){
        Karten.add(new Karten("Audi_A4_DTM", "bildUrl", 465, 290, 20, 4000, 4.3));
        Karten.add(new Karten("Chrysler_Viper_GTSR", 315, 7986, 3.7, 10, 600, 7000));
        Karten.add(new Karten("Citroen_Xsara_WRC", 270, 1998, 4.7, 4, 305, 7300));
        Karten.add(new Karten("VW_Polo_Super1600",205,1598,5.8,4,215,8750));
        Karten.add(new Karten("Opel_Vectra_GTS",285,3998,4.4,8,465,6800));
        Karten.add(new Karten("Bentley_EXP_Speed8",335,3994,3.8,8,620,7900));
        Karten.add(new Karten("Skoda_Fabia_WRC",275,1999,4.6,4,295,6900));
        Karten.add(new Karten("BMW_320i_WTCC",250,1998,4.4,4,275,8800));
        Karten.add(new Karten("Nissan_350Z_JGTC",330,2987,4.1,6,465,5600));
        Karten.add(new Karten("Maserati_MC12",335,5998,3.8,12,630,7700));
        Karten.add(new Karten("Mitsubishi_Lancer_WRC",280,1999,4.4,4,300,7700));
        Karten.add(new Karten("Lister_Storm_GT",325,6996,3.7,12,630,8400));
        Karten.add(new Karten("Mercedez_C_AMG",295,4000,4.1,8,465,7500));
        Karten.add(new Karten("Porsche_911_Carrera_RS",280,3600,4.8,6,280,6800));
        Karten.add(new Karten("Subaru_Impreza_WRC",285,1998,4.8,4,310,6900));
        Karten.add(new Karten("Cadillac_CTSV",265,6026,4.9,8,500,7800));
        Karten.add(new Karten("Pescarolo_Judd_LMP1",385,4997,3.0,10,630,8100));
        Karten.add(new Karten("TVR_Tuscan_400R",330,3996,3.9,6,446,7600));
        Karten.add(new Karten("Volvo_S60",280,2400,4.6,5,285,6500));
        Karten.add(new Karten("Chevrolet_Lacetti_WTCC",254,1998,4.5,4,280,8500));
        Karten.add(new Karten("Vauxhall_Astra",298,3998,3.9,8,335,6900));
        Karten.add(new Karten("AlflaRomeo_147_GTACup",230,1970,5.6,4,220,7000));
        Karten.add(new Karten("Morgan_Aero_GT",330,4398,4.1,8,500,6300));
        Karten.add(new Karten("Suzuki_Ignis",225,1598,6.0,4,215,8750));
        Karten.add(new Karten("Porsche_996_GT3_RSR",295,3598,3.1,6,451,8250));
        Karten.add(new Karten("Audi_R8",330,3600,3.3,8,593,8050));
        Karten.add(new Karten("Porsche_911_GT1",355,3200,3.5,6,600,7200));
        Karten.add(new Karten("Heiko_HS4_ODIN",275,2521,5.5,5,354,6000));
        Karten.add(new Karten("Peugeot_307_WRC",290,1998,4.3,4,298,6500));
        Karten.add(new Karten("Seat_Leon_Supercopa",235,1797,4.8,4,254,6300));
        Karten.add(new Karten("Ford_Focus_WRC",205,1998,3.9,4,300,6000));
        Karten.add(new Karten("Ferrari_F40",325,4706,3.7,12,521,8700));
	}
	
	public Karten getKarte(int id){
		return Karten.get(id);
	}
	
	public void addKarte(Karten a){
		Karten.add(a);
	}
	
	
	// Muss noch 
	public void entferneKarte(){
		return;
	}
	
	public void printAll(){
		for(Karten a: Karten){
			a.printKarte();
		}
	}
	
    public static void main(String [] args) {

    }
}