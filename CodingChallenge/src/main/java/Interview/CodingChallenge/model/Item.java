package Interview.CodingChallenge.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Accessors(chain = true)
@Data
public class Item implements Serializable {
    private static final long serialVersionUID = -6673532093586278058L;

    private String title = null;
    private String seller = null;
    private int category = -1;
    private double price = -1;
}