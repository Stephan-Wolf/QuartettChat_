package app;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IViewModel extends Remote {

    String IMODELVIEW = "QuartettChat";
	
	void changeGame (String comparisonAttribute) throws RemoteException;
	void setObserver1 (ViewModelObserver observer) throws RemoteException;
	void setObserver2 (ViewModelObserver observer) throws RemoteException;
	void changeChat (String message, int id) throws RemoteException;
	void restartGame (int id) throws RemoteException;
	void quitGame (int id) throws RemoteException;	
}
