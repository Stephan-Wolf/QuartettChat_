package app;

import java.rmi.Remote;
import java.rmi.RemoteException;
import javafx.beans.property.StringProperty;
import javafx.beans.property.BooleanProperty;

public interface IModel extends Remote
{  
    void starten() throws RemoteException;
    void spielWiederholen () throws RemoteException;
    
    int ermittleRundenergebnis(String attribut) throws RemoteException;
    
	public StringProperty getSpieler1NameProperty () throws RemoteException;
	public StringProperty getSpieler1PsProperty () throws RemoteException;
	public StringProperty getSpieler1KmhProperty () throws RemoteException;
	public StringProperty getSpieler1VerbrauchProperty () throws RemoteException;
	public StringProperty getSpieler1CcmProperty () throws RemoteException;
	public StringProperty getSpieler1BeschleunigungProperty () throws RemoteException;
	public StringProperty getSpieler1KartenanzahlProperty () throws RemoteException;
	public StringProperty getSpieler1JpgUrlProperty () throws RemoteException;
	public StringProperty getSpieler1StatusProperty () throws RemoteException;

	public StringProperty getSpieler2NameProperty () throws RemoteException;
	public StringProperty getSpieler2PsProperty () throws RemoteException;
	public StringProperty getSpieler2KmhProperty () throws RemoteException;
	public StringProperty getSpieler2VerbrauchProperty () throws RemoteException;
	public StringProperty getSpieler2CcmProperty () throws RemoteException;
	public StringProperty getSpieler2BeschleunigungProperty () throws RemoteException;
	public StringProperty getSpieler2KartenanzahlProperty () throws RemoteException;
	public StringProperty getSpieler2JpgUrlProperty () throws RemoteException;
	public StringProperty getSpieler2StatusProperty () throws RemoteException;
	
	public BooleanProperty getAktiverSpieler1Boolean() throws RemoteException;
    
}
