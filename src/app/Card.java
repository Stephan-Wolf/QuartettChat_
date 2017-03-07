package app;

//import javafx.beans.property.ObjectProperty;
//import javafx.beans.property.ReadOnlyStringProperty;
//import javafx.beans.property.SimpleObjectProperty;
//import javafx.beans.property.SimpleStringProperty;
//import javafx.beans.property.StringProperty;
//import javafx.scene.image.Image;

public class Card {
    // private StringProperty cardName = new SimpleStringProperty();
    // private ObjectProperty<javafx.scene.image.Image> imageProperty = new SimpleObjectProperty<>();

//    private String image;
//    private StringProperty jpgUrl = new SimpleStringProperty();
//	private StringProperty ps = new SimpleStringProperty();
//	private StringProperty kmhSpeed = new SimpleStringProperty();
//	private StringProperty verbrauch = new SimpleStringProperty();
//	private StringProperty ccMotor = new SimpleStringProperty();
//	private StringProperty beschleunigung = new SimpleStringProperty();
	
	
	private String name;
	private String hp;
	private String kmh;
	private String consumption;
	private String ccm;
	private String acceleration;
	private String srcOfJpg;
	
	
    
    public Card (String name, String srcOfJpg, String hp, String kmh, String consumption, String ccm, String acceleration){
    
//    	this.jpgUrl.setValue(srcOfJpg);
//    	this.cardName.setValue(name);
//        this.image = new String(srcOfJpg);
//        Image imageUse = new Image(image);
//        this.imageProperty.set(imageUse);
//		this.ps.setValue(hp);
//		this.kmhSpeed.setValue(kmh);
//		this.verbrauch.setValue(consumption);
//		this.ccMotor.setValue(ccm);
//		this.beschleunigung.setValue(acceleration);
		
		this.name = name;
		this.srcOfJpg = srcOfJpg;
		this.hp = hp;
		this.kmh = kmh;
		this.consumption = consumption;
		this.ccm= ccm;
		this.acceleration= acceleration;
		
		
    }
    
//    BRAUCHEN WIR BEIDE?
//    public ReadOnlyStringProperty kmhProperty(){
//		return kmh;
//	}
//	
//	public StringProperty getKmhProperty(){
//		return kmh;
//	}
    
    
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
    
//    public ObjectProperty<javafx.scene.image.Image> getImageProperty() {
//		return imageProperty;
//	}
//
//	public void setImageProperty(ObjectProperty<javafx.scene.image.Image> imageProperty) {
//		this.imageProperty = imageProperty;
//	}
	

	public void printKarte(){
    	System.out.println(this.getName());
    }
    
    
//    public String getName1() {
//		return cardName.get();
//	}
//
//	public void setName(String name) {
//		this.cardName.set(name);
//	}
//	
//	public ReadOnlyStringProperty nameProperty(){
//		return cardName;
//	}
//	
//	public StringProperty getNameProperty(){
//		return cardName;
//	}
	
//	public String getImage() {
//		return image;
//	}
//
//	public String getPs() {
//		return ps.get();
//	}
//
//	public void setPs(String ps) {
//		this.ps.set(ps);
//	}
//	
//	public ReadOnlyStringProperty psProperty(){
//		return ps;
//	}
//	
//	public StringProperty getPsProperty(){
//		return ps;
//	}
//
//	public String getKmh1() {
//		return kmhSpeed.get();
//	}
//
//	public void setKmh(String kmh) {
//		this.kmhSpeed.set(kmh);
//	}
//	
//	public ReadOnlyStringProperty kmhProperty(){
//		return kmhSpeed;
//	}
//	
//	public StringProperty getKmhProperty(){
//		return kmhSpeed;
//	}
//
//	public String getVerbrauch() {
//		return verbrauch.get();
//	}
//
//	public void setVerbrauch(String verbrauch) {
//		this.verbrauch.set(verbrauch);
//	}
//	
//	public ReadOnlyStringProperty verbrauchProperty(){
//		return verbrauch;
//	}
//	
//	public StringProperty getVerbrauchProperty(){
//		return verbrauch;
//	}
//
//	public String getCcm1() {
//		return ccMotor.get();
//	}
//
//	public void setCcm(String ccm) {
//		this.ccMotor.set(ccm);
//	}
//	
//	public ReadOnlyStringProperty ccmProperty(){
//		return ccMotor;
//	}
//	
//	public StringProperty getCcmProperty(){
//		return ccMotor;
//	}
//	
//	public StringProperty getJgpUrlProperty(){
//		return jpgUrl;
//	}
//
//	public String getBeschleunigung() {
//		return beschleunigung.get();
//	}
//
//	public void setBeschleunigung(String beschleunigung) {
//		this.beschleunigung.set(beschleunigung);
//	}
//	
//	public ReadOnlyStringProperty beschleunigungProperty(){
//		return beschleunigung;
//	}	
//	
//	public StringProperty getBeschleunigungProperty(){
//		return beschleunigung;
//	}	
}

