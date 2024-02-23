package pojo.request.issue;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Description {

	private String type;

	private int version;

	private List<Content> content;

	public Description() {
		this.content = List.of(new Content());
	}

}