package SecureMessageSystem;
import java.math.BigInteger;
 
public class Receiver {

    
    private Packet rcvPacket;  
  
   
    public Receiver() {
        System.out.println("----- Receiver is created -------");
   
        rcvPacket = new Packet();       
   }

    public void receive(Network net, keys en) {
       
        System.out.println("----------------STEP:1--------------");
        System.out.println("Receiver Receives the packet from Internet rcvPacket ");
        rcvPacket = net.receiveFromSender();   
        
        System.out.println("----------------STEP:2--------------");
        System.out.println("Split the Packet");
        System.out.println("Packet is: " + rcvPacket.toString() + "\n");
        BigInteger message = rcvPacket.getMessage();
        BigInteger sessionKey = rcvPacket.getSessionKey();
        BigInteger signature = rcvPacket.getSignature();
        
        System.out.println("----------------STEP:3--------------");
        System.out.println("Decrypting the Session Key with RECEIVER'S PRIVATE KEY");
        BigInteger decryptSession = en.receiver.processWithPrivateKey(sessionKey);
        System.out.println("Encrypted Session Key = " + sessionKey);
        System.out.println("Decrypted Session Key = " + decryptSession + "\n");
        
        System.out.println("----------------STEP:4--------------");
        System.out.println("Decrypting the Message using DECRYPTED SESSION KEY");
        BigInteger decryptMessage = message.subtract(decryptSession);
        System.out.println("Decrypted Message = " + decryptMessage + "\n");
        
        System.out.println("----------------STEP:5--------------");
        System.out.println("Decrypting the Signature using the SESSION KEY");
        BigInteger decryptSignature = signature.subtract(decryptSession);
        System.out.println("Decrypted Signature = " + decryptSignature + "\n");
        
        System.out.println("----------------STEP:6--------------");
        System.out.println("Hash the Message");
        Hashing hash = new Hashing();
        BigInteger hashedMessage = hash.Hashing(decryptMessage);
        System.out.println("Hashed Message = " + hashedMessage + "\n");
        
        System.out.println("----------------STEP:7--------------");
        System.out.println("Decrypting the Signature using the SENDER'S PUBLIC KEY");
        BigInteger pubdecryptSignature = en.sender.processWithPublicKey(decryptSignature);
        System.out.println("Decrypted Signature = " + pubdecryptSignature + "\n");
        
        System.out.println("----------------STEP:8--------------");
        System.out.println("Comparing the Hashed Hessages.");
        System.out.println("If they are NOT EQUAL there are errors." + "\n");
        if (hashedMessage.equals(pubdecryptSignature)){
        	System.out.println("No error in the Packet!");
        }
        else{
        	System.out.println("Error in Packet!");
        }
        
    }

	


}

