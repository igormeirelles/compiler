package projfin.ast;

import projfin.datastructures.projVariable;

public class CommandLeitura extends AbstractCommand {
	private String id;
	private projVariable var;
	
	public CommandLeitura (String id, projVariable var) {
		this.id=id;
		this.var=var;
	}
	
	@Override
	public String generateJavaCode() {
		// TODO Auto-generated method stub
		return id + "= _key." + (var.getType()==projVariable.NUMBER? "nextDouble();": "nextLine();");
	}

	@Override
	public String toString() {
		return "CommandLeitura [id=" + id + "]";
	}
	
	
}
