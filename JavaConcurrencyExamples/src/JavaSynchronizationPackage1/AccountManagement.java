package JavaSynchronizationPackage1;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;


public class AccountManagement implements Runnable {

	private TransactionObject transObj;
	private BigDecimal accountBalance;	
	private BlockingQueue <TransactionObject> transQ;
	private BlockingQueue<opReturnData> retQ;
	
	private List<accountObject> accountList = new ArrayList<>(10);
	private opReturnData opRet = new opReturnData();
	
	public AccountManagement(BlockingQueue<TransactionObject> bq, BlockingQueue<opReturnData> rq, BigDecimal initialAmount) {
		
		this.transQ = bq;
		this.retQ = rq;
		accountList.add(new accountObject("Braun Brelin",12345,initialAmount));
	}
	
	
@Override
	public void run() {
		accountOperation opKey;
	    BigDecimal amount;
	     
	   
	    while (true) {
	    	try {
	    	    this.transObj = transQ.take();
	    	} catch (InterruptedException ex) {
	    		System.err.println("Caught an interrupted exception!");
	    	}
	   	    opKey = transObj.getOperation();
	    	amount = transObj.getAmount();
	    	switch (opKey) {
	    	    case WITHDRAW:
	        	    this.accountList.get(0).setBalance(accountBalance.subtract(amount));
	    	        opRet.setReturnValue(true); 	        	 
	    	    case DEPOSIT:
	    	         this.accountList.get(0).setBalance(accountBalance.add(amount));
	    	         opRet.setReturnValue(true);
	    	    case GETACCOUNT:
	    	         opRet.setReturnValue(true);
	    	}	
	        opRet.setAccountObject(accountList.get(0));
       	    try {
       	       retQ.put(opRet);
       	    } catch (InterruptedException ex) {
       		   System.err.println("Caught an interrupted exception!");
       	    }
	    }
	}
}
