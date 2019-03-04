package SecureMessageSystem;

public class SecureMessageSystem {

    public static void main(String[] args) {
    	       
    	keys en = new keys();
    	Sender amy = new Sender(en);
        Receiver bob = new Receiver();
        Network net = new Network();      

        System.out.println("\n ------Sender sends the test packet to Receiver through internet" + "\n");
        
        net.sendToReceiver(amy.getPacket());
        
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||| ");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||| ");
        
        net.setInternetCondition(0);
        
        System.out.println("------Asumme perfect Internet with no error----- ");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||| ");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||| " + "\n");

        
       System.out.println("------Receiver receives the test packet through network");
        
       bob.receive(net, en);


    }

}
