package pojo.request.issue;

import lombok.Data;

import java.util.List;

@Data
public class Content {

	private String type;

	private List<ContentItem> content;

	public Content() {
		this.content = List.of(new ContentItem());
	}

}
