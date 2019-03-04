package SecureMessageSystem;


public class keys {
//basic certificate authority
	RSA sender = new RSA();
	RSA receiver = new RSA();
	
	
	public keys(){
		System.out.println("----Certificate Authority(CA) is created-----");
		sender.generateKeys();
		System.out.println("Sender's public key: Alex(n, e) = (" + sender.getN() + "," + sender.getE() + ") now in CA , it is generated from the RSA algorithm.");
		System.out.println("Sender's private key: Alex(n, d) = (" + sender.getN() + "," + sender.getD() + ") It is generated from the RSA algorithm. It is NEVER given out.");
		receiver.generateKeys();
		System.out.println("Receiver's public key:Maggie(n, e) = (" + receiver.getN() + "," + receiver.getE() +")  now in CA, it is generated from the RSA algorithm.");
		System.out.println("Receiver's public key:Maggie(n, D) = (" + receiver.getN() + "," + receiver.getD() +") It is generated from the RSA algorithm. It is NEVER given out.");

		
		
		
	}
	
	
}