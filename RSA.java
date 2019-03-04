package SecureMessageSystem;

import java.math.BigInteger;
import java.util.Random;

public class RSA {

    private BigInteger p, q, n, z, e, d;

    RSA() {
        //all the settings are from our In-class exercise problems or 
        //powerpoint slides on Cryptography. //
//        p = new BigInteger("5");
//        q = new BigInteger("11");
//        n = new BigInteger("55");
//        z = new BigInteger("40");
//        e = new BigInteger("3");
//        d = new BigInteger("27");
    }

    public void generateKeys() {

        Random r = new Random();
        int bitlength = 13;

        p = BigInteger.probablePrime(bitlength, r);
        q = BigInteger.probablePrime(bitlength, r);
        n = p.multiply(q);
        z = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        setE(BigInteger.probablePrime(bitlength / 2, r));

        while (z.gcd(getE()).compareTo(BigInteger.ONE) > 0 && getE().compareTo(z) < 0) {
            getE().add(BigInteger.ONE);
        }
        setD(getE().modInverse(z));

    }

    public BigInteger processWithPrivateKey(BigInteger m) {

        return m.modPow(d, n);

    }
   
    public BigInteger processWithPublicKey(BigInteger c) {
 
        return c.modPow(e, n);

    }

    public BigInteger getN() {
        return n;
    }

   
    public BigInteger getE() {
        return e;
    }

    
    public void setE(BigInteger e) {
        this.e = e;
    }

    
    public BigInteger getD() {
        return d;
    }

    public void setD(BigInteger d) {
        this.d = d;
    }

}
