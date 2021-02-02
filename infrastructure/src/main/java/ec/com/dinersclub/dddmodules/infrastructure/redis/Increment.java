package ec.com.dinersclub.dddmodules.infrastructure.redis;

public class Increment {
	
    private String key;
    private int value;
    
    public Increment() {
    	
    }

    public Increment(String key, int value) {
        this.setKey(key);
        this.setValue(value);
    }

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
    
}
