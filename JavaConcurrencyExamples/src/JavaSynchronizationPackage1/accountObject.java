package JavaSynchronizationPackage1;

import java.math.BigDecimal;

public class accountObject {
    private String accountHolderName;
    private Integer accountHolderId;
    private BigDecimal balance;
    
    public accountObject(String name, Integer id, BigDecimal b) {
    	this.accountHolderName = name;
    	this.accountHolderId = id;
    	this.balance = balance;
    }
    
    public String getAccountName() {
    	return this.accountHolderName;
    }
    
    public void setBalance(BigDecimal b) {
    	this.balance=b;
    }
}
