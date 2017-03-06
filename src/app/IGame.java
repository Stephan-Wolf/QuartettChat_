package app;

import java.rmi.Remote;
import java.rmi.RemoteException;
import javafx.beans.property.StringProperty;
import javafx.beans.property.BooleanProperty;

public interface IGame extends Remote
{  
    void startGame() throws RemoteException;
    void repeatGame () throws RemoteException;
    int calculateRoundResult(String carAttribute) throws RemoteException;
	public BooleanProperty activePlayer1Property() throws RemoteException;
    
	public StringProperty players1CardNameProperty () throws RemoteException;
	public StringProperty players1HpProperty () throws RemoteException;
	public StringProperty players1KmhProperty () throws RemoteException;
	public StringProperty palyers1ConsumptionProperty () throws RemoteException;
	public StringProperty players1CcmProperty () throws RemoteException;
	public StringProperty players1AccelerationProperty () throws RemoteException;
	public StringProperty players1NumberOfCardsProperty () throws RemoteException;
	public StringProperty players1SourceOfJpgProperty () throws RemoteException;
	public StringProperty players1StatusProperty () throws RemoteException;

	public StringProperty players2CardNameProperty () throws RemoteException;
	public StringProperty players2HpProperty () throws RemoteException;
	public StringProperty players2KmhProperty () throws RemoteException;
	public StringProperty players2ConsumptionProperty () throws RemoteException;
	public StringProperty players2CcmProperty () throws RemoteException;
	public StringProperty players2AccelerationProperty () throws RemoteException;
	public StringProperty players2NumberOfCardsProperty () throws RemoteException;
	public StringProperty players2SourceOfJpgProperty () throws RemoteException;
	public StringProperty players2StatusProperty () throws RemoteException;
}
