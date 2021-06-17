package indi.klz.util;

public enum Sort {
	
	ASC("asc"),
	DESC("desc");
	
    private String name;  
    private Sort() {
    }  
    private Sort(String name) {  
        this.name = name;  
    }
    
    public String getName() {  
        return name;  
    }  

}
