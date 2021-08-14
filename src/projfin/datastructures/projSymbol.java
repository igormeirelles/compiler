package projfin.datastructures;

public abstract class projSymbol {
	
	protected String name;
	
	public abstract String generateJavaCode();
	
	public projSymbol(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "projSymbol [name=" + name + "]"; 
	}
}
