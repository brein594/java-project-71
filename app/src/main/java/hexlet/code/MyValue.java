package hexlet.code;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class MyValue {
    public String key;
    public Object value;
}
