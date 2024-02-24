package pojo.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.text.AbstractDocument;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Body {

	private String type;

	private int version;

	private List<Content> content;

}