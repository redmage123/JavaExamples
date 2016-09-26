package JavaSynchronizationPackage1;

public class opReturnData {
    private Boolean opReturnValue;
    private accountObject accObj;
	public opReturnData(){
	    this.opReturnValue = new Boolean(false);
	}
	public Boolean getReturnValue() {
		return this.opReturnValue;
	}	
	public accountObject getAccount() {
		return this.accObj;
	}
	public void setReturnValue(boolean b) {
		this.opReturnValue = b;
	}
	public void setAccountObject(accountObject ao) {
		this.accObj = ao;
	}
}
