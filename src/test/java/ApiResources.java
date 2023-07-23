
public enum ApiResources {

	addBook("/Library/Addbook.php"),
	getBook("/Library/GetBook.php"),
	deleteBook("/Library/DeleteBook.php");
	
	private String resource;
	
	ApiResources (String resource){
		
		this.resource=resource;
	}
	
	public String getResource() {
		
		return resource;
	}
	

	
}
