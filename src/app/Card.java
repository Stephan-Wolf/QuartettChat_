package app;

public class Card {
	
	private String name;
	private String hp;
	private String kmh;
	private String consumption;
	private String ccm;
	private String acceleration;
	private String srcOfJpg;
	
    public Card (String name, String srcOfJpg, String hp, String kmh, String consumption, String ccm, String acceleration){
    
		this.name = name;
		this.srcOfJpg = srcOfJpg;
		this.hp = hp;
		this.kmh = kmh;
		this.consumption = consumption;
		this.ccm= ccm;
		this.acceleration= acceleration;	
    }
    
    public String getName() {
    	return this.name;
    }
    
    public String getSrcOfJpG() {
    	return this.srcOfJpg;
    }
    
    public String getHp() {
    	return this.hp;
    }
    
    public String getKmh() {
    	return this.kmh; 
    }
    
    public String getConsumption() {
    	return this.consumption;
    }
    
    public String getCcm() {
    	return this.ccm;
    }
    
    public String getAcceleration() {
    	return this.acceleration;
    }
    
	public void printCard(){
    	System.out.println(this.getName());
    }    
}