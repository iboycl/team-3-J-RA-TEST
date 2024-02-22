package pojo.request.issue;

import java.util.List;
import lombok.Data;

@Data
public class ContentItem {

	private String type;

	private List<ContentItem> content;

	private String text;

}