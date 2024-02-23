package pojo.request.issue;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Fields {

	private Project project;

	private String summary;

	private Issuetype issuetype;

	private Description description;

	private List<String> labels;

	public Fields() {
		this.project = new Project();
		this.issuetype = new Issuetype();
		this.description = new Description();
	}

}