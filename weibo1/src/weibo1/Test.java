package weibo1;

public class Test {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Blog blog = new Blog();
		User user = new User();
		ContentObserver co = new ContentObserver("A");
		CounterObserver ro = new CounterObserver();
		FansObserver fo = new FansObserver();
		
		blog.addObserver(co);
		blog.addObserver(ro);
		user.addObserver(fo);
		
		blog.addContent("aa","ÄãºÃ",1);
		blog.addContent("b","µØ·½1",1);
		blog.read(73);
		blog.delete(11);
		user.fans(1,20);
	}

}