package JavaEnumPackageExample;

class Car {
	private String mark;
	private EnumColors eColor;
	
	public Car(String m, EnumColors ec) {
	    this.mark = m;
	    this.eColor = ec;
    }
	
	public String toString() {
		return ("Mark: " + this.mark + " color: "  + this.eColor);
	}
}
	
public class EnumClassExample1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Car c = new Car("BMW",EnumColors.GREEN); 
        System.out.println("Car = " + c);
        System.out.println("Here are all of my possible colors:");
        for (EnumColors e : EnumColors.values()) {
        	System.out.println(e);
        }
	}

}
