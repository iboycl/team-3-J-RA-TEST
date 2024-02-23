package pojo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Watcher {

	private boolean isWatching;

	private String self;

	private int watchCount;

	private Watchers watchers;

}
