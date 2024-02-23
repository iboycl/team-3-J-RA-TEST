package pojo.request.issue;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ContentItem {

	private String type;

	private String text;

}