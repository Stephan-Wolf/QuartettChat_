package app;
import java.rmi.Remote;
import java.rmi.RemoteException;

// TEST
public interface Beobachter extends Remote {
	
	
	void update (String name, String ps, String kmh, String verbrauch, String ccm, String beschleunigung, boolean aktiverSpieler_1, String kartenanzahl, String jpgUrl)  throws RemoteException;
}
