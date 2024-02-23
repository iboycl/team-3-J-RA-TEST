package pojo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Votes {
    private  String self;
    private  int votes;
    private  boolean hasVoted;

}
