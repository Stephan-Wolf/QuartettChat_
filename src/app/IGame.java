package app;

/**
* IGame.java
*
* @author  Oliver Dusel
* @version 1.0
* @since   2017/03 
*/

import java.rmi.Remote;
import java.rmi.RemoteException;
import javafx.beans.property.StringProperty;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;

public interface IGame extends Remote
{  
    void startGame() throws RemoteException;
    void repeatGame () throws RemoteException;
    void calculateRoundResult(String carAttribute) throws RemoteException;
	BooleanProperty activePlayer1Property() throws RemoteException;
	BooleanProperty gameoverProperty() throws RemoteException;
    
	StringProperty players1CardNameProperty () throws RemoteException;
	StringProperty players1HpProperty () throws RemoteException;
	StringProperty players1KmhProperty () throws RemoteException;
	StringProperty palyers1ConsumptionProperty () throws RemoteException;
	StringProperty players1CcmProperty () throws RemoteException;
	StringProperty players1AccelerationProperty () throws RemoteException;
	IntegerProperty players1NumberOfCardsProperty () throws RemoteException;
	StringProperty players1SourceOfJpgProperty () throws RemoteException;
	StringProperty players1StatusProperty () throws RemoteException;

	StringProperty players2CardNameProperty () throws RemoteException;
	StringProperty players2HpProperty () throws RemoteException;
	StringProperty players2KmhProperty () throws RemoteException;
	StringProperty players2ConsumptionProperty () throws RemoteException;
	StringProperty players2CcmProperty () throws RemoteException;
	StringProperty players2AccelerationProperty () throws RemoteException;
	IntegerProperty players2NumberOfCardsProperty () throws RemoteException;
	StringProperty players2SourceOfJpgProperty () throws RemoteException;
	StringProperty players2StatusProperty () throws RemoteException;
}
