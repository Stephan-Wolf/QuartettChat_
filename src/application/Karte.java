package application;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.image.Image;

public class Karte {
    private static StringProperty name = new SimpleStringProperty();
    private ObjectProperty<javafx.scene.image.Image> imageProperty = new SimpleObjectProperty<>();

    private String image;
	private StringProperty ps = new SimpleStringProperty();
	private StringProperty kmh = new SimpleStringProperty();
	private StringProperty verbrauch = new SimpleStringProperty();
	private StringProperty ccm = new SimpleStringProperty();
	private StringProperty beschleunigung = new SimpleStringProperty();
    
    public Karte (String name, String bildUrl, String ps, String kmh, String verbrauch, String ccm, String beschleunigung){
    
        // TODO Auto-generated constructor stub
        this.name.setValue(name);
        this.image = new String(bildUrl);
        Image imageUse = new Image(image);
        this.imageProperty.set(imageUse);
		this.ps.setValue(ps);
		this.kmh.setValue(kmh);
		this.verbrauch.setValue(verbrauch);
		this.ccm.setValue(ccm);
		this.beschleunigung.setValue(beschleunigung);
    }
    
    public ObjectProperty<javafx.scene.image.Image> getImageProperty() {
		return imageProperty;
	}

	public void setImageProperty(ObjectProperty<javafx.scene.image.Image> imageProperty) {
		this.imageProperty = imageProperty;
	}
	

	public void printKarte(){
    	System.out.println(this.getName());
    }
    
    
    public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name.set(name);
	}
	
	public ReadOnlyStringProperty nameProperty(){
		return name;
	}
	
	public StringProperty getNameProperty(){
		return name;
	}
	
	public String getImage() {
		return image;
	}

	public String getPs() {
		return ps.get();
	}

	public void setPs(String ps) {
		this.ps.set(ps);
	}
	
	public ReadOnlyStringProperty psProperty(){
		return ps;
	}
	
	public StringProperty getPsProperty(){
		return ps;
	}

	public String getKmh() {
		return kmh.get();
	}

	public void setKmh(String kmh) {
		this.kmh.set(kmh);
	}
	
	public ReadOnlyStringProperty kmhProperty(){
		return kmh;
	}
	
	public StringProperty getKmhProperty(){
		return kmh;
	}

	public String getVerbrauch() {
		return verbrauch.get();
	}

	public void setVerbrauch(String verbrauch) {
		this.verbrauch.set(verbrauch);
	}
	
	public ReadOnlyStringProperty verbrauchProperty(){
		return verbrauch;
	}
	
	public StringProperty getVerbrauchProperty(){
		return verbrauch;
	}

	public String getCcm() {
		return ccm.get();
	}

	public void setCcm(String ccm) {
		this.ccm.set(ccm);
	}
	
	public ReadOnlyStringProperty ccmProperty(){
		return ccm;
	}
	
	public StringProperty getCcmProperty(){
		return ccm;
	}

	public String getBeschleunigung() {
		return beschleunigung.get();
	}

	public void setBeschleunigung(String beschleunigung) {
		this.beschleunigung.set(beschleunigung);
	}
	
	public ReadOnlyStringProperty beschleunigungProperty(){
		return beschleunigung;
	}	
	
	public StringProperty getBeschleunigungProperty(){
			return beschleunigung;
		}	
}

