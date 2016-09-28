package yoinkToDecider;

public class Ytd {
	
	private final long id;
    private final String content;

    public Ytd(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

}
