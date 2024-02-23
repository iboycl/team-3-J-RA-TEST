package pojo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attachment {

	private String content;

	private String created;

	private String fileName;

	private int id;

	private String mimeType;

	private String self;

	private int size;

	private String thumbnail;

	private Author author;

}
