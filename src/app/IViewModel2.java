package app;

import java.rmi.Remote;
import java.rmi.RemoteException;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public interface IViewModel2 extends Remote {

    String IMODELVIEW = "QuartettChat";
	
	public void change (String vergleichsattribut) throws RemoteException;
	public void setBeobachter_1 (Beobachter beobachter_1) throws RemoteException;
	public void setBeobachter_2 (Beobachter beobachter_2) throws RemoteException;
	
}
