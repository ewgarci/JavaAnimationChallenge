package Animation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AnimationFrame {
	private List<List<Character>> frame = null;
	private int count = 0;
	
	public static final Character EMPTY_SYMBOL = '.';
	public static final Character OCCUPIED_SYMBOL = 'X';
	public static final Character LEFT_SYMBOL = 'L';
	public static final Character RIGHT_SYMBOL = 'R';

	public AnimationFrame (String init) throws InvalidCharacterException{
		int length = init.length();
		this.frame = new ArrayList<List<Character>>();
		
		for (int i = 0; i < length; i++){
			List<Character> l = new ArrayList<Character>();
			this.frame.add(l);
			Character c = init.charAt(i);
			
			if (c == EMPTY_SYMBOL){
				//Do nothing
			} else if (c == LEFT_SYMBOL || c == RIGHT_SYMBOL){
				l.add(c);
				this.count++;
			} else {
		        String s = String.format("Invalid Character %c", c);
				throw new InvalidCharacterException(s);
			}
					
		}
	}
	
	private void addCharacterToList(Character c, int index){
		if (index >= 0 && index < this.frame.size()) {
			List<Character> l = this.frame.get(index);
			l.add(c);
			this.count++;
		}
	}
	
	public int getCount(){
		return this.count;
	}
	
	public void animate(int speed) {
		this.rotateRight(speed);
		this.rotateLeft(speed);
	}
	
	private void rotateRight(int speed) {
		for (int i = (this.frame.size() - 1); i >= 0; i--) {
			List<Character> l = this.frame.get(i);
			Iterator<Character> iter = l.iterator();
			while (iter.hasNext()) {
				Character c = iter.next();
				if (c == RIGHT_SYMBOL){
					iter.remove();
					this.count--;
					addCharacterToList(c, i+speed);
				} 
			}
		}

	}
	
	private void rotateLeft(int speed) {
		for (int i = 0; i < this.frame.size(); i++) {
			List<Character> l = this.frame.get(i);
			Iterator<Character> iter = l.iterator();
			while (iter.hasNext()) {
				Character c = iter.next();
				if (c == LEFT_SYMBOL){
					iter.remove();
					this.count--;
					addCharacterToList(c, i-speed);
				} 
			}
		}

	}
	
	private String toStringHelper(Boolean debug) { 
	    StringBuilder str = new StringBuilder();
		for (int i = 0; i < this.frame.size(); i++){
			List<Character> l = this.frame.get(i);
			
			if (l.isEmpty()){
				str.append(EMPTY_SYMBOL);
			} else if (debug && l.size() == 1){
				str.append(l.get(0));
			} else if (debug && l.size() > 1){
				str.append(l.size());
			} else {
				str.append(OCCUPIED_SYMBOL);
			}
		}
	
	    return str.toString();
	}
	
	public String toDebugString() { 
	    return this.toStringHelper(true);
	}
	
	public String toAnimationString() { 
	    return this.toStringHelper(false);
	} 
	
	public void printDebug(){		
		System.out.println(this.toDebugString());
	}
	
	public void printFrame(){
		System.out.println(this.toAnimationString());
	}
}
