package app;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ViewModelObserver extends Remote {
	
	void updateGame (String name, String hp, String kmh, String consumption, String ccm, String acceleration, boolean isPlayer1active, int numberOfCards, String jpgUrl, String status, boolean gameover)  throws RemoteException;
	void updateChat(String message) throws RemoteException;
	void updateRestartGame() throws RemoteException;	
	void updateQuitGame() throws RemoteException;
	void updateButtonSend() throws RemoteException;
	int  getID () throws RemoteException;
}
