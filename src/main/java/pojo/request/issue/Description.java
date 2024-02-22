package pojo.request.issue;

import java.util.List;
import lombok.Data;

@Data
public class Description {

	private String type;

	private int version;

	private List<ContentItem> content;

}