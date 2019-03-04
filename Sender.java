package SecureMessageSystem;

import java.math.BigInteger;
import java.util.Random;

public class Sender {

    private Packet pk;
    keys en;
  
    public Sender(keys en) {
        System.out.println("\n");
        System.out.println("----------Sender is created----------");
        System.out.println("---------------Step: 1---------------");
        System.out.println("Sender Generates Message");
        BigInteger message = new BigInteger("10");
        System.out.println("message = "+ message + "\n");
        
        System.out.println("---------------Step: 2---------------");
        System.out.println("Hash Message");
        Hashing hash = new Hashing();
        BigInteger hashedMessage =hash.Hashing(message);
        System.out.println("Hashed Message = " + hashedMessage + "\n");
        
        System.out.println("---------------Step: 3---------------");
        System.out.println("Encrypting the message with Sender's Private Key");
        BigInteger digitalSig = en.sender.processWithPrivateKey(hashedMessage);
        System.out.println("Digital Signature = " + digitalSig + "\n");
        
        System.out.println("---------------Step: 4---------------");
        System.out.println("Generating Session Key");
        Random r = new Random();
        int keyLength = 16;
        BigInteger symmetricKey = BigInteger.probablePrime(keyLength, r);
        System.out.println("Session Key = " + symmetricKey + "\n");
        
        System.out.println("---------------Step: 5---------------");    
        System.out.println("Encrypting the Session Key with Receiver's Public Key using RSA Algorithm");
        BigInteger encryptSymmetric = en.receiver.processWithPublicKey(symmetricKey);
        System.out.println("Receiver's N is: " + en.receiver.getN());
        System.out.println("Receiver's E is: " + en.receiver.getE());
        System.out.println("The Encrypted Session key with the receiver's public key = " + encryptSymmetric + "\n");
       
        System.out.println("---------------Step: 6---------------");
        System.out.println("Encrypting the message with Symmetric Key");
        
       // add a = new add();
        //BigInteger encryptMessage =" ";
        BigInteger encryptMessage =message.add(symmetricKey);
        System.out.println("Encrypted Message = " + encryptMessage + "\n");
        
        System.out.println("---------------Step: 7---------------");        
        System.out.println("Encrypting the Digital Signature with Symmetric Key");
        BigInteger encryptSig =digitalSig.add(symmetricKey);
        System.out.println("Encrypted Digital Signature = " + encryptSig + "\n");
       
        System.out.println("---------------Step: 8---------------");    
        pk = new Packet(encryptSymmetric, encryptMessage,encryptSig);
        System.out.println("Packet to be sent to network is :" + pk.toString());
    }
    
 

	public Packet getPacket(){
       
           return pk;
    
    }

   

}

