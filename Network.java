package SecureMessageSystem;

import java.math.BigInteger;

public class Network {

    Packet inFromSender, outToReceiver;
    

    Network() {
        System.out.println("----Network is created-----");
        inFromSender = new Packet(); 
        outToReceiver =  new Packet();
    }

   
    public void sendToReceiver(Packet pk) {
        inFromSender = pk;

    }

   
    public void setInternetCondition( int error) {
    	        if (error == 0) {
            outToReceiver = inFromSender;
        } else {
            
            inFromSender.setErrorInMessage(new BigInteger(Integer.toString(error)));
            outToReceiver = inFromSender;
        }

    }

    public Packet receiveFromSender() {
        return outToReceiver;

    }

}
