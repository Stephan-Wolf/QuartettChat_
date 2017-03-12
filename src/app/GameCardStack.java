package app;

import java.util.LinkedList;
import java.util.Collections;

 public class GameCardStack {
	
	private LinkedList<Card> cards;
	Card card1 = new Card("Audi-V8","/Img/Audi-V8.jpg", "500", "250","16.5","6500","4");
	Card card2 = new Card("BMW Z1","/Img/BMWZ1.jpg", "200", "220","12.5","6200","8");
	Card card3 = new Card("Honda NSX","/Img/HondaNSX.jpg", "400", "210","6.5","4500","9");
	Card card4 = new Card("Mercedes W124 (T-Modell)","/Img/Mercedes-Baureihe-W-124-als-T-Modell.jpg", "240", "220","12.5","4500","12");
	Card card5 = new Card("Mercedes 190","/Img/Mercedes190.jpg", "90", "175","8.5","1797","12.5");
	Card card6 = new Card("Mini","/Img/Mini-im-Grossstadtverkehr.jpg", "100", "150","11.5","1500","11");
	Card card7 = new Card("Opel Kadett E GS","/Img/Opel-Kadett-E-GS.jpg", "300", "250","19.5","8500","8");
	Card card8 = new Card("Opel Calibra","/Img/Opel-Calibra.jpg", "300", "180","10.5","1200","31");
	Card card9 = new Card("Porsche","/Img/Ratgeber-Porsche.jpg", "280", "250","19.5","4800","3");
	Card card10 = new Card("VW Golf 2 GTI G6","/Img/VWGolf2GTIG6.jpg", "300", "250","15.5","1600","13");
	Card card11 = new Card("VW Polo 1 GT","/Img/VWPolo2GT.jpg", "60", "150","11.3","1300","10");
	Card card12 = new Card("Porsche 911 Turbo S","/Img/Porsch911_TurboS.jpg","580","330","12","3800","3");
	Card card13 = new Card("Ferrari F40","/Img/FerrariF40.jpg","521","325", "18","4706","3.7");
	Card card14 = new Card("Mitsubishi Lancer WRC","/Img/Mitsubishi_Lancer_WRC.jpg","300","280", "15","1999","4.4");
	Card card15 = new Card("Skoda Fabia WRC","/Img/Skoda_Fabia_WRC.jpg","295","275","17","1999","4.6");
	Card card16 = new Card("Opel Vectra GTS","/Img/Opel_Vectra_GTS.jpg","465","285", "21","3998","4.4");
	
	public GameCardStack() {
		cards = new LinkedList<Card>();
		cards.add(card1);
		cards.add(card2);
		cards.add(card3);
		cards.add(card4);
		cards.add(card5);
		cards.add(card6);
		cards.add(card7);
		cards.add(card8);
		cards.add(card9);
		cards.add(card10);
		cards.add(card11);
		cards.add(card12);
		cards.add(card13);
		cards.add(card14);
		cards.add(card15);
		cards.add(card16);
	}
	
	public void printAllCards(){
		for(Card card: cards){
			card.printCard();
		}
	}
	
	public void mix(){
		Collections.shuffle(cards);
	}
	
	public PlayerCardStack [] getPlayerCardStacks () {
		PlayerCardStack [] playerCardStacks = new PlayerCardStack [2];
		PlayerCardStack players1CardStack = new PlayerCardStack();
		PlayerCardStack players2CardStack = new PlayerCardStack();
		
		int numberOfCards = cards.size();
		
		for(int i = 0; i < numberOfCards; i++) {
			if (i%2 == 0) {
				Card card = cards.removeLast();
				players1CardStack.addCardOnTop(card);
			} else {
				Card card = cards.removeLast();
				players2CardStack.addCardOnTop(card);
			}
		}
		playerCardStacks[0]  = players1CardStack;
		playerCardStacks[1]  = players2CardStack;
		return playerCardStacks;
	} 
}