package week3llnode;

public class LLNode<T> {
	
	private LLNode<T> link;
	private T info;
	
	public LLNode(T info) {
		this.setInfo(info);
		this.setLink(null);
	}

	public LLNode<T> getLink() {
		return link;
	}

	public void setLink(LLNode<T> link) {
		this.link = link;
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}
	
	

}
