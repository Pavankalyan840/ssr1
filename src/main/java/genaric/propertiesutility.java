package genaric;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class propertiesutility {
Properties property;
public String readDataFromProperties(String filepath) {
	FileInputStream fil=null;
	try {
		fil=new FileInputStream(filepath);
	}
	catch(FileNotFoundException e) {
		e.printStackTrace();
	}
	property= new Properties();
	try {
	property.load(fil);	
	}
	catch(IOException e) {
		e.printStackTrace();
	}
	return filepath;
	
	}
public String excelfile(String key) {
	return key;
}

}
