package JavaSynchronizationPackage1;

import java.math.BigDecimal;

public class TransactionObject {
    private accountOperation op;
    private BigDecimal amount;
    
  
    
    public void setAmount(BigDecimal am) {
    	this.amount = amount;
    }
    
    public void setOperation(accountOperation o) {
    	this.op =o;
    }
    public BigDecimal getAmount() {
    	return this.amount;
    }
    
    public accountOperation getOperation() {
    	return this.op;
    }
}
