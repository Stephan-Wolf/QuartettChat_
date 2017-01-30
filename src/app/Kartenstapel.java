package app;
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