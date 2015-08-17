package jumpingalien.model.programs.expressions;

import jumpingalien.model.ActiveObject;
import jumpingalien.part3.programs.IProgramFactory;

import java.util.Comparator;

public class locationComparator implements Comparator<ActiveObject>
{
	ActiveObject centerObject;
	IProgramFactory.Direction direction;
	locationComparator(ActiveObject obj,IProgramFactory.Direction dir){
		centerObject = obj;direction = dir;
	}
	@Override
	public int compare(ActiveObject t1, ActiveObject t2)
	{
		switch (direction){

			case LEFT:
				//check if t1 & t2 is right of center
				if (t1.getRawLocation()[0] - centerObject.getRawLocation()[0] > 0) return -1;
				if (t2.getRawLocation()[0] - centerObject.getRawLocation()[0] > 0) return 1;
				//check if t1 is closer than t2
				if (t1.getRawLocation()[0] - centerObject.getRawLocation()[0] >
						t2.getRawLocation()[0] - centerObject.getRawLocation()[0]) {
					return 1;
				} else {
					return -1;
				}
			case RIGHT:
				if (t1.getRawLocation()[0] - centerObject.getRawLocation()[0] < 0) return -1;
				if (t2.getRawLocation()[0] - centerObject.getRawLocation()[0] < 0) return 1;
				//check if t1 is closer than t2
				if (t1.getRawLocation()[0] - centerObject.getRawLocation()[0] <
						t2.getRawLocation()[0] - centerObject.getRawLocation()[0]) {
					return 1;
				} else {
					return -1;
				}
			case UP:
				if (t1.getRawLocation()[1] - centerObject.getRawLocation()[1] < 0) return -1;
				if (t2.getRawLocation()[1] - centerObject.getRawLocation()[1] < 0) return 1;
				//check if t1 is closer than t2
				if (t1.getRawLocation()[1] - centerObject.getRawLocation()[1] <
						t2.getRawLocation()[1] - centerObject.getRawLocation()[1]) {
					return 1;
				} else {
					return -1;
				}
			case DOWN:
				//check if t1 & t2 is right of center
				if (t1.getRawLocation()[1] - centerObject.getRawLocation()[1] > 0) return -1;
				if (t2.getRawLocation()[1] - centerObject.getRawLocation()[1] > 0) return 1;
				//check if t1 is closer than t2
				if (t1.getRawLocation()[1] - centerObject.getRawLocation()[1] >
						t2.getRawLocation()[1] - centerObject.getRawLocation()[1]) {
					return 1;
				} else {
					return -1;
				}
			default:
				return 0;
		}
	}

}
