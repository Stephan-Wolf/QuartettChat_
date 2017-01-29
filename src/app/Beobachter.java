package app;
import java.rmi.Remote;
import java.rmi.RemoteException;


public interface Beobachter extends Remote {

	void update (String name, String ps, String kmh, String verbrauch, String ccm, String beschleunigung, boolean aktiverSpieler_1)  throws RemoteException;
	
}
