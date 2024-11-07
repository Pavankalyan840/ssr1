package genaric;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class javautility {
public int generateRandonum(int limit) {
	Random random =new Random();
	return random.nextInt();
	
	
}
public String getcurrenttime() {
	Date date =new Date();
	SimpleDateFormat sdf= new SimpleDateFormat("dd-mm--yy hh-cm-ss");
	
	return sdf.format(date);
	}
}
