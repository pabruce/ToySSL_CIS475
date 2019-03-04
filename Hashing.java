package SecureMessageSystem;

import java.math.BigInteger;

public class Hashing {
	
	 public BigInteger Hashing(BigInteger message){
    	BigInteger modulus = new BigInteger("8");
    	BigInteger hashedVal = message.mod(modulus);
    	return hashedVal;
    	
    }
    

}