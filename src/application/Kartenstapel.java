package application;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Collections;

 public class Kartenstapel {
	
	// LinkedList statt List und ArrayList
	 // dadurch k�nnen wir sehr einfach am Ende / Anfang einf�gen / entfernen
	 // die letzten 5 Werten von Karten auf float �ndern!!
	private LinkedList<Karte> list;// hier vom typ der Karten-Klasse
	Karte a1 = new Karte("Audi-V8","/Img/Audi-V8.jpg", "500", "250","16.5","6500","4");
	Karte a2 = new Karte("BMW Z1","/Img/BMWZ1.jpg", "200", "220","12.5","6200","8");
	Karte a3 = new Karte("Honda NSX","/Img/HondaNSX.jpg", "400", "210","6.5","4500","9");
	Karte a4 = new Karte("Mercedes W124 (T-Modell)","/Img/Mercedes-Baureihe-W-124-als-T-Modell.jpg", "240", "220","12.5","4500","12");
	Karte a5 = new Karte("Mercedes 190","/Img/Mercedes190.jpg", "200", "50","26.5","3530","3.5");
	Karte a6 = new Karte("Mini","/Img/Mini-im-Grossstadtverkehr.jpg", "100", "150","11.5","1500","11");
	Karte a7 = new Karte("Opel Kadett E GS","/Img/Opel-Kadett-E-GS.jpg", "300", "250","19.5","8500","8");
	Karte a8 = new Karte("Opel Calibra","/Img/Opel-Calibra.jpg", "300", "180","10.5","1200","31");
	Karte a9 = new Karte("Porsche","/Img/Ratgeber-Porsche.jpg", "280", "250","19.5","4800","3");
	Karte a10 = new Karte("VW Golf 2 GTI G6","/Img/VWGolf2GTIG6.jpg", "300", "250","15.5","1600","13");
	Karte a11 = new Karte("VW Polo 2 GT","/Img/VWPolo2GT.jpg", "320", "190","11.3","1300","10");
	Karte a12 = new Karte("Porsche 911 Turbo S","/Img/Porsch911_TurboS.jpg","580","330","12","3800","3");
	Karte a13 = new Karte("Ferrari_F40","/Img/FerrariF40.jpg","521","325", "18","4706","3.7");
	Karte a14 = new Karte("Mitsubishi_Lancer_WRC","/Img/Mitsubishi_Lancer_WRC.jpg","300","280", "15","1999","4.4");
	Karte a15 = new Karte("Skoda_Fabia_WRC","/Img/Skoda_Fabia_WRC.jpg","295","275","17","1999","4.6");
	Karte a16 = new Karte("Opel_Vectra_GTS","/Img/Opel_Vectra_GTS.jpg","465","285", "21","3998","4.4");
//	Karte a13 = new Karte("Ferrari F40","/Img/FerrariF40.jpg","521","325", "18","4706","3.7");
//	Karte a14 = new Karte("Mitsubishi Lancer WRC","/Img/Mitsubishi_Lancer_WRC.jpg","300","280", "15","1999","4.4");
//	Karte a15 = new Karte("Skoda Fabia WRC","/Img/Skoda_Fabia_WRC.jpg","295","275","17","1999","4.6");
//	Karte a16 = new Karte("Opel Vectra GTS","/img/Opel_Vectra_GTS.jpg","465","285", "21","3998","4.4");

	
	//  Karte (String name, String bildUrl, String ps, String kmh, String verbrauch, String ccm, String beschleunigung)
	public Kartenstapel() {
		list = new LinkedList<Karte>();
		list.add(a1);
		list.add(a2);
		list.add(a3);
		list.add(a4);
		list.add(a5);
		list.add(a6);
		list.add(a7);
		list.add(a8);
		list.add(a9);
		list.add(a10);
		list.add(a11);
		list.add(a12);
		list.add(a13);
		list.add(a14);
		list.add(a15);
		list.add(a16);
		
//        list.add(new Karte("Audi_A4_DTM", "bildUrl", "465", "290", "20", "4000", "4.3"));
//        list.add(new Karte("Chrysler_Viper_GTSR","bildUrl", "600", "315", "30","7986", "3.7"));
//        list.add(new Karte("Citroen_Xsara_WRC","bildUrl", "305", "270", "18","1998", "4.7"));
//        list.add(new Karte("VW_Polo_Super1600","bildUrl", "215", "205", "12","1598","5.8"));
//        list.add(new Karte("Opel_Vectra_GTS","bildUrl","465","285", "21","3998","4.4"));
//        list.add(new Karte("Bentley_EXP_Speed8","bildUrl","620","335","32","3994","3.8"));
//        list.add(new Karte("Skoda_Fabia_WRC","bildUrl","295","275","17","1999","4.6"));
//        list.add(new Karte("BMW_320i_WTCC","bildUrl","275","250", "19","1998","4.4"));
//        list.add(new Karte("Nissan_350Z_JGTC","bildUrl","465","330", "16","2987","4.1"));
//        list.add(new Karte("Maserati_MC12","bildUrl","630","335","22","5998","3.8"));
//        list.add(new Karte("Mitsubishi_Lancer_WRC","bildUrl","300","280", "15","1999","4.4"));
//        list.add(new Karte("Lister_Storm_GT","bildUrl","630","325","33","6996","3.7"));
//        list.add(new Karte("Mercedez_C_AMG","bildUrl","465","295","14","4000","4.1"));
//        list.add(new Karte("Porsche_911_Carrera_RS","bildUrl","280","280", "14","3600","4.8"));
//        list.add(new Karte("Subaru_Impreza_WRC","bildUrl","310","285","18","1998","4.8"));
//        list.add(new Karte("Cadillac_CTSV","bildUrl","500","265","35","6026","4.9"));
//        list.add(new Karte("Pescarolo_Judd_LMP1","bildUrl","630","385","25","4997","3.0"));
//        list.add(new Karte("TVR_Tuscan_400R","bildUrl","446","330","25","3996","3.9"));
//        list.add(new Karte("Volvo_S60","bildUrl","285","280","12","2400","4.6"));
//        list.add(new Karte("Chevrolet_Lacetti_WTCC","bildUrl","280","254","18","1998","4.5"));
//        list.add(new Karte("Vauxhall_Astra","bildUrl","335","298","25","3998","3.9"));
//        list.add(new Karte("AlflaRomeo_147_GTACup","bildUrl","220","230","14","1970","5.6"));
//        list.add(new Karte("Morgan_Aero_GT","bildUrl","500","330","31","4398","4.1"));
//        list.add(new Karte("Suzuki_Ignis","bildUrl","215","225","17","1598","6.0"));
//        list.add(new Karte("Porsche_996_GT3_RSR","bildUrl","451","295","16","3598","3.1"));
//        list.add(new Karte("Audi_R8","bildUrl","593","330","14","3600","3.3"));
//        list.add(new Karte("Porsche_911_GT1","bildUrl","600","355","16","3200","3.5"));
//        list.add(new Karte("Heiko_HS4_ODIN","bildUrl","354","275","12","2521","5.5"));
//        list.add(new Karte("Peugeot_307_WRC","bildUrl","298","290","18","1998","4.3"));
//        list.add(new Karte("Seat_Leon_Supercopa","bildUrl","254","235", "11","1797","4.8"));
//        list.add(new Karte("Ford_Focus_WRC","bildUrl","300","205", "17","1998","3.9"));
//        list.add(new Karte("Ferrari_F40","bildUrl","521","325", "18","4706","3.7"));
	}
	
	public Karte getKarte(int id){
		return list.get(id);
	}
	
	public void addKarte(Karte a){
		list.add(a);
	}
	
	// Wird das überhaupt benötigt?  
	public void entferneKarte(int i){
		list.remove(i);
	}
	
	//Testen
	public void entferneErsteKarte(){
		list.removeFirst();
	}
	
	
	public LinkedList<Karte> getList() {
	       return list;
	}
	
	public void printAll(){
		for(Karte a: list){
			a.printKarte();
		}
	}
	
	public void mischen () {
		Collections.shuffle(list);
	}
	
	public Spielerstapel [] gebeSpielerstapel () {
		Spielerstapel [] spielerstapel = new Spielerstapel [2];
		Spielerstapel spieler1Stapel = new Spielerstapel();
		Spielerstapel spieler2Stapel = new Spielerstapel();
		
		int listSize = list.size();
		
		for(int i = 0; i < listSize; i++) {
			if (i%2 == 0) {
				Karte k = list.removeLast();
				spieler1Stapel.fuegeKarteObenHinzu(k);
			} else {
				Karte k = list.removeLast();
				// k.printKarte();
				spieler2Stapel.fuegeKarteObenHinzu(k);
			}
		}
		spielerstapel[0]  = spieler1Stapel;
		spielerstapel[1]  = spieler2Stapel;
		// return (new Spielerstapel [] {spieler1Stapel, spieler2Stapel});
		return spielerstapel;
	}
    
}