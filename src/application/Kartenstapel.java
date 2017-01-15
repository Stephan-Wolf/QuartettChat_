package application;
import java.util.ArrayList;
import java.util.List;

 public class Kartenstapel {
	
	 private int anzahlKarten;
	 
	List<Karte> Karte = new ArrayList<Karte>(); // hier vom typ der Karten-Klasse
	
	public Kartenstapel(){
		
	}
	
	//  public Karten(String name, int topspeed, int hubraum, double beschleunigung, int zylinder, int ps, int rpm)
	//  (String name, String bildUrl, String ps, String kmh, String verbrauch, String ccm, String beschleunigung)
	public Kartenstapel(int a){
        Karte.add(new Karte("Audi_A4_DTM", "bildUrl", "465", "290", "20", "4000", "4.3"));
        Karte.add(new Karte("Chrysler_Viper_GTSR","bildUrl", "600", "315", "30","7986", "3.7"));
        Karte.add(new Karte("Citroen_Xsara_WRC","bildUrl", "305", "270", "18","1998", "4.7"));
        Karte.add(new Karte("VW_Polo_Super1600","bildUrl", "215", "205", "12","1598","5.8"));
        Karte.add(new Karte("Opel_Vectra_GTS","bildUrl","465","285", "21","3998","4.4"));
        Karte.add(new Karte("Bentley_EXP_Speed8","bildUrl",620,335, 32,3994,3.8));
        Karte.add(new Karte("Skoda_Fabia_WRC","bildUrl",295,275, 17,1999,4.6));
        Karte.add(new Karte("BMW_320i_WTCC","bildUrl",275,250, 19,1998,4.4));
        Karte.add(new Karte("Nissan_350Z_JGTC","bildUrl",465,330, 16,2987,4.1));
        Karte.add(new Karte("Maserati_MC12","bildUrl",630,335, 22,5998,3.8));
        Karte.add(new Karte("Mitsubishi_Lancer_WRC","bildUrl",300,280, 15,1999,4.4));
        Karte.add(new Karte("Lister_Storm_GT","bildUrl",630,325, 33,6996,3.7));
        Karte.add(new Karte("Mercedez_C_AMG","bildUrl",465,295, 14,4000,4.1));
        Karte.add(new Karte("Porsche_911_Carrera_RS","bildUrl",280,280, 14,3600,4.8));
        Karte.add(new Karte("Subaru_Impreza_WRC","bildUrl",310,285, 18,1998,4.8));
        Karte.add(new Karte("Cadillac_CTSV","bildUrl",500,265, 35,6026,4.9));
        Karte.add(new Karte("Pescarolo_Judd_LMP1","bildUrl",630,385, 25,4997,3.0));
        Karte.add(new Karte("TVR_Tuscan_400R","bildUrl",446,330, 25,3996,3.9));
        Karte.add(new Karte("Volvo_S60","bildUrl",285,280, 12,2400,4.6));
        Karte.add(new Karte("Chevrolet_Lacetti_WTCC","bildUrl",280,254, 18,1998,4.5));
        Karte.add(new Karte("Vauxhall_Astra","bildUrl",335,298, 25,3998,3.9));
        Karte.add(new Karte("AlflaRomeo_147_GTACup","bildUrl",220,230, 14,1970,5.6));
        Karte.add(new Karte("Morgan_Aero_GT","bildUrl",500,330, 31,4398,4.1));
        Karte.add(new Karte("Suzuki_Ignis","bildUrl",215,225, 17,1598,6.0));
        Karte.add(new Karte("Porsche_996_GT3_RSR","bildUrl",451,295, 16,3598,3.1));
        Karte.add(new Karte("Audi_R8","bildUrl",593,330, 14,3600,3.3));
        Karte.add(new Karte("Porsche_911_GT1","bildUrl",600,355, 16,3200,3.5));
        Karte.add(new Karte("Heiko_HS4_ODIN","bildUrl",354,275, 12,2521,5.5));
        Karte.add(new Karte("Peugeot_307_WRC","bildUrl",298,290, 18,1998,4.3));
        Karte.add(new Karte("Seat_Leon_Supercopa","bildUrl","254","235", "11","1797","4.8"));
        Karte.add(new Karte("Ford_Focus_WRC","bildUrl","300","205", "17","1998","3.9"));
        Karte.add(new Karte("Ferrari_F40","bildUrl","521","325", "18","4706","3.7"));
	}
	
	public Karte getKarte(int id){
		return Karte.get(id);
	}
	
	public void addKarte(Karte a){
		Karte.add(a);
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