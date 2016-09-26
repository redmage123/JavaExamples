package JavaSynchronizationPackage1;

import java.math.BigDecimal;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class AccountDriver {

	
	
	public static void main(String args[]) {
		
		BlockingQueue<TransactionObject> tq = new ArrayBlockingQueue<TransactionObject>(10);
		BlockingQueue<opReturnData> rq = new ArrayBlockingQueue<opReturnData>(10);
		TransactionObject transObj = new TransactionObject();
		
		opReturnData retObj;
		
		BigDecimal initAmount = new BigDecimal(1000.00);
		AccountManagement am = new AccountManagement(tq,rq,initAmount);
		Thread t1 = new Thread(am);
    	Thread t2 = new Thread(am);
    	Thread t3 = new Thread(am);
    	opReturnData opRetData;
    	
    	BigDecimal balance;
    	 
    	t1.start();
    	t2.start();
    	t3.start();
    	
    	transObj.setAmount(new BigDecimal(500.00));
    	transObj.setOperation(accountOperation.DEPOSIT);
    	try {
    	    tq.put(transObj);
    	} catch (InterruptedException ex) {
    		System.err.println(ex.getStackTrace());
    		System.exit(-1);
    	}
    	
    	transObj.setAmount(new BigDecimal(500.00));
    	transObj.setOperation(accountOperation.WITHDRAW);
    	try {
    	    tq.put(transObj);
    	} catch (InterruptedException ex) {
    		System.err.println(ex.getStackTrace());
    		System.exit(-1);
    	}
    	transObj.setAmount(new BigDecimal(0.00));
        transObj.setOperation(accountOperation.GETACCOUNT);
    	try {
    	    tq.put(transObj);
    	} catch (InterruptedException ex) {
    		System.err.println(ex.getStackTrace());
    		System.exit(-1);
    	}
	}	
}
