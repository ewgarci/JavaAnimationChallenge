package Animation;
import java.util.ArrayList;
import java.util.List;

public class Animation {
	
	public String[] animate(int speed, String init){
		List<String> animation = new ArrayList<String>();
				
		try {
			AnimationFrame frame = new AnimationFrame(init);
			animation.add(frame.toAnimationString());

			while (frame.getCount() > 0){
				frame.animate(speed);
				animation.add(frame.toAnimationString());
			}
			
		} catch (InvalidCharacterException e) {
			e.printStackTrace();
		}
		
		String[] animationArr = new String[animation.size()];
		animationArr = animation.toArray(animationArr);
		
		return animationArr;
	}
}
