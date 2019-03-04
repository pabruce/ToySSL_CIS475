package SecureMessageSystem;


import java.math.BigInteger;


public class Packet {

    private BigInteger sessionKey;
    private BigInteger message;
    private BigInteger signature;

    Packet() {

        sessionKey = BigInteger.ZERO;
        message = BigInteger.ZERO;
        signature = BigInteger.ZERO;

    }

    public Packet(BigInteger sessionKey, BigInteger message, BigInteger signature) {
        this.sessionKey = sessionKey;
        this.message = message;
        this.signature = signature;
    }

    
    public BigInteger getSessionKey() {
        return sessionKey;
    }
    
    /*  public BigInteger add(BigInteger sessionKey) {
    	return this.sessionKey = sessionKey;
    }
    
   public BigInteger Hashing(BigInteger message) {
        return this.message=message;
    }*/
  
    public void setSessionKey(BigInteger sessionKey) {
        this.sessionKey = sessionKey;
    }

   
    public BigInteger getMessage() {
        return message;
    }

    public void setMessage(BigInteger message) {
        this.message = message;
    }

    public void setErrorInMessage(BigInteger error) {
        this.message = this.message.add(error);
    }

    
    public BigInteger getSignature() {
        return signature;
    }

    
    public void setSignature(BigInteger signature) {
        this.signature = signature;
    }

    @Override
	public String toString() {

        String result = " ";

        result = "Message = " + this.message.toString() + "\n"
                + "Signature = " + this.signature.toString() + "\n"
                + "SessionKey = " + this.sessionKey.toString() + "\n";

        return result;
    }

    
    
    
}
