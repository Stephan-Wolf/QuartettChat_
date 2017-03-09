package app;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IViewModel extends Remote {

    String IMODELVIEW = "QuartettChat";
	
	public void change (String comparisonAttribute) throws RemoteException;
	public void setObserver1 (Observer observer) throws RemoteException;
	public void setObserver2 (Observer observer) throws RemoteException;
	
	void changeChat (String message, int id) throws RemoteException;
	
	void restartGame (int id) throws RemoteException;
	void quitGame (int id) throws RemoteException;
	
	
}
