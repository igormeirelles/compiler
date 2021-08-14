package projfin.datastructures;

import java.util.ArrayList;
import java.util.HashMap;

public class projSymbolTable {
	
	private HashMap<String, projSymbol> map;
	
	public projSymbolTable() {
		map = new HashMap<String, projSymbol>();
	}
	
	public void add(projSymbol symbol) {
		map.put(symbol.getName(), symbol);
	}
	
	public boolean exists(String symbolName) {
		return map.get(symbolName) != null;
	}
	
	public projSymbol get(String symbolName) {
		return map.get(symbolName);
	}
	
	public ArrayList<projSymbol> getAll(){
		ArrayList<projSymbol> lista = new ArrayList<projSymbol>();
		for (projSymbol symbol : map.values()) {
			lista.add(symbol);
		}
		return lista;
	}
	
}
