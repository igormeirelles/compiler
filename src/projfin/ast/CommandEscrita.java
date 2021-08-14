package projfin.ast;

public class CommandEscrita extends AbstractCommand {
	private String id;
	private int type; // 1 para imprimir conte�do de vari�veis, 2 para impimir diretamente alguma string
	
	public CommandEscrita (String id, int type) {
		this.id=id;
		this.type=type;
	}
	
	@Override
	public String generateJavaCode() {
		// TODO Auto-generated method stub
		if (type == 1) {
			return "System.out.println("+id+")";
		}else {
			return "System.out.println(\""+id+"\");";
		}
		
	}

	@Override
	public String toString() {
		return "CommandEscrita [id=" + id + "]";
	}
	
}
