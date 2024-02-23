package pojo.request.issue;

import java.util.List;
import lombok.Data;

@Data
public class Fields {

	private String summary;

	private Issuetype issuetype;

	private Parent parent;

	private List<ComponentsItem> components;

	private String customfield20000;

	private Customfield40000 customfield40000;

	private List<String> customfield70000;

	private Description description;

	private Project project;

	private Reporter reporter;

	private String customfield10000;

	private List<FixVersionsItem> fixVersions;

	private Priority priority;

	private List<String> labels;

	private Timetracking timetracking;

	private List<String> customfield30000;

	private Customfield80000 customfield80000;

	private Environment environment;

	private Security security;

	private List<VersionsItem> versions;

	private String customfield60000;

	private String duedate;

	private Customfield50000 customfield50000;

	private Assignee assignee;

}