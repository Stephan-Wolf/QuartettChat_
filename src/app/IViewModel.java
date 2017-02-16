package app;

import java.rmi.Remote;
import java.rmi.RemoteException;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public interface IViewModel extends Remote {

    String IMODELVIEW = "QuartettChat";
	
	public void change (String vergleichsattribut) throws RemoteException;
	public void setBeobachter_1 (Beobachter beobachter_1) throws RemoteException;
	public void setBeobachter_2 (Beobachter beobachter_2) throws RemoteException;
	
	void changeChat (String message, int id) throws RemoteException;
	public void starten() throws RemoteException;
	
}
