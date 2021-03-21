package mojeKnihovna;

public class File {

	private String name;
	
	public File(String name) {
		this.name=name;
		
	}
	 public String getFilepath() {
		
		String currentDirectory = System.getProperty("user.dir");
		String filePath=currentDirectory.replace("\\", "\\\\")+"\\\\"+name;
		return filePath;
	}
	
}
