package app;

import java.util.LinkedList;
import java.util.Collections;

 public class Kartenstapel {
	
	private LinkedList<Card> list;
	Card a1 = new Card("Audi-V8","/Img/Audi-V8.jpg", "500", "250","16.5","6500","4");
	Card a2 = new Card("BMW Z1","/Img/BMWZ1.jpg", "200", "220","12.5","6200","8");
	Card a3 = new Card("Honda NSX","/Img/HondaNSX.jpg", "400", "210","6.5","4500","9");
	Card a4 = new Card("Mercedes W124 (T-Modell)","/Img/Mercedes-Baureihe-W-124-als-T-Modell.jpg", "240", "220","12.5","4500","12");
	Card a5 = new Card("Mercedes 190","/Img/Mercedes190.jpg", "90", "175","8.5","1797","12.5");
	Card a6 = new Card("Mini","/Img/Mini-im-Grossstadtverkehr.jpg", "100", "150","11.5","1500","11");
	Card a7 = new Card("Opel Kadett E GS","/Img/Opel-Kadett-E-GS.jpg", "300", "250","19.5","8500","8");
	Card a8 = new Card("Opel Calibra","/Img/Opel-Calibra.jpg", "300", "180","10.5","1200","31");
	Card a9 = new Card("Porsche","/Img/Ratgeber-Porsche.jpg", "280", "250","19.5","4800","3");
	Card a10 = new Card("VW Golf 2 GTI G6","/Img/VWGolf2GTIG6.jpg", "300", "250","15.5","1600","13");
	Card a11 = new Card("VW Polo 1 GT","/Img/VWPolo2GT.jpg", "60", "150","11.3","1300","10");
	Card a12 = new Card("Porsche 911 Turbo S","/Img/Porsch911_TurboS.jpg","580","330","12","3800","3");
	Card a13 = new Card("Ferrari_F40","/Img/FerrariF40.jpg","521","325", "18","4706","3.7");
	Card a14 = new Card("Mitsubishi_Lancer_WRC","/Img/Mitsubishi_Lancer_WRC.jpg","300","280", "15","1999","4.4");
	Card a15 = new Card("Skoda_Fabia_WRC","/Img/Skoda_Fabia_WRC.jpg","295","275","17","1999","4.6");
	Card a16 = new Card("Opel_Vectra_GTS","/Img/Opel_Vectra_GTS.jpg","465","285", "21","3998","4.4");
	
	public Kartenstapel() {
		list = new LinkedList<Card>();
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
	
	public Card getKarte(int id){
		return list.get(id);
	}
	
	public void addKarte(Card a){
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
	
	
	public LinkedList<Card> getList(){
	       return list;
	}
	
	public void printAll(){
		for(Card a: list){
			a.printKarte();
		}
	}
	
	public void mischen(){
		Collections.shuffle(list);
	}
	
	public PlayerCardStack [] gebeSpielerstapel () {
		PlayerCardStack [] spielerstapel = new PlayerCardStack [2];
		PlayerCardStack spieler1Stapel = new PlayerCardStack();
		PlayerCardStack spieler2Stapel = new PlayerCardStack();
		
		int listSize = list.size();
		
		for(int i = 0; i < listSize; i++) {
			if (i%2 == 0) {
				Card k = list.removeLast();
				spieler1Stapel.fuegeKarteObenHinzu(k);
			} else {
				Card k = list.removeLast();
				spieler2Stapel.fuegeKarteObenHinzu(k);
			}
		}
		spielerstapel[0]  = spieler1Stapel;
		spielerstapel[1]  = spieler2Stapel;
		return spielerstapel;
	}
    
}